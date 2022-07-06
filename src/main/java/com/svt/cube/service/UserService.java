package com.svt.cube.service;

import com.svt.cube.entity.StatistiquesInformation;
import com.svt.cube.entity.Topic;
import com.svt.cube.entity.TopicByCategories;
import com.svt.cube.entity.User;
import com.svt.cube.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final TopicService topicService;
  private final ViewService viewService;
  private final TagService tagService;
  private final CommentService commentService;
  private final ResponseCommentService responseCommentService;

  @Autowired
  public UserService(UserRepository userRepository, TopicService topicService, ViewService viewService,
      TagService tagService, CommentService commentService, ResponseCommentService responseCommentService) {
    this.userRepository = userRepository;
    this.topicService = topicService;
    this.viewService = viewService;
    this.tagService = tagService;
    this.commentService = commentService;
    this.responseCommentService = responseCommentService;
  }

  public List<User> getUsers(Long userId) {
    return userRepository.findAllWithoutMyUser(userId);
  }

  public void updatePassword(Long id, String newPassword) {
    User user = userRepository.getById(id);
    user.setPassword(newPassword);
    userRepository.save(user);
  }

  public void addPicturePath(Long id, String namePicture) {
    String path = "http://localhost:8080/api/v1/filesController/files/";
    User user = userRepository.getById(id);
    String pictureUrl = path + namePicture;
    user.setPicture(pictureUrl);
    userRepository.save(user);
  }

  public void updateProfile(User newInfoUser) {
    userRepository.save(newInfoUser);
  }

  public void activatedProfile(Long userId) {
    User user = userRepository.findById(userId).get();
    user.setIsActivated(true);
    userRepository.save(user);
  }

  public void desactivatedProfile(Long userId) {
    User user = userRepository.findById(userId).get();
    user.setIsActivated(false);
    userRepository.save(user);
  }

  public Optional<User> getUser(Long id) {
    return userRepository.findById(id);
  }

  public Integer getTotalUsers() {
    return (int) userRepository.count();
  }

  public StatistiquesInformation getDashboardStat(Integer id) {
    List<Topic> topics = topicService.getMyTopics(id);
    Integer myTotalViews = viewService.getMyCountView(id);
    Integer totalUsers = getTotalUsers();
    Integer totalTopics = topicService.getTotalTopics();
    Integer totalTags = tagService.getTotalTopicsCount();
    Integer totalTopicViews = viewService.getTotalViews();
    Integer totalComments = commentService.getCommentsCount();
    Integer totalResponseComments = responseCommentService.getResponseCommentsCount();
    Integer averageCommentsByTopic = topicService.getAverageCommentsCount();
    Integer averageResponseCommentsByTopic = topicService.getAverageResponseCommentsCount();
    List<TopicByCategories> TotalTopicsByCategories = topicService.getTopicByCategeries();
    StatistiquesInformation statistiquesInformation = new StatistiquesInformation(topics, myTotalViews, totalUsers,
        totalTopics, totalTags, totalTopicViews, totalComments, totalResponseComments, averageCommentsByTopic,
        averageResponseCommentsByTopic, TotalTopicsByCategories);

    return statistiquesInformation;
  }
}
