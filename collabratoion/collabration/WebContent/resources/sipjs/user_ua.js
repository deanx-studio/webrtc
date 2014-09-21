//设置基本参数，包括用户名等
var options = {
	extraHeaders : ['Route: <sip:deanx.cn:5060;lr;sipml5-outbound;transport=udp>' ]
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

ua[0].on('connected', function() {
	console.log("--------1000 connected!!!!!!");
});

// 媒体获取成功
function getUserMediaSuccess(stream) {
	console.log('getUserMedia succeeded', stream);
	mediaStream = stream;

	ua.start();
	// debugger;
	console.log("call register.");
	
	 debugger;

	// Makes a call
	useSession( ua.invite(target, {
		extraHeaders : ['Route: <sip:deanx.cn:5060;lr;sipml5-outbound;transport=udp>' ],
		media : {
			stream : mediaStream,
			
			render : {
				remote : {
					video : document.getElementById('video_remote0')
				},
				local : {
					video : document.getElementById('video_local')
				}
			}
		}
	}));

}

// var startCall = document.getElementById('btnCall');
var startCall = function(tar) {
	target = tar;
	console.log("invoke call");
	if (mediaStream) {
		getUserMediaSuccess(mediaStream);
	} else {
		if (SIP.WebRTC.isSupported()) {
			SIP.WebRTC.getUserMedia(mediaConstraints, getUserMediaSuccess,
					getUserMediaFailure);
		}
	}
};
