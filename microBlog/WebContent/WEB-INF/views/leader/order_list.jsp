<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 0px;"></div>
<s:url var="orderURL" value="/leader/order?id="></s:url>
<div class="container" style="max-width: 960px;">
	<h3>订单列表</h3>
	<c:choose>
		<c:when test="${isMobile==true }">
			<s:url var="detailURL" value="/show/spec?id="></s:url>
			<c:forEach var="order" items="${orderList}" varStatus="status">
				<h4>${order.productName}</h4>
				<table>
					<tr>
						<td style="text-align: right">订单号:</td>
						<td>${order.orderId}</td>

						<td style="text-align: right">下单日期:</td>
						<td>${order.orderDate}</td>
					</tr>
					<tr>
						<td style="text-align: right">客人姓名:</td>
						<td>${order.userName}</td>

						<td style="text-align: right">&nbsp;&nbsp;订购数量:</td>
						<td>${order.amount}</td>

					</tr>
					<tr>
						<td style="text-align: right">状&nbsp;&nbsp;&nbsp;&nbsp;态:</td>
						<td>
							<!-- 1-下单；2-下单失败；3：出单/支付成功；4：客户取消；5：退款；6：已经消费 --> <c:if
								test="${order.orderState==1}">
								<b class="text-info">下单</b>
							</c:if> <c:if test="${order.orderState==2}">
								<b class="text-danger">下单失败</b>
							</c:if> <c:if test="${order.orderState==3}">
								<b class="text-success">支付</b>
							</c:if> <c:if test="${order.orderState==4}">
								<b class="text-success">客户取消</b>
							</c:if> <c:if test="${order.orderState==5}">
								<b class="text-success">退款</b>
							</c:if> <c:if test="${order.orderState==6}">
								<b class="text-success">已经消费</b>
							</c:if>
						</td>
						<td style="text-align: right">出发日期:</td>
						<td>${order.arriveDate}</td>
					</tr>
					<tr>
						<td colspan="2"><a class="btn btn-info"
							href="${context}/leader/order?productID=${order.productId }">再次订购</a></td>
					</tr>
				</table>
				<hr />
			</c:forEach>
		</c:when>
		<c:otherwise>
			<s:url var="detailURL" value="/custom/detail?id="></s:url>
			<table class="table">
				<tr>
					<th>订单号</th>
					<th>产品名称</th>
					<th>下单日期</th>
					<th>客人姓名</th>
					<th>订购数量</th>
					<th>儿童数量</th>
					<th>出发日期</th>
					<th>订单状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="order" items="${orderList}" varStatus="status">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.productName}</td>
						<td>${order.arriveDate}</td>
						<td>${order.userName}</td>
						<td>${order.amount}</td>
						<td>${order.childrenCount}</td>
						<td>${order.arriveDate}</td>
						<td>
							<!-- 1-下单；2-下单失败；3：出单/支付成功；4：客户取消；5：退款；6：已经消费 --> <c:if
								test="${order.orderState==1}">
								<b class="text-info">下单</b>
							</c:if> <c:if test="${order.orderState==2}">
								<b class="text-danger">下单失败</b>
							</c:if> <c:if test="${order.orderState==3}">
								<b class="text-success">支付</b>
							</c:if> <c:if test="${order.orderState==4}">
								<b class="text-success">客户取消</b>
							</c:if> <c:if test="${order.orderState==5}">
								<b class="text-success">退款</b>
							</c:if> <c:if test="${order.orderState==6}">
								<b class="text-success">已经消费</b>
							</c:if>
						</td>
						<td colspan="2"><a class="btn btn-info"
							href="${context}/leader/order?productID=${order.productId }">再次订购</a></td>
					</tr>
				</c:forEach>

			</table>


		</c:otherwise>
	</c:choose>
	<!-- 分页共用  -->
	<c:if test="${not empty orderList}">
		<ul class="pager">
			<c:if test="${not empty prevPage}">
				<li><a href="${context}/leader/order/list?pageNo=${prevPage}">上一页</a></li>
			</c:if>
			<li>第${pageNo+1}页</li>
			<c:if test="${not empty nextPage}">
				<li><a href="${context}/leader/order/list?pageNo=${nextPage}">下一页</a></li>
			</c:if>
		</ul>
	</c:if>
</div>