<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources" />

<h4>管理员资料</h4>
<c:if test="${not empty message }">
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>提示</strong>${message }
	</div>
</c:if>
<form class="form-horizontal" method="POST"
	action="${context }/super/user/edit" onsubmit="return check();">
	<div class="control-group">
		<label class="control-label">用户名</label>
		<div class="controls">
			<input type="hidden" id="travlerId" name="travelerId"
				value="${travelerObj.id }"> <input type="text" id="username"
				placeholder="请输入用户名" name="username" value="${travelerObj.name }" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">密码</label>
		<div class="controls">
			<input type="password" name="userPwd" id="userPwd"
				placeholder="请输入密码">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">确认密码</label>
		<div class="controls">
			<input type="password" name="passwdconfirm" id="passwdconfirm"
				placeholder="请输入确认密码" onblur="check_pwd(this)"><label
				id="pwdConfirm_result"></label>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">联系手机号码</label>
		<div class="controls">
			<input type="text" name="mobile" placeholder="请输入联系手机号码"
				value="${travelerObj.mobile }">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">管理员级别</label>
		<div class="controls">
		
			<select  name="role">
				<option value="ROLE_ADMIN" <c:if test="${travelerObj.role=='ROLE_ADMIN'}">selected</c:if>>微信管理员</option>
				<option value="ROLE_SUPER" <c:if test="${travelerObj.role=='ROLE_SUPER'}">selected</c:if>>超级管理员</option>
				<option value="ROLE_DRIVE" <c:if test="${travelerObj.role=='ROLE_DRIVE'}">selected</c:if>>境外自驾管理员</option>
				<option value="ROLE_LEAD" <c:if test="${travelerObj.role=='ROLE_LEAD'}">selected</c:if>>境外自驾领队</option>
			</select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">管辖的微信号</label>
		<div class="controls">
			<select  name="wxAccount">
				<c:forEach var="account" items="${accountList}" varStatus="status">
					<option value="${account.wxFromUserName }" <c:if test="${account.wxFromUserName==travelerObj.weixinid }">selected</c:if>>${account.wxName
						}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<button type="submit" class="btn btn-primary">保存信息</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	function check() {
		var pass = document.getElementById("userPwd").value;
		var confromPass = document.getElementById("passwdconfirm").value;
		//alert(pass);
		if (pass.length == 0 || confromPass.length == 0) {
			alert("密码不能为空");
			return false;
		}
		if (confromPass != pass) {
			alert("两次密码输入不一致,请重新输入。");
			return false;
		}
		return true;
	}

	
</script>