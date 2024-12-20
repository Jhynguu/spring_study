package com.example.modelmapper.controller;

import com.example.modelmapper.domain.User;
import com.example.modelmapper.dto.UserDTO;
import com.example.modelmapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setFullName("홍길동");
        user1.setEmail("hong@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setFullName("김철수");
        user2.setEmail("kim@example.com");

        users.add(user1);
        users.add(user2);

        return userService.convertToDTOList(users);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userService.convertToEntity(userDTO);
        // 저장 로직 추가 필요
        return userService.convertToDTO(user);
    }
}
