package com.svt.cube.entity;

import javax.persistence.*;

@Entity
public class View {
    @Id
    @SequenceGenerator(name = "favorite_sequence", sequenceName = "favorite_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_sequence")
    private Integer id;
    @Column(nullable = false, length = 3)
    private Integer topicId;
    @Column(length = 3)
    private Integer userId;

    public View(Integer topicId, Integer userId) {
        this.topicId = topicId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
