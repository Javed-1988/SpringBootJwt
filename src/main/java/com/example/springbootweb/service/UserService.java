package com.example.springbootweb.service;

import com.example.springbootweb.model.UserInfo;
import com.example.springbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public UserInfo saveUser(UserInfo userInfo)
    {
        return userRepository.save(userInfo);

    }

}
