package com.springboot.sample.service.user;


import com.springboot.sample.entity.User;

import java.util.List;

public interface userService {

     void save(User user);

     void deleteById(String userId);

     void update(User user);

     List<User> queyList(String userId);

}
