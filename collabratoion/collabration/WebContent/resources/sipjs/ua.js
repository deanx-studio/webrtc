//设置基本参数，包括用户名等
var options = {
	extraHeaders : [ 'X-Foo: foo', 'X-Bar: bar', 'wangyong:lzj',
			'Route: <sip:deanx.cn:5060;lr;sipml5-outbound;transport=udp>' ]
};

var config0 = {
	// EXAMPLE wsServers: "wss://my.websocketserver.com",
	wsServers : [ "ws://deanx.cn:10060" ],
	uri : "sip:1000@deanx.cn:5060",
	authorizationUser : "1000",
	password : "1000",
	// usePreloadedRoute: true,
	// registarServer:"sip:deanx.cn:5060",
	// FILL IN THOSE VALUES ^
	register : true,
	userAgentString : 'SIP.js/0.5.0-devel BAREBONES DEMO',
	// viaHost : ['115.28.86.18'],
	traceSip : true,
	hackIpInContact : true,
};

var config1 = {
	// EXAMPLE wsServers: "wss://my.websocketserver.com",
	wsServers : "ws://deanx.cn:8088/ws",
	uri : "sip:1001@deanx.cn",
	authorizationUser : "1001",
	password : "1001",
	// FILL IN THOSE VALUES ^

	userAgentString : 'SIP.js/0.5.0-devel BAREBONES DEMO',

	traceSip : true,
	hackIpInContact : true,
};

// Here you determine which media the stream has
var mediaConstraints = {
	audio : true,
	video : true
};

// 创建UA对象,并注册到域
var ua = [ 2 ];
ua[0] = new SIP.UA(config0);

// ua[0].on('connected', function() {
// console.log("--------1000 registerd!!!!!!");
//
// });

var clientCount = 2;
var target = [ 2 ];
// 'sip:bryan@wadearcade.onsip.com';
target[0] = 'sip:2000@deanx.cn';
target[1] = 'sip:9001@deanx.cn';
var mediaStream;
var session = [ clientCount ];

function sleep(sleepTime) {
	for (var start = Date.now(); Date.now() - start <= sleepTime;) {
	}
}

// 媒体获取失败
function getUserMediaFailure(e) {
	console.error('getUserMedia failed:', e);
}
function useSession(id, s) {
	session[id] = s;
	session[id].on('bye', function() {
		session[id] = null;
	});
}

ua[0].on('connected', function() {
	console.log("--------1000 connected!!!!!!");
	//
	/*
	 * debugger; ua[1] = new SIP.UA(config1); // sleep(200); //第一个连接成功之后发起第二个呼叫
	 * useSession(1, ua[1].invite(target[1], { media : { stream : mediaStream,
	 * render : { remote : { video : document.getElementById('video_remote1') },
	 * local : { video : document.getElementById('video_local') } } } }));
	 */

});

// 媒体获取成功
function getUserMediaSuccess(stream) {
	console.log('getUserMedia succeeded', stream);
	mediaStream = stream;

	ua[0].start();
	// debugger;
	console.log("call register.");
	ua[0].register(options);
	// debugger;

	// Makes a call
	useSession(0, ua[0].invite(target[0], {
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

	/*
	 * // 第二个呼叫 ua[1] = new SIP.UA(config1); // sleep(200); // 第一个连接成功之后发起第二个呼叫
	 * useSession(1, ua[1].invite(target[1], { media : { stream : mediaStream,
	 * render : { remote : { video : document.getElementById('video_remote1') },
	 * local : { video : document.getElementById('video_local') } } } }));
	 * 
	 */

	/*
	 * 不用注册被叫 // Picks up incoming calls ua.on('invite', function (s) {
	 * useSession(s); s.accept({ media: mediaStream }); });
	 */
}

// var startCall = document.getElementById('btnCall');
var startCall = function() {
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
