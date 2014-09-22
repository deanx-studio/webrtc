<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 20px;"></div>
<s:url var="orderURL" value="/custom/order?productID="></s:url>
<c:choose>
	<c:when test="${isMobile==true }">
		<s:url var="detailURL" value="/show/spec?id="></s:url>
	</c:when>
	<c:otherwise>
		<s:url var="detailURL" value="/custom/detail?id="></s:url>
	</c:otherwise>
</c:choose>
<div class="container" style="max-width:960px;">
	<ul class="nav nav-tabs" style="border-bottom: 0px;">
		<c:forEach var="items" items="${productList}">
			<li id="img_sel_0" style="text-align: left; min-height: 180px;">
				<div style="width: 285px;min-height:230px;">
					<a href="${detailURL}${items.mediaID}"><img
						src="${items.img}" style="width: 278px;" title="${items.name}"></a>
						<p style="text-align: left; line-height: 35px;">
							<a href="${orderURL}${items.productID}" class="btn btn-warning">预订</a>&nbsp;${items.name}
						</p>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>