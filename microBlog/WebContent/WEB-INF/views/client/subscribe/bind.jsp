<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url var="home" value="/home" />
<s:url var="dosignup" value="/dosignup"></s:url>

<div class="control-group">
	<div style="height: 3px;"></div>
	<h4>填写用户信息</h4>
</div>
<c:if test="${not empty message }">
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>提示：</strong>${message}
	</div>
</c:if>
<form accept-charset="UTF-8" action="${context}/sub/bindAction?travelerId=${travelerId}"
	id="new_user" method="post" class="form-horizontal"
	onsubmit="return check()">
	<input type="hidden" name="openid" id="openid" value="${openId}" />
	<div class="control-group">
		<label class="control-label">登录名</label>
		<div class="controls">
			<input style="width: 120px;" type="text" name="username"
				id="username" value="${username}" placeholder="登录名" autocomplete="off"
				onblur="check_name(this)" /><label id="username_result"></label>
		</div>
	</div>
	<div class="control-group" style="display: none">
		<label class="control-label">登录密码</label>
		<div class="controls">
			<input type="password" name="userPwd" id="userPwd" placeholder="登录密码"
				value="8888" style="width: 120px;">
		</div>
	</div>
	<div class="control-group" style="display: none">
		<label class="control-label">确认密码</label>
		<div class="controls">
			<input type="password" name="passwdconfirm" id="passwdconfirm"
				placeholder="确认密码" onblur="check_pwd(this)" value="8888"
				style="width: 120px;" /><label id="pwdConfirm_result"></label>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">手机号码</label>
		<div class="controls">
			<input type="text" size="11" id="mobile" name="mobile"
				value="${mobile}" placeholder="手机号码" style="width: 120px;" /> <input
				onclick="sendSmsCode()" class="btn btn-warning" type="button"
				value="验证码" /><br /> <label id="mobile_result"></label>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">短信验证码</label>
		<div class="controls">
			<input type="text" name="smsCode" id="smsCode" placeholder="短信验证码"
				style="width: 120px;" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label"></label>
		<div class="controls">
			<button type="submit" class="btn btn-primary btn-lg">
				<c:choose>
					<c:when test="${not empty travelerId }">
				更新信息
				</c:when>
					<c:otherwise>创建账户</c:otherwise>
				</c:choose>

			</button>
		</div>
	</div>

</form>

<script>

	function check() {
		var openid = document.getElementById("openid");
		//alert(openid.value);
		if (openid.value.length == 0) {
			alert("请从微信客户端访问。");
			return false;
		}
		var userPwd = document.getElementById("userPwd").value;
		var passwdconfirm = document.getElementById("passwdconfirm").value;
		var mobile = document.getElementById("mobile").value;
		var username = document.getElementById("username").value;
		
		/*if (passwdconfirm.length == 0 || passwdconfirm != userPwd) {
			alert("密码输入不一致，请确认或重新输入");
			return false;
		}*/
		return true;
	}
	function sendSmsCode() {
		var mobile = document.getElementById("mobile").value;
		var username = document.getElementById("username").value;
		if (username.length == 0) {
			alert("请输入用户名");
			return;
		}
		var url = "${context}/sub/sendValidateCode";
		var mobile_result = document.getElementById("mobile_result");
		if (mobile.length == 0 || mobile.substring(0, 1) != "1"
				|| mobile.length != 11 || !$.isNumeric(mobile)) {

			mobile_result.style.color = "red";
			mobile_result.innerText = "手机号码非法，请重新输入";
			return;
		} else {
			mobile_result.innerText = "";
		}
		$.post(url, {
			"mobile" : mobile,
			"username" : username
		}, function(data, status) {
			if (status == 'success')
				if (data == '0')
					alert("短信已经发送！");
				else if (data == '-1')
					alert("用户名或者手机号码为空，请重新输入。！");
				else if (data == '-3')
					alert("手机号码非法，请重新输入。！");
				else
					alert("短信发送失败，请重新获取！");
			else
				alert("服务器未响应！");
		});
	}

	
</script>