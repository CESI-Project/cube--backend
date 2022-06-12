package com.svt.cube.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

  @Id
  @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", initialValue = 3, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
  private Long id;
  private String userName;
  private String picture;
  @Column(name = "is_activated", columnDefinition = "boolean default true")
  private Boolean isActivated = true;
  @NotBlank
  @Email
  @Column(nullable = false, unique = true, length = 45)
  private String email;
  @Column(nullable = false, length = 64)
  private String password;
  private Integer age;
  @ManyToMany(fetch = FetchType.LAZY)
  // @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name =
  // "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String userName, String email, String password, Integer age) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getIsActivated() {
    return isActivated;
  }

  public void setIsActivated(Boolean isActivated) {
    this.isActivated = isActivated;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User{" +
          "id=" + id +
          ", userName='" + userName + '\'' +
          ", email='" + email + '\'' +
          ", password='" + password + '\'' +
          ", age=" + age +
          ", roles=" + roles +
          '}';
  }
}
