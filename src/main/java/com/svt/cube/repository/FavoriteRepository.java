package com.svt.cube.repository;

import com.svt.cube.entity.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.svt.cube.entity.Topic;
import com.svt.cube.entity.User;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    Favorite findByTopicAndUser(Topic topic, User user);
}
