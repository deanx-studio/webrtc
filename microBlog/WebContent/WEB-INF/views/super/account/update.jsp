<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources" />

<h4>微信资料编辑</h4>
<c:if test="${not empty message }">
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>提示</strong>${message }
	</div>
</c:if>
<form class="form-horizontal" method="post"
	action="${context }/super/weixin/edit">
	<div class="control-group">
		<label class="control-label">微信名称</label>
		<div class="controls">
		<input type="hidden" name="wid" value="${weixinObj.accountId }"/>
			<input type="text" id="wxName" placeholder="请输入微信名称" name="wxName" value="${weixinObj.wxName }">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">原始ID</label>
		<div class="controls">
			<input type="text" id="wxFromUserName" placeholder="请输入微信原始ID"
				name="wxFromUserName" value="${weixinObj.wxFromUserName }">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">微信号</label>
		<div class="controls">
			<input type="text" name="wxAccount" placeholder="请输入微信号" value="${weixinObj.wxAccount }" >
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">微信appId</label>
		<div class="controls">
			<input type="text" name="appId" placeholder="请输入微信号" value="${weixinObj.appId }" >
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">微信appSecret</label>
		<div class="controls">
			<input type="text" name="appSecret" placeholder="请输入微信号" value="${weixinObj.appSecret }" >
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">帐号类型</label>
		<div class="controls">
			<select name="wxType">
				<option value="0" <c:if test="${weixinObj.wxType==0 }">selected</c:if> >订阅号</option>
				<option value="1" <c:if test="${weixinObj.wxType==1 }">selected</c:if>>服务号</option>
			</select>
		</div>
	</div>


	<div class="control-group">
		<div class="controls">
			<button type="submit" class="btn">更新微信帐号</button>
		</div>
	</div>
</form>