<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
	//全局参数
	request.setAttribute("compName", "北京泰乐德信息技术有限公司");
	request.setAttribute("projectName", "泰乐德移动指挥调度");
	request.setAttribute("pageTitle", "泰乐德");
%>