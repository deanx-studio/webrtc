<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<s:url var="home" value="/home" />
<s:url var="forget" value="/forget" />

<div class="page-header"></div>

<div class="pretty">
<p>正在登录，请稍候...</p>

</div>

<s:url var="sign_in" value="/static/j_spring_security_check" />

<form accept-charset="UTF-8" action="${sign_in}" class="new_user"
	method="post" role="form" class="form-horizontal" id="form1">

			<input
			id="user_login" name="j_username" placeholder="账户" type="hidden" class="form-control" value="${traveler.username }" />
			<input id="user_password"
			name="j_password" type="hidden" id="inputPassword" class="form-control" placeholder="密码" value="${traveler.token}"/>
				<input
			name="_spring_security_remember_me" type="hidden" value="0" />
			
	</form>

<script>

document.getElementById("form1").submit();


</script>
