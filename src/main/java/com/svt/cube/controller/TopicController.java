package com.svt.cube.controller;

import com.svt.cube.entity.AllTopicInfo;
import com.svt.cube.entity.Comment;
import com.svt.cube.entity.ResponseComment;
import com.svt.cube.entity.Tag;
import com.svt.cube.entity.Topic;
import com.svt.cube.payload.response.MessageResponse;
import com.svt.cube.repository.ResponseCommentRepository;
import com.svt.cube.service.CommentService;
import com.svt.cube.service.TopicService;
import com.svt.cube.service.ViewService;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/topic")
public class TopicController {

  private final TopicService topicService;

  @Autowired
  public TopicController(TopicService topicService) {
    this.topicService = topicService;
  }

  @CrossOrigin
  @GetMapping("/notConnected")
  public List<Topic> getTopicsNotConnected() {
    return topicService.getTopicsNotConnected();
  }

  // decommenter quand fait en front
  // @CrossOrigin
  // @GetMapping("user/{id}")
  // public List<Topic> getTopics(@Valid @PathVariable Integer id) {
  // return topicService.getTopics(id);
  // }

  // supp quand celle du dessus remise
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

  @CrossOrigin
  @PostMapping
  public ResponseEntity<?> createTopic(@Valid @RequestBody Topic topic) {
    topicService.createTopic(topic);
    return ResponseEntity.ok(new MessageResponse("Topic registered successfully!"));
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
  public AllTopicInfo getTopicById(@PathVariable Integer id) {
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
  @PutMapping("/{id}")
  public ResponseEntity<?> modifyTopic(@Valid @PathVariable Integer id, @RequestBody Topic topic) {
    topicService.modifyTopic(id, topic);
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

  @CrossOrigin
  @DeleteMapping("/admin/{id}")
  // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
  public void deleteTagAdmin(@PathVariable Integer id) {
    topicService.deleteTagAdmin(id);
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  // @PreAuthorize("hasRole('ROLE_USER')")
  public void deleteTag(@PathVariable Integer id, @RequestBody Integer userId) {
    topicService.deleteTag(id, userId);
  }
}
