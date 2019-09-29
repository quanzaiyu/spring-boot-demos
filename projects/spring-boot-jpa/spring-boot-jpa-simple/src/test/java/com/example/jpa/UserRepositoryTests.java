package com.example.jpa;

import com.example.jpa.enums.UserSexEnum;
import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
//        // 添加
//        userRepository.save(new User("xiaoyu", "123456", UserSexEnum.MAN, "xiaoxiaoyu"));
//
//        // 删除
//        userRepository.delete(userRepository.findByUserName("aa1"));
//
//        // 查询
//        String name = userRepository.findByUserNameOrNickName("", "xiaoxiaoyu").getNickName();
//        System.out.println(name);
//
//        // 长度
//        System.out.println(userRepository.findAll().size());
    }

}
