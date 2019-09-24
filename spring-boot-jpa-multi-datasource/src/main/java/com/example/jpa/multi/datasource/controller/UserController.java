package com.example.jpa.multi.datasource.controller;

import com.example.jpa.multi.datasource.enums.UserSexEnum;
import com.example.jpa.multi.datasource.model.User;
import com.example.jpa.multi.datasource.repository.test1.UserTest1Repository;
import com.example.jpa.multi.datasource.repository.test2.UserTest2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserTest1Repository userTest1Repository;

    @Autowired
    private UserTest2Repository userTest2Repository;

    @RequestMapping("/getUsers1")
    public List<User> getUsers1() {
        List<User> users = userTest1Repository.findAll();
        return users;
    }

    @RequestMapping("/getUsers2")
    public List<User> getUsers2() {
        List<User> users = userTest2Repository.findAll();
        return users;
    }

    @RequestMapping("/testSave")
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userTest1Repository.save(new User("xiaoyu1", "123456", UserSexEnum.MAN, "xiaoxiaoyu1", "aa1@126.com", formattedDate));
        userTest1Repository.save(new User("xiaoyu2", "123456", UserSexEnum.MAN, "xiaoxiaoyu2", "aa2@126.com", formattedDate));
        userTest1Repository.save(new User("xiaoyu3", "123456", UserSexEnum.WOMAN, "xiaoxiaoyu3", "aa3@126.com", formattedDate));
    }
}
