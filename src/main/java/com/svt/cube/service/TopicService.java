package com.svt.cube.service;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    public List<Topic> getTopicsByTags(Set<Tag> tags) {
        return topicRepository.findAllByTagsIn(tags);
    }

    public Topic getTopicById(Integer id) {
        Topic topic = topicRepository.getById(id);
        var view = topic.getView();
        topic.setView(view + 1);
        topicRepository.save(topic);
        return topic;
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

    public Topic modifyTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void modifyTag(Topic topic) {
        topicRepository.save(topic);
    }
}
