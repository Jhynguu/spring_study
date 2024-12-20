package com.example.jpa.controller;

import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/demonstrate")
    public String demonstrate() {
        memberService.demonstrateEntityLifecycle();
        return "Member entity lifecycle demonstrated.";
    }
}
