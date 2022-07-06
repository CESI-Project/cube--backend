package com.svt.cube.service;

import com.svt.cube.entity.Favorite;
import com.svt.cube.repository.FavoriteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

  private final FavoriteRepository favoriteRepository;

  @Autowired
  public FavoriteService(FavoriteRepository favoriteRepository) {
    this.favoriteRepository = favoriteRepository;
  }

  public List<Favorite> getAllFavoritesUser(Long userId) {
    return favoriteRepository.findAllByUserId(userId);
  }

  public Favorite createFavorite(Favorite favorite) {
    return favoriteRepository.save(favorite);
  }

  public void deleteFavorite(Integer favoriteId) {
    favoriteRepository.deleteById(favoriteId);
  }

  public Favorite getIsFavorite(Favorite favorite) {
    return favoriteRepository.findByTopicIdAndUserId(favorite.gettopicId(), favorite.getuserId());
  }

}
