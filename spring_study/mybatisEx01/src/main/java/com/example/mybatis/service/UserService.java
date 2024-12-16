package com.example.mybatis.service;

import com.example.mybatis.dto.UserTO;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserTO> getAllUsers() {
        return userMapper.findAllUsers();
    }

    public UserTO getUserById(int id) {
        return userMapper.findUserById(id);
    }
}
