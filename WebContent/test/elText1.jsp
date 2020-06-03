<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setAttribute("username", "ssar");
	RequestDispatcher dis = request.getRequestDispatcher("elText2.jsp");
	dis.forward(request, response);
%>