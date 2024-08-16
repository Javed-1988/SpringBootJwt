package com.example.springbootweb.controller;

import com.example.springbootweb.model.UserInfo;
import com.example.springbootweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/v1/user")
public class UserController {




    private final UserService userService;
    UserController(UserService userService)
    {
        this.userService=userService;
    }


    @PostMapping("/saveuser")
    public UserInfo saveUser(@RequestBody UserInfo user)
    {
        log.info(user.toString());
        return userService.saveUser(user);
    }
    @GetMapping("/get")
    public String getUser()
    {
       return "Hi User";
    }
}
