package com.example.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {

    @RequestMapping("/hello1.do")
    public String hello1() {
        return "hello1";
    }

    @RequestMapping("/hello2.do")
    public ModelAndView hello2() {
        return new ModelAndView("hello2");
    }

    //
    @RequestMapping("/form.do")
    public ModelAndView form() {
        return new ModelAndView("form");
    }

/*
    @RequestMapping( "/form_ok.do" )
    public ModelAndView form_ok(HttpServletRequest request) {
        // request.getParameter()
        System.out.println( "data : " + request.getParameter( "data" ) );

        //request.setAttribute( "data", request.getParameter( "data" ) );
        ModelAndView modelAndView = new ModelAndView( "form_ok" );
        modelAndView.addObject( "data", request.getParameter( "data" ) );
        return modelAndView;
    }*/

    @RequestMapping("/form_ok.do")
    //public String form_ok(@RequestParam("data") String data1) {
    public String form_ok(String data, Model model) {
        System.out.println("data1 : " + data);

        model.addAttribute("data", data );
        return "form_ok";
    }
}