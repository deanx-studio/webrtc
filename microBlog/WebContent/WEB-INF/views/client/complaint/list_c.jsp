<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="home" value="/home" />
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<s:url var="complaint_ui" value="/complaint/my/do"></s:url>
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li><a href="${complaint_ui}">投诉</a> <span class="divider">/</span></li>
	<li class="active">投诉历史</li>
</ul>

<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>我的投诉记录</h3>
				<p>
				<table class="table">
					<thead>
						<tr>
							<th>投诉内容</th>
							<th>类型</th>
							<th>涉及订单</th>
							<th>提交时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="complaint" items="${complaint_list}">
							<tr>
								<td>${complaint.content}</td>
								<td><c:choose>
										<c:when test="${complaint.type==1}">产品相关</c:when>
										<c:when test="${complaint.type==2}">价格相关</c:when>
										<c:when test="${complaint.type==3}">服务相关</c:when>
										<c:when test="${complaint.type==4}">售后相关</c:when>
										<c:when test="${complaint.type==5}">活动相关</c:when>
										<c:when test="${complaint.type==6}">网站相关</c:when>
										<c:otherwise>其他相关</c:otherwise>
									</c:choose></td>
								<td>${complaint.orderNo}</td>
								<td>${complaint.submitDate}</td>
								<td>${complaint.state}</td>
								<td><a href="#" class="disabled">查看</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</p>
				<p>
					<s:url var="ui_complaint" value="/complaint/my/do"></s:url>
					如果遇到困难，请点击这里&rarr;<a class="btn btn-danger btn-xs" href="${ui_complaint}">投诉</a>，我们承诺第一时间解决。
				</p>
			</div>
		</div>
	</div>
</div>
<script>
	$("tr:odd").css("background-color", "#cef");
	$("tr:even").css("background-color", "#ffffff");
</script>
