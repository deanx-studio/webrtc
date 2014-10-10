<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.conducterVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini.png");
	background-repeat: no-repeat;
	width: 248px;
	height: 198px;
}

.remoteVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini.png");
	background-repeat: no-repeat;
	width: 496px;
	height: 396px;
}

.operater {
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
}

.hiddenCheckBox {
	/* display: none;*/
	background: url(${context}/resources/image/CheckBox.gif) 0px -300px
		no-repeat;
	display: block;
	width: 16px;
	height: 16px;
	display: inline-block;
	vertical-align: top;
	margin-left: -80px;
}

.chkTerm {
	position: absolute;
	margin-left: -15px;
	margin-top: 5px;
}

.divTerm {
	min-height: 110px;
	max-width: 110px;
	width: 100px;
	cursor: pointer;
}
</style>
<h4>协同指挥操作台</h4>
<div>
	<div class="alert alert-info" id="tishi">
		<strong>温馨提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
</div>
<!-- 终端列表  -->
<div>
	<div class="modal-body" style="height: 350px;">
		<div class="row-fluid text-center" id="termList">
			<c:forEach var="term" items="${termList}" varStatus="status">
				<div class="span5 divTerm"
					style="<c:if test="${status.count==1}">margin-left: 25px;</c:if>"
					onclick="selPhone('${term.peer }')">
					<div id="border_${term.peer }"
						style="border: 2px <c:if test="${term.channelState==-2}">gray</c:if>
								<c:if test="${term.channelState==-1}">blue</c:if>
								<c:if test="${term.channelState>=0}">red</c:if> solid; border-radius: 10px;">
						<span class="hiddenCheckBox" id="span_${term.peer }"> <input
							name="termChk" type="checkbox" id="${term.peer }"
							style="display: none;" /></span> <img src=""
							onclick="sel_chk(this, '${term.peer }')" class="chkTerm" />
						<div class="mini-layout fluid">
							<div class="mini-layout-sidebar">
								<img src="/collabration/resources/img/phone_unregister.png"
									style="width: 40px; height: 40px;">
							</div>
							<div class="mini-layout-body">
								${term.peer }<br>状态：
								<c:if test="${term.channelState==-2}">未注册</c:if>
								<c:if test="${term.channelState==-1}">空闲</c:if>
								<c:if test="${term.channelState>=0}">忙</c:if>

							</div>
						</div>
					</div>
					<div style="height: 5px;"></div>
				</div>

			</c:forEach>


		</div>
	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:videoCall();" class="btn btn-primary">强插</a> <a
			href="javascript:videoCall();" class="btn btn-primary">强拆</a> <a
			href="javascript:videoCall();" class="btn btn-primary">代接</a> <a
			href="javascript:videoCall();" class="btn btn-primary">视频呼叫</a> <a
			href="javascript:audioCall();" class="btn btn-primary">音频呼叫</a>
	</div>
</div>
<!-- 消息提示框  -->
<div class="modal hide fade" id="callModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>终端选择</h3>
	</div>
	<div class="modal-body form-horizontal">
		<input type="text" id="termId" />
		<div id="userInfoRegion">
			<div class="control-group">
				<label class="control-label">登录帐号</label>
				<div class="controls">
					<input type="text" id="inputUserName" placeholder="登录帐号">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">账户角色</label>
				<div class="controls">
					<select id="inputRole">
						<option value="ROLE_ADMIN">管理员</option>
						<option value="ROLE_CONDUCTER">操作员</option>
						<option value="ROLE_USER">用户</option>
					</select>

				</div>
			</div>

			<div class="control-group">
				<label class="control-label">联系电话</label>
				<div class="controls">
					<input type="text" id="inputMobile" placeholder="联系电话">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">IP电话号码</label>
				<div class="controls">
					<input type="text" id="inputTerminateNumber" placeholder="IP电话">
				</div>
			</div>
		</div>

	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:addUser();" id="newUserBtn" class="btn btn-primary">视频</a>
		<a href="javascript:updateUser();" id="saveUserBtn"
			class="btn btn-primary">音频</a>
	</div>
</div>
<script type="text/javascript"
	src="${context }/resources/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	function selPhone(chkId) {
		var chkObj = document.getElementById(chkId);
		chkObj.checked = !chkObj.checked;
		var spanObj = document.getElementById("span_" + chkId);
		if (chkObj.checked) {
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -450px no-repeat";
		} else {
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
		}
	}
	function sel_chk(imgChkObj, chkId) {
		//	do
		//	imgChkObj.
	}
	function call(id) {
		termId.value = id;
		$("#callModal").modal("show");
	}

	function mouseout(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//alert("from:" + from.tagName + ";to:" + to.tagName);

		if (from.tagName == "DIV"
				|| (from.tagName == "VIDEO" && to.tagName == "VIDEO"))
			document.getElementById("op_" + id).style.display = "none";
	}
	function mouseover(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		document.getElementById("op_" + id).style.display = "";
	}

	
</script>