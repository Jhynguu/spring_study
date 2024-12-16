<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // time.jsp
    String result = (String) request.getAttribute( "result" );
    out.println( "현재 시간 : " + result );
%>
