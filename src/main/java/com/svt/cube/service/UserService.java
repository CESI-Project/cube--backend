package com.svt.cube.service;

import com.svt.cube.entity.User;
import com.svt.cube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void updatePassword(Long id, String newPassword) {
        User user = userRepository.getById(id);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public void addPicturePath(Long id, String namePicture) {
        String path = "http://localhost:8080/api/v1/filesController/files/";
        User user = userRepository.getById(id);
        String pictureUrl = path + namePicture;
        user.setPicture(pictureUrl);
        userRepository.save(user);
    }

    public void updateProfile(User newInfoUser) {
        userRepository.save(newInfoUser);
    }

    public void activatedProfile(Long userId) {
        User user = userRepository.findById(userId).get();
        user.setIsActivated(true);
        userRepository.save(user);
    }

    public void desactivatedProfile(Long userId) {
        User user = userRepository.findById(userId).get();
        user.setIsActivated(false);
        userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
