<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 0px;"></div>
<s:url var="orderURL" value="/leader/order?id="></s:url>
<c:choose>
	<c:when test="${isMobile==true }">
		<s:url var="detailURL" value="/show/spec?id="></s:url>
	</c:when>
	<c:otherwise>
		<s:url var="detailURL" value="/custom/detail?id="></s:url>
	</c:otherwise>
</c:choose>
<div class="container" style="max-width:960px;">
<h3>我的收益</h3>
	<ul class="nav nav-tabs">
		<c:forEach var="items" items="${productList}">
			<li id="img_sel_0" style="text-align: left; min-height: 130px;">
				<div style="width: 285px;">
					<a href="${detailURL}${items.mediaID}"><img
						src="${items.img}" style="width: 278px;" title="${items.name}">
						<p style="text-align: left; line-height: 35px;">
							<a href="${orderURL}${items.productID}" class="btn btn-warning">预订</a>&nbsp;${items.name}
						</p></a>
				</div>
			</li>
		</c:forEach>

	</ul>
</div>