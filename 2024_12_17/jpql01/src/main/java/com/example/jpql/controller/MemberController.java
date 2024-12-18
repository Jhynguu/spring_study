package com.example.jpql.controller;

import com.example.jpql.dto.Member;
import com.example.jpql.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/age/{age}")
    public List<Member> getMembersAboveAge(@PathVariable int age) {
        return memberService.findMembersAboveAge(age);
    }
}
