<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />

<s:url var="go_pay" value="/order/go_pay.do"></s:url>

<div class="container">

	<div>
		<c:if test="${not empty catalogName}">
			<div class="prettyprint" style="padding: 0px;">
				<div class="row-fluid">
					<div class="text-left">
						<div>
							<h4>
								分类主题:${catalogName } <i
									style="position: absolute; padding-left: 10px;"> <wb:share-button
										appkey="6EvTuZ" addition="simple" type="button"></wb:share-button>
								</i>
							</h4>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div style="margin-bottom: 10px;"></div>
		<s:url var="ticket_detail" value="/scenic/ticketDetail"></s:url>
		<s:url var="view_detail" value="/scenic/detail?scenic_id="></s:url>
		<c:forEach var="ticketInfo" items="${ticketInfoList}"
			varStatus="status">
			<div class="prettyprint" style="padding: 0px;">
				<div class="row-fluid">
					<div class="text-left">
						<div>
							<c:choose>
								<c:when test="${fn:length(ticketInfo.imgUrl) > 0 }">
									<span><a href="${view_detail}${ticketInfo.scenicId}"><img
											style="width: 100%" src="${ticketInfo.imgUrl}" /></a></span>
								</c:when>
							</c:choose>
						</div>

						<div style="margin-top: 5px;">
							<span style=""><strong><a
									href="${ticket_detail}?ticketId=${ticketInfo.ticketId}">${ticketInfo.ticketName}</a></strong></span>
							<div></div>
							<div style='height: 15px;'></div>
							<div style="color: red;">
								<span style="font-size: 14px; line-height: 30px;">市场价<del>
										￥
										<fmt:formatNumber value="${ticketInfo.marketPrice/100.0}"
											pattern="#0.00" />
									</del></span> <span style="font-size: 14px; float: right;"> <a
									href="${go_pay}?ticketId=${ticketInfo.ticketId}&scenicId=${ticketInfo.scenicId}"
									style="background-color: #f60; color: white;"
									class="btn btn-lg active">￥<fmt:formatNumber
											value="${ticketInfo.salePrice/100.0}" pattern="#0.00" /></a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div style="margin-bottom: 10px;"></div>
		</c:forEach>

	</div>
	<ul class="pager">
		<c:if test="${not empty prevPage}">
			<li><a href="javascript:submit_s(${prevPage})">上一页</a></li>
		</c:if>
		<c:if test="${not empty nextPage && pageNo!=1}">
			<li>第${pageNo}页</li>
		</c:if>
		<c:if test="${not empty nextPage}">
			<li><a href="javascript:submit_s(${nextPage})">下一页</a></li>
		</c:if>
	</ul>
</div>


