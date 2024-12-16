package com.example.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {

    @RequestMapping("/form")
    public ModelAndView form() {
        return new ModelAndView("form");
    }

    @RequestMapping("/form_ok")
    public ModelAndView form_ok(HttpServletRequest request) {
        String data = request.getParameter("data");
        System.out.println("data = " + data);
        ModelAndView mav = new ModelAndView("form_ok");
        mav.addObject("data", data);
        return mav;
    }
}
