<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="sub_enter" value="/sub/enter"></s:url>
<script type="text/javascript" src="${resource}/js/validate.js"
	charset="UTF-8"></script>
<!-- 
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li><a href="${sub_enter}">在线订购</a> <span class="divider">/</span></li>
	<li class="active">支付详情</li>
</ul>
 -->
<s:url var="getPrice" value="/order/getPriceForDate.do"></s:url>
<s:url var="order_confirm" value="/order/confirm.do"></s:url>
<div class="container" style="max-width: 600px;">

	<div class="control-group">
		<div class="alert alert-success">
			<h4>订单状态</h4>
			<c:choose>
				<c:when test="${empty order_object}">您好，该订单不存在，请确认！</c:when>
				<c:otherwise>
			
			产品名称：${order_object.ticketName}<br/>订单号:${order_object.orderID},订单状态：
			<c:if test="${order_object.orderState==0}">待支付</c:if>
					<c:if test="${order_object.orderState==1}">
						已确认</c:if>
					<c:if test="${order_object.orderState==2}">
						已支付
						</c:if>
					<c:if test="${order_object.orderState==3}">
						已取消</c:if>
					<c:if test="${order_object.orderState==4}">
						已消费
						</c:if>
					<c:if test="${order_object.orderState==5}">
						已撤单
						</c:if>
					<c:if test="${order_object.orderState==6}">
						已退款
						</c:if>
				</c:otherwise>
			</c:choose>
		</div>
		<p style="text-align:center">
		<a href="${context }" class="btn btn-info">返回首页</a>
		</p>
	</div>


</div>



