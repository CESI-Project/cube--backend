package com.svt.cube.service;

import com.svt.cube.entity.Comment;
import com.svt.cube.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) { this.commentRepository = commentRepository; }

    public List<Comment> getComments(Integer id) { return commentRepository.findByTopicId(id); }
}
