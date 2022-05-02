package com.svt.cube.entity;

import javax.persistence.*;

@Entity
@Table
public class SharedTopic {
    @Id
    @SequenceGenerator(name = "shared_topic_sequence", sequenceName = "shared_topic_sequence", initialValue = 3, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shared_topic_sequence")
    private Integer id;
    private Integer userId;
    private Integer topicId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}
