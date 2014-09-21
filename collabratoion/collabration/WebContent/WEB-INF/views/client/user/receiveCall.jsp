<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<script src="${context}/resources/sipjs/sip-0.6.2.js"
	type="text/javascript"></script>
<video id="remoteVideo"></video>
<video id="localVideo" muted="muted"></video>
<button id="endCall">End Call</button>
<script src="sip-devel.min.js"></script>
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
				  wsServers: "ws://deanx.cn:8088/ws",
				  uri: "sip:1001@deanx.cn",
				  authorizationUser: "1001",
				  password: "1001",
				  // FILL IN THOSE VALUES ^

				  userAgentString: 'SIP.js/0.5.0-devel BAREBONES DEMO',
				  traceSip: true,
				  hackIpInContact:true
				};
		//Creates the anonymous user agent so that you can make calls
		var userAgent = new SIP.UA(config);

		//here you determine whether the call has video and audio
		var options = {
			media : {
				constraints : {
					audio : true,
					video : true
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
		//receive the call
		userAgent.on('invite', function (incomingSession) {
			console.log("recv invite.");
	        session = incomingSession;
	        session.accept({
	            media: {
	                render: {
	                    remote: {
	                        video: document.getElementById('remoteVideo')
	                    },
	                    local: {
	                        video: document.getElementById('localVideo')
	                    }
	                }
	            }
	        });
	    });
	})();
</script>
