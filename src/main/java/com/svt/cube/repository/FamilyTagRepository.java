package com.svt.cube.repository;

import com.svt.cube.entity.FamilyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyTagRepository extends JpaRepository<FamilyTag, Integer> {
}
