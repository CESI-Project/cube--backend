package com.svt.cube.repository;

import com.svt.cube.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Query(value = "SELECT t from Topic t WHERE t.id=:id")
    Optional<Topic> findTopicById(@Param("id") Integer id);
}
