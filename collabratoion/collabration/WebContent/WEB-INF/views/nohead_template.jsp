<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources/s" />
<%@ include file="./public/global.jsp"%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://v2.bootcss.com/examples/hero.html? -->
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>泰乐德</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="webrtc,sip,互联网通信">
<meta name="author" content="程序员老刘">
<meta name="Keywords"
	content="WEBRTC,SIP通信,协同指挥,调度系统,浏览器的WEB通信,无插件的通信,SIP,WEBRTC2SIP,PBX,企业通信交换机,企业通信解决方案">
<meta name="baidu-site-verification" content="PrEHKigbjQ" />
<!-- Le styles -->
<link href="${context}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${context}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<script type="text/javascript"
	src="${context }/resources/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="${context }/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${context }/resources/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
</head>
<body>
	<div class="container">
		<!-- 页面主题  -->
		<t:insertAttribute name="content" />
	</div>
</body>
</html>