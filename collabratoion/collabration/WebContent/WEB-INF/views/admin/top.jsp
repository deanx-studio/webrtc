<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="${context }/admin/home">${projectName }</a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					欢迎:
					<c:choose>
						<c:when test="${not empty username}">
							${username}&nbsp;&nbsp;<a href="${context}/static/j_spring_security_logout">退出</a>
						</c:when>
					</c:choose>
				</p>

				<ul class="nav">
					<li class="active"><a href="${context }">首页</a></li>
					<li><a href="#about">关于</a></li>
					<li><a href="#contact">联系泰乐德</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>