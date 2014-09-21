<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.conducterVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini.png");
	background-repeat: no-repeat;
	width: 248px;
	height: 198px;
}

.remoteVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini.png");
	background-repeat: no-repeat;
	width: 496px;
	height: 396px;
}

.operater {
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
}
</style>
<h4>协同指挥操作台</h4>
<div>
	<div class="alert alert-info" id="tishi">
		<strong>温馨提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
</div>
<table style="width: 100%">
	<tr>
		<td style="vertical-align: top; min-width: 120px; max-width: 120px;"><ul>
				<li>消息提示</li>
				<li>消息提示</li>
				<li>消息提示</li>
			</ul></td>
		<td>
			<!-- 远端视频开始 -->
			<div class="row-fluid show-grid">
				<div class="span4">
					<!-- 左上 -->
					<div class="btn-group operater" id="op_1" style="display: none">
						<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
							href="#"> 操作 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="javascript:call(1)">呼叫</a></li>
							<li><a href="javascript:huangup(1)">挂断</a></li>
							<li><a href="javascript:register(1)">注册</a></li>
						</ul>
					</div>
					<video id="video_remote_1" onmouseout="mouseout(event, this, 1)"
						onmouseover="mouseover(event, this, 1);" class="conducterVideo"></video>
					<div style="height: 10px"></div>
				</div>
				<div class="span4">
					<!-- 右上 -->
					<div class="btn-group operater" id="op_2" style="display: none">
						<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
							href="#"> 操作 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="javascript:call(2)">呼叫</a></li>
							<li><a href="javascript:huangup(2)">挂断</a></li>
							<li><a href="javascript:register(2)">注册</a></li>
						</ul>
					</div>
					<video id="video_remote_2" onmouseout="mouseout(event, this, 2)"
						onmouseover="mouseover(event, this, 2);" class="conducterVideo"></video>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<!-- 左下 -->
					<div class="btn-group operater" id="op_3" style="display: none">
						<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
							href="#"> 操作 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="javascript:call(3)">呼叫</a></li>
							<li><a href="javascript:huangup(3)">挂断</a></li>
							<li><a href="javascript:register(3)">注册</a></li>
						</ul>
					</div>
					<video id="video_remote_3" onmouseout="mouseout(event, this, 3)"
						onmouseover="mouseover(event, this, 3);" class="conducterVideo"></video>
				</div>
				<div class="span4">
					<!-- 右下 -->
					<div class="btn-group operater" id="op_4" style="display: none">
						<a class="btn btn-info dropdown-toggle" data-toggle="dropdown"
							href="#"> 操作 <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="javascript:call(4)">呼叫</a></li>
							<li><a href="javascript:huangup(4)">挂断</a></li>
							<li><a href="javascript:register(4)">注册</a></li>
						</ul>
					</div>
					<video id="video_remote_4" onmouseout="mouseout(event, this, 4)"
						onmouseover="mouseover(event, this, 4);" class="conducterVideo"></video>
				</div>
			</div>
		</td>
	</tr>
</table>

<!-- 消息提示框  -->
<div class="modal hide fade" id="callModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>终端选择</h3>
	</div>
	<div class="modal-body form-horizontal">
		<input type="text" id="termId" />
		<div id="userInfoRegion">
			<div class="control-group">
				<label class="control-label">登录帐号</label>
				<div class="controls">
					<input type="text" id="inputUserName" placeholder="登录帐号">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">账户角色</label>
				<div class="controls">
					<select id="inputRole">
						<option value="ROLE_ADMIN">管理员</option>
						<option value="ROLE_CONDUCTER">操作员</option>
						<option value="ROLE_USER">用户</option>
					</select>

				</div>
			</div>

			<div class="control-group">
				<label class="control-label">联系电话</label>
				<div class="controls">
					<input type="text" id="inputMobile" placeholder="联系电话">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">IP电话号码</label>
				<div class="controls">
					<input type="text" id="inputTerminateNumber" placeholder="IP电话">
				</div>
			</div>
		</div>

	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:addUser();" id="newUserBtn" class="btn btn-primary">视频</a>
		<a href="javascript:updateUser();" id="saveUserBtn"
			class="btn btn-primary">音频</a>
	</div>
</div>
<script type="text/javascript"
	src="${context }/resources/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	function call(id) {
		termId.value = id;
		$("#callModal").modal("show");
	}

	function mouseout(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//alert("from:" + from.tagName + ";to:" + to.tagName);

		if (from.tagName == "DIV"
				|| (from.tagName == "VIDEO" && to.tagName == "VIDEO"))
			document.getElementById("op_" + id).style.display = "none";
	}
	function mouseover(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		document.getElementById("op_" + id).style.display = "";
	}

	
</script>