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
	<i style="position: absolute; padding-left: 10px;"> <wb:share-button
			appkey="6EvTuZ" addition="simple" type="button"></wb:share-button>
	</i>

	<div>
		<s:url var="ticket_detail" value="/scenic/ticketDetail"></s:url>
		<s:url var="view_detail" value="/scenic/detail?scenic_id="></s:url>
		<c:forEach var="ticketInfo" items="${ticketInfoList}"
			varStatus="status">
			<div class="prettyprint">
				<div class="row-fluid">
					<div class="text-left">
						<div>
							<c:choose>
								<c:when test="${fn:length(ticketInfo.imgUrl) > 0 }">
									<span><a href="${view_detail}${ticketInfo.scenicId}"><img
											src="${ticketInfo.imgUrl}" /></a></span>
								</c:when>
							</c:choose>
						</div>

						<div style="margin-top: 5px;">
							<span style="font-size: 16px;"><strong><a
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
</div>