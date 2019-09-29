package com.example.websocket.controller;

import com.example.websocket.component.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    // 页面请求
    @GetMapping("/socket/{cid}")
    public String index(ModelMap map, @PathVariable String cid) {
        map.addAttribute("cid", cid);
        return "socket";
    }

    // 单发
    @ResponseBody
    @RequestMapping("/socket/push/{from}/{to}")
    public Result pushToOne(@PathVariable String from, @PathVariable String to, String message) {
        System.out.println("one");
        try {
            WebSocketServer.send(message, from, to);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(from + " : " + to + "#" + e.getMessage());
        }
        return Result.ok("发送成功");
    }

    // 群发
    @ResponseBody
    @RequestMapping("/socket/push/{from}")
    public Result pushToAll(@PathVariable String from, String message) {
        System.out.println("all");
        try {
            WebSocketServer.send(message, from, null);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(from + " : " + null + "#" + e.getMessage());
        }
        return Result.ok("发送成功");
    }
}
