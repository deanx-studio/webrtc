<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<s:url var="home" value="/home" />
<s:url var="forget" value="/forget" />

<s:url var="sign_in" value="/static/j_spring_security_check" />
<div class="container">

	<form accept-charset="UTF-8" action="${sign_in}" method="post"
		role="form" class="form-signin">
		<div class="page-header">
			<h2>
				登录 <small>欢迎使用泰乐德系统!</small>
			</h2>
		</div>
		<div class="control-group">
			<label class="control-label" for="user_login">账户</label>
			<div class="controls">
				<input id="user_login" name="j_username" placeholder="账户"
					type="text" class="form-control" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="user_password"> <span
				class="control-label" style="margin-left: 0px;">密码 <a
					href="${forget}" style="margin-left: 125px;">忘记密码</a></span>
			</label>
			<div class="controls">
				<input id="user_password" name="j_password" type="password"
					id="inputPassword" class="form-control" placeholder="密码" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox"> <input
					name="_spring_security_remember_me" type="hidden" value="0" /> <input
					id="user_remember_me" name="_spring_security_remember_me"
					type="checkbox" value="1" /> 记住密码
				</label>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">登录</button>
			</div>
		</div>

	</form>
</div>
<script type="text/javascript">
	$('#user_login').focus();
</script>



