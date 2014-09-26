//定义全局变量
var pwd;
var domain;
var oSipStack;
var oConfigCall;
var viewVideoLocal, viewVideoRemote;
var videoRemote, videoLocal, audioRemote;
var stackConfig;
var oSipSessionRegister;
var oSipSessionCall;

// 全局变量定义结束

// 等待页面加载完毕进行初始化
window.onload = function() {
	videoLocal = document.getElementById("video_local");
	videoRemote = document.getElementById("video_remote");
	audioRemote = document.getElementById("audio_remote");
	/** ******SIP基本参数初始化开始*********** */
	// 给stack 赋值，因为 只有在onSipEventStack事件函数声明后面events_listener的listener才有值
	stackConfig = {
		enable_rtcweb_breaker : 'true',
		events_listener : {
			events : '*',
			listener : onSipEventStack
		},
		enable_early_ims : 'true',
		enable_media_stream_cache : "true",
		bandwidth : "{ audio:64, video:512 }",
		video_size : "{ minWidth: 640, minHeight:480, maxWidth: 640, maxHeight:480 }",
		sip_headers : [ {
			name : 'User-Agent',
			value : 'IM-client/OMA1.0 sipML5-v1.2014.04.18'
		}, {
			name : 'Organization',
			value : 'wang liu studio'
		} ]
	};

	console.log("get term config......");
	//从系统获取动态数据
	var url = webRoot + "/user/term/config?termId=" + impi;
	$.get(url, function(data, status) {
		// debugger;
		if (status == 'success') {
			// debugger;
			var conf = eval(data);
			if (conf.length > 0) {
				impi = "" + conf[0].termId;
				pwd = conf[0].termPwd;
				domain = conf[0].domain;
				stackConfig.realm = conf[0].realm;
				stackConfig.impi = "" + conf[0].termId;
				stackConfig.impu = 'sip:' + impi + '@' + conf[0].domain;
				stackConfig.password = conf[0].termPwd;
				stackConfig.display_name = "" + conf[0].termId;// 'lzj',
				stackConfig.websocket_proxy_url = conf[0].websocket_proxy_url;
				stackConfig.outbound_proxy_url = conf[0].outbound_proxy_url;
				stackConfig.ice_servers = conf[0].ice_servers;
				// debugger;
			}
		}
	});
	/** ******SIP基本参数初始化结束*********** */

	readyTimer = setInterval(function() {
		if (document.readyState == "complete") {
			// debugger;
			clearInterval(readyTimer);
			console.log("页面加载完毕，初始化SIPml5!");
			initSIPml5();
		}
	}, 500);
};// end window.onload

// 初始化SIPML5
var initSIPml5 = function() {

	console.log("init SIPml5......");
	SIPml.init(postInit);
};// end initSIPml5

// 检查浏览器是否支持webrtc，并设置基本参数
var postInit = function() {

	console.log("check webrtc4all version");
	// debugger;
	// check webrtc4all version
	if (SIPml.isWebRtc4AllSupported() && SIPml.isWebRtc4AllPluginOutdated()) {
		if (confirm("Your WebRtc4all extension is outdated ("
				+ SIPml.getWebRtc4AllVersion()
				+ "). A new version with critical bug fix is available. Do you want to install it?\nIMPORTANT: You must restart your browser after the installation.")) {
			window.location = 'http://code.google.com/p/webrtc4all/downloads/list';
			return;
		}
	}

	// check for WebRTC support
	if (!SIPml.isWebRtcSupported()) {
		// is it chrome?
		if (SIPml.getNavigatorFriendlyName() == 'chrome') {
			if (confirm("You're using an old Chrome version or WebRTC is not enabled.\nDo you want to see how to enable WebRTC?")) {
				window.location = 'http://www.webrtc.org/running-the-demos';
			} else {
				window.location = "index.html";
			}
			return;
		}

		// for now the plugins (WebRTC4all only works on Windows)
		if (SIPml.getSystemFriendlyName() == 'windows') {
			// Internet explorer
			if (SIPml.getNavigatorFriendlyName() == 'ie') {
				// Check for IE version
				if (parseFloat(SIPml.getNavigatorVersion()) < 9.0) {
					if (confirm("You are using an old IE version. You need at least version 9. Would you like to update IE?")) {
						window.location = 'http://windows.microsoft.com/en-us/internet-explorer/products/ie/home';
					} else {
						window.location = "index.html";
					}
				}

				// check for WebRTC4all extension
				if (!SIPml.isWebRtc4AllSupported()) {
					if (confirm("webrtc4all extension is not installed. Do you want to install it?\nIMPORTANT: You must restart your browser after the installation.")) {
						window.location = 'http://code.google.com/p/webrtc4all/downloads/list';
					} else {
						// Must do nothing: give the user the chance to accept
						// the extension
						// window.location = "index.html";
					}
				}
				// break page loading ('window.location' won't stop JS
				// execution)
				if (!SIPml.isWebRtc4AllSupported()) {
					return;
				}
			} else if (SIPml.getNavigatorFriendlyName() == "safari"
					|| SIPml.getNavigatorFriendlyName() == "firefox"
					|| SIPml.getNavigatorFriendlyName() == "opera") {
				if (confirm("Your browser don't support WebRTC.\nDo you want to install WebRTC4all extension to enjoy audio/video calls?\nIMPORTANT: You must restart your browser after the installation.")) {
					window.location = 'http://code.google.com/p/webrtc4all/downloads/list';
				} else {
					window.location = "index.html";
				}
				return;
			}
		}
		// OSX, Unix, Android, iOS...
		else {
			if (confirm('WebRTC not supported on your browser.\nDo you want to download a WebRTC-capable browser?')) {
				window.location = 'https://www.google.com/intl/en/chrome/browser/';
			} else {
				window.location = "index.html";
			}
			return;
		}
	}

	// checks for WebSocket support
	if (!SIPml.isWebSocketSupported() && !SIPml.isWebRtc4AllSupported()) {
		if (confirm('Your browser don\'t support WebSockets.\nDo you want to download a WebSocket-capable browser?')) {
			window.location = 'https://www.google.com/intl/en/chrome/browser/';
		} else {
			window.location = "index.html";
		}
		return;
	}

	// displays must be per session
	// attachs video displays
	// debugger;
	if (SIPml.isWebRtc4AllSupported()) {
		viewVideoLocal = videoLocal;
		viewVideoRemote = videoRemote;
		WebRtc4all_SetDisplays(viewVideoLocal, viewVideoRemote); // FIXME:
		// move to
		// SIPml.*
		// API
	} else {
		viewVideoLocal = videoLocal;
		viewVideoRemote = videoRemote;
	}

	if (!SIPml.isWebRtc4AllSupported() && !SIPml.isWebRtcSupported()) {
		if (confirm('Your browser don\'t support WebRTC.\naudio/video calls will be disabled.\nDo you want to download a WebRTC-capable browser?')) {
			window.location = 'https://www.google.com/intl/en/chrome/browser/';
		}
	}
	// 各种检查结束

	// 设置基本参数
	console.log("浏览器检查完毕，设置基本参数。");
	oConfigCall = {
		audio_remote : audioRemote,
		video_local : viewVideoLocal,
		video_remote : viewVideoRemote,
		bandwidth : {
			audio : undefined,
			video : undefined
		},
		video_size : {
			minWidth : undefined,
			minHeight : undefined,
			maxWidth : undefined,
			maxHeight : undefined
		},
		events_listener : {
			events : '*',
			listener : onSipEventSession
		},
		sip_caps : [ {
			name : '+g.oma.sip-im'
		}, {
			name : '+sip.ice'
		}, {
			name : 'language',
			value : '\"en,fr\"'
		} ]
	};// end oConfigCall 赋值

	console.log("auto register server。");
	register();
};// end postInit

/** ******界面控制函数开始*********** */
// 执行注册
var register = function() {
	// enable notifications if not already done
	if (window.webkitNotifications
			&& window.webkitNotifications.checkPermission() != 0) {
		window.webkitNotifications.requestPermission();
	}
	// update debug level to be sure new values will be used if the user haven't
	// updated the page
	SIPml.setDebugLevel((window.localStorage && window.localStorage
			.getItem('org.doubango.expert.disable_debug') == "true") ? "error"
			: "info");

	console.log(stackConfig.impi + " is registering, server:"
			+ stackConfig.websocket_proxy_url + ",please wating......");
	// create SIP stack
	oSipStack = new SIPml.Stack(stackConfig);
	if (oSipStack.start() != 0) {
		console.log('<b>Failed to start the SIP stack</b>');
	}

};// end refister function

// 弹出呼叫窗口
var startCallWin = function() {
	$("#callModal").modal("show");
};// end startCallWin function

// 开始一个视频呼叫
var videoCall = function() {
	// mediaConstraints.video = true;
	$("#callModal").modal("hide");
	// debugger;
	startCall(calledNumber.value + "@" + domain, 'call-audiovideo');

};// end videoCall

// 开始一个音频呼叫
var audioCall = function() {
	// mediaConstraints.video = false;
	$("#callModal").modal("hide");
	// debugger;
	startCall(calledNumber.value + "@" + domain, 'call-audio');

};// end audioCall

// 接听呼叫
var Answer = function() {
	txtTishi.innerHTML = '正在接听中......';
	oSipSessionCall.accept(oConfigCall);
};
// 发起呼叫
var startCall = function(callee, s_type) {
	if (oSipSessionRegister != null) {

		// debugger;
		// create call session
		oSipSessionCall = oSipStack.newSession(s_type, oConfigCall);
		// make call
		if (oSipSessionCall.call(callee) != 0) {
			oSipSessionCall = null;
			txtTishi.innerHTML = '创建呼叫失败';
			btnCall.style.display="";
			btnHangUp.style.display="none";

		}
	} else {
		txtTishi.innerHTML = "对不起，您还没有注册，请先注册。";
	}
};
// 结束一个呼叫
var hangup = function() {
	if (oSipSessionCall) {

		oSipSessionCall.hangup({
			events_listener : {
				events : '*',
				listener : onSipEventSession
			}
		});
	}
};// end huangup

// 做被叫时，本机铃音，提示用户摘机
function startRingTone() {
	try {
		ringtone.play();
	} catch (e) {
	}
}
// 结束被叫振铃
function 放() {
	try {
		ringtone.pause();
	} catch (e) {
	}
}

// 主叫播出后，被叫回复180ring，本机开始播放回铃音
function startRingbackTone() {
	try {
		ringbacktone.play();
	} catch (e) {
	}
}

// 回铃音结束
function stopRingbackTone() {
	try {
		ringbacktone.pause();
	} catch (e) {
	}
}
//振铃音结束
function stopRingTone() {
    try { ringtone.pause(); }
    catch (e) { }
}

/** ******界面控制函数结束*********** */
/** ******界面事件开始*********** */
// 注册成功事件
var onRegister = function(evtType, desc) {
	btnRegister.style.display="none";
	btnCall.style.display="";

	if (evtType == "connecting")
		txtTishi.innerHTML = "正在连接中(" + desc + ")";
	else if (evtType == "connected")
		txtTishi.innerHTML = "注册成功(" + desc + ")";
	else
		txtTishi.innerHTML = evtType + ":" + desc;
};
// 挂机事件
var onTerminating = function(evtType, desc) {
	btnCall.style.display="";
	btnHangUp.style.display="none";
	// case 'terminating':
	// case 'terminated': {
	if (evtType == "terminating")
		txtTishi.innerHTML = '中断呼叫中...';
	else
		txtTishi.innerHTML = '呼叫已经中断';
};

// 注册失败事件
var onUnregister = function(evtType, desc) {
	btnRegister.style.display="";
	btnCall.style.display="none";
	if (evtType == "terminated")
		txtTishi.innerHTML = "服务终止(" + desc + ")";
	else if (evtType == "stopped")
		txtTishi.innerHTML = "WS服务器终止(" + desc + ")";
	else if (evtType == "failed_to_start")
		txtTishi.innerHTML = "WS服务器连接失败(" + desc + ")";
	else
		txtTishi.innerHTML = evtType + ":" + desc;
};
/** ******界面事件结束*********** */
/** ******SIP基本事件开始*********** */
// SIP堆栈事件
var onSipEventStack = function(e /* SIPml.Stack.Event */) {
	console.log('==stack event = ' + e.type);
	switch (e.type) {
	case 'started': {
		// catch exception for IE (DOM not ready)
		try {
			// LogIn (REGISTER) as soon as the stack finish starting
			// 这个是事件函数，this就是SIPstatck
			oSipSessionRegister = this.newSession('register', {
				expires : 200,
				events_listener : {
					events : '*',
					listener : onSipEventSession
				},
				sip_caps : [ {
					name : '+g.oma.sip-im',
					value : null
				}, {
					name : '+audio',
					value : null
				}, {
					name : 'language',
					value : '\"en,fr\"'
				} ]
			});
			oSipSessionRegister.register();
		} catch (e) {
			console.log(e);
		}
		break;
	}
	case 'stopping':
	case 'stopped':
	case 'failed_to_start':
	case 'failed_to_stop': {

		oSipSessionRegister = null;
		oSipSessionCall = null;
		onUnregister(e.type, e.description);

		// 停止回铃音和振铃音
		stopRingbackTone();
		stopRingTone();
		break;
	}
	case 'i_new_call': {
		if (oSipSessionCall) {
			e.newSession.hangup();
		} else {
			oSipSessionCall = e.newSession;
			// start listening for events
			oSipSessionCall.setConfiguration(oConfigCall);

			btnReject.style.display="";
			btnAnswer.style.display="";
			btnCall.style.display="none";
			btnHangUp.style.display="none";

			startRingTone();

			var sRemoteNumber = (oSipSessionCall.getRemoteFriendlyName() || 'unknown');
			txtTishi.innerHTML = "来电提醒，号码：" + sRemoteNumber + "";
			// showNotifICall(sRemoteNumber);
		}
		break;
	}
	case 'm_permission_requested': {
		break;
	}
	case 'm_permission_accepted':
	case 'm_permission_refused': {
		break;
	}
	case 'starting':
	default:
		break;
	}
};

// sip 呼叫事件
var onSipEventSession = function(e /* SIPml.Session.Event */) {
	console.log('==session event type= ' + e.type + ";desc=" + e.description);
	switch (e.type) {
	case 'connecting':
	case 'connected': {
		if (e.session == oSipSessionRegister) {
			// 注册阶段
			onRegister(e.type, e.description);
		} else if (e.session == oSipSessionCall) {
			{
				//debugger;
				btnCall.style.display="none";
				btnHangUp.style.display="";
				btnAnswer.style.display = "none";
				btnReject.style.display = "none";
				// 呼叫阶段
				// debugger;
				if (e.type == 'connected')// invite 200 OK
				{
					stopRingbackTone();
					stopRingTone();
					txtTishi.innerHTML = "对方已经摘机";
				} else {
					txtTishi.innerHTML = "呼叫中......";
				}
			}
		}
		break;
	}
	case 'terminating':
	case 'terminated': {
		if (e.session == oSipSessionRegister) {
			onUnregister(e.type, e.description);
			oSipSessionCall = null;
			oSipSessionRegister = null;
		} else if (e.session == oSipSessionCall) {
			// debugger;
			oSipSessionCall = null;
			onTerminating(e.type, e.description);
			stopRingbackTone();
			stopRingTone();
			btnAnswer.style.display="none";
			btnReject.style.display="none";
		}
		break;
	}
	case 'm_stream_video_local_added': {
		break;
	}
	case 'm_stream_video_local_removed': {
		break;
	}
	case 'm_stream_video_remote_added': {
		break;
	}
	case 'm_stream_video_remote_removed': {
		break;
	}
	case 'm_stream_audio_local_added':
	case 'm_stream_audio_local_removed':
	case 'm_stream_audio_remote_added':
	case 'm_stream_audio_remote_removed': {
		break;
	}

	case 'i_ect_new_call': {
		break;
	}
	case 'i_ao_request': {
		if (e.session == oSipSessionCall) {
			var iSipResponseCode = e.getSipResponseCode();
			if (iSipResponseCode == 180 || iSipResponseCode == 183) {
				startRingbackTone();
				txtTishi.innerHTML = '等待对方接听，远端振铃中，(' + iSipResponseCode + ")";
			}
		}
		break;
	}
	case 'm_early_media': {
		if (e.session == oSipSessionCall) {
			stopRingbackTone();
			stopRingTone();
			txt.innerHTML = '早期媒体启动';
		}
		break;
	}
	case 'm_local_hold_ok': {
		break;

	}
	case 'm_local_hold_nok': {
		break;

	}
	case 'm_local_resume_ok': {
		break;
	}
	case 'm_local_resume_nok': {
		break;

	}
	case 'm_remote_hold': {
		break;

	}
	case 'm_remote_resume': {
		break;

	}
	case 'o_ect_trying': {
		break;

	}
	case 'o_ect_accepted': {
		break;

	}
	case 'o_ect_completed':
	case 'i_ect_completed': {
		break;
	}
	case 'o_ect_failed':
	case 'i_ect_failed': {
		break;
	}
	case 'o_ect_notify':
	case 'i_ect_notify': {
		break;
	}
	case 'i_ect_requested': {
		break;
	}
	}// end switch
};
/** ******SIP基本事件结束*********** */
