package com.svt.cube.repository;

import com.svt.cube.entity.ResponseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseCommentRepository extends JpaRepository<ResponseComment, Integer> {

    List<ResponseComment> findByCommentId(Integer commentId);

    void deleteByCommentId(Integer commentId);
}