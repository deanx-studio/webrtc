<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
	request.setAttribute("wx_code", request.getParameter("code"));
%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<div class="navbar navbar-fixed-top" style="position: fixed;">
	<div class="navbar">
		<ul class="nav">
			<li><a href="${context}/leader/home" style="margin-left: 20px;"><img
					alt="" src="${context}/resources/image/client/xzjz_tm.png"
					style="height: 20px;" /></a></li>
		</ul>
		<div class="navbar-inner">

			<ul class="nav" style="margin-top: 0px;">
				<c:choose>
					<c:when test="${empty username}">
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">菜单<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${context}/leader/home">产品列表</a></li>
							</ul></li>
					</c:otherwise>
				</c:choose>

			</ul>

			<ul class="nav pull-right" style="margin-top: 0px;">
				<c:choose>
					<c:when test="${empty username}">
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">您好,${username}<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${context}/leader/order/list">我的订单</a></li>
								<li><a href="${context}/leader/benifit">我的收益</a></li>
								<li class="divider"></li>
								<li><a href="${context}/static/j_spring_security_logout">退出</a>
								</li>
							</ul></li>
					</c:otherwise>
				</c:choose>

			</ul>


		</div>
	</div>

</div>
<div style="height: 5px;"></div>