package dev.com.controller;

import dev.com.mapper.UserMapper;
import dev.com.pojo.User;
import dev.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getUsers(){
       return userService.getUsers();
    }
    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }

    @RequestMapping("/getUserById")
    public User getUserById(String id){
      return   userMapper.getUser(id);
    }
}
