package com.svt.cube.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence", initialValue = 3, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
    private Integer id;
    private String text;
    @CreatedDate
    private LocalDate createdAt;
    private Integer topicId;

    private Integer userId;

    public Comment() {
    }

    public Comment(String text, LocalDate createdAt, Integer topicId, Integer userId) {
        this.text = text;
        this.createdAt = createdAt;
        this.topicId = topicId;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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
                ", topicId=" + topicId +
                ", userId=" + userId +
                '}';
    }
}
