package com.svt.cube.controller;

import com.svt.cube.entity.ResponseComment;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.repository.ResponseCommentRepository;
import com.svt.cube.service.ResponseCommentService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/responseComment")
public class ResponseCommentController {

    private final ResponseCommentService responseCommentService;

    private final ResponseCommentRepository responseCommentRepository;

    public ResponseCommentController(ResponseCommentService responseCommentService,
            ResponseCommentRepository responseCommentRepository) {
        this.responseCommentService = responseCommentService;
        this.responseCommentRepository = responseCommentRepository;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public List<ResponseComment> getResponseComments(@PathVariable Integer id) {
        return responseCommentService.getResponseComments(id);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createResponseComment(@RequestBody ResponseComment Responsecomment) {
        responseCommentRepository.save(Responsecomment);
        return ResponseEntity.ok(new MessageResponse("Response comment registered successfully!"));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    // @PreAuthorize("hasRole('ROLE_MODE') or hasRole('ROLE_ADMIN') or
    // hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<?> deleteResponseComment(@PathVariable Integer id) {
        responseCommentRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Response comment deleted successfully!"));
    }
}
