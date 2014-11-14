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
	height: 186px;
}

.conducterAudio {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/broading.png");
	background-repeat: no-repeat;
	width: 248px;
	height: 186px;
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
	z-index: 199;
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
}

.hiddenCheckBox {
	/* display: none;*/
	background: url(${context}/resources/image/CheckBox.gif) 0px -300px
		no-repeat;
	display: block;
	width: 16px;
	height: 16px;
	display: inline-block;
	vertical-align: top;
	margin-left: -80px;
}

.chkTerm {
	position: absolute;
	margin-left: -15px;
	margin-top: 5px;
}

.divTerm {
	min-height: 110px;
	max-width: 110px;
	width: 100px;
	cursor: pointer;
}
</style>
<h4>协同指挥操作台</h4>
<div>
	<div class="alert alert-info" id="tishi">
		<strong>温馨提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
</div>
<video id="videoLocal" style="display: none;"></video>
<table style="width: 100%">
	<tr>
		<td>
			<!-- 远端视频开始 -->
			<div class="row-fluid show-grid">
				<div class="span4">
					<!-- 左上 -->
					<div class="btn-group operater" id="op_1" style="display: none">
						<button class="btn btn-info" onclick="javascript:startWin(1)"
							id="btnCall_1" style="display:">呼叫</button>
						<button class="btn btn-danger" onclick="javascript:hangup(1)"
							id="btnHangup_1" style="display: none">挂机</button>

					</div>
					<video id="video_remote_1" onmouseout="mouseout(event, this, 1)"
						onmouseover="mouseover(event, this, 1);" class="conducterVideo"></video>
					<div style="height: 10px"></div>
				</div>
				<div class="span4">
					<!-- 右上 -->
					<div class="btn-group operater" id="op_2" style="display: none">
						<button class="btn btn-info" onclick="javascript:startWin(2)"
							id="btnCall_2" style="display:">呼叫</button>
						<button class="btn btn-danger" onclick="javascript:hangup(2)"
							id="btnHangup_2" style="display: none">挂机</button>
					</div>
					<video id="video_remote_2" onmouseout="mouseout(event, this, 2)"
						onmouseover="mouseover(event, this, 2);" class="conducterVideo"></video>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<!-- 左下 -->
					<div class="btn-group operater" id="op_3" style="display: none">
						<button class="btn btn-info" onclick="javascript:startWin(3)"
							id="btnCall_3" style="display:">呼叫</button>
						<button class="btn btn-danger" onclick="javascript:hangup(3)"
							id="btnHangup_3" style="display: none">挂机</button>
					</div>
					<video id="video_remote_3" onmouseout="mouseout(event, this, 3)"
						onmouseover="mouseover(event, this, 3);" class="conducterVideo"></video>
				</div>
				<div class="span4">
					<!-- 右下 -->
					<div class="btn-group operater" id="op_4" style="display: none">
						<button class="btn btn-info" onclick="javascript:startWin(4)"
							id="btnCall_4" style="display:">呼叫</button>
						<button class="btn btn-danger" onclick="javascript:hangup(4)"
							id="btnHangup_4" style="display: none">挂机</button>
					</div>
					<video id="video_remote_4" onmouseout="mouseout(event, this, 4)"
						onmouseover="mouseover(event, this, 4);" class="conducterVideo"></video>
				</div>
			</div>
		</td>
		<td
			style="vertical-align: top; min-width: 120px; max-width: 120px; display: none;"><ul>
				<li>消息提示</li>
				<li>消息提示</li>
				<li>消息提示</li>
			</ul></td>
	</tr>
</table>
<!-- 终端显示模板 -->
<div id="termTmpl" style="display: none;">
	<div class="span5 divTerm" style="margin-left: 25px;"
		id="divTerm_$termId" onclick="selPhone('$termId', $state)">
		<div id="border_$termId"
			style="border: 2px solid$color; border-radius: 10px;">
			<span class="hiddenCheckBox" id="span_$termId"> <input
				name="termChk" type="checkbox" id="$termId" style="display: none;"></span>
			<img src="" onclick="sel_chk(this, '$termId')" class="chkTerm">
			<div class="mini-layout fluid">
				<div class="mini-layout-sidebar">
					<img src="/collabration/resources/img/phone_unregister.png"
						style="width: 40px; height: 40px;">
				</div>
				<div class="mini-layout-body">
					$termId<br>状态： <span id="state_$termId">$termState</span>
				</div>
			</div>
		</div>
		<div style="height: 5px;"></div>
	</div>
</div>
<input type="hidden" id="calledNumber">
<input type="hidden" id="txtWindow">
<!-- 消息提示框  -->
<div class="modal hide fade" id="callModal" style="width: 600px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>终端选择</h3>
	</div>
	<div class="modal-body form-horizontal">
		<div class="row-fluid text-center" id="termList" style="width: 600px;"></div>
	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span>
		<button onclick="javascript:videoCall();" id="btnVideoCall" disabled
			class="btn btn-primary">视频</button>
		<button onclick="javascript:audioCall();" id="btnAudioCall"
			class="btn btn-primary" disabled>音频</button>
	</div>
</div>
<script type="text/javascript"
	src="${context }/resources/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	function startWin(id) {
		$("#callModal").modal("show");
		txtWindow.value = id;
		termList.innerHTML = "正在获取终端......";
		//获取终端列表
		var url = webRoot + "/term/search?status=>-3";
		$.get(url, function(data, status) {
			if (status == 'success') {
				//debugger;
				var terms = eval(data);
				var nouse_img = "${context}/resources/img/phone_nouse.png";
				var un_img = "${context}/resources/img/phone_unregister.png";
				var ring_img = "${context}/resources/img/phone_ring.kpg";
				var idle_img = "${context}/resources/img/phone_idle.png";
				var busy_img = "${context}/resources/img/phone_busy.png";
				var listStr = "";
				var termTmpl_str = termTmpl.innerHTML;
				for (var i = 0; i < terms.length; i++) {
					//去掉自己
					if (impi == terms[i].Peer.substr(4))
						continue;

					var img = "";
					var stateStr = "";
					var color = " gray";
					if (terms[i].ChannelState == -3) {
						img = nouse_img;//未使用
						stateStr = "未放号";
					} else if (terms[i].ChannelState == -2) {
						img = un_img;//未注册
						stateStr = "未注册";
					} else if (terms[i].ChannelState == -1) {
						img = idle_img;//空闲
						color = " blue";
						stateStr = "空闲";
					} else if (terms[i].ChannelState == 1) {
						img = ring_img;//振铃
						stateStr = "振铃中";
						color = " gold";
					} else {
						img = busy_img;//通话中
						stateStr = "通话中";
						color = " red";
					}
					var termId = terms[i].Peer;//.substr(4);
					var state = terms[i].ChannelState;

					var tmpl = termTmpl_str;

					tmpl = tmpl.replace(/\\$color/g, color);
					tmpl = tmpl.replace(/\\$termId/g, termId);
					tmpl = tmpl.replace(/\\$termState/g, stateStr);
					tmpl = tmpl.replace(/\\$state/g, state);

					listStr += tmpl;
				}//end for
				termList.innerHTML = listStr;
			}
		});
	}

	/*function makeAudioCall()
	{
		
	}
	
	function makeVideoCall()
	{
		
	}*/
	function selPhone(chkId, state) {
		btnVideoCall.disabled = true;
		btnAudioCall.disabled = true;
		if (parseInt(state) < -1) {
			alert("对不起，该终端未注册，不能进行任何操作！");
			return;
		}
		var termList = document.getElementsByName("termChk");

		//清除其他的选项，
		for (var i = 0; i < termList.length; i++) {
			if (termList[i].checked) {
				document.getElementById(termList[i].id).checked = false;
				var spanObj0 = document
						.getElementById("span_" + termList[i].id);
				spanObj0.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
			}
		}
		//debugger;
		//设置当前选中的终端
		var chkObj = document.getElementById(chkId);
		chkObj.checked = !chkObj.checked;
		var spanObj = document.getElementById("span_" + chkId);
		if (chkObj.checked) {
			//保存最后一次选中的终端
			//calledNumber.value = chkId.substr(4);
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -450px no-repeat";
		} else {
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
		}

		//按钮设置

		if (parseInt(state) == -1) {
			//	alert("ok");
			calledNumber.value = chkId.substr(4);
			btnVideoCall.disabled = false;
			btnAudioCall.disabled = false;
		}
		//setFuntionBtn(chkId,state);
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

<!-- 呼叫控制部分开始 -->
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
	src="${context}/resources/sipml5/SIPml5-multi.js">
	//UA/UE侧控制
</script>
<!-- 呼叫控制部分结束 -->