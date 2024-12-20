package com.example.jpql.controller;

import com.example.jpql.domain.User;
import com.example.jpql.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/findByName")
    public List<User> getUsersByName(@RequestParam String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/findTop")
    public List<User> getTop3UsersByAge() {
        return userRepository.findTop3ByOrderByAgeDesc();
    }

}
