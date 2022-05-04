package com.svt.cube.service;

import com.svt.cube.entity.Comment;
import com.svt.cube.repository.CommentRepository;
import com.svt.cube.repository.ResponseCommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ResponseCommentRepository responseCommentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ResponseCommentRepository responseCommentRepository) {
        this.commentRepository = commentRepository;
        this.responseCommentRepository = responseCommentRepository;
    }

    public List<Comment> getComments(Integer id) {
        return commentRepository.findByTopicId(id);
    }

    public void deleteById(Integer commentId) {
        commentRepository.deleteById(commentId);
        responseCommentRepository.deleteByCommentId(commentId);
    }

    public void deleteByTopicId(Integer topicId) {
        List<Comment> comments = commentRepository.findByTopicId(topicId);
        for (Comment comment : comments) {
            commentRepository.deleteById(comment.getId());
            responseCommentRepository.deleteByCommentId(comment.getId());
        }
    }
}
