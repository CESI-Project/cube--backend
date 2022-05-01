package com.svt.cube.entity;

import javax.persistence.*;

@Entity
@Table
public class Favorite {
    @Id
    @SequenceGenerator(name = "favorite_sequence", sequenceName = "favorite_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_sequence")
    private Integer id;
    private Long userId;
    private Integer topicId;

    public Favorite() {
    }

    public Favorite(Long userId, Integer topicId) {
        this.userId = userId;
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public Integer gettopicId() {
        return topicId;
    }

    public void settopicId(Integer topicId) {
        this.topicId = topicId;
    }
}
