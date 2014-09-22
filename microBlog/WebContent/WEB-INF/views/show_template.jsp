<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:url var="resource" value="/resources" />
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html lang="zh-cn" xmlns:wb=“http://open.weibo.com/wb”>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${context}/resources/image/fav.ico"
	type="image/x-icon" />
<link rel="shortcut icon" href="${context }/resources/image/fav.ico"
	type="image/x-icon" />
<title>${title}-智网明达微信管理</title>
<meta name="Keywords"
	content="${metaKeys }">
<script type="text/javascript" src="${resource}/js/jquery-1.8.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="${resource}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${resource}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<link href="${resource}/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${resource}/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<!-- 
<link href="${resource}/css/prettify.css" rel="stylesheet">
 
<link href="${resource}/css/docs.css" rel="stylesheet">
<script src="${resource}/js/holder.min.js"></script>
<script src="${resource}/js/prettify.js"></script>
<script src="${resource}/js/application.js"></script>
<script src="${resource}/js/h.js" type="text/javascript"></script>
 
<script src="${resource}/js/validate.js"></script>
 -->
<script src="${resource}/js/travel.js"></script>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
<link href="${resource}/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	font-size: 16px;
	font-family: "Microsoft YaHei";
}
.top_shape {
	width: 100%;
	height: 40px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: 0px;
	background-color:black;
}
.search_shape {
	width: 100%;
	height: 50px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: 45px;
}

.shape {
	width: 50px;
	height: 50px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: expression(eval(document.compatMode &&       document.compatMode ==  
		  'CSS1Compat')?    (documentElement.clientHeight- this.clientHeight ):document.body.scrollTop+(document.body.clientHeight-
		this.clientHeight ) );
	z-index:9000;
}

.shape .con {
	width: 200px;
	height: 100px;
	background:
		url(http://static.l99.com/skin/default/images/versus/pk_vote_record.gif)
		no-repeat;
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
<script type="text/javascript">
	/*
	 document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	 WeixinJSBridge.call('hideToolbar');
	 });
	 /* 
	 document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	 WeixinJSBridge.call('hideOptionMenu');
	 });*/
</script>
<body  onscroll="scroll_event(1);" onload="scroll_event(0);">

	<div class="container" style="margin-top: -0px;">
		<t:insertAttribute name="content" />
	</div>
	<p class="text-info" align="center">
		<!-- 
		<a href="weixin://contacts/profile/${weixinId}"><img alt=""
			src="/travel-weixin/resources/image/client/ps144_logo.png"
			style="height: 40px;">${weixinName}</a> <br />
			 -->
		北京智网明达信息技术有限公司 @ copyright 2013
	</p>

	<div class="container">
		<div class="shape">
			<div class="button" onclick="javascript:gotop()"></div>
		</div>
	</div>
	<!--/.container-->
	<script type="text/javascript">
		function gotop() {
			$('body,html').animate({
				scrollTop : 0
			}, 1000);
		}

		function scroll_event(load) {

			if (document.body.scrollTop > 0 && load == 1) {
				//alert($('.shape'));
				$('.shape').css('display', '');
			} else {
				$('.shape').css('display', 'none');
			}
		}

		//scroll_event();
	</script>
</body>

</html>