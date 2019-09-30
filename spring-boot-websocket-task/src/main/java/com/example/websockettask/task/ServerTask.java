package com.example.websockettask.task;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class ServerTask {
    /**
     * 按照标准时间来算，每隔 1s 执行一次
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void websocket() throws Exception {
        String currentTime = DateUtil.formatDateTime(new Date());
        log.info("当前时间：{}", currentTime);
    }
}
