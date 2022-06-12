package com.svt.cube.service;

import com.svt.cube.entity.FamilyTag;
import com.svt.cube.repository.FamilyTagRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public void modifyFamilyTag(FamilyTag familyTag) {
    familyTagRepository.save(familyTag);
  }
}