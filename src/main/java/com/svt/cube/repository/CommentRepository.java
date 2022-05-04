package com.svt.cube.repository;

import com.svt.cube.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByTopicId(Integer id);

    void deleteByTopicId(Integer topicId);
}
