package com.example.test.controller;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.example.test.config.PageNumber;
import com.example.test.config.Result;
import com.example.test.model.User;
import com.example.test.model.UserScoreVo;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public User test(User user) {
        return user;
    }

    @GetMapping(value = "/hello/{name}", produces="application/json; charset=utf-8")
    public String sayHello(@PathVariable String name) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("data", "Hello " + name + "先生");
        return result.toString();
    }

    @GetMapping(value = { "/all", "/list", "/all/**/*" })
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/page")
    public Page<User> page(
        @RequestParam("page") Integer page,
        @RequestParam("size") Integer size,
        @RequestParam("sortType") String sortType
    ) {
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, "id") : new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page-1,size,sort);
        return userRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/score/{id}")
    public List<UserScoreVo> findScore(@PathVariable Long id) {
        return userRepository.findScore(id);
    }

    @GetMapping("/name/{name}")
    public User findName(@PathVariable String name) {
        return userRepository.findByNames(name);
    }
}
