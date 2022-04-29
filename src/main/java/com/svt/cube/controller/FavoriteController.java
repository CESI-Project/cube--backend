package com.svt.cube.controller;

import java.util.List;

import com.svt.cube.entity.Favorite;
import com.svt.cube.service.FavoriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @CrossOrigin
    @GetMapping
    // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or
    // hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    public List<Favorite> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }
}
