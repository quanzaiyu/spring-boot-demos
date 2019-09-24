package com.example.jpa.multi.datasource.repository.test2;

import com.example.jpa.multi.datasource.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserTest2Repository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
}