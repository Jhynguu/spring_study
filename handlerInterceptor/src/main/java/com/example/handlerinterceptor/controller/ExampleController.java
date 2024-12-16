package com.example.handlerinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/api/test")
    public String testEndpoint() {
        return "This is a test endpoint.";
    }

    @GetMapping("/api/login")
    public String loginEndpoint() {
        return "This is the login endpoint.";
    }
}