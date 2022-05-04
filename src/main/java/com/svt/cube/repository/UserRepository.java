package com.svt.cube.repository;

import java.util.List;
import java.util.Optional;
import com.svt.cube.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    @Query("Select u from User u where id != :userId")
    List<User> findAllWithoutMyUser(@Param("userId") Long userId);
}
