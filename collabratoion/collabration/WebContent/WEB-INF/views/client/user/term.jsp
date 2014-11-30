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
	z-index: 999;
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
				onclick="javascript:Answer();" style="display: none">接听</button>
			<button id="btnReject" type="button" class="btn btn-danger"
				onclick="javascript:hangup();" style="display: none">拒绝</button>
			<button id="btnCall" type="button" class="btn btn-info"
				onclick="javascript:startCallWin();" style="display: none">呼叫</button>

			<button id="btnHangUp" type="button" class="btn btn-danger"
				onclick="javascript:hangup();" style="display: none">挂断</button>
			<button id="btnRegister" type="button" class="btn btn-info"
				onclick="javascript:register();" style="display:">注册</button>
		</div>
		<video id="video_local" class="localVideo"
			onmouseout="mouseout(event, this)"
			onmouseover="mouseover(event, this);"></video>
		<div>
			<!-- <h4>呼叫历史记录</h4>  -->
			<table class="table">
				<thead>
					<tr>
						<th>号码</th>
						<th>类型</th>
						<th>时长</th>
						<th>时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="call" items="${callList}" varStatus="status">
						<tr>
							<td><a href="javascript:callAgain(${call.remotePeer})">${call.remotePeer}</a></td>
							<td>
							<c:choose><c:when test="${call.callType == 0 }">呼出</c:when><c:otherwise>呼入</c:otherwise></c:choose>
							
							</td>
							<td>${call.callLength}</td>
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
			<!-- 
			<div class="control-group">
				<label class="control-label">终端搜索</label>
				<div class="controls">
					<input type="text" id="searchNumber" placeholder="请输入呼叫号码">
				</div>
			</div>
			 -->
		</div>
		<div class="modal-body">
			<div class="row-fluid text-center" id="termList"></div>

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
	var impi = "${termId}";
	var webRoot = "${context}";
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
	function callAgain(peer) {
		startCallWin();
		calledNumber.value = peer;
	}
	function mouseout(event, obj) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//alert("from:" + from.tagName + ";to:" + to.tagName);

		if (from.tagName == "DIV"
				|| (from.tagName == "VIDEO" && to.tagName == "VIDEO")) {
			var oo = document.getElementById("op");
			if (oo.style.display != "none")
				oo.style.display = "none";
		}
	}
	function mouseover(event, obj) {
		//发生闪烁现象
		//var from = event.relatedTarget ? event.relatedTarget
		//		: event.fromElement;
		//var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		var oo = document.getElementById("op");
		if (oo.style.display == "none")
			oo.style.display = "block";
	}

	// 弹出呼叫窗口
	var startCallWin = function() {

		//填充终端状态
		var url = webRoot + "/term/search?status=>-3";
		$
				.get(
						url,
						function(data, status) {
							if (status == 'success') {
								//debugger;
								var terms = eval(data);
								var listStr = "";
								//
								var nouse_img = "${context}/resources/img/phone_nouse.png";
								var un_img = "${context}/resources/img/phone_unregister.png";
								var ring_img = "${context}/resources/img/phone_ring.kpg";
								var idle_img = "${context}/resources/img/phone_idle.png";
								var busy_img = "${context}/resources/img/phone_busy.png";
								for (var i = 0; i < terms.length; i++) {

									var img = "";
									var stateStr = "";
									if (terms[i].ChannelState == -3) {
										img = nouse_img;//未使用
										stateStr = "未放号";
									} else if (terms[i].ChannelState == -2) {
										img = un_img;//未注册
										stateStr = "未注册";
									} else if (terms[i].ChannelState == -1) {
										img = idle_img;//空闲
										stateStr = "空闲";
									} else if (terms[i].ChannelState == 1) {
										img = ring_img;//振铃
										stateStr = "振铃中";
									} else {
										img = busy_img;//通话中
										stateStr = "通话中";
									}
									var termId = terms[i].Peer.substr(4);
									var state = terms[i].ChannelState;

									listStr += '<div class="span5" style="min-height:99px;max-width:110px;width:100px;" onclick="selPhone('
											+ termId + ',' + state + ')">';
									listStr += '<div class="mini-layout fluid">';
									listStr += '<div class="mini-layout-sidebar">';
									listStr += '<img src="'+img+'"	style="width: 40px; height: 40px;">';
									listStr += '</div>';
									listStr += '<div class="mini-layout-body">';
									listStr += termId + '<br />状态：' + stateStr;
									listStr += '</div></div></div>';
								}//end for
								termList.innerHTML = listStr;
							}//end if
						});

		$("#callModal").modal("show");
	};
	// end startCallWin function

	function selPhone(termId, state) {
		calledNumber.value = termId;
	}
</script>
<!-- SIP部分 -->

