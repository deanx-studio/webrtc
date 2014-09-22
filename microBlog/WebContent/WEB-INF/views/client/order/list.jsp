<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<s:url var="orderPage" value="/order/go_pay.do"></s:url>
<h3>${uname }的订单</h3>
<div>
	<c:if test="${empty orderList}">
		<h4 class="text-danger">${message }</h4>
	</c:if>
</div>
<div class="alert alert-success" style="display: none">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<strong>手机号码:</strong>${mobile }
</div>

<c:forEach var="order" items="${orderList}" varStatus="status">
	<h4>${order.ticketName}</h4>
	<table>
		<tr>
			<td style="text-align: right">订单号:</td>
			<td>${order.orderID}</td>

			<td style="text-align: right">下单日期:</td>
			<td>${order.orderDate}</td>
		</tr>
		<tr>
			<td style="text-align: right">金&nbsp;&nbsp;&nbsp;&nbsp;额:</td>
			<td>￥${order.orderTotalMoney/100}元</td>

			<td style="text-align: right">&nbsp;&nbsp;订购数量:</td>
			<td>${order.orderNumber}</td>
			<!-- <td>游玩:</td>
						<td>${order.playDate}</td>
						 -->
		</tr>
		<tr>
			<td style="text-align: right">状&nbsp;&nbsp;&nbsp;&nbsp;态:</td>
			<td><c:if test="${order.orderState==0}">
					<b class="text-info">待支付</b>
				</c:if> <c:if test="${order.orderState==1}">
					<b class="text-info">已确认</b>
				</c:if> <c:if test="${order.orderState==2}">
					<b class="text-danger">已支付</b>
				</c:if> <c:if test="${order.orderState==3}">
					<b class="text-success">已取消</b>
				</c:if> <c:if test="${order.orderState==4}">
					<b class="text-success">已消费</b>
				</c:if> <c:if test="${order.orderState==5}">
					<b class="text-success">已撤单</b>
				</c:if> <c:if test="${order.orderState==6}">
					<b class="text-success">已退款</b>
				</c:if></td>
			<td style="text-align: right">产品状态:</td>
			<td><c:choose>
					<c:when test="${order.productState==0}">销售中</c:when>
					<c:otherwise>已下架</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<c:if test="${order.orderState==0}">
				<td colspan="2"><a href="${order.payUrl}"
					class="btn btn-warning">去付款</a></td>
			</c:if>
			<c:if test="${order.productState==0}">
				<td colspan="2"><a class="btn btn-info"
					href="${orderPage}?ticketId=${order.ticketId }&scenicId=${order.viewId}">再次订购</a></td>
			</c:if>

		</tr>
	</table>
	<hr />
</c:forEach>

<c:if test="${not empty orderList}">
	<ul class="pager">
		<c:if test="${not empty prevPage}">
			<li><a
				href="${context}/order/list?openid=${openId}&pageNo=${prevPage}">上一页</a></li>
		</c:if>
		<li>第${pageNo}页</li>
		<c:if test="${not empty nextPage}">
			<li><a
				href="${context}/order/list?openid=${openId}&pageNo=${nextPage}">下一页</a></li>
		</c:if>
	</ul>
</c:if>