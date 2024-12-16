package com.example.swagger.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Swagger!";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return message;
    }
}