<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.jsppaging.dto.BoardDTO" %>

<html>
<head>
    <title>게시글 보기</title>
</head>
<body>
<h1><%= ((BoardDTO) request.getAttribute("board")).getSubject() %></h1>
<p>작성자: <%= ((BoardDTO) request.getAttribute("board")).getWriter() %></p>
<p>작성일: <%= ((BoardDTO) request.getAttribute("board")).getWdate() %></p>
<p>조회수: <%= ((BoardDTO) request.getAttribute("board")).getHit() %></p>
</body>
</html>
