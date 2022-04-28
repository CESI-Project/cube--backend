package com.svt.cube.service;

import com.svt.cube.entity.FamilyTag;
import com.svt.cube.repository.FamilyTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyTagService {
    private final FamilyTagRepository familyTagRepository;

    @Autowired
    public FamilyTagService(FamilyTagRepository familyTagRepository) {
        this.familyTagRepository = familyTagRepository;
    }

    public List<FamilyTag> getAllFamilyTags() {
        return familyTagRepository.findAll();
    }

    public FamilyTag createFamilyTag(FamilyTag familyTag) {
        return familyTagRepository.save(familyTag);
    }

    public void deleteFamilyTag(Integer id) {
        familyTagRepository.deleteById(id);
    }

    public void modifyFamilyTag(Integer id, FamilyTag familyTag) {
        FamilyTag updatedTag = familyTagRepository.getById(id);
        if (familyTag.getNameEn() != null) {
            updatedTag.setNameEn(familyTag.getNameEn());
        }
        if (familyTag.getNameFr() != null) {
            updatedTag.setNameFr(familyTag.getNameFr());
        }
        if (familyTag.getTags() != null) {
            updatedTag.setTags(familyTag.getTags());
        }
        familyTagRepository.save(updatedTag);
    }
}