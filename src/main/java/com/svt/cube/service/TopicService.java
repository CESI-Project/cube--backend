package com.svt.cube.service;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.TagRepository;
import com.svt.cube.repository.TopicRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TopicService {

  private final TopicRepository topicRepository;
  private final TagRepository tagRepository;
  private final FilesStorageService storageService;

  @Autowired
  public TopicService(TopicRepository topicRepository, FilesStorageService storageService,
      TagRepository tagRepository) {
    this.topicRepository = topicRepository;
    this.storageService = storageService;
    this.tagRepository = tagRepository;
  }

  public List<Topic> getTopics() {
    return topicRepository.findAll();
  }

  public List<Topic> getTopicsByTags(Set<Tag> tags) {
    return topicRepository.findAllByTagsIn(tags);
  }

  public List<Topic> getAllTopics() {
    return topicRepository.findAll();
  }

  public Topic getTopicById(Integer id) {
    return topicRepository.findById(id).get();
  }

  public void addPicturePath(Integer id, String namePicture) {
    String path = "http://localhost:8080/api/v1/filesController/files/";
    Topic topic = topicRepository.getById(id);
    String pictureUrl = path + namePicture;
    topic.setPicture(pictureUrl);
    topicRepository.save(topic);
  }

  public Topic createTopic(Topic topic) {
    return topicRepository.save(topic);
  }

  public Topic createTopicWithPhoto(Topic topic, MultipartFile file) {
    Topic newTopic = topicRepository.save(topic);
    String nameFile = "Topic_" + newTopic.getId().toString() + "_" + file.getOriginalFilename();
    storageService.saveTopic(file, nameFile);
    this.addPicturePath(newTopic.getId(), nameFile);
    return newTopic;
  }

  public Topic modifyTopic(Integer id, Topic topic) {
    Topic modifyTopic = topicRepository.getById(id);
    if (topic.getText() != null) {
      modifyTopic.setText(topic.getText());
    }
    if (topic.getTags() != null) {
      Set<Tag> tagsList = new HashSet<>();
      Set<Tag> tags = topic.getTags();
      tags.forEach(tag -> tagsList.add(tagRepository.getById(tag.getId())));
      modifyTopic.setTags(tagsList);
    }
    if (topic.getTitle() != null) {
      modifyTopic.setTitle(topic.getTitle());
    }
    return topicRepository.save(modifyTopic);
  }

  public void modifyTag(Topic topic) {
    topicRepository.save(topic);
  }

  public void validationTopic(Integer topicId) {
    Topic topicToValidated = topicRepository.findById(topicId).get();
    topicToValidated.setIsValidated(true);
    topicRepository.save(topicToValidated);
  }

  public void unvalidationTopic(Integer topicId) {
    Topic topicToValidated = topicRepository.findById(topicId).get();
    topicToValidated.setIsValidated(false);
    topicRepository.save(topicToValidated);
  }

  public List<Topic> getTopicValidated() {
    return topicRepository.findAllValidated();
  }

  public List<Topic> getTopicNotValidated() {
    return topicRepository.findAllNotValidated();
  }

  public Integer getTotalTopics() {
    return (int) topicRepository.count();
  }

  public List<Topic> getMyTopics(Integer userId) {
    return topicRepository.findAllByUserId(userId);
  }
}
