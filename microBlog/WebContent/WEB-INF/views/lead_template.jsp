<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources/s" />
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>境外自驾管理, 智网明达</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="Keywords"
	content="智网, 旅游, 自驾, 境外, 美国, 夏威夷, 旧金山, 洛杉矶, 好莱坞, 金门大桥, 66, 黄石 ">

<!-- Le styles -->
<link href="${context}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${context}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="icon" href="${context}/resources/image/fav.ico"
	type="image/x-icon" />
<link rel="shortcut icon" href="${context }/resources/image/fav.ico"
	type="image/x-icon" />
<style type="text/css">
body {
	padding-top: 60px;
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

	<!-- 顶部菜单  -->
	<t:insertAttribute name="header" />


	<!-- 页面主题  -->
	<t:insertAttribute name="content" />
	<div class="container" style="max-width: 960px;">

		<!-- 页脚  -->
		<t:insertAttribute name="footer" />

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- 
	<script src="${context }/resources/custom/js/bootstrap-transition.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-alert.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-modal.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-dropdown.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-scrollspy.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-tab.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-tooltip.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-popover.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-button.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-collapse.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-carousel.js"></script>
	<script src="${context }/resources/custom/js/bootstrap-typeahead.js"></script>

 -->

</body>
</html>