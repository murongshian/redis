package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisService {
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public RedisService(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public String stringTest(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (String) redisTemplate.opsForValue().get("kak");
    }

    public Map<Object,Object> hashTest(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取整个map
        return redisTemplate.opsForHash().entries("user");
    }

    public Set<Object> setTest(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取所有元素
        return  redisTemplate.opsForSet().members("你好");
    }

    public List<Object> listTest(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  redisTemplate.opsForList().range("left-list",0,100);
    }
}