package com.example.test.controller;

import com.example.test.component.RedisUtils;
import com.example.test.common.Result;
import io.swagger.annotations.Api;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@Api(tags = "LoginController", description = "授权认证及登录")
@RestController
@RequestMapping(value="/login")
public class LoginController {
    @Resource
    private RedisUtils redisUtils;

    @GetMapping("/code")
    public Result code(@RequestParam String phone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisUtils.set("portal:authCode:" + phone, sb.toString());
        // 设置失效时间为2min
        redisUtils.expire("portal:authCode:" + phone, 120);
        return Result.ok("获取验证码成功");
    }

    @GetMapping("/auth")
    public Result user(@RequestParam String phone, @RequestParam String code) {
        if (StringUtils.isEmpty(code)) {
            return Result.error("请输入验证码");
        }
        String realAuthCode = redisUtils.get("portal:authCode:" + phone);
        boolean result = code.equals(realAuthCode);
        if (result) {
            return Result.ok("验证码校验成功");
        } else {
            return Result.error("验证码不正确");
        }
    }
}
