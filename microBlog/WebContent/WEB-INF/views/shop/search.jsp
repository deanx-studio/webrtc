<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="delete_news" value="/admin/article/delete"></s:url>
<script type="text/javascript">
	function addssearch(page) {
		var frm = document.getElementById("addSearch");
		frm.action+="pageNo="+page;
		frm.submit();
	}
</script>

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<h2>本地产品搜索</h2>
		<div>
			<form id="addSearch" action="${context }/shop/add/search?" method="POST">
				<input type="text" id="searchKey" name="searchKey" class="input-large"
					placeholder="请输入目的名称或景区关键字" autocomplete="off" value="${searchKey}" /><input
					type="submit" value="搜索" class="btn btn-primary"/>
			</form>
		</div>
		<c:if test="${empty ticketInfoList}">
		对不起，没有找到符合条件的数据，
		</c:if>
		<c:forEach var="ticketInfo" items="${ticketInfoList}"
			varStatus="status">
			<p>
				<a
					href="${context }/shop/add/init?ticketId=${ticketInfo.ticketId}&scenicId=${ticketInfo.scenicId}">${ticketInfo.ticketName}</a>
			</p>
		</c:forEach>
		<c:if test="${not empty ticketInfoList}">

			<ul class="pager">
				<c:if test="${not empty prevPage}">
					<li><a
						href="javascript:addssearch(${prevPage})">上一页</a></li>
				</c:if>
				<c:if test="${not empty nextPage && pageNo!=1}">
					<li>第${pageNo}页</li>
				</c:if>
				<c:if test="${not empty nextPage}">
					<li><a
						href="javascript:addssearch(${nextPage})">下一页</a></li>
				</c:if>
			</ul>
		</c:if>
	</div>
</div>
