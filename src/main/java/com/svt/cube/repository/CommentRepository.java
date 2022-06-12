package com.svt.cube.repository;

import com.svt.cube.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

  List<Comment> findByTopicId(Integer id);
}
