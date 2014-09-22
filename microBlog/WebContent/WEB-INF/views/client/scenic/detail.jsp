<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<!--  <div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<%-- <li><a href="${complaint_ui}">个人中心</a> <span class="divider">/</span></li> --%>
	<li class="active">景区详情</li>
</ul>
 -->
<s:url var="go_pay" value="/order/go_pay.do"></s:url>
<script>
	function goOrder(scenicId, ticketId) {

		window.location.href = '${go_pay}?scenicId=' + scenicId + '&ticketId='
				+ ticketId;
	}
</script>

<s:url var="ticket_detail" value="/scenic/ticketDetail"></s:url>
<!-- 
<div class="container">
	<span class="span1.5"><h4>景区详情</h4></span><span class="span1" style="margin-left:5px;margin-top:15px;"><h6><a
		href="weixin://contacts/profile/gh_ff9414edf993" style="color:red;">想走就走</a></h6></span>
</div>  -->
<div class="container" style="max-width: 500px;">
	<h4>
		景区：${scenicName }<i style="position: absolute; padding-left: 10px;"> <wb:share-button
				appkey="6EvTuZ" addition="simple" type="button"></wb:share-button>
		</i>
	</h4>
	<div style="">
		<c:forEach var="viewDetail" items="${viewDetails}" varStatus="status">
			<c:if test="${viewDetail.PCUrl !=''}">
				<p style="text-align: center;">
					<img src="${viewDetail.PCUrl}" />
				</p>
			</c:if>
			<c:if test="${viewDetail.pc_text !=''}">
				<p style="text-align: left;font-size:16px;">${viewDetail.pc_text}</p>
			</c:if>
		</c:forEach>
	</div>

	<h5>相关产品</h5>
	<div class="" style="">
		<c:forEach var="scenic" items="${scenicInfo}" varStatus="status">
			<div class="prettyprint" style="background-color: white;">
				<div class="row-fluid">
					<div>
						<div style="font-size: 16px;">
							<span><b><a
									href="${ticket_detail}?ticketId=${scenic.ticketId}">${scenic.ticketName}</a></b></span>
						</div>

						<div style="color: red; font-size: 16px; margin-top: 3px;">
							<span style="color: black; line-height: 30px;">门市价</span>
							<del style="color: gray;">
								<fmt:formatNumber value="${scenic.marketPrice/100}"
									pattern="#0.00" />
								起
							</del>
							<span style="float: right; font-size: 14px;"> <a
								href="${go_pay}?scenicId=${scenic.scenicId}&ticketId=${scenic.ticketId}"
								style="background-color: #f60; color: white;"
								class="btn btn-lg active" style="color:gray;">￥<fmt:formatNumber
										value="${scenic.salePrice/100}" pattern="#0.00" /></a></b></span>
							<!-- <button class="btn"
										onclick="javascript:goOrder('${scenic.scenicId}','${scenic.ticketId}')">预订</button>
								 -->
						</div>
					</div>

				</div>
			</div>
			<hr />
		</c:forEach>
	</div>
</div>
