<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources" />
<h4>管理员列表</h4>
<div>
	<c:if test="${empty userList}">
		<h4 class="text-danger">${message }</h4>
	</c:if>
</div>
<table class="table table-striped">
	<tr>
		<th>操作</th>
		<th>名称</th>
		<th>角色</th>
		<th>手机号码</th>
		<th>微信名称</th>
		<th>微信ID</th>
	</tr>
	<c:forEach var="user" items="${userList}" varStatus="status">
		<tr id="user_node_${user.id}">
			<td>
				<div class="btn-group">
					<button class="btn">
						<a href="${context}/super/user/add?id=${user.id}">编辑</a>
					</button>
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="${context}/super/user/add?id=${user.id}">编辑</a></li>
						<li><a href="javascript:delete_user(${user.id})">删除</a></li>
					</ul>
				</div>
			</td>
			<td>${user.name}</td>
			<td>${user.role }</td>
			<td>${user.mobile }</td>
			<td>${user.weixinName }</td>
			<td>${user.weixinid }</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${not empty userList}">
	<ul class="pager">
		<c:if test="${not empty prevPage}">
			<li><a href="${context}/spper/userList?pageNo=${prevPage}">上一页</a></li>
		</c:if>
		<li>第${pageNo}页</li>
		<c:if test="${not empty nextPage}">
			<li><a href="${context}/super/userList?pageNo=${nextPage}">下一页</a></li>
		</c:if>
	</ul>
</c:if>
<script type="text/javascript">
	function delete_user(uid) {
		var url = "${context}/super/user/delete?travelerId=" + uid;
		//alert(url);
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0) {
					alert("删除成功");
					var usrObj = document.getElementById("user_node_" + uid);
					usrObj.style.display = "none"

				} else
					alert("伤处失败，请检查数据！")
			} else
				alert("服务器访问失败，请稍后重试！")
		});

	}

	
</script>