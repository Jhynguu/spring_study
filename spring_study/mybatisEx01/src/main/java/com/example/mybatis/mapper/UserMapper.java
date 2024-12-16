package com.example.mybatis.mapper;

import com.example.mybatis.dto.UserTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserTO> findAllUsers();

    UserTO findUserById(int id);
}
