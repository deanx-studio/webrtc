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
<!-- 获取用户身份 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<div class="span9">
	<div class="hero-unit">
		<h2>管理员操作台</h2>
		<p>通过泰乐德协同指挥调度管理台，您可以完成用户管理、终端管理</p>
		<p>
			<a href="${context }/admin/user/list" class="btn btn-primary btn-large">用户管理 &raquo;</a>
		</p>
	</div>
</div>
<!--/span-->
