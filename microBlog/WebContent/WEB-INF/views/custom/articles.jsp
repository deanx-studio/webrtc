<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 00px;"></div>
<style type="text/css">
/* Featurettes
    ------------------------- */
.featurette-divider {
	margin: 10px 0; /* Space out the Bootstrap <hr> more */
}

.featurette { //
	padding-top: 120px;
	/* Vertically center images part 1: add padding above and below text. */
	overflow: hidden;
	/* Vertically center images part 2: clear their floats. */
}

.featurette-image {
	margin-top: -10px;
	/* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
}

/* Give some space on the sides of the floated elements so text doesn't run right into it. */
.featurette-image.pull-left {
	margin-right: 40px;
}

.featurette-image.pull-right {
	margin-left: 40px;
}

/* Thin out the marketing headings */
.featurette-heading {
	font-size: 30px;
	font-weight: 300;
	line-height: 1;
	letter-spacing: -1px;
}

.lead {
	font-size: 16px;
}

.intro_text {
	
}

.tb_title {
	color: black;
	font-size: 20px;
}

.tb_date {
	color: gray;
	font-size: 12px;
}
</style>
<div class="container" style="max-width: 960px;">

	<!-- START THE FEATURETTES -->
	<h3 id="title">美国自驾游文章列表</h3>
	<!-- 
	<input id="touchMove" value="" /> <input id="touchStart" value="" />
 -->
	<c:choose>
		<c:when test="${IsMobile==true }">
			<s:url var="articlePath" value="/show/spec?id="></s:url>
		</c:when>
		<c:otherwise>
			<s:url var="articlePath" value="/custom/detail?id="></s:url>
		</c:otherwise>
	</c:choose>
	<table class="table">
		<c:forEach var="items" items="${artileList}" varStatus="status">
			<tr>
				<td style="width: 90px;"><a
					href="${articlePath}${items.id}"><img
						style="width: 80px; height: 60px;" src="${items.img}"></a></td>
				<td><a href="${articlePath}${items.id}"><span
						class="tb_title">${items.title }</span></a><br /> <span
					class="tb_date">发表日期：${items.specialMaketime}</span></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<ul>
			<c:if test="${prevPage>=0}">
				<li><a href="${context}/custom/articles?page=${prevPage}">上一页</a></li>
			</c:if>
			<c:forEach var="i" begin="0" end="${pageNo}" step="1">
				<li><a href="${context}/custom/articles?page=${i}">第${i+1}页</a></li>
			</c:forEach>
			<c:if test="${nextPage>0}">
				<li><a href="${context}/custom/articles?page=${nextPage}">下一页</a></li>
			</c:if>
		</ul>
	</div>
	<!-- /END THE FEATURETTES -->
</div>