<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // form.jsp
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="./form_ok.do" method="get">
    데이터 <input type="text" name="data" />
    <input type="submit" value="get 방식 전송" />
</form>

<br />

<form action="./form_ok.do" method="post">
    데이터 <input type="text" name="data" />
    <input type="submit" value="post 방식 전송" />
</form>

</body>
</html>