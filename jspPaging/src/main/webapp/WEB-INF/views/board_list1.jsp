<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jsppaging.dto.BoardDTO" %>

<%
    // 현재 페이지와 총 페이지 수 가져오기
    int currentPage = (Integer) request.getAttribute("currentPage");
    int totalPage = (Integer) request.getAttribute("totalPage");
%>

<table border="1">
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<BoardDTO> boards = (List<BoardDTO>) request.getAttribute("boards");
        for (BoardDTO board : boards) {
    %>
    <tr>
        <td><%= board.getSeq() %></td>
        <td><a href="board_view1.jsp?seq=<%= board.getSeq() %>&cpage=<%= currentPage %>"><%= board.getSubject() %></a></td>
        <td><%= board.getWriter() %></td>
        <td><%= board.getWdate() %></td>
        <td><%= board.getHit() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<!-- 페이지 네비게이션 -->
<div class="paginate_regular">
    <div align="absmiddle">
        <%
            // 페이지 네비게이션 로직
            if (currentPage > 1) {
                out.println("<a href='/board?cpage=" + (currentPage - 1) + "'>&lt; 이전</a>");
            }
            for (int i = 1; i <= totalPage; i++) {
                if (i == currentPage) {
                    out.println("<strong>" + i + "</strong>");
                } else {
                    out.println("<a href='/board?cpage=" + i + "'>" + i + "</a>");
                }
            }
            if (currentPage < totalPage) {
                out.println("<a href='/board?cpage=" + (currentPage + 1) + "'>다음 &gt;</a>");
            }
        %>
    </div>
</div>
