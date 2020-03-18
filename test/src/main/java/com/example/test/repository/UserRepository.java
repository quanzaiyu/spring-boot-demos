package com.example.test.repository;

import com.example.test.model.User;
import com.example.test.model.UserScoreVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from user u where u.name = ?1")
    User findByNames(String name);

    @Query(value = "SELECT new com.example.test.model.UserScoreVo(u, s) FROM user u, score s WHERE u.id = s.user_id AND u.id = ?1")
    List<UserScoreVo> findScore(Long id);
}
