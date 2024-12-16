<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    out.println( "jdbc1.jsp<br />" );

    String result = (String)request.getAttribute( "result" );
    out.println( "현재 시간 : " +  result );
%>