package com.example.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @CrossOrigin(origins = "http://frontend.example.com")
    @GetMapping("/data")
    public String getData() {
        return "CORS 설정된 데이터";
    }
}
