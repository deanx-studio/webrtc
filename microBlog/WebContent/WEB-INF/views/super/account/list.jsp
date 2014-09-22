<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources" />
<h4>微信帐号列表</h4>
<div>
	<c:if test="${empty weiwinList}">
		<h4 class="text-danger">没有找到相关数据</h4>
	</c:if>
</div>
<table class="table table-striped">
	<tr>
		<th>操作</th>
		<th>微信名称</th>
		<th>原始ID</th>
		<th>微信号</th>
		<th>帐号类型</th>
		<th>创建时间</th>
	</tr>
	<c:forEach var="wx" items="${weiwinList}" varStatus="status">
		<tr id="weixin_node_${wx.accountId}">
			<td>
				<div class="btn-group">
					<button class="btn"><a href="${context}/super/weixin/add?wid=${wx.accountId}">编辑</a></button>
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="${context}/super/weixin/add?wid=${wx.accountId}">编辑</a></li>
						<li><a href="javascript:delete_weixin(${wx.accountId})">删除</a></li>
					</ul>
				</div>
			</td>
			<td>${wx.wxName}</td>
			<td>${wx.wxFromUserName}</td>
			<td>${wx.wxAccount }</td>
			<td>
			<c:choose>
			<c:when test="${wx.wxType==0 }">订阅号</c:when>
			<c:otherwise>服务号</c:otherwise>
			</c:choose>
			</td>
			<td>${wx.makeTime }</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${not empty weixinList}">
	<ul class="pager">
		<c:if test="${not empty prevPage}">
			<li><a href="${context}/super/userList?pageNo=${prevPage}">上一页</a></li>
		</c:if>
		<li>第${pageNo}页</li>
		<c:if test="${not empty nextPage}">
			<li><a href="${context}/super/userList?pageNo=${nextPage}">下一页</a></li>
		</c:if>
	</ul>
</c:if>
<script type="text/javascript">
	function delete_weixin(wid) {
		var url = "${context}/super/weixin/delete?wid=" + wid;
		//alert(url);
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0) {
					alert("删除成功");
					var wxObj = document.getElementById("weixin_node_" + wid);
					wxObj.style.display = "none"

				} else
					alert("删除失败，请检查数据！")
			} else
				alert("服务器访问失败，请稍后重试！")
		});

	}
</script>