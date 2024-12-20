package com.example.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    // 단순 리다이렉션
    @RequestMapping("/redirect")
    public String redirectExample() {
        return "redirect:/newPage";
    }

    // 파라미터와 함께 리다이렉션
    @RequestMapping("/redirectWithParams")
    public String redirectWithParams() {
        return "redirect:/newPage?status=success";
    }

    // 새로운 페이지를 위한 핸들러
    @RequestMapping("/newPage")
    public String newPage() {
        return "newPage";
    }
}
