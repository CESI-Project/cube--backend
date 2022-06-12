package com.svt.cube.controller;

import com.svt.cube.entity.FamilyTag;
import com.svt.cube.service.FamilyTagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/familyTag")
public class FamilyTagController {

  private final FamilyTagService familyTagService;

  @Autowired
  public FamilyTagController(FamilyTagService familyTagService) {
    this.familyTagService = familyTagService;
  }

  @CrossOrigin
  @GetMapping
  // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or
  // hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
  public List<FamilyTag> getAllFamilyTags() {
    return familyTagService.getAllFamilyTags();
  }

  @CrossOrigin
  @PostMapping
  // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
  public FamilyTag createFamilyTag(@RequestBody FamilyTag familyTag) {
    return familyTagService.createFamilyTag(familyTag);
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
  public void deleteFamilyTag(@PathVariable Integer id) {
    familyTagService.deleteFamilyTag(id);
  }

  @CrossOrigin
  @PutMapping("/{id}")
  // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
  public void modifyFamilyTag(@PathVariable Integer id, @RequestBody FamilyTag familyTag) {
    familyTagService.modifyFamilyTag(familyTag);
  }

}
