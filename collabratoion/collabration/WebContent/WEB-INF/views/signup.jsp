<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url var="home" value="/home" />
<s:url var="dosignup" value="/dosignup"></s:url>

<div class="page-header">
	<div style="height: 3px;"></div>
	<h1>
		<small>绑定手机</small>
	</h1>
</div>
<c:choose>
	<c:when test="${empty message}"></c:when>
	<c:otherwise>
		<div style="height: 15px;">
			<h5 class="text-primary text-danger">${message}</h5>
		</div>
	</c:otherwise>
</c:choose>
<form accept-charset="UTF-8" action="${dosignup}" id="new_user"
	method="post" role="form">
	<div class="form-group">
		<label for="username"><span class="text-warning">*</span>登录唯一账户</label>
		<span style="color: red; font-size: 24px; font-style: italic;"
			id="username_msg"></span> <input id="username" class="form-control"
			name="username" type="text" required="required" />
	</div>
	<div class="form-group">
		<label for="login_pass"><span class="text-warning">*</span>登录密码</label>
		<input id="login_pass" name="pass" required="required" type="password"
			class="form-control" />
	</div>
	<div class="form-group">
		<label for="exampleInputPassword"><span class="text-warning">*</span>确认密码</label>
		<input name="confirm_pass" type="password" required="required"
			class="form-control" id="exampleInputPassword" />
	</div>
	<div class="form-group">
		<label for="mobile"><span class="text-warning">*</span>有效手机号码</label>
		<input id="mobile" name="mobile" type="text" class="form-control"
			required="required" />
	</div>
	<div class="form-group">
		<label for="get_valid_code"><a id="signup_validcode"
			class="btn btn-default">获取验证码</a><span id="get_valid_info"
			class="text-info"></span></label> <input name="valid_code" type="text"
			class="form-control" required="required" id="get_valid_code" />
	</div>
	<button type="submit" data-disable-with="正在确认..."
		class="btn btn-primary btn-lg">创建账户</button>
</form>
<p class='muted'>
	<span class="glyphicon glyphicon-user"></span> <span
		class="text-warning">已注册</span> &nbsp;<span
		class="glyphicon glyphicon-hand-right"></span> <a
		class="btn btn-default btn-xs" href='<s:url value="/login"/>'>登录</a>
</p>

<script>
	window.onload = function() {
		$('#signup_validcode').click(
				function() {
					var username = $('#username').val();
					var mobile = $('#mobile').val();
					var xhr = getXmlHttpRequest();
					
					var temp = loc.length ? loc.split("/") : [];
					var send_loc = '/' + temp[1] + '/signup/get_valid_code';
					xhr.open('post', send_loc, true); // 必须添加一个消息头content-type
					xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded");
					
					xhr.onreadystatechange = function() {
						// 编写相应的处理代码
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								var txt = xhr.responseText;
								$('#get_valid_info').text(txt);
							} else {
								$('#get_valid_info').text('系统错误，稍后重试');
							}
						} else {
							$('#get_valid_info').text('玩命发送...');
						}
					};
					xhr.send('username='+username+'&mobile='+mobile);
				});
		$('#username').blur(
				function() {
					var xhr = getXmlHttpRequest();
					var username = $('#username').val();
					xhr.open('post', 'check/username', true); //必须添加一个消息头content-type 
					xhr.setRequestHeader("Content-Type",
							"application/x-www-form-urlencoded");
					xhr.onreadystatechange = function() {
						//编写相应的处理代码 
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								var txt = xhr.responseText;
								$('#username_msg').text(txt);
							} else {
								$('#username_msg').text('系统错误，稍后重试');
							}
						} else {
							$('#username_msg').text('正在验证...');
						}
					};
					xhr.send('username=' + username);
				});
	};

	
</script>