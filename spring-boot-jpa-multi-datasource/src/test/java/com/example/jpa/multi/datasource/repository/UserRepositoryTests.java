package com.example.jpa.multi.datasource.repository;

import com.example.jpa.multi.datasource.enums.UserSexEnum;
import com.example.jpa.multi.datasource.repository.test2.UserTest2Repository;
import com.example.jpa.multi.datasource.model.User;
import com.example.jpa.multi.datasource.repository.test1.UserTest1Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Resource
    private UserTest1Repository userTest1Repository;
    @Resource
    private UserTest2Repository userTest2Repository;

    @Test
    public void testSave() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userTest1Repository.save(new User("xiaoyu1", "123456", UserSexEnum.MAN, "xiaoxiaoyu", "aa1@126.com", formattedDate));
        userTest1Repository.save(new User("xiaoyu2", "123456", UserSexEnum.MAN, "xiaoxiaoyu", "aa2@126.com", formattedDate));
        userTest1Repository.save(new User("xiaoyu3", "123456", UserSexEnum.WOMAN, "xiaoxiaoyu", "aa3@126.com", formattedDate));
    }

    @Test
    public void testDelete() throws Exception {
        userTest1Repository.deleteAll();
        userTest2Repository.deleteAll();
    }

    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("xiaoyu1", "123456", UserSexEnum.MAN, "xiaoxiaoyu", "aa1@126.com", formattedDate);

        userTest1Repository.findAll();
        userTest2Repository.findById(3l);
        userTest2Repository.save(user);
        user.setId(2l);
        userTest1Repository.delete(user);
        userTest1Repository.count();
        userTest2Repository.findById(3l);
    }
}