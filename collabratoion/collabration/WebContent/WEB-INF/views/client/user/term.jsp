<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.localVideo {
	border: 1px solid black;
	background-image: url("${context}/resources/image/local_video.png");
	background-repeat: no-repeat;
	width: 248px;
	height: 186px;
}

.remoteVideo {
	border: 1px solid black;
	background-image: url("${context}/resources/image/remote_video.png");
	background-repeat: no-repeat;
	width: 496px;
	height: 372px;
}

.operater {
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
}
</style>
<h4>用户终端</h4>
<div>
	<div class="alert alert-info" id="tishi">
		<strong>温馨提示：</strong><span id="txtTishi">${message }</span>
	</div>
</div>

<div class="row-fluid show-grid">
	<div class="span4">
		<div class="btn-group operater" id="op">
			<button id="btnAnswer" type="button" class="btn btn-info"
				onclick="javascript:Answer();" disabled>接听</button>
			<button id="btnReject" type="button" class="btn btn-info"
				onclick="javascript:hangup();" disabled>拒绝</button>
			<button id="btnCall" type="button" class="btn btn-info"
				onclick="javascript:startCallWin();" disabled>呼叫</button>
			<button id="btnHangUp" type="button" class="btn btn-warning"
				onclick="javascript:hangup();" disabled>挂断</button>
			<button id="btnRegister" type="button" class="btn btn-info"
				onclick="javascript:register();">注册</button>
		</div>
		<video id="video_local" class="localVideo"
			onmouseout="mouseout(event, this)"
			onmouseover="mouseover(event, this);"></video>
		<div>
			<!-- <h4>呼叫历史记录</h4>  -->
			<table class="table">
				<thead>
					<tr>
						<th>呼叫号码</th>
						<!-- 	<th>呼叫类型</th>  -->
						<th>呼叫时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="call" items="${callList}" varStatus="status">
						<tr>
							<td><a href="javascript:callAgain(${call.remotePeer})">${call.remotePeer}</a></td>

							<td>${call.endTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="span6">
		<video id="video_remote" class="remoteVideo"></video>
	</div>
</div>

<!-- 消息提示框  -->
<div class="modal hide fade" id="callModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>终端呼叫</h3>
	</div>
	<div class="modal-body form-horizontal">
		<input type="hidden" id="editUID" />
		<div id="userInfoRegion">
			<div class="control-group">
				<label class="control-label">呼叫号码</label>
				<div class="controls">
					<input type="text" id="calledNumber" placeholder="请输入呼叫号码">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">终端搜索</label>
				<div class="controls">
					<input type="text" id="searchNumber" placeholder="请输入呼叫号码">
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:videoCall();" class="btn btn-primary">视频呼叫</a> <a
			href="javascript:audioCall();" class="btn btn-primary">音频呼叫</a>
	</div>
</div>
<audio id="audio_remote" autoplay="autoplay"></audio>
<audio id="ringtone" loop
	src="${context }/resources/sipml5/sounds/ringtone.wav"></audio>
<audio id="ringbacktone" loop
	src="${context }/resources/sipml5/sounds/ringbacktone.wav"></audio>
<script type="text/javascript">
	var domain = 'webrtc.vmeeting.cn';// 'rtctest';
	var impi = '${termId}';
	var pwd = '${password}';
</script>
<script src="${context}/resources/sipml5/SIPml-api.js?svn=224"
	type="text/javascript">
	//
</script>
<script src="${context}/resources/sipml5/SIPml.js"
	type="text/javascript">
	//SIPml5基本类库
</script>
<script type="text/javascript"
	src="${context}/resources/sipml5/SIPml5-ua.js">
	//UA/UE侧控制
</script>
<script type="text/javascript">
	function mouseout(event, obj) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//alert("from:" + from.tagName + ";to:" + to.tagName);

		if (from.tagName == "DIV"
				|| (from.tagName == "VIDEO" && to.tagName == "VIDEO"))
			document.getElementById("op").style.display = "none";
	}
	function mouseover(event, obj) {
		//发生闪烁现象
		//var from = event.relatedTarget ? event.relatedTarget
		//		: event.fromElement;
		//var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		document.getElementById("op").style.display = "";
	}
</script>
<!-- SIP部分 -->

