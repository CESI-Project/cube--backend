package com.svt.cube.controller;

import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.service.TopicService;
import com.svt.cube.service.ViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService, ViewService viewService) {
        this.topicService = topicService;
    }

    @CrossOrigin
    @GetMapping
    public List<Topic> getTopics() {
        return topicService.getTopics();
    }

    @CrossOrigin
    @GetMapping("/byTags")
    public List<Topic> getTopicsByTags(@RequestBody Set<Tag> tags) {
        return topicService.getTopicsByTags(tags);
    }

    // All for admin
    @CrossOrigin
    @GetMapping("/admin")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    // Stats Admin
    @CrossOrigin
    @GetMapping("/admin/count")
    public Integer getTotalTopics() {
        return topicService.getTotalTopics();
    }

    @CrossOrigin
    @GetMapping("/user/{id}/myTopic")
    public List<Topic> getTotalTopics(@Valid @PathVariable Integer id) {
        return topicService.getMyTopics(id);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Integer id) {
        return topicService.getTopicById(id);
    }

    @CrossOrigin
    @GetMapping("/notValidated")
    public List<Topic> getTopicNotValidated() {
        return topicService.getTopicNotValidated();
    }

    @CrossOrigin
    @GetMapping("/validated")
    public List<Topic> getTopicValidated() {
        return topicService.getTopicValidated();
    }

    // @CrossOrigin
    // @PostMapping
    // public ResponseEntity<?> createTopic(@Valid @RequestBody Topic topic,
    // @RequestParam("file") MultipartFile file) {
    // if (file == null) {
    // topicService.createTopic(topic);
    // } else {
    // topicService.createTopicWithPhoto(topic, file);
    // }
    // return ResponseEntity.ok(new MessageResponse("Topic registered
    // successfully!"));
    // }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createTopic(@Valid @RequestBody Topic topic) {
        topicService.createTopic(topic);
        return ResponseEntity.ok(new MessageResponse("Topic registeredsuccessfully!"));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyTopic(@Valid @PathVariable Integer id, @RequestBody Topic topic) {
        topicService.modifyTopic(topic);
        return ResponseEntity.ok(new MessageResponse("Topic modified successfully!"));
    }

    @CrossOrigin
    @PutMapping("/{id}/validation")
    public ResponseEntity<?> validationTopic(@Valid @PathVariable Integer id) {
        topicService.validationTopic(id);
        return ResponseEntity.ok(new MessageResponse("Topic is validated !"));
    }

    @CrossOrigin
    @PutMapping("/{id}/unvalidation")
    public ResponseEntity<?> unvalidationTopic(@Valid @PathVariable Integer id) {
        topicService.unvalidationTopic(id);
        return ResponseEntity.ok(new MessageResponse("Topic is unvalidated !"));
    }
}
