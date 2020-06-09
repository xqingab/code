package com.springboot.sample.controller.user;

import com.springboot.sample.common.BaseResult;
import com.springboot.sample.entity.User;
import com.springboot.sample.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;


    @GetMapping("/save")
    public BaseResult saveUser(User user) {
        try {
            userService.save(user);
            return new BaseResult(null,true);
        }catch (Exception e) {
            System.err.println(e);
            return new BaseResult("保存用户信息失败",null,false);
        }
    }

    @RequestMapping("/delete/{userId}")
    public BaseResult delete(String userId){
        try {
            userService.deleteById(userId);
            return new BaseResult(null,true);
        }catch (Exception e){
            return new BaseResult("删除失败",null,false);
        }
    }

    @RequestMapping("/update")
    public BaseResult update(User user) {
        try {
            userService.update(user);
            return new BaseResult(null,true);
        }catch (Exception e){
            return new BaseResult("更新失败",null,false);
        }
    }

    @RequestMapping("/{userId}")
    public BaseResult queryUserList(String userId) {
        try {
          List<User> userList = userService.queyList(userId);
            return new BaseResult(userList,true);
        }catch (Exception e) {
            return new BaseResult("根据id查询失败",null,false);
        }
    }
}
