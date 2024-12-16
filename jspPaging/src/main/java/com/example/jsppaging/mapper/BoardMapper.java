package com.example.jsppaging.mapper;

import com.example.jsppaging.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getBoards(@Param("offset") int offset, @Param("limit") int limit);
    int getTotalCount();
}
