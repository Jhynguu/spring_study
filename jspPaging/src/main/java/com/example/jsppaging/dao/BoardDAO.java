package com.example.jsppaging.dao;

import com.example.jsppaging.dto.BoardDTO;
import com.example.jsppaging.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDTO> getBoards(int page, int size) {
        int offset = (page - 1) * size;
        return boardMapper.getBoards(offset, size);
    }

    public int getTotalCount() {
        return boardMapper.getTotalCount();
    }
}
