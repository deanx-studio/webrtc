<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script type="text/javascript">
	function g(objName) {
		return document.getElementById(objName);
	}
	function chgNumber(objName, num) {
		numberObj = g(objName);
		var newDays = parseInt(numberObj.value);
		newDays += parseInt(num);
		if (newDays < 0) {
			alert("对不起，数量不能小于0，请重新设置");
			return;
		}
		numberObj.value = newDays;
	}
	function sel_count(objName) {
		var count = 0;
		var obj = document.getElementsByName(objName);
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].checked)
				count++;
		}
		return count;
	}
	function CurentTime() {
		var span = 60;//默认提前60天
		var now = new Date();
		now = now.valueOf();
		now = now + span * 24 * 60 * 60 * 1000;
		now = new Date(now);

		var year = now.getFullYear(); //年
		var month = now.getMonth() + 1; //月
		var day = now.getDate(); //日

		//  var hh = now.getHours();            //时
		//  var mm = now.getMinutes();          //分

		var clock = year + "-";

		if (month < 10)
			clock += "0";

		clock += month + "-";

		if (day < 10)
			clock += "0";

		clock += day
		/*
		clock +=  " ";
		 if(hh < 10)
		     clock += "0";
		    
		 clock += hh + ":";
		 if (mm < 10) clock += '0'; 
		 clock += mm;
		 */
		return (clock);
	}
</script>
<style>
body {
	padding-top: 0px;
}

.navbar .brand {
	font-size: 14px;
}

.navbar .active {
	color: white;
}

.top_shape {
	width: 100%;
	height: 38px;
	position: fixed !important;
	position: absolute;
	left: 0px;
	bottom: 5px !important;
	bottom: auto;
	top: 0px;
	/*background-color: #0065CC;*/
	background-color: rgba(255, 255, 255, 0.85);
	border-bottom: 1px solid gray;
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
		               'CSS1Compat')?                 (documentElement.clientHeight-
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
		   
		               'CSS1Compat')?                 (documentElement.clientHeight-
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

.icon_menu {
	background-position: 30% 6px;
	background-size: 24px auto;
	background-repeat: no-repeat;
	width: 42px;
	height: 42px;
	background-image: url("${context}/resources/image/client/menu.png");
}
.menu_text {
font-size: 16px;
line-height:20px;
font-weight: bold;
}
</style>
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<img
	src="http://xdujia.com/resources/media/201408/178f6cc42fc51255c25747e328a89a38.jpg"
	style="display: none;">
<div class="top_shape">

	<div class="container" style="width: 95%">
		<img style="height: 30px; margin-left: 5px; margin-top: 4px;"
			src="${context}/resources/image/client/guanxing_logo.png">
		<div class="btn-group" style="float: right;">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<div class="icon_menu">&nbsp;</div>
			</a>
			<ul class="dropdown-menu pull-right ">
				<li><a href="${context }/custom/book" class="menu_text">经典线路</a></li>
				<li><a href="${context }/custom/group/list" class="menu_text">即刻发团</a></li>
				<li><a href="${context }/custom/private" class="menu_text">私人订制</a></li>
				<li><a href="${context }/custom/mine_sel" class="menu_text">我的定制</a></li>
				<li class="divider"></li>
				<li><a href="${context }/show/spec?id=123" class="menu_text">车型介绍</a></li>
				<li><a href="${context }/show/spec?id=124" class="menu_text">自驾须知</a></li>
				<li><a href="${context }/show/spec?id=125" class="menu_text">准备去美国</a></li>
				<li><a href="${context }/custom/articles" class="menu_text">更多精彩</a></li>
			</ul>
		</div>
	</div>

</div>
<div style="height: 35px"></div>
<!-- 	
<div class="navbar navbar-inverse navbar-fixed-top"
	style="margin-top: -20px;">
	<div class="navbar-inner">
		<div class="container">

			<a class="brand <c:if test="${menuIndex==3}"> active</c:if>"
				href="${context }/custom/private">个性定制</a> 
			<ul class="nav" style="margin-top: 0px;">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 旅行线路<strong class="caret"></strong>
				</a>
					<ul class="dropdown-menu">

						<li><a href="${context }/custom/book">经典线路</a></li>
						<li><a href="${context }/custom/group/list">即刻发团</a></li>

					</ul></li>
			</ul>
			<ul class="nav" style="margin-top: 0px;">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 前往美国<strong class="caret"></strong>
				</a>
					<ul class="dropdown-menu">

						<li><a href="${context }/show/spec?id=123">车型介绍</a></li>
						<li><a href="${context }/show/spec?id=124">自驾须知</a></li>
						<li><a href="${context }/show/spec?id=125">准备去美国</a></li>

					</ul></li>
			</ul>
		
		</div>
	</div>
</div>
-->