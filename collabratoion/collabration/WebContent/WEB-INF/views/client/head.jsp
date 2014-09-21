<%@page import="java.security.Principal"%>
<%@page import="net.zhinet.travel.pojo.basepojo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal" />
</sec:authorize>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="${context}">泰乐德协同</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="${context}">首页</a></li>
					<li><a href="${context}/log">日志</a></li>
					<li><a href="${context}/about">关于</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div style="height:0px;"></div>