<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">${projectName}</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<s:url var="recommend_url" value="/admin/article/recommend.do"></s:url>
				<li class="active"><a href="${recommend_url}">图文</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</div>
<!-- /.navbar -->
