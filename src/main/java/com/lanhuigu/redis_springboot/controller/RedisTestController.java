package com.lanhuigu.redis_springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HeChengyao
 * @date: 2021/9/2 16:16
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    public static final Logger log= LoggerFactory.getLogger(RedisTestController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/testRedis")
    public String testRedis() {
        //设置值到redis
        redisTemplate.opsForValue().set("name","rose");
        //从redis获取值
        String name = (String)redisTemplate.opsForValue().get("name");
        log.info(">>>>>> RedisTestController: testRedis.name = {}", name);
        return name;
    }

}
