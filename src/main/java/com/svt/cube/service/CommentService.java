package com.svt.cube.service;

import com.svt.cube.entity.Comment;
import com.svt.cube.entity.User;
import com.svt.cube.repository.CommentRepository;
import com.svt.cube.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository, UserRepository userRepository) {
    this.commentRepository = commentRepository;
    this.userRepository = userRepository;
  }

  public List<Comment> getComments(Integer id) {
    return commentRepository.findByTopicId(id);
  }

  public Integer getCommentsCount() {
    return (int) commentRepository.count();
  }

  public void deleteById(Integer id, Long userId) {
    User user = userRepository.findById(userId).get();
    Comment comment = commentRepository.findById(id).get();
    if (user.getId().intValue() != comment.getUserId()) {
      return;
    }
    commentRepository.deleteById(id);
  }
}
