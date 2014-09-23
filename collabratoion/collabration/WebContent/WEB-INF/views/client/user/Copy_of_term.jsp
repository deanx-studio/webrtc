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
			<button id="btnCall" type="button" class="btn btn-info"
				onclick="javascript:startCallWin();" disabled>呼叫</button>
			<button id="btnHangup" type="button" class="btn btn-warning"
				onclick="javascript:huangup();" disabled>挂断</button>
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
<script src="${context}/resources/sipjs/sip-0.6.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
function callAgain(remotePeer)
{
	calledNumber.value = remotePeer;
	startCallWin();
	}
	//test function 
	/*
	 (function () {
	 var session;
	 //Creates the anonymous user agent so that you can make calls
	 var userAgent = new SIP.UA({
	 traceSip: true
	 });

	 //here you determine whether the call has video and audio
	 var options = {
	 media: {
	 constraints: {
	 audio: true,
	 video: true
	 },
	 render: {
	 remote: {
	 video: document.getElementById('video_local')
	 },
	 local: {
	 video: document.getElementById('video_remote')
	 }
	 }
	 }
	 };
	 //makes the call
	 session = userAgent.invite('sip:bryan@wadearcade.onsip.com', options);
	 })();
	 */

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
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		document.getElementById("op").style.display = "";
	}
	//Here you determine which media the stream has
	var mediaConstraints = {
		audio : true,
		video : true
	};
	var domain = "${domain}";
	var termId = "${termId}";
	function startCallWin() {
		$("#callModal").modal("show");
	}
	function videoCall() {
		mediaConstraints.video = true;
		$("#callModal").modal("hide");
		//debugger;
		startCall(calledNumber.value + "@" + domain);

	}
	function audioCall() {
		mediaConstraints.video = false;
		$("#callModal").modal("hide");
		//debugger;
		startCall(calledNumber.value + "@" + domain);

	}
	function huangup() {
	}
	function register() {
		txtTishi.innerHTML = termId + "正注册到" + domain;
		ua.start();
		//debugger;
		ua.register(/*options*/);
	}

	//sip模块初始化
	var config = {
		// EXAMPLE wsServers: "wss://my.websocketserver.com",
		wsServers : [ "${wsServers}" ],
		//wsServers : ["wss://deanx.cn:10062"],
		
		uri : "${uri}",
		authorizationUser : "${authorizationUser}",
		password : "${password}",
		stunServers : ['stun:deanx.cn:3478'],
		turnServers :  {
			  urls:"turn:deanx.cn:3478",
			  username:"lzj",
			  password:"123456"
			},
		// FILL IN THOSE VALUES ^
		register : true,
		userAgentString : 'SIP.js/0.5.0-devel BAREBONES DEMO',
		// viaHost : ['115.28.86.18'],
		traceSip : true,
		hackIpInContact : true,
		usePreloadedRoute : true,
	};
	//设置基本参数，包括用户名等
	var options = {
		extraHeaders : [ 'Route: <sip:deanx.cn:5060;lr;sipml5-outbound;transport=udp>' ]
	};

	// 创建UA对象,并注册到域
	var ua = new SIP.UA(config);

	// 'sip:bryan@wadearcade.onsip.com';

	var mediaStream;
	var session;
	var target;

	// 媒体获取失败
	function getUserMediaFailure(e) {
		console.error('getUserMedia failed:', e);
	}
	function useSession(s) {
		session = s;
		session.on('bye', function() {
			session = null;
		});
	}

	//sip事件
	ua.on('connected', function() {
		console.log("--------connected!!!!!!");
		txtTishi.innerHTML = "web socket 连接成功。正在注册......";
	});

	ua.on('registered', function() {
		console.log("--------register!!!!!!");
		txtTishi.innerHTML = "注册成功。";
		btnCall.disabled = false;
		btnRegister.disabled = true;
	});

	ua.on('unregistered', function() {
		console.log("--------unregister!!!!!!");
		txtTishi.innerHTML = "与服务器失联。";
		btnCall.disabled = true;
		btnRegister.disabled = false;
	});
	
	ua.on('invite', function (incomingSession) {
		console.log("--------invite!!!");
		txtTishi.innerHTML = "呼入中.......";
		
        session = incomingSession;
        session.accept({
            media: {
                render: {
                    remote: {
                        video: document.getElementById('video_remote')
                    },
                    local: {
                        video: document.getElementById('video_local')
                    }
                }
            }
        });
	});


	// 媒体获取成功
	function getUserMediaSuccess(stream) {
		console.log('getUserMedia succeeded', stream);
		mediaStream = stream;

		//debugger;

		// Makes a call
		useSession(ua
				.invite(
						target,
						{
							extraHeaders : [ 'Route: <sip:deanx.cn:5060;lr;sipml5-outbound;transport=udp>' ],
							media : {
								stream : mediaStream,

								render : {
									remote : {
										video : document
												.getElementById('video_remote')
									},
									local : {
										video : document
												.getElementById('video_local')
									}
								}
							}
						}));

	}

	// var startCall = document.getElementById('btnCall');
	var startCall = function(tar) {
		target = tar;
		console.log("--------------invoke call：" + target);
		if (mediaStream) {
			getUserMediaSuccess(mediaStream);
		} else {
			if (SIP.WebRTC.isSupported()) {
				SIP.WebRTC.getUserMedia(mediaConstraints, getUserMediaSuccess,
						getUserMediaFailure);
			}
		}
	};

	//注册
	window.onload = function() {
		readyTimer = setInterval(
				function() {
					if (document.readyState == "complete") {
						//debugger;
						clearInterval(readyTimer);
						console
								.log("----------------on interval, call register function!");
						register();
					}
				}, 500);
	};
	//register();
</script>
<!-- 启动sip-js  -->

<!--
<script src="${context}/resources/sipjs/user_ua.js"
	type="text/javascript"></script>
-->