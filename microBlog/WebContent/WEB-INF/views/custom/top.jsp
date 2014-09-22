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
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<div class="container" style="max-width: ${maxWidth}px;">
	<img
		src="${context }/resources/image/web_logo.png"
		style="height: 60px;">
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li <c:if test="${menuIndex==0}"> class="active"</c:if>><a
						href="${context }/custom/home"><h4>首页</h4></a></li>
					<!-- 
					<li <c:if test="${menuIndex==1}"> class="active"</c:if>><a
						href="${context}/custom/recommend"><h4>爆款产品</h4></a></li>
						  -->
					<sec:authorize access="hasAnyRole('ROLE_LEAD')">
						<li <c:if test="${menuIndex==1}"> class="active"</c:if>><a
							href="${context}/leader/home"><h4>旅行线路</h4></a></li>
					</sec:authorize>
					
						<ul class="nav" style="margin-top: 0px;">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><h4>
										旅行线路 <strong class="caret"></strong>
									</h4> </a>
								<ul class="dropdown-menu">

									<li><a href="${context }/custom/book"><h5>经典线路</h5></a></li>
									<li><a href="${context }/custom/group/list"><h5>即刻发团</h5></a></li>

								</ul></li>
						</ul>

						<ul class="nav" style="margin-top: 0px;">
							<li class="dropdown <c:if test="${menuIndex==3}"> active</c:if>"><a
								href="#" class="dropdown-toggle" data-toggle="dropdown"><h4>
										私人定制<strong class="caret"></strong>
									</h4> </a>
								<ul class="dropdown-menu">

									<li><a href="${context}/custom/private"><h5>私人定制</h5></a></li>
									<li><a href="${context}/custom/mine_sel"><h5>我的定制</h5></a></li>
									<!-- 
									<li ><a
										href="${context}/custom/myOrders"><h5>我的预订</h5></a></li>
 -->
								</ul></li>
						</ul>


					
					<!-- 
					<li <c:if test="${menuIndex==5}"> class="active"</c:if>><a
						href="#"><h4>冠行动态</h4></a></li>
						 -->
					<ul class="nav" style="margin-top: 0px;">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><h4>
									前往美国<strong class="caret"></strong>
								</h4></a>
							<ul class="dropdown-menu">

								<li><a href="${context }/custom/detail?id=123"><h5>车型介绍</h5></a></li>
								<li><a href="${context }/custom/detail?id=124"><h5>自驾须知</h5></a></li>
								<li><a href="${context }/custom/detail?id=125"><h5>准备去美国</h5></a></li>
								<li><a href="${context }/custom/articles"><h5>更多精彩</h5></a></li>

							</ul></li>
					</ul>

					<!-- （实时，领队发送内容 游记 经验） -->


					<!-- 
					<li <c:if test="${menuIndex==4}"> class="active"</c:if>><a
						href="${context}/custom/mine"><h4>我的定制</h4></a></li>
						 -->
					<!-- 
					<ul class="nav" style="margin-top: 0px;">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><h4>
									领队<strong class="caret"></strong>
								</h4></a>
							<ul class="dropdown-menu">
								<li><a href="/travel-weixin/leader/home">产品列表</a></li>
							</ul></li>
					</ul>
					
					<li <c:if test="${menuIndex==6}"> class="active"</c:if>><a
						href="${context}/leader/home"><h4>VIP预订</h4></a></li>
 					-->


					<sec:authorize access="hasAnyRole('ROLE_LEAD')">

						<ul class="nav pull-right" style="margin-top: 0px;">
							<c:choose>
								<c:when test="${empty username}">
								</c:when>
								<c:otherwise>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown"><h4>
												${username}<strong class="caret"></strong>
											</h4></a>
										<ul class="dropdown-menu">
											<li><a href="${context}/leader/order/list">我的订单</a></li>
											<li><a href="${context}/leader/benifit">我的收益</a></li>
											<li class="divider"></li>
											<li><a href="${context}/static/j_spring_security_logout">退出</a>
											</li>
										</ul></li>
								</c:otherwise>
							</c:choose>

						</ul>

					</sec:authorize>
				</ul>
				<c:if test="${empty username}">
					<h3 style="color: white;" class="pull-right">
						电话：<a style="color: gold;" href="tel:4006910800">4006910800</a>
					</h3>
				</c:if>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>