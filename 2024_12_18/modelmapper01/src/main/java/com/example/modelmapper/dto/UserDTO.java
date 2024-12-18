package com.example.modelmapper.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    // 필드명이 다를 경우 name => Entity의 fullName 필드에 매핑
    private String name;
    private String email;

}
