package com.example.web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcDAO {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //public void jdbc1() {
    public String jdbc1() {
        //System.out.println( "dataSource : " + dataSource );
        //System.out.println( "jdbcTemplate : " + jdbcTemplate );

        String result = jdbcTemplate.queryForObject( "select now() as now", String.class );
        System.out.println( "result : " + result );
        return result;
    }

}
