package com.svt.cube.controller;

import com.svt.cube.entity.ERole;
import com.svt.cube.entity.Role;
import com.svt.cube.entity.StatistiquesInformation;
import com.svt.cube.entity.User;
import com.svt.cube.payload.request.LoginRequest;
import com.svt.cube.payload.request.SignupRequest;
import com.svt.cube.payload.request.SignupSpecialRequest;
import com.svt.cube.payload.response.JwtResponse;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.repository.RoleRepository;
import com.svt.cube.repository.UserRepository;
import com.svt.cube.security.jwt.JwtUtils;
import com.svt.cube.security.services.UserDetailsImpl;
import com.svt.cube.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

  private final UserService userService;
  private final UserRepository userRepository;
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  public UserController(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository = userRepository;
  }

  // All users for admin
  @CrossOrigin
  @GetMapping("admin/{id}")
  public List<User> getUsers(@PathVariable Long id) {
    return userService.getUsers(id);
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public Optional<User> getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }

  @CrossOrigin
  @GetMapping("/{id}/dashboard")
  public StatistiquesInformation getDashboardStat(@PathVariable Integer id) {
    return userService.getDashboardStat(id);
  }

  // Stats Admin
  @CrossOrigin
  @GetMapping("/admin/count")
  public Integer getTotalUsers() {
    return userService.getTotalUsers();
  }

  @CrossOrigin
  @PostMapping("auth/log-in")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    User user = userRepository.findByUserName(loginRequest.getUsername()).get();
    if (!user.getIsActivated()) {
      return new ResponseEntity<>("User account desactivated!", HttpStatus.UNAUTHORIZED);
    }
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());
    return ResponseEntity.ok(
        new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
  }

  @CrossOrigin
  @PostMapping("auth/sign-up")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUserName(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }
    // Create new user's account
    User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()),
        signUpRequest.getAge());
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "superAdmin":
            Role superAdminRole = roleRepository.findByName(ERole.ROLE_SUPERADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(superAdminRole);
            break;
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
            break;
          case "mode":
            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);
            break;
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @CrossOrigin
  @PutMapping("/{id}/modifyPassword")
  public ResponseEntity<?> updatePassword(@Valid @PathVariable Long id, @RequestBody String newPassword) {
    String password = encoder.encode(newPassword);
    userService.updatePassword(id, password);
    return ResponseEntity.ok(new MessageResponse("The password has been updated"));
  }

  @CrossOrigin
  @PutMapping("/{id}/modifyProfil")
  public ResponseEntity<?> udpdateProfile(@Valid @RequestBody User newInfoUser) {
    userService.updateProfile(newInfoUser);
    return ResponseEntity.ok(new MessageResponse("Profil User succesfully updated"));
  }

  @CrossOrigin
  @PutMapping("/{id}/activation")
  public ResponseEntity<?> activatedProfile(@Valid @PathVariable Long id) {
    userService.activatedProfile(id);
    return ResponseEntity.ok(new MessageResponse("Profil User reactivated succesfully"));
  }

  @CrossOrigin
  @PutMapping("/{id}/desactivation")
  public ResponseEntity<?> desactivatedProfile(@Valid @PathVariable Long id) {
    userService.desactivatedProfile(id);
    return ResponseEntity.ok(new MessageResponse("Profil User desactivated succesfully updated"));
  }
}
