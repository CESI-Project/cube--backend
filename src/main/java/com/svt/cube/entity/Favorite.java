package com.svt.cube.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Favorite {
    @Id
    @SequenceGenerator(name = "favorite_sequence", sequenceName = "favorite_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_sequence")
    private Integer id;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(nullable = false)
    private User user;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Topic topic;

    public Favorite() {
    }

    public Favorite(User user, Topic topic) {
        this.user = user;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setId(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
