<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container" style="max-width: 960px;">

	<h2 id="title">美国自驾游文章列表</h2>

	<table class="table">
		<c:forEach var="items" items="${artileList}" varStatus="status">
			<tr>
				<td><a href="${context }/custom/detail?id=${items.id}"><span
						class="tb_title">${items.title }</span></a><br /> <span
					class="tb_date">发表日期：${items.specialMaketime}</span></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<ul>
			<c:if test="${prevPage>=0}">
				<li><a href="${context}/custom/robot?page=${prevPage}">上一页</a></li>
			</c:if>

			<c:forEach var="i" begin="0" end="${pageNo}" step="1">
				<li><a
					href="${context}/custom/robot?page=${i}">第${i+1}页</a></li>
			</c:forEach>
			
			<c:if test="${nextPage>0}">
				<li><a href="${context}/custom/robot?page=${nextPage}">下一页</a></li>
			</c:if>
		</ul>
	</div>
	<!-- /END THE FEATURETTES -->
</div>