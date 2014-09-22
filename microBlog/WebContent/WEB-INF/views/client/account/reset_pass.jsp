<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="basic_info" value="/account/my/basic" />
<s:url var="reset_info" value="/account/my/reset_info" />
<s:url var="reset_pass" value="/account/my/reset_pass" />
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li><a href="${basic_info}">账户设置</a> <span class="divider">/</span></li>
	<li class="active">修改密码</li>
</ul>

<ul class="nav nav-tabs">
	<li><a href="${basic_info}">基本信息</a></li>
	<li><a href="${reset_info}">换个号码</a></li>
	<li class="active"><a href="${reset_pass}" id="change_pass">修改密码</a></li>
</ul>

<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>会员凭证</h3>
				<p>
				<s:url var="form_change_pass" value="/account/my/do_reset_pass"></s:url>
				<form accept-charset="UTF-8" action="${form_change_pass}" id="new_user"
					method="post" role="form">
					<div class="form-group">
						<label for="old_pass"><span
							class="text-warning">*</span>旧的密码:</label> <input name="old_pass"
							type="password" class="form-control" required="required"
							id="old_pass" />
					</div>
					<div class="form-group">
						<label for="new_pass"><span
							class="text-warning">*</span>新的密码:</label> <input name="new_pass"
							type="password" class="form-control" required="required"
							id="new_pass" />
					</div>
					<div class="form-group">
						<label for="second_pass"><span
							class="text-warning">*</span>再次确认:</label> <input name="second_pass"
							type="password" class="form-control" required="required"
							id="second_pass" />
					</div>
					
					<button type="submit" data-disable-with="正在确认..."
						class="btn btn-warning btn-lg">确认修改</button><span class="text-warning">${info.info}</span>
				</form>
				</p>
			</div>

		</div>
	</div>
</div>
<script>
$("#change_pass").click(
		function (){
			return false;
		}
		);
</script>