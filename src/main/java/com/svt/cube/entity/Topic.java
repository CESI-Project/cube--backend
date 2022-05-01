package com.svt.cube.entity;

import java.util.Set;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Topic {
    @Id
    @SequenceGenerator(name = "topic_sequence", sequenceName = "topic_sequence", initialValue = 3, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_sequence")
    private Integer id;
    private String title;
    private String text;
    private String picture;
    private Integer view;
    @Column(name = "is_validated", columnDefinition = "boolean default false")
    private Boolean isValidated = false;
    @OneToMany
    private List<Comment> comment;
    @JsonManagedReference(value = "topic-favorite")
    @OneToMany
    private Set<Favorite> favorite;
    @ManyToMany(cascade = { CascadeType.MERGE })
    private Set<Tag> tags;

    public Topic() {
    }

    public Topic(String title, String text, String picture, Integer view) {
        this.title = title;
        this.text = text;
        this.picture = picture;
        this.view = view;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Favorite> getFavoriteTopic() {
        return favorite;
    }

    public void setFavoriteTopic(Set<Favorite> favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", picture='" + picture + '\'' +
                ", view=" + view +
                ", comment=" + comment +
                '}';
    }
}
