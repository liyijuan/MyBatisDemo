package com.github.yeecode.mybatisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public Object index() {
        User userParam = new User();
        userParam.setSchoolName("Sunny School");
        List<User> userList = userMapper.queryUserBySchoolName(userParam);
        for (User user : userList) {
            System.out.println("name : " + user.getName() + " ;  email : " + user.getEmail());
        }
        return userList;
    }
    @RequestMapping("/id/{id}")
    public Object queryById(@PathVariable int id){
        User user = userMapper.queryUserById(id);
//        System.out.println(user);
        return user;
    }
}
