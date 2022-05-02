package com.svt.cube.repository;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    @Query("SELECT t FROM Topic t WHERE t.type='Publiques'")
    List<Topic> findByType();

    @Query("SELECT t FROM Topic t WHERE t.type='Privées' AND t.userId = :userId")
    List<Topic> findByTypeAndUserId(@Param("userId") Integer userId);

    // @Query("SELECT t FROM Topic t WHERE t.type='Partagées' AND :userId IN
    // t.sharedPersonId")
    // List<Topic> findByTypeAndSharedPersonId(@Param("userId") Integer userId);

    List<Topic> findAllByTagsIn(Set<Tag> tags);
}