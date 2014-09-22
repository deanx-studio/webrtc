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
<div class="navbar navbar-fixed-top"
	style="position: fixed; height: 55px;">
	<div class="navbar">
		<ul class="nav">
			<li><a href="${context}" style="margin-left: 20px;"><img
					alt="" src="${context}/resources/image/client/ps144_logo.png"
					style="height: 40px;" /></a></li>
		</ul>
		<div class="navbar-inner">

			<ul class="nav" style="margin-top: 8px;">
				<c:choose>
					<c:when test="${empty username}">
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">系统设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${context}/super/user/add">新增管理员</a></li>
								<li><a href="${context}/super/user/list">管理员列表</a></li>
								
								<li class="divider"></li>

								<li><a href="${context}/super/weixin/add">新增微信帐号</a></li>
								<li><a href="${context}/super/weixin/list">微信帐号列表</a></li>
																
								<li class="divider"></li>
								<li><a href="${context}/static/j_spring_security_logout">退出</a>
								</li>
							</ul></li>
						

					</c:otherwise>
				</c:choose>

			</ul>
			<ul class="nav pull-right" style="margin-top: 18px;margin-right:20px;"><li class="dropdown">超级管理员：${username}，您好,&nbsp;</li></ul>	
						
		
		</div>
	</div>
	<!-- 
	<div class="navbar-inner">
		<div class="container">



			<ul class="nav">
				<li><a href="${context}"><img alt=""
						src="${context}/resources/image/client/ps144_logo.png"
						style="height: 40px;" /></a></li>
			</ul>

			<ul class="nav" style="margin-top: 8px;">

				<c:choose>
					<c:when test="${empty username}">
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">图文消息设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${context}/event/article/keys">专题目录浏览</a></li>
								<li><a href="${context}/event/article/add">新增专题目录</a></li>
								<li class="divider"></li>

								<li><a href="${context}/admin/article/list.do?page=1">图文消息浏览</a></li>
								<li><a href="${context}/admin/article/add.do">新增图文消息</a></li>
								<li class="divider"></li>

								<li><a href="${context}/menu/list">菜单浏览</a></li>
								<li><a href="${context}/menu/add">新增菜单</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">您好,${username}<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${context}/static/j_spring_security_logout">退出</a>
								</li>
							</ul></li>

					</c:otherwise>
				</c:choose>
			</ul>

		</div>
	</div>
	-->
</div>
<div style="height: 55px;"></div>
<!-- 
<script type="text/javascript">
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
	});
	/*
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
	});
	*/
function viewProfile(){
	alert("ok");
	 if (typeof WeixinJSBridge != "undefined" && WeixinJSBridge.invoke){
	 
		 WeixinJSBridge.invoke('profile',{
	 'username':'gh_ff9414edf993',
	 'scene':'57'
	 });
	 
	 /*
	 WeixinJSBridge.invoke("getNetworkType", {},
	            function(e) {
	                alert(netType[e.err_msg])
	            });*/
	 }
	 else
		 {
		 alert("WeixinJSBridge undefine.");
		 }
	 }
</script>
<a href="javascript:viewProfile();">网络状态</a><br/>code:
<%=request.getQueryString()%>
 -->
<!--
关注 <a href="weixin://contacts/profile/gh_ff9414edf993">想走就走</a>
-->