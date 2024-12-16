package com.example.web.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JdbcMapper {

    String select();
}
