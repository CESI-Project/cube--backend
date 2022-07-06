package com.svt.cube.repository;

import java.util.List;

import com.svt.cube.entity.SharedTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedTopicRepository extends JpaRepository<SharedTopic, Integer> {
    List<SharedTopic> findAllByUserId(Integer userId);
}
