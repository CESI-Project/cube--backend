package com.svt.cube.entity;

import javax.persistence.*;

@Entity
@Table
public class Topic {
    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    private Integer id;
    private String title;
    private String picture;
    private Integer react; // Postgres doesn't like the "like" word
    private Integer view;
    private String comment; // ToDo: Change it later

    public Topic() {
    }

    public Topic(String title, String picture, Integer react, Integer view, String comment) {
        this.title = title;
        this.picture = picture;
        this.react = react;
        this.view = view;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getLike() {
        return react;
    }

    public void setLike(Integer react) {
        this.react = react;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", react=" + react +
                ", view=" + view +
                ", comment='" + comment + '\'' +
                '}';
    }
}
