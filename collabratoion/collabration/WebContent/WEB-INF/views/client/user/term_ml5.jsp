<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="${context}/resources/sipml5/SIPml-api.js"
	type="text/javascript"></script>
<script src="${context}/resources/sipml5/sipcall.js"
	type="text/javascript"></script>
<!-- 获取用户身份 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>

<script type="text/javascript">
	function settingsSave() {
		var host = "192.168.1.200";
		window.localStorage.setItem('org.doubango.expert.disable_video',
				"false");
		window.localStorage.setItem(
				'org.doubango.expert.enable_rtcweb_breaker', "false");//cbRTCWebBreaker.checked ? "true" : "false");
		/*if (!txtWebsocketServerUrl.disabled) {
		    window.localStorage.setItem('org.doubango.expert.websocket_server_url', txtWebsocketServerUrl.value);
		}*/
		window.localStorage.setItem('org.doubango.expert.websocket_server_url',
				"ws://" + host + ":8088/ws");
		window.localStorage.setItem(
				'org.doubango.expert.sip_outboundproxy_url', "udp://" + host
						+ ":5060");//txtSIPOutboundProxyUrl.value);
		window.localStorage.setItem('org.doubango.expert.ice_servers', "");//"[{ url: 'stun:stun.l.google.com:19302'}, { url:'turn:user@numb.viagenie.ca', credential:'myPassword'}]");//txtIceServers.value);
		window.localStorage.setItem('org.doubango.expert.bandwidth',
				"{ audio:64, video:512 }");//txtBandwidth.value);
		window.localStorage
				.setItem('org.doubango.expert.video_size',
						"{ minWidth: 640, minHeight:480, maxWidth: 640, maxHeight:480 }");//txtSizeVideo.value);
		window.localStorage.setItem('org.doubango.expert.disable_early_ims',
				"false");//cbEarlyIMS.checked ? "true" : "false");
		window.localStorage.setItem('org.doubango.expert.disable_debug',
				"false");//cbDebugMessages.checked ? "true" : "false");
		window.localStorage.setItem('org.doubango.expert.enable_media_caching',
				"false");//cbCacheMediaStream.checked ? "true" : "false");
		window.localStorage.setItem(
				'org.doubango.expert.disable_callbtn_options', "false");//cbCallButtonOptions.checked ? "true" : "false");

		window.console.info("save init data over!");
	}
	settingsSave();
</script>

<!-- Styles -->
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}

.navbar-inner-red {
	background-color: #600000;
	background-image: none;
	background-repeat: no-repeat;
	filter: none;
}

.full-screen {
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.normal-screen {
	position: relative;
}

.call-options {
	padding: 5px;
	background-color: #f0f0f0;
	border: 1px solid #eee;
	border: 1px solid rgba(0, 0, 0, 0.08);
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	-webkit-transition-property: opacity;
	-moz-transition-property: opacity;
	-o-transition-property: opacity;
	-webkit-transition-duration: 2s;
	-moz-transition-duration: 2s;
	-o-transition-duration: 2s;
}

.tab-video,.div-video {
	width: 100%;
	height: 0px;
	-webkit-transition-property: height;
	-moz-transition-property: height;
	-o-transition-property: height;
	-webkit-transition-duration: 2s;
	-moz-transition-duration: 2s;
	-o-transition-duration: 2s;
}

.label-align {
	display: block;
	padding-left: 15px;
	text-indent: -15px;
}

.input-align {
	width: 13px;
	height: 13px;
	padding: 0;
	margin: 0;
	vertical-align: bottom;
	position: relative;
	top: -1px;
	*overflow: hidden;
}

.glass-panel {
	z-index: 99;
	position: fixed;
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	top: 0;
	left: 0;
	opacity: 0.8;
	background-color: Gray;
}

.div-keypad {
	z-index: 100;
	position: fixed;
	-moz-transition-property: left top;
	-o-transition-property: left top;
	-webkit-transition-duration: 2s;
	-moz-transition-duration: 2s;
	-o-transition-duration: 2s;
}
</style>

<input type="hidden" id="txtDisplayName" value="${displayName }" />
<input type="hidden" id="txtPrivateIdentity" value="${privateIdentity }" />
<input type="hidden" id="txtPublicIdentity" value="${publicIdentity}" />
<input type="hidden" id="txtPassword" value="${passwd}" />
<input type="hidden" id="txtRealm" value="${realm }" />

<div id="divCallCtrl" class="well"
	style='display: table-cell; vertical-align: middle'>


	<table style='width: 330px;'>
		<tr>
			<td id="tdVideo" class='tab-video'>
				<div id="divVideo" class='normal-screen'>
					<div id="divVideoRemote"
						style='border: 1px solid #000; height: 200px; width: 100%;'>
						<video class="video" width="100%" height="100%" id="video_remote"
							autoplay="autoplay"
							style="opacity: 0; background-color: #000000; -webkit-transition-property: opacity; -webkit-transition-duration: 2s;">
						</video>
					</div>
					<div id="divVideoLocal" style='border: 0px solid #000'>
						<video class="video" width="88px" height="72px" id="video_local"
							autoplay="autoplay" muted="true"
							style="opacity: 0; margin-top: -80px; margin-left: 5px; background-color: #000000; -webkit-transition-property: opacity; -webkit-transition-duration: 2s;">
						</video>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td style="white-space: nowrap;"><input type="text"
				style="width: 100%; height: 100%" id="txtPhoneNumber" value=""
				placeholder="Enter phone number to call" /></td>
		</tr>

		<tr>
			<td colspan="1" align="left">
				<div class="btn-toolbar" style="margin: 0; vertical-align: middle">
					<input type="button" class="btn btn-success" id="btnRegister"
						value="LogIn" disabled onclick='sipRegister();' /> &nbsp; <input
						type="button" class="btn btn-danger" id="btnUnRegister"
						value="LogOut" disabled onclick='sipUnRegister();' />
					<div id="divBtnCallGroup" class="btn-group dropup">
						<button id="btnCall" disabled class="btn btn-primary"
							data-toggle="dropdown">Call</button>
					</div>
					&nbsp;&nbsp;
					<div class="btn-group">
						<input type="button" id="btnHangUp"
							style="margin: 0; vertical-align: middle; height: 100%;"
							class="btn btn-primary" value="HangUp" onclick='sipHangUp();'
							disabled />
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td><label style="width: 100%;" align="center" id="txtRegStatus">
			</label> <label style="width: 100%;" align="center" id="txtCallStatus">
			</label></td>
		</tr>
		<!-- 
				<tr>
					<td align='center'>
						<div id='divCallOptions' class='call-options'
							style='opacity: 0; margin-top: 3px'>
							<input type="button" class="btn" style="" id="btnFullScreen"
								value="FullScreen" disabled onclick='toggleFullScreen();' />
							&nbsp; <input type="button" class="btn" style=""
								id="btnHoldResume" value="Hold" onclick='sipToggleHoldResume();' />
							&nbsp; <input type="button" class="btn" style="" id="btnTransfer"
								value="Transfer" onclick='sipTransfer();' /> &nbsp; <input
								type="button" class="btn" style="" id="btnKeyPad" value="KeyPad"
								onclick='openKeyPad();' />
						</div>
					</td>
				</tr>
				 -->
	</table>


	<br />
	<footer>

		<!-- Creates all ATL/COM objects right now 
                Will open confirmation dialogs if not already done
            -->
		<object id="fakeVideoDisplay"
			classid="clsid:5C2C407B-09D9-449B-BB83-C39B7802A684"
			style="visibility: hidden;"> </object>
		<object id="fakeLooper"
			classid="clsid:7082C446-54A8-4280-A18D-54143846211A"
			style="visibility: hidden;"> </object>
		<object id="fakeSessionDescription"
			classid="clsid:DBA9F8E2-F9FB-47CF-8797-986A69A1CA9C"
			style="visibility: hidden;"> </object>
		<object id="fakeNetTransport"
			classid="clsid:5A7D84EC-382C-4844-AB3A-9825DBE30DAE"
			style="visibility: hidden;"> </object>
		<object id="fakePeerConnection"
			classid="clsid:56D10AD3-8F52-4AA4-854B-41F4D6F9CEA3"
			style="visibility: hidden;"> </object>
		<!-- 
                NPAPI  browsers: Safari, Opera and Firefox
            -->
		<!--embed id="WebRtc4npapi" type="application/w4a" width='1' height='1' style='visibility:hidden;' /-->
	</footer>
</div>
<!-- /container -->

<!-- Glass Panel -->
<div id='divGlassPanel' class='glass-panel' style='visibility: hidden'></div>
<!-- KeyPad Div -->
<div id='divKeyPad' class='span2 well div-keypad'
	style="left: 0px; top: 0px; width: 250; height: 240; visibility: hidden">
	<table style="width: 100%; height: 100%">
		<tr>
			<td><input type="button" style="width: 33%" class="btn"
				value="1" onclick="sipSendDTMF('1');" /><input type="button"
				style="width: 33%" class="btn" value="2" onclick="sipSendDTMF('2');" /><input
				type="button" style="width: 33%" class="btn" value="3"
				onclick="sipSendDTMF('3');" /></td>
		</tr>
		<tr>
			<td><input type="button" style="width: 33%" class="btn"
				value="4" onclick="sipSendDTMF('4');" /><input type="button"
				style="width: 33%" class="btn" value="5" onclick="sipSendDTMF('5');" /><input
				type="button" style="width: 33%" class="btn" value="6"
				onclick="sipSendDTMF('6');" /></td>
		</tr>
		<tr>
			<td><input type="button" style="width: 33%" class="btn"
				value="7" onclick="sipSendDTMF('7');" /><input type="button"
				style="width: 33%" class="btn" value="8" onclick="sipSendDTMF('8');" /><input
				type="button" style="width: 33%" class="btn" value="9"
				onclick="sipSendDTMF('9');" /></td>
		</tr>
		<tr>
			<td><input type="button" style="width: 33%" class="btn"
				value="*" onclick="sipSendDTMF('*');" /><input type="button"
				style="width: 33%" class="btn" value="0" onclick="sipSendDTMF('0');" /><input
				type="button" style="width: 33%" class="btn" value="#"
				onclick="sipSendDTMF('#');" /></td>
		</tr>
		<tr>
			<td colspan=3><input type="button" style="width: 100%"
				class="btn btn-medium btn-danger" value="close"
				onclick="closeKeyPad();" /></td>
		</tr>
	</table>
</div>
<!-- Call button options -->
<ul id="ulCallOptions" class="dropdown-menu" style="visibility: visible">
	<li><a href="#" onclick='sipCall("call-audio");'>Audio</a></li>
	<li><a href="#" onclick='sipCall("call-audiovideo");'>Video</a></li>
	<li id='liScreenShare'><a href="#"
		onclick='sipCall("call-screenshare");'>Screen Share</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick='uiDisableCallOptions();'><b>Disable
				these options</b></a></li>
</ul>

<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- 
	<script type="text/javascript" src="./assets/js/jquery.js"></script>
	<script type="text/javascript"
		src="./assets/js/bootstrap-transition.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-alert.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-modal.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-dropdown.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-scrollspy.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-tab.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-tooltip.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-popover.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-button.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-collapse.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-carousel.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap-typeahead.js"></script>
 -->
<!-- Audios -->
<audio id="audio_remote" autoplay="autoplay" />
<audio id="ringtone" loop
	src="${context }/resources/sipml5/sounds/ringtone.wav" />
<audio id="ringbacktone" loop
	src="${context }/resources/sipml5/sounds/ringbacktone.wav" />
<audio id="dtmfTone" src="${context }/resources/sipml5/sounds/dtmf.wav" />

<!-- 
        Microsoft Internet Explorer extension
        For now we use msi installer as we don't have trusted certificate yet :(
    -->
<!--object id="webrtc4ieLooper" classid="clsid:7082C446-54A8-4280-A18D-54143846211A" CODEBASE="http://sipml5.org/deploy/webrtc4all.CAB"> </object-->

<!-- GOOGLE ANALYTICS -->
<script type="text/javascript">
	var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl."
			: "http://www.");
	document
			.write(unescape("%3Cscript src='"
					+ gaJsHost
					+ "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>

<script type="text/javascript">
	try {
		var pageTracker = _gat._getTracker("UA-6868621-19");
		pageTracker._trackPageview();
	} catch (err) {
	}

	
</script>