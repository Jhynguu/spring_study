package com.example.jsppaging.controller;

import com.example.jsppaging.dao.BoardDAO;
import com.example.jsppaging.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardDAO boardDAO;

    @GetMapping("/board")
    public String list(@RequestParam(defaultValue = "1") int cpage, Model model) {
        int recordPerPage = 10; // 한 페이지당 게시물 수
        int totalRecord = boardDAO.getTotalCount(); // 전체 게시물 수
        int totalPage = (int) Math.ceil((double) totalRecord / recordPerPage); // 전체 페이지 수

        // 게시물 리스트 가져오기
        List<BoardDTO> boards = boardDAO.getBoards(cpage, recordPerPage);
        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", cpage);
        model.addAttribute("totalPage", totalPage);
        return "board_list1"; // board_list1.jsp를 반환
    }
}

