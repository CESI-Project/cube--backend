package com.svt.cube.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Topic {
  @Id
  @SequenceGenerator(name = "topic_sequence", sequenceName = "topic_sequence", initialValue = 7, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_sequence")
  private Integer id;
  private String title;
  private String text;
  private String picture;
  private Integer view;
  private Integer userId;
  @Column(columnDefinition = "varchar(10) default 'Publiques'")
  private String type;
  @Column(name = "is_validated", columnDefinition = "boolean default false")
  private Boolean isValidated = false;
  @ManyToMany(cascade = { CascadeType.MERGE })
  private Set<Tag> tags;

  public Topic() {
  }

  public Topic(String title, String text, String picture, Integer view, Integer userId) {
    this.title = title;
    this.text = text;
    this.picture = picture;
    this.view = view;
    this.userId = userId;
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

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getIsValidated() {
    return isValidated;
  }

  public void setIsValidated(Boolean isValidated) {
    this.isValidated = isValidated;
  }

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "Topic{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", text='" + text + '\'' +
        ", picture='" + picture + '\'' +
        ", view=" + view +
        '}';
  }
}
