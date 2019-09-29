package com.example.mybatis;

import com.example.mybatis.entity.UserEntity;
import com.example.mybatis.enums.UserSexEnum;
import com.example.mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new UserEntity("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("cc1", "b123456", UserSexEnum.WOMAN));
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = userMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userMapper.getOne(20l);
        System.out.println(user.toString());
        user.setNickName("yu");
        userMapper.update(user);
        Assert.assertTrue(("yu".equals(userMapper.getOne(20l).getNickName())));
    }

}
