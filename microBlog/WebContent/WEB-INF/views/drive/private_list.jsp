<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 0px;"></div>

<div class="container" style="max-width: 960px;">
	<h3>个性定制列表</h3>
	<table class="table table-striped">
		<tr>
			<th>操作</th>
			<th>联系电话</th>
			<th>姓名</th>
			<th>计划出行日期</th>
			<th>填表日期</th>
		</tr>

		<c:forEach var="items" items="${privateList}">
			<tr>
				<td><a
					href="${context }/drive/private/detail?sid=${items.sessionID}">详细</a></td>
				<td>${items.mobile }</td>
				<td>${items.userName }</td>
				<td>${items.startDate }</td>
				<td>${items.makeTime }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<ul>
			<c:if test="${prevPage>=0}">
				<li><a
					href="${context}/drive/private/list?page=${prevPage}&t=${stype }&context=${sText}">上一页</a></li>
			</c:if>
			<c:forEach var="i" begin="0" end="${pageNo}" step="1">
				<li><a
					href="${context}/drive/private/list?page=${i}&t=${stype }&context=${sText}">第${i+1}页</a></li>
			</c:forEach>
			<c:if test="${fn:length(special_list)>0}">
				<li><a
					href="${context}/drive/private/list?page=${nextPage}&t=${stype }&context=${sText}">下一页</a></li>
			</c:if>
		</ul>
	</div>
</div>