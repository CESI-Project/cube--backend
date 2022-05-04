package com.svt.cube.service;

import com.svt.cube.entity.ResponseComment;
import com.svt.cube.entity.User;
import com.svt.cube.repository.ResponseCommentRepository;
import com.svt.cube.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponseCommentService {
    private final ResponseCommentRepository responseCommentRepository;
    private final UserRepository userRepository;

    @Autowired
    public ResponseCommentService(ResponseCommentRepository responseCommentRepository, UserRepository userRepository) {
        this.responseCommentRepository = responseCommentRepository;
        this.userRepository = userRepository;
    }

    public List<ResponseComment> getResponseComments(Integer commentId) {
        return responseCommentRepository.findByCommentId(commentId);
    }

    public void modifyResponseComment(Long userId, ResponseComment responseComment) {
        User user = userRepository.findById(userId).get();
        if (userId.intValue() == responseComment.getUserId()) {
            responseCommentRepository.save(responseComment);
        }
    }
}
