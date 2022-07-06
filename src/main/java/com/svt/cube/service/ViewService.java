package com.svt.cube.service;

import java.util.HashSet;
import java.util.Set;

import com.svt.cube.entity.Topic;
import com.svt.cube.entity.View;
import com.svt.cube.repository.TopicRepository;
import com.svt.cube.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;

@Service
public class ViewService {

  private final ViewRepository viewRepository;
  private final TopicRepository topicRepository;

  @Autowired
  public ViewService(ViewRepository viewRepository, TopicRepository topicRepository) {
    this.viewRepository = viewRepository;
    this.topicRepository = topicRepository;
  }

  public void createViews(View view) {
    Integer topicId = view.getTopicId();
    Integer userId = view.getUserId();
    View verifView = new View();
    if (userId != null && topicId != null && viewRepository.findOneBytopicIdAndUserId(topicId, userId) != null) {
      verifView = viewRepository.findOneBytopicIdAndUserId(topicId, userId);
      if (verifView.getTopicId() == topicId && userId != null && verifView.getUserId() == userId) {
        return;
      }
    }

    Topic topic = topicRepository.findById(topicId).get();
    viewRepository.save(view);
    topic.setView(this.getCountViews(topicId));
    topicRepository.save(topic);
  }

  public Integer getCountViews(Integer id) {
    return viewRepository.countByTopicId(id);
  }

  public Integer getMyCountView(Integer userId) {
    return viewRepository.countByUserId(userId);
  }

  public Integer getTotalViews() {
    return (int) viewRepository.count();
  }

  public Integer getTotalViewsNotUsers() {
    return (int) viewRepository.countNotUsers();
  }

  public Set<Integer> getUserTopicsViewId(Integer userId) {
    Set<View> views = viewRepository.findByUserId(userId);
    Set<Integer> viewsId = new HashSet<>();
    views.forEach(view -> viewsId.add(view.getId()));
    return viewsId;
  }
}
