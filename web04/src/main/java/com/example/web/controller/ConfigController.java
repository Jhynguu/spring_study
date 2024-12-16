package com.example.web.controller;

import com.example.web.model.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @Autowired
    private JdbcDAO jdbcDAO;

    @RequestMapping( "/jdbc1.do" )
    public String jdbc1(Model model) {

        String result = jdbcDAO.jdbc1();
        model.addAttribute( "result", result );

        return "jdbc1";
    }
}
