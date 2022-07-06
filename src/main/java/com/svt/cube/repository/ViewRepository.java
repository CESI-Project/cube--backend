package com.svt.cube.repository;

import com.svt.cube.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View, Integer> {

  View findOneBytopicIdAndUserId(Integer topicId, Integer userId);

  Integer countByTopicId(Integer topicId);

  Integer countByUserId(Integer userId);

  @Query("SELECT COUNT(v) FROM View v WHERE v.userId = null")
  int countNotUsers();
}
