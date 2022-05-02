package com.svt.cube.service;

import com.svt.cube.entity.SharedTopic;
import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.SharedTopicRepository;
import com.svt.cube.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogFormatUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final SharedTopicRepository sharedTopicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, SharedTopicRepository sharedTopicRepository) {
        this.topicRepository = topicRepository;
        this.sharedTopicRepository = sharedTopicRepository;
    }

    public List<Topic> getTopicsNotConnected() {
        return topicRepository.findByType();
    }

    public List<Topic> getTopics(Integer userId) {
        List<SharedTopic> sharedTopicwithuser = sharedTopicRepository.findAllByUserId(userId);
        List<Integer> listTopicId = new ArrayList<Integer>();
        List<Topic> topicsPartaged = new ArrayList<Topic>();

        for (SharedTopic record : sharedTopicwithuser) {
            listTopicId.add(record.getTopicId());
        }

        for (Integer record : listTopicId) {
            Topic topic = topicRepository.findById(record).get();
            topicsPartaged.add(topic);
        }
        List<Topic> topicsPrivate = topicRepository.findByTypeAndUserId(userId);
        List<Topic> topicsPublic = topicRepository.findByType();

        List<Topic> topicsAll = new ArrayList<Topic>(topicsPartaged);
        topicsAll.addAll(topicsPrivate);
        topicsAll.addAll(topicsPublic);
        Set<Topic> setWithUniqueValues = new HashSet<>(topicsAll);
        List<Topic> topics = new ArrayList<>(setWithUniqueValues);

        return topics;
    }

    public List<Topic> getTopicsByTags(Set<Tag> tags) {
        return topicRepository.findAllByTagsIn(tags);
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

    public Topic modifyTopic(Topic topic) {
        return topicRepository.save(topic);
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
}
