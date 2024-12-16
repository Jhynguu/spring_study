<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // form_ok.jsp

    String data = (String) request.getAttribute( "data" );
    out.println( "data : " + data );
%>