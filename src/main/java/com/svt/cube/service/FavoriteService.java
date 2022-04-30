package com.svt.cube.service;

import java.util.List;

import com.svt.cube.entity.Favorite;
import com.svt.cube.entity.Topic;
import com.svt.cube.entity.TopicUserWrapper;
import com.svt.cube.entity.User;
import com.svt.cube.repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public Favorite createFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Integer favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }

    public Favorite getIsFavorite(TopicUserWrapper topicUserWrapper) {
        Topic topic = topicUserWrapper.getTopic();
        User user = topicUserWrapper.getUser();
        return favoriteRepository.findByTopicAndUser(topic, user);
    }

}
