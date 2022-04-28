package com.svt.cube.service;

import com.svt.cube.entity.Tag;
import com.svt.cube.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }

    public void modifyTag(Integer id, Tag tag) {
        Tag updatedTag = tagRepository.getById(id);
        if (tag.getNameEn() != null) {
            updatedTag.setNameEn(tag.getNameEn());
        }
        if (tag.getNameFr() != null) {
            updatedTag.setNameFr(tag.getNameFr());
        }
        tagRepository.save(updatedTag);
    }
}