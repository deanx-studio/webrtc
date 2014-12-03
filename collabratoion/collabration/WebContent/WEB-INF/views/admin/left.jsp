<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/public/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="span3" style="width: 200px;">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<li class="nav-header">用户管理</li>

			<li <c:if test="${menuInx==1 }">class="active"</c:if>><a
				href="${context }/admin/user/list">用户管理</a></li>
			<li <c:if test="${menuInx==2 }">class="active"</c:if>><a
				href="${context }/term/list">终端管理</a></li>

			<li class="nav-header">操作员</li>
			<li><a href="${context }/conducter/videoTerm?id=${termId}">视频调度</a></li>
			<li><a href="${context }/conducter/audioTerm?id=${termId}">音频调度</a></li>
			<li class="nav-header">用户</li>
			<li><a href="${context }/user/term?id=${termId}">用户终端</a></li>
			<li class="nav-header">系统设置</li>
			<li><a href="${context }/admin/param/websocket">WEB Socket参数配置</a></li>
			<li><a href="${context }/admin/param/ami">AMI参数配置</a></li>
			<!-- 
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Link</a></li>
			 -->
		</ul>
	</div>
</div>