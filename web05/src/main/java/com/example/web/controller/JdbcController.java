package com.example.web.controller;

import com.example.web.dao.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JdbcController {

    @Autowired
    private JdbcDAO jdbcDAO;

    @RequestMapping( "/time.do" )
    public String time(Model model) {
        System.out.println( "time()" );
        model.addAttribute( "result", jdbcDAO.select() );
        return "time";
    }

}
