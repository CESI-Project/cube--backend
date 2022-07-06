package com.svt.cube.repository;

import com.svt.cube.entity.ResponseComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseCommentRepository extends JpaRepository<ResponseComment, Integer> {

  List<ResponseComment> findByCommentId(Integer commentId);

  void deleteByCommentId(Integer commentId);
}