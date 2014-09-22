<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<%-- <li><a href="${complaint_ui}">个人中心</a> <span class="divider">/</span></li> --%>
	<li class="active">景区导览</li>
</ul>
<style>
@import "${resource}/test/videobooth.css";
</style>
<div id="booth">
	<div id="videoDiv">
		<video id="video" width="720" height="480"></video>
	</div>
	<div id="dashboard">
		<div id="effects">
			<a class="effect" id="normal"></a>
			<a class="effect" id="western"></a>
			<a class="effect" id="noir"></a>
			<a class="effect" id="scifi"></a>
		</div>
		<div id="controls">
			<a class="control" id="play"></a>
			<a class="control" id="pause"></a>
			<a class="control" id="loop"></a>
			<a class="control" id="mute"></a>
		</div>
		<div id="videoSelection">
			<a class="videoSelection" id="video1"></a>
			<a class="videoSelection" id="video2"></a>
		</div>
	</div>
</div>
<script src="${resource}/test/webvilletv.js"></script>