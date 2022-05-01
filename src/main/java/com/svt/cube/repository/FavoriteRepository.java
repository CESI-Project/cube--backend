package com.svt.cube.repository;

import java.util.List;

import com.svt.cube.entity.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findAllByUserId(Long userId);

    Favorite findByTopicIdAndUserId(Integer topicId, Long userId);
}
