<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<video id="remoteVideo"></video>
<video id="localVideo" muted="muted"></video>
<button id="endCall">End Call</button>
<script src="${context}/resources/sipjs/sip-0.6.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	// main.js
	(function() {
		var session;

		var endButton = document.getElementById('endCall');
		endButton.addEventListener("click", function() {
			session.bye();
			alert("Call Ended");
		}, false);

		var config = {
			// EXAMPLE wsServers: "wss://my.websocketserver.com",
			wsServers : "ws://deanx.cn:8088/ws",
			uri : "sip:1001@deanx.cn",
			authorizationUser : "1001",
			password : "1001",
			// FILL IN THOSE VALUES ^

			userAgentString : 'SIP.js/0.5.0-devel BAREBONES DEMO',
			hackIpInContact : true,
			 
			traceSip : true,
			
		};
		//Creates the anonymous user agent so that you can make calls
		var userAgent = new SIP.UA(config);

		//here you determine whether the call has video and audio
		var options = {
			media : {
				constraints : {
					audio : true,
					video : false,
				},
				
				render : {
					remote : {
						video : document.getElementById('remoteVideo')
					},
					local : {
						video : document.getElementById('localVideo')
					}
				}
				
			}
		};
		//sip event
		userAgent.on('connected', function() {
			console.log("--------call connected!!!!!!");
		});
		userAgent.on('registered', function() {
			console.log("--------registered!!!!!!");
		});
		userAgent.on('unregistered', function() {
			console.log("--------had unregistered!!!!!!");
		});
		userAgent.on('invite', function(incomingSession) {
			console.log("recv invite.");
			session = incomingSession;
			session.accept({
				media : {
					render : {
						remote : {
							video : document.getElementById('remoteVideo')
						},
						local : {
							video : document.getElementById('localVideo')
						}
					}
				}
			});
		});
		//makes the call
		session = userAgent.invite('sip:9000@deanx.cn', options);
	})();
</script>
