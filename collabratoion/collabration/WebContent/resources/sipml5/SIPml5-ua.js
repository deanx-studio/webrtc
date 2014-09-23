//定义全局变量
var oSipStack;
var oConfigCall;
var viewVideoLocal, viewVideoRemote;
var videoRemote, videoLocal, audioRemote;
var stackConfig;
var oSipSessionRegister;
var oSipSessionCall;

// 等待页面加载完毕
window.onload = function() {
	videoLocal = document.getElementById("video_local");
	videoRemote = document.getElementById("video_remote");
	audioRemote = document.getElementById("audio_remote");

	readyTimer = setInterval(function() {
		if (document.readyState == "complete") {
			// debugger;
			clearInterval(readyTimer);
			console.log("页面加载完毕，初始化SIPml5!");
			initSIPml5();
		}
	}, 500);
};

// 初始化SIPML5
var initSIPml5 = function() {

	console.log("init SIPml5......");
	SIPml.init(postInit);
};

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
	if (SIPml.isWebRtc4AllSupported()) {
		viewVideoLocal = document.getElementById("divVideoLocal");
		viewVideoRemote = document.getElementById("divVideoRemote");
		WebRtc4all_SetDisplays(viewVideoLocal, viewVideoRemote); // FIXME:
		// move to
		// SIPml.*
		// API
	} else {
		viewVideoLocal = videoRemote;
		viewVideoRemote = videoLocal;
	}

	if (!SIPml.isWebRtc4AllSupported() && !SIPml.isWebRtcSupported()) {
		if (confirm('Your browser don\'t support WebRTC.\naudio/video calls will be disabled.\nDo you want to download a WebRTC-capable browser?')) {
			window.location = 'https://www.google.com/intl/en/chrome/browser/';
		}
	}

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
	};

};

// 注册
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

	// create SIP stack
	oSipStack = new SIPml.Stack(stackConfig);
	if (oSipStack.start() != 0) {
		console.log('<b>Failed to start the SIP stack</b>');
	}

};

var onRegister = function(evtType, desc) {
	btnRegister.disabled = true;
	btnCall.disabled = false;
	if (evtType == "connecting")
		txtTishi.innerHTML = "正在连接中(" + desc + ")";
	else if (evtType == "connected")
		txtTishi.innerHTML = "注册成功(" + desc + ")";
	else
		txtTishi.innerHTML = evtType + ":" + desc;
};

var onUnregister = function(evtType, desc) {
	btnRegister.disabled = false;
	btnCall.disabled = true;
	if (evtType == "terminated")
		txtTishi.innerHTML = "服务终止("+desc+")";
	else if (evtType == "stopped")
		txtTishi.innerHTML = "webrtc服务器终止("+desc+")";
	else
		txtTishi.innerHTML = evtType + ":" + desc;
};

// SIP事件
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
		break;
	}
	case 'i_new_call': {
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
var onSipEventSession = function(e /* SIPml.Session.Event */) {
	console.log('==session event type= ' + e.type + ";desc=" + e.description);
	switch (e.type) {
	case 'connecting':
	case 'connected': {
		if (e.session == oSipSessionRegister) {
			// 注册阶段
			onRegister(e.type, e.description);
		} else {
			// 呼叫阶段
		}
		break;
	}
	case 'terminating':
	case 'terminated': {
		if (e.session == oSipSessionRegister) {
			onUnregister(e.type, e.description);
			oSipSessionCall = null;
			oSipSessionRegister = null;
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
		break;
	}
	case 'm_early_media': {
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

// 给stack 赋值，因为 只有在onSipEventStack事件函数声明后面events_listener的listener才有值
stackConfig = {
	realm : 'asterisk',
	impi : '2001',
	impu : 'sip:2001@rectest',
	password : '2001',
	display_name : 'lzj',
	websocket_proxy_url : 'ws://rtctest:10060',
	outbound_proxy_url : 'udp://rtctest:5060',
	ice_servers : "[{ url: 'stun:stun.l.google.com:19302'}, { url:'turn:user@numb.viagenie.ca', credential:'myPassword'}]",
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