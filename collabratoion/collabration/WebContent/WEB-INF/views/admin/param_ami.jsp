<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="${context}/resources/sipml5/SIPml-api.class.js"
	type="text/javascript">
	
</script>
<style>
span {
	color: gray;
}
</style>
<!-- 获取用户身份 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<c:forEach var="items" items="${params}" varStatus="status">
	<c:if test="${items.keyName=='amiServer'}">
		<s:url var="amiServer" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='amiPort'}">
		<s:url var="amiPort" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='amiUsername'}">
		<s:url var="amiUsername" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='amiSecrect'}">
		<s:url var="amiSecrect" value="${items.keyValue}" />
	</c:if>
</c:forEach>
<div class="span12">
	<legend>AMI参数设置</legend>
	<c:if test="${not empty message}">
		<div class="alert">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>提示!</strong>${message }
		</div>
	</c:if>
	<form class="form-horizontal" action="${context }/admin/param/ami"
		method="post">

		<div class="control-group">
			<!-- private String amiServer;  -->
			<label class="control-label">服务器地址</label>
			<div class="controls">
				<input type="text" name="amiServer" value="${amiServer}"
					placeholder="ami.deanx.cn"> <span>AMI服务器地址</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private int amiPort;   -->
			<label class="control-label">端口号</label>
			<div class="controls">
				<input type="text" name="amiPort" value="${amiPort }"
					placeholder="5038"> <span>AMI服务器端口号</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String amiUsername;   -->
			<label class="control-label">登录用户名</label>
			<div class="controls">
				<input type="text" name="amiUsername" value="${amiUsername }">
				<span>AMI登陆用户名称</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String amiSecrect;   -->
			<label class="control-label">登录密码</label>
			<div class="controls">
				<input type="text" name="amiSecrect" value="${amiSecrect }">
				<span>AMI访问密码</span>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">保存</button>
			</div>
		</div>
	</form>
</div>
<!--/span-->
