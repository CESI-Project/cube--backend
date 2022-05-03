package com.svt.cube.service;

import com.svt.cube.entity.Topic;
import com.svt.cube.entity.View;
import com.svt.cube.repository.ViewRepository;
import com.svt.cube.repository.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        View verifView = viewRepository.findOneBytopicIdAndUserId(topicId, userId);
        Topic topic = topicRepository.findById(topicId).get();
        if (verifView.getTopicId() == topicId && userId != null && verifView.getUserId() == userId) {
            return;
        }

        viewRepository.save(view);
        topic.setView(this.getCountViews(topicId));
        topicRepository.save(topic);
    }

    public Integer getCountViews(Integer id) {
        return viewRepository.countByTopicId(id);
    }
}
