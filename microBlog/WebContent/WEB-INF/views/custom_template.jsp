<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url var="resource" value="/resources/s" />
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
	request.setAttribute("maxWidth", 1140);
%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://v2.bootcss.com/examples/hero.html? -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title><c:choose>
		<c:when test="${not empty mainTitle }">冠行-${mainTitle }</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${not empty title }">冠行-${title }</c:when>
				<c:otherwise>
冠行-美国自驾游
</c:otherwise>
			</c:choose>

		</c:otherwise>
	</c:choose></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="冠行旅游(guantravel.com)，为你提供全球最精彩的自驾游，没有跟团游的匆忙和自助游的盲目，4人以上即可成团，带你体验更加自由的旅程；我们的口号是：我的旅行我做主！">
<meta name="baidu-site-verification" content="XROhNHMZGM" />
<meta name="author" content="程序员老刘">
<meta name="Keywords" content="${metaKeys }">
<!-- Le styles -->
<link href="${context}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${context}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="icon" href="${context}/resources/image/bitbug_favicon.ico"
	type="image/x-icon" />
<link rel="shortcut icon"
	href="${context }/resources/image/bitbug_favicon.ico"
	type="image/x-icon" />
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
	font-family: "Microsoft YaHei";
	background-color: #FCFDEF;
}

h1 {
	color: white;
}

h3 {
	color: rgb(150, 147, 147);
	font-size: 20px;
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
	<c:if test="${isMobile==true }">
		<img
			src="http://xdujia.com/resources/media/201408/178f6cc42fc51255c25747e328a89a38.jpg"
			style="width: 1px;">
	</c:if>
	<!-- 顶部菜单  -->
	<t:insertAttribute name="header" />

	<!-- 页面主题  -->
	<t:insertAttribute name="content" />
	<div class="container" style="max-width: ${maxWidth}px;">

		<!-- 页脚  -->
		<t:insertAttribute name="footer" />

	</div>
	<!-- /container -->

</body>
</html>