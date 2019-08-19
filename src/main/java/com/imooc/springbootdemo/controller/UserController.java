package com.imooc.springbootdemo.controller;

import com.imooc.springbootdemo.domain.User;
import com.imooc.springbootdemo.repositpry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController 表示这个类是一个controller 同时返回一个ResponseBody，可以简单理解ResponseBody是一个jason格式的数据
 */
@RestController
public class UserController {
    private final UserRepository userRepository;

    /**
     *  springboot框架会 自动set UserController
     * @param userRepository
     */
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);

        return user;
    }

}
