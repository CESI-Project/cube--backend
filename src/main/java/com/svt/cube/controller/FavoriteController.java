package com.svt.cube.controller;

import java.util.List;

import javax.validation.Valid;

import com.svt.cube.entity.Favorite;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.service.FavoriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/{id}/hisFavorites")
    // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or
    // hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    public List<Favorite> getAllFavorites(@Valid @PathVariable Long id) {
        return favoriteService.getAllFavoritesUser(id);
    }

    @CrossOrigin
    @GetMapping("/isFavorite")
    // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or
    // hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
    public Boolean getIsFavorite(@Valid @RequestBody Favorite favorite) {
        Favorite getFavorite = favoriteService.getIsFavorite(favorite);
        if (getFavorite != null) {
            return true;
        }
        return false;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createFavorite(@Valid @RequestBody Favorite favorite) {
        favoriteService.createFavorite(favorite);
        return ResponseEntity.ok(new MessageResponse("Topic registered successfully!"));
    }

    @CrossOrigin
    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<?> deleteFavorite(@Valid @PathVariable Integer favoriteId) {
        favoriteService.deleteFavorite(favoriteId);
        return ResponseEntity.ok(new MessageResponse("Topic deleted successfully!"));
    }
}
