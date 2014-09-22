<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>

<div class="container"></div>

<div class="container">

	<s:url var="scenic_tickets" value="/sub/scenic/tickets"></s:url>
	<s:url var="scenic_detail" value="/scenic/detail"></s:url>

	<c:forEach var="view" items="${view_list}" varStatus="status">

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<c:choose>
						<c:when test="${view.scenicImg != null }">
							<img alt="300x200" src="${view.scenicImg}" style="width:100%"/>
						</c:when>
					</c:choose>
					<h5 style="font-size: 20px; margin-top: 10px;">${view.scenicName}</h5>
					<p>
						<c:if test="${fn:length(view.scenicIntro) > 100}">
				${fn:substring(view.scenicIntro, 0, 100)}...
				</c:if>
						<c:if test="${fn:length(view.scenicIntro) < 100}">
				${fn:substring(view.scenicIntro, 0, 100)}
				</c:if>
					</p>
					<div>
						<span style="font-size: 25px; color: red; float: left;"> <a
							href="${scenic_tickets}?scenic_id=${view.scenicId}"
							style="color: red;"><strong>￥<fmt:formatNumber
										value="${view.scenicSeaLevel/100.0}" pattern="#0.00" />
							</strong></a>
						</span>&nbsp;起 <span style="float: right;"> <a
							class="btn btn-primary"
							href="${scenic_tickets}?scenic_id=${view.scenicId}">预订</a> <a
							class="btn btn-primary"
							href="${scenic_detail}?scenic_id=${view.scenicId}">详情</a>
						</span>
					</div>
				</div>
			</div>
		</div>
		<hr />

	</c:forEach>
</div>

