package com.springboot.sample.dao.user;

import com.springboot.sample.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {

     void save(User user);

     void deleteById(String userId);

     void update(User user);

     List<User> queryList(String userId);



}