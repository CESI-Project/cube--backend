package com.svt.cube.repository;

import java.util.List;

import com.svt.cube.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByFamilyTagId(Integer familyTagId);
}
