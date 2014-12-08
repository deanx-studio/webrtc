<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script src="${context}/resources/sipml5/SIPml-api.class.js"
	type="text/javascript">
	
</script>
<!-- 获取用户身份 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal.username" />
</sec:authorize>
<c:forEach var="items" items="${params}" varStatus="status">
	<c:if test="${items.keyName=='domain'}">
		<s:url var="domain" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='websocket_proxy_url'}">
		<s:url var="websocket_proxy_url" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='outbound_proxy_url'}">
		<s:url var="outbound_proxy_url" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='ICE'}">
		<s:url var="ICE" value="${items.keyValue}" />
	</c:if>
	<c:if test="${items.keyName=='realm'}">
		<s:url var="realm" value="${items.keyValue}" />
	</c:if>
</c:forEach>
<div class="span12">
	<legend>WEB Socket参数设置</legend>
	<c:if test="${not empty message}">
		<div class="alert">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>提示!</strong>${message }
		</div>
	</c:if>
	<form class="form-horizontal" action="${context }/admin/param/websocket" method="post">

		<div class="control-group">
			<!-- private String domain;  -->
			<label class="control-label">SIP域(domain)</label>
			<div class="controls">
				<input type="text" name="domain" value="${domain }" placeholder="webrtc.deanx.cn">
				<span>SIP域(domain)</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String websocket_proxy_url;   -->
			<label class="control-label">websocket_proxy_url</label>
			<div class="controls">
				<input type="text" name="websocket_proxy_url"
					placeholder="ws://webrtc.vmeeting.cn:10060"  value="${websocket_proxy_url }"> <span>web socket服务器地址和端口号</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String outbound_proxy_url;  -->
			<label class="control-label">outbound_proxy_url</label>
			<div class="controls">
				<input type="text" name="outbound_proxy_url"
					placeholder="udp://webrtc.vmeeting.cn:5060" value="${outbound_proxy_url }"> <span>sip服务器地址和端口</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String ice_servers;   -->
			<label class="control-label">ICE服务器：</label>
			<div class="controls">
				<input type="text" name="ICE" value="${ICE }"
					placeholder="[{ url: 'stun:stun.l.google.com:19302'}, {
				url:'turn:user@numb.viagenie.ca', credential:'myPassword'}]">
				<span>穿越防火墙的ICE、STUN或者TURN服务器</span>
			</div>
		</div>

		<div class="control-group">
			<!-- private String realm;  -->
			<label class="control-label">realm</label>
			<div class="controls">
				<input type="text" name="realm" value="${realm }" placeholder="asterisk">
				<span>realm：sip领域名称</span>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">保存</button>
			</div>
		</div>
	</form>
</div>
<!--/span-->
