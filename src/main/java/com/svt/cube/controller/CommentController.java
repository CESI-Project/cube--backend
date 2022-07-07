package com.svt.cube.controller;

import com.svt.cube.entity.Comment;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.repository.CommentRepository;
import com.svt.cube.repository.ResponseCommentRepository;
import com.svt.cube.service.CommentService;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

  private final CommentService commentService;

  private final CommentRepository commentRepository;
  private final ResponseCommentRepository responseCommentRepository;

  public CommentController(CommentService commentService, CommentRepository commentRepository,
      ResponseCommentRepository responseCommentRepository) {
    this.commentService = commentService;
    this.commentRepository = commentRepository;
    this.responseCommentRepository = responseCommentRepository;
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public List<Comment> getComments(@PathVariable Integer id) {
    return commentService.getComments(id);
  }

  @CrossOrigin
  @PostMapping
  public void pullComment(@RequestBody Comment comment) {
    commentRepository.save(comment);
  }

  @CrossOrigin
  @PutMapping("/{id}")
  public ResponseEntity<?> modifyResponseComment(@PathVariable Integer id,
      @RequestBody Comment comment) {
    commentRepository.save(comment);
    return ResponseEntity.ok(new MessageResponse("Comment modify successfully!"));
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  public void deleteComment(@PathVariable Integer id, @RequestParam Long userId) {
    commentService.deleteById(id, userId);
    responseCommentRepository.deleteByCommentId(id);
  }
}
