<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
	//全局参数
	request.setAttribute("compName", "德安智能工作室");
	request.setAttribute("projectName", "德安智能通信");
	request.setAttribute("pageTitle", "德安通信");
%>