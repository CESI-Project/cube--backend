package com.svt.cube.service;

import com.svt.cube.entity.ResponseComment;
import com.svt.cube.repository.ResponseCommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseCommentService {

  private final ResponseCommentRepository responseCommentRepository;

  @Autowired
  public ResponseCommentService(ResponseCommentRepository responseCommentRepository) {
    this.responseCommentRepository = responseCommentRepository;
  }

  public Integer getResponseCommentsCount() {
    return (int) responseCommentRepository.count();
  }

  public List<ResponseComment> getResponseComments(Integer commentId) {
    return responseCommentRepository.findByCommentId(commentId);
  }
}
