<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="form_mobile_pass" value="/account/find_name_or_pass"></s:url>

<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li class="active">找回方式</li>
</ul>


<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>重置密码</h3>
				<p>
				<form accept-charset="UTF-8" action="${form_mobile_pass}"
					id="new_user" method="post" role="form">
					<div class="form-group">
						<label for="mobile"><span class="text-warning">*</span>已绑定手机号:</label>
						<input name="valid_mobile" type="text" class="form-control"
							required="required" id="forget_mobile" />
					</div>
					<div class="form-group">
						<label for="get_valid_code"><span class="text-warning">*</span>验证码:<a id="getvalidcode"
							class="btn btn-default">获取验证码</a>&nbsp;&nbsp;&nbsp;<span
							id="get_valid_info" class="text-info"></span></label> 
							<input name="validate_code" type="text" class="form-control"
							required="required" id="get_valid_code" placeholder="输入验证码"/>
					</div>
					<div class="form-group">
						<label for="new_pass"><span class="text-warning">*</span>新的密码:</label>
						<input name="new_pass" type="password" class="form-control"
							required="required" id="new_pass" />
					</div>
					<div class="form-group">
						<label for="second_pass"><span class="text-warning">*</span>再次确认:</label>
						<input name="second_pass" type="password" class="form-control"
							required="required" id="second_pass" />
					</div>

					<button type="submit" data-disable-with="正在确认..."
						class="btn btn-warning btn-lg">确认修改</button>
					<span class="text-warning">${Message.info}</span>
				</form>
				</p>
			</div>

		</div>
	</div>
</div>

<script>
		$('#getvalidcode').click(
				function() {
					//var username = $('#username').val();
					var username="anonymousUser";
					var mobile = $('#forget_mobile').val();
					
					var xhr = getXmlHttpRequest();
					
					var temp = loc.length ? loc.split("/") : [];
					var send_loc = '/' + temp[1] + '/signup/get_valid_code';
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
					xhr.send('username='+username+'&mobile='+mobile);
				});

	
</script>
