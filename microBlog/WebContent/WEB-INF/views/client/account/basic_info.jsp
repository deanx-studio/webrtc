<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="basic_info" value="/account/my/basic" />
<s:url var="reset_info" value="/account/my/reset_info" />
<s:url var="reset_pass" value="/account/my/reset_pass" />
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li><a href="${basic_info}">账户设置</a> <span class="divider">/</span></li>
	<li class="active">基本信息</li>
</ul>

<ul class="nav nav-tabs">
	<li class="active"><a href="${basic_info}" id="find_basic">基本信息</a></li>
	<li><a href="${reset_info}">换个号码</a></li>
	<li><a href="${reset_pass}">修改密码</a></li>
</ul>

<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>会员中心</h3>
				<p>
				<table class="table">
					<tbody>
						<tr class="active">
							<td>登录用户名:</td>
							<td>${traveler.username}</td>
						</tr>
						<tr class="warning">
							<td>绑定手机号:</td>
							<td>${traveler.mobile}</td>
						</tr>
					</tbody>
				</table>
				</p>

			</div>
		</div>
	</div>
</div>
<script>
	$("#find_basic").click(function() {
		return false;
	});
</script>