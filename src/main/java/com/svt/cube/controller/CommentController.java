package com.svt.cube.controller;

import com.svt.cube.entity.Comment;
import com.svt.cube.repository.CommentRepository;
import com.svt.cube.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    private final CommentRepository commentRepository;

    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
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
    @DeleteMapping("/{id}")
    // @PreAuthorize("hasRole('ROLE_MODE') or hasRole('ROLE_ADMIN') or
    // hasRole('ROLE_SUPERADMIN')")
    public void deleteTag(@PathVariable Integer id, @RequestParam Long userId) {
        commentService.deleteById(id, userId);
    }
}
