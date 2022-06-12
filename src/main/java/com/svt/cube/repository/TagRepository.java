package com.svt.cube.repository;

import com.svt.cube.entity.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

  List<Tag> findAllByFamilyTagId(Integer familyTagId);
}
