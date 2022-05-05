package com.svt.cube.repository;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findAllByTagsIn(Set<Tag> tags);

    @Query("SELECT t from Topic t where isValidated = true")
    List<Topic> findAllValidated();

    @Query("SELECT t from Topic t where isValidated = false")
    List<Topic> findAllNotValidated();

    List<Topic> findByTitleContainingIgnoreCase(String keyword);
}
