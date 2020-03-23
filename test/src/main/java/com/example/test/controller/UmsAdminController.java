package com.example.test.controller;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.example.test.common.Result;
import com.example.test.component.RedisUtils;
import com.example.test.mdb.mapper.UmsAdminMapper;
import com.example.test.mdb.model.UmsAdmin;
import com.example.test.mdb.model.UmsAdminExample;
import com.example.test.service.UmsAdminService;
import io.swagger.annotations.Api;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Api(tags = "UmsAdminController", description = "管理员")
@RestController
@RequestMapping(value="/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private UmsAdminMapper adminMapper;

    @GetMapping("/find")
    public Result find(@RequestParam(value = "name", required = false) String username) {
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        if (umsAdmin == null) {
            return Result.error("error");
        }

        return Result.ok(umsAdmin);
    }
}

