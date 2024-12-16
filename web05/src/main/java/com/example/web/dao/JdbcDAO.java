package com.example.web.dao;

import com.example.web.mapper.JdbcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {

    @Autowired
    private JdbcMapper jdbcMapper;

    public String select() {
        System.out.println( "JdbcDAO select() 호출" );
        return jdbcMapper.select();
    }
}
