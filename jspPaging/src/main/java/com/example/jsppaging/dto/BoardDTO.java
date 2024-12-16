package com.example.jsppaging.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Data
public class BoardDTO {
    private int seq;
    private String subject;
    private String writer;
    private Date wdate;
    private int hit;
}
