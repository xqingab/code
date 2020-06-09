package com.springboot.sample.service.user.impl;

import com.springboot.sample.dao.user.userMapper;
import com.springboot.sample.entity.User;
import com.springboot.sample.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class userSevieceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${sex}")
    private String sex;

    @Override
    @Transactional
    public void save(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        userMapper.save(user);
    }

    @Override
    @Transactional
    public void deleteById(String userId) {
        userMapper.deleteById(userId);
    }

    @Override
    @Transactional
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> queyList(String userId) {
       List<User> userList = userMapper.queryList(userId);
        return userList;
    }
}

