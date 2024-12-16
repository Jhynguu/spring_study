package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Web02Application.class, args);
    }

    @RequestMapping( "/" )
    @ResponseBody
    public String index() {
        return "Hello String Boot";
    }

    @RequestMapping( "/hello1" )
    public String hello1() {
        return "hello1";
    }
}
