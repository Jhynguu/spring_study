package com.example.web.controller;

import com.example.web.dto.Address;
import com.example.web.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ConfigController {

    @GetMapping("/search")
    public String search(@RequestParam String keyword) {
        return "Search keyword: " + keyword;
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id) {
    return "USER ID : " + id;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        return "Created user: " + user.getName();
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        return "Registered user: " + user.getName();
    }

    @PostMapping("/submit")
    public String submit(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "Submitted name: " + name;
    }

    @GetMapping("/headers")
    public String getHeaders(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @GetMapping("/cookies")
    public String getCookie(@CookieValue(value = "sessionId", defaultValue = "unknown") String sessionId) {
        return "Session ID: " + sessionId;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return "Uploaded file name: " + file.getOriginalFilename();
    }

    @PostMapping("/submit2")
    public String handleForm(
            @RequestParam String name,
            @RequestParam int age,
            @ModelAttribute Address address,
            @RequestHeader("User-Agent") String userAgent) {
        return String.format("Name: %s<br> Age: %d<br> Address: %s<br> User-Agent: %s",
                name, age, address.toString(), userAgent);
    }

}
