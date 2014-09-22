<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="${context}/resources/image/admin/favicon.png">
<title>微信管理后台</title>

<!-- Bootstrap core CSS -->
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/resources/css/admin/style.css" rel="stylesheet">

<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${context}/resources/css/docs.css" rel="stylesheet">
<link href="${context}/resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="${context}/resources/css/prettify.css" rel="stylesheet">
<link href="${context}/resources/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<script type="text/javascript">
	var webRoot = "${context}";
</script>
<script src="${context}/resources/js/jquery-1.10.2.min.js"></script>
<script src="${context}/resources/css/bootstrap.min.css"></script>
<script src="${context}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/travel.js">
	
</script>

</head>

<body>
	<t:insertAttribute name="header" />
	<div class="container">
		<t:insertAttribute name="content" />
		<hr>
		<footer>
			<t:insertAttribute name="footer" />
		</footer>

	</div>
	<!--/.container-->

</body>

</html>