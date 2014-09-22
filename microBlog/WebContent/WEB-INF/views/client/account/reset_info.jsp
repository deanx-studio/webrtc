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
	<li class="active">绑定手机</li>
</ul>

<ul class="nav nav-tabs">
	<li><a href="${basic_info}">基本信息</a></li>
	<li class="active"><a href="${reset_info}" id="change_mobile">换个号码</a></li>
	<li><a href="${reset_pass}">修改密码</a></li>
</ul>
<!-- class="disabled" -->

<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>VIP</h3>
				<p>
					<s:url var="binging_new_mobile" value="/account/my/do_reset_info"></s:url>
				<form action="${binging_new_mobile}" method="post" role="form">
				<input type="hidden" name="oldmobile" value="${traveler.mobile}" />
				<input type="hidden" name="username" value="${traveler.username}" />
					<div class="form-group">
						<label for="new_mobile"><span class="text-warning">*</span>新的手机号:</label>
						<input name="mobile" type="text" class="form-control"
							id="mobile" required="required" id="new_mobile" />
					</div>
					<div class="form-group">
						<label for="get_valid_code">验证码:<a id="getvalidcode"
							class="btn btn-default">获取验证码</a>&nbsp;&nbsp;&nbsp;<span
							id="get_valid_info" class="text-info"></span></label> <input
							name="valid_code" placeholder="输入验证码" type="text"
							class="form-control" required="required" id="get_valid_code" />
					</div>
					<button type="submit" data-disable-with="正在确认..."
						class="btn btn-warning btn-lg">确认修改</button>
					<span class="text-info">${reset.info}</span>
				</form>
			</div>
		</div>
	</div>
	
</div>
<script>

$("#getvalidcode").click(function() {
		var username = $('#username').val();
		var mobile = $('#mobile').val();
		var xhr = getXmlHttpRequest();
		
		var temp = loc.length ? loc.split("/") : [];
		var send_loc = '/' + temp[1] + '/account/resetMobile';
		xhr.open('post', send_loc, true); // 必须添加一个消息头content-type
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		alert(send_loc);
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
		xhr.send('username='+username+'&valid_mobile='+mobile);
});
</script>

