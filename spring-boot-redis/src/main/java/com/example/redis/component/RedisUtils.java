package com.example.redis.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 读取缓存
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 写入缓存
    public void set(final String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 更新缓存
    public void update(final String key, String value) {
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除缓存
    public void delete(final String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 判断某个键是否存在
    public boolean has(String key) {
        return redisTemplate.hasKey(key);
    }
}
