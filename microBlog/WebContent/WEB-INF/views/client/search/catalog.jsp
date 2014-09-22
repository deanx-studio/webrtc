<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />

<div class="container">
	<h4>分类检索</h4>
	<s:url var="catalog_result" value="/catalog/"></s:url>
	<ul class="nav nav-tabs" style="border-bottom: 0px solid #ddd;">

		<c:forEach var="catalogItem" items="${catalogList}" varStatus="status">
			<li class="" style="text-align: center;"><div
					style="min-height: 50px; min-width: 80px; max-width: 100px;">
					<code style="font-size:16px;">
					<a class=""
						href="${context}/catalog/ticket?catalogId=${catalogItem.id}">${catalogItem.catalogName}</a>
					 </code>
					
				</div></li>
		</c:forEach>
	</ul>
	<hr>
	<h4>我的</h4>
	<ul class="nav nav-tabs" style="border-bottom: 0px solid #ddd;">
		<li class=""><div
				style="min-height: 50px; min-width: 120px; max-width: 100px;">
				<a class="btn btn-primary" href="${context}/order/list?openid=${openId}">我的订单</a>
			</div></li>
		<li class=""><div
				style="min-height: 50px; min-width: 120px; max-width: 100px;">
				<a class="btn btn-primary" href="${context}/sub/bind?openid=${openId}">我的资料</a>
			</div></li>
	</ul>
</div>