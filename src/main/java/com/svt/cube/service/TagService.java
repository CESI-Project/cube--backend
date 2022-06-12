package com.svt.cube.service;

import com.svt.cube.entity.Tag;
import com.svt.cube.repository.TagRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

  private final TagRepository tagRepository;

  @Autowired
  public TagService(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public List<Tag> getAllTags() {
    return tagRepository.findAll();
  }

  public List<Tag> getFamilyTagsTags(Integer familyTagId) {
    return tagRepository.findAllByFamilyTagId(familyTagId);
  }

  public Tag createTag(Tag tag) {
    return tagRepository.save(tag);
  }

  public void deleteTag(Integer id) {
    tagRepository.deleteById(id);
  }

  public void modifyTag(Tag tag) {
    tagRepository.save(tag);
  }
}