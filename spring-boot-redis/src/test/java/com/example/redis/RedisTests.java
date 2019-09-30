package com.example.redis;

import com.example.redis.component.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTests {
    @Resource
    private RedisUtils redisUtils;

    // 插入缓存数据
    @Test
    public void set() {
        redisUtils.set("redis_key", "redis_vale");
    }

    // 读取缓存数据
    @Test
    public void get() {
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }

    // 更新缓存数据
    @Test
    public void update() {
        redisUtils.update("redis_key", "newValue");
    }

    // 删除缓存数据
    @Test
    public void delete() {
        redisUtils.delete("redis_key");
    }

    // 判断某个键是否存在
    @Test
    public void has() {
        Boolean value = redisUtils.has("redis_key");
        System.out.println(value);
    }
}