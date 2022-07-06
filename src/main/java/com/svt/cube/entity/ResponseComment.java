package com.svt.cube.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table
public class ResponseComment {

  @Id
  @SequenceGenerator(name = "responsecomment_sequence", sequenceName = "responsecomment_sequence", initialValue = 3,
        allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsecomment_sequence")
  private Integer id;
  private String text;
  @CreatedDate
  private Timestamp createdAt;
  private Integer commentId;

  private Integer userId;

  public ResponseComment() {
  }

  public ResponseComment(String text, Timestamp createdAt, Integer commentId, Integer userId) {
    this.text = text;
    this.createdAt = createdAt;
    this.commentId = commentId;
    this.userId = userId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Comment{" +
          "id=" + id +
          ", text='" + text + '\'' +
          ", createdAt=" + createdAt +
          ", commentId=" + commentId +
          ", userId=" + userId +
          '}';
  }
}
