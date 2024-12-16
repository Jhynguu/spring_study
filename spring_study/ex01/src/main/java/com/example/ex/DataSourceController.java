package com.example.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/datasource-info")
    public String getDataSourceInfo() {
        StringBuilder info = new StringBuilder();
        info.append("DataSource Class: ").append(dataSource.getClass().getName()).append("<br>");
        try {
            info.append("JDBC URL: ").append(dataSource.getConnection().getMetaData().getURL()).append("<br>");
            info.append("DB Username: ").append(dataSource.getConnection().getMetaData().getUserName()).append("<br>");
        } catch (Exception e) {
            info.append("Error retrieving DataSource info: ").append(e.getMessage());
        }
        return info.toString();
    }
}