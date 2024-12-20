package com.example.parameterattribute.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParameterAttributeController {

    @GetMapping("/testParameter")
    @ResponseBody
    public String testParameter(@RequestParam String key1, @RequestParam String key2) {
        return "Key1: " + key1 + ", Key2: " + key2;
    }

    @GetMapping("/testAttribute")
    @ResponseBody
    public String testAttribute(HttpServletRequest request) {
        // 요청 속성 설정
        request.setAttribute("user", "홍길동");
        String user = (String) request.getAttribute("user");
        return "User: " + user;
    }

    @PostMapping("/submit")
    public String handleForm(HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.println("Username: " + username);

        // JSP에 사용자 이름 전달하기 위해 사용
        request.setAttribute("username", username);
        return "result";
    }

    @GetMapping("/search")
    public String search(HttpServletRequest request) {
        String keyword = request.getParameter("q");
        System.out.println("Search Keyword: " + keyword);

        // JSP에 검색 키워드 전달
        request.setAttribute("keyword", keyword);

        return "searchResult"; // searchResult.jsp로 포워딩
    }

    // 클라이언트의 요청을 받아서 메시지를 설정한 후, /nextPage로 포워딩한다.
    @RequestMapping("/forwardExample")
    public String forwardExample(HttpServletRequest request) {
        request.setAttribute("message", "Hello from Controller");
        return "forward:/nextPage";
    }

    // nextPage.jsp 파일로 포워딩하여 요청 속성인 "message"를 사용할 수 있게 함
    @RequestMapping("/nextPage")
    public String nextPage(HttpServletRequest request) {
        // request에서 message 속성을 JSP에서 사용할 수 있도록 설정
        return "nextPage"; // nextPage.jsp로 포워딩
    }


}
