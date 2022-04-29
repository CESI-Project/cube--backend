package com.svt.cube.service;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<Topic> getTopicById(Integer id) {
        return topicRepository.findById(id);
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic modifyTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void modifyTag(Topic topic) {
        // Topic updatedTopic = topicRepository.getById(topic.getId());
        // updatedTopic = topic;
        topicRepository.save(topic);
    }
}
