package com.svt.cube.controller;

import com.svt.cube.entity.Topic;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @CrossOrigin
    @GetMapping
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Topic> getTopicById(@PathVariable Integer id) {
        return topicService.getTopicById(id);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createTopic(@Valid @RequestBody Topic topic) {
        topicService.createTopic(topic);
        return ResponseEntity.ok(new MessageResponse("Topic registered successfully!"));
    }
}
