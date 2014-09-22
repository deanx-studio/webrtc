<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources" />
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html lang="zh-CN" xmlns:wb=“http://open.weibo.com/wb”>
<head>
<link rel="icon" href="${context}/resources/image/fav.ico"
	type="image/x-icon" />
<link rel="shortcut icon" href="${context }/resources/image/fav.ico"
	type="image/x-icon" />
<meta charset='utf-8'>
<meta content='text/html; charset=utf-8' http-equiv='Content-Type'>
<meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
<!-- <meta content='width=device-width, initial-scale=1.0' name='viewport'> -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta charset="utf-8" />
<meta name="Keywords"
	content="${metaKeys }">
<link href="${resource}/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<title>想走就走</title>
<!-- Le styles -->
<script type="text/javascript">
	var webRoot = "${context}";
</script>
<script type="text/javascript" src="${resource}/js/jquery-1.8.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="${resource}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${resource}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>

<link href="${resource}/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${resource}/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="${resource}/css/prettify.css" rel="stylesheet">
<link href="${resource}/css/docs.css" rel="stylesheet">
<!-- 
<script src="${resource}/js/holder.min.js"></script>

<script src="${resource}/js/prettify.js"></script>
<script src="${resource}/js/application.js"></script>
<script src="${resource}/js/h.js" type="text/javascript"></script>
<script src="${resource}/js/validate.js"></script>
 -->
<script src="${resource}/js/travel.js"></script>
<link href="${resource}/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
	<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"
	src="${resource}/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<style type="text/css">
.top_shape {
	width: 100%;
	height: 35px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: 0px;
	/*background-color: #0065CC;*/
	background-color: #C33B34;
}

.search_shape {
	width: 100%;
	height: 35px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: 35px;
}

.bottom_shape {
	width: 100%;
	height: 35px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 0px !important;
	bottom: auto;
	top: expression(eval(document.compatMode &&                    
		    document.compatMode ==       	   
		           'CSS1Compat')?             (documentElement.clientHeight-
		this.clientHeight ):document.body.scrollTop+(document.body.clientHeight-
		this.clientHeight ) );
	/*background-color: #0065CC;*/
	background-color: rgb(248, 243, 243);
}

.shape {
	width: 50px;
	height: 50px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 35px !important;
	bottom: auto;
	top: expression(eval(document.compatMode &&                    
		    document.compatMode ==       
		   
		           'CSS1Compat')?             (documentElement.clientHeight-
		this.clientHeight ):document.body.scrollTop+(document.body.clientHeight-
		this.clientHeight ) );
	z-index: 9000;
}

.shape .button {
	width: 50px;
	height: 50px;
	cursor: pointer;
	border-radius: 10px;
	background: url(${context}/resources/image/client/up_30.png);
}
</style>

</head>
<body onscroll="scroll_event(1);" onload="scroll_event(0);">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<t:insertAttribute name="head" />

				<t:insertAttribute name="content" />


			</div>
			<footer>
				<t:insertAttribute name="footer" />
			</footer>
		</div>
	</div>
	<div class="container">
		<div class="shape" style="display: none">
			<div class="button" onclick="javascript:gotop()"></div>
		</div>
	</div>
	<div class="container">
		<div class="bottom_shape">
			<table style="width: 100%; margin-top: 6px;">
				<tr>
					<td style="text-align: center">
					<s:url var="showPay" value="none"></s:url>
					<a href="tel:4006910800" style="color: rgb(245, 80, 48); font-style: italic; font-size: 18px;">客服：4006910800</a>
							&nbsp;&nbsp;<a href="${payUrl }" class="btn btn-warning" id="payBtn"
							style="margin-top: -5px;display:${showPay};">预订</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="height" style="height: 40px;"></div>
</body>

</html>