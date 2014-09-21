<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ include file="./public/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-CH">
<head>
<meta charset="utf-8">
<title>泰乐德协同指挥管理员操作台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="WEBRTC,SIP通信,协同指挥,调度系统,浏览器的WEB通信,无插件的通信">
<meta name="author" content="程序员老刘">
<meta name="Keywords"
	content="WEBRTC,SIP通信,协同指挥,调度系统,浏览器的WEB通信,无插件的通信,SIP,WEBRTC2SIP,PBX,企业通信交换机,企业通信解决方案">
<meta name="baidu-site-verification" content="PrEHKigbjQ" />
<!-- Le styles -->
<link href="${context}/resources/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-family: "Microsoft YaHei";
	background-color: #FCFDEF;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="${context}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${context}/resources/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${context}/resources/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${context}/resources/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${context}/resources/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="${context}/resources/ico/favicon.png">
</head>
<body>

	<!-- 顶菜单 -->
	<t:insertAttribute name="header" />

	<div class="container-fluid">
		<div class="row-fluid">
			<!-- 左侧菜单 -->
			<t:insertAttribute name="left" />
			<!-- 左侧菜单 结束-->
			<!-- 页面主体 -->
			<div class="span9">
				<t:insertAttribute name="content" />
			</div>
		</div>
		<!--/row-->

		<hr>

		<footer>
			<t:insertAttribute name="footer" />
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${context}/resources/js/jquery-1.8.3.min.js"></script>
	
	<script src="${context}/resources/js/bootstrap.min.js"></script>
	<!-- 
	<script src="${context}/resources/js/bootstrap-alert.js"></script>
	<script src="${context}/resources/js/bootstrap-modal.js"></script>
	<script src="${context}/resources/js/bootstrap-dropdown.js"></script>
	<script src="${context}/resources/js/bootstrap-scrollspy.js"></script>
	<script src="${context}/resources/js/bootstrap-tab.js"></script>
	<script src="${context}/resources/js/bootstrap-tooltip.js"></script>
	<script src="${context}/resources/js/bootstrap-popover.js"></script>
	<script src="${context}/resources/js/bootstrap-button.js"></script>
	<script src="${context}/resources/js/bootstrap-collapse.js"></script>
	<script src="${context}/resources/js/bootstrap-carousel.js"></script>
	<script src="${context}/resources/js/bootstrap-typeahead.js"></script>
 -->
</body>
</html>