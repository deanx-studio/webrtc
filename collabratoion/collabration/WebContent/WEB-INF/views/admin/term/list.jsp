<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="resource" value="/resources" />
<h4>终端管理</h4>
<div>

	<div class="alert alert-info fade in hide" id="tishi">
		<strong>批量操作提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
</div>
<table class="table table-striped">
	<tr>
		<th><input type="checkbox" onchange="sel_all(this);" /></th>
		<th>终端</th>
		<th>终端状态</th>
		<th>注册时间</th>
		<th>呼叫channel</th>
		<th>channel状态</th>
		<th>通话结束时间</th>
	</tr>
	<c:forEach var="items" items="${termList}" varStatus="status">
		<tr id="term_node_${items.id}">
			<td><input type="checkbox" name="term_sel"
				id="term_sel_${items.id }" /></td>

			<td id="peer_${items.id }">${items.peer }</td>
			<td id="peer_status_${items.id }"><c:choose>
					<c:when test="${items.peerStatus =='Unregistered' }">未注册</c:when>
					<c:otherwise>已注册</c:otherwise>
				</c:choose></td>
			<td id="last_register_time_${items.id }">${items.lastRegisterTime }</td>
			<td id="channel_${items.id }">${items.channel}</td>
			<td id="channel_state_${items.id }"><c:if
					test="${items.channelState == -3 }">未放号</c:if> <c:if
					test="${items.channelState == -2 }">未注册</c:if> <c:if
					test="${items.channelState == -1 }">已注册</c:if> <c:if
					test="${items.channelState >= 0 }">呼叫中</c:if></td>

			<td id="last_call_end_time_${items.id }">${items.lastCallEndTime }</td>

		</tr>
	</c:forEach>
	<tr>
		<td colspan="9"><button class="btn btn-small btn-primary"
				type="button" onclick="newTerm()">新建</button>&nbsp;&nbsp;
			<button class="btn btn-small btn-primary" type="button"
				onclick="startCall()">发起呼叫</button>&nbsp;&nbsp;
			<button class="btn btn-small btn-primary" type="button"
				onclick="huangup()">挂断</button></td>
	</tr>
</table>
<c:if test="${not empty termList}">
	<ul class="pager">
		<c:if test="${not empty prevPage}">
			<li><a href="${context}/term/list?pageNo=${prevPage}">上一页</a></li>
		</c:if>
		<li>第${pageNo+1}页</li>
		<c:if test="${not empty nextPage}">
			<li><a href="${context}/term/list?pageNo=${nextPage}">下一页</a></li>
		</c:if>
	</ul>
</c:if>

<!-- 消息提示框  -->
<div class="modal hide fade" id="editUserModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>用户编辑</h3>
	</div>
	<div class="modal-body form-horizontal">
		<input type="hidden" id="editUID" />
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
		<div id="pwdRegion">
			<div class="control-group">
				<label class="control-label">登录密码</label>
				<div class="controls">
					<input type="password" id="inputPasswd" value="" placeholder="登录密码">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">确认密码</label>
				<div class="controls">
					<input type="password" id="inputConfirmPwd" value=""
						placeholder="确认密码">
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:addUser();" id="newUserBtn" class="btn btn-primary">新增</a>
		<a href="javascript:updateUser();" id="saveUserBtn"
			class="btn btn-primary">保存</a>
	</div>
</div>
<script type="text/javascript">
	function deleteUser() {
		$("#tishi").show('fade');
		txtTishi.innerHTML = ">正在处理中......";
		var chks = document.getElementsByName("user_sel");
		for (var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				var uid = chks[i].id.substr(9);
				var url = "${context}/admin/user/delete?uid=" + uid;
				//alert(url);
				$.get(url, function(data, status) {
					if (status == 'success') {
						if (data == 0) {
							//alert("删除成功");
							var usrObj = document.getElementById("user_node_"
									+ uid);
							usrObj.style.display = "none";
							txtTishi.innerHTML = "用户id：" + uid + ",删除完毕。";
						} else
							txtTishi.innerHTML = "伤处失败，请检查数据！";
					} else
						txtTishi.innerHTML = "服务器访问失败，请稍后重试！";
				});
			}// end if
		}//end for

		setTimeout(function() {
			$(".alert").hide('fade');
			//alert("OK");
		}, 5000);
	}
	function sel_all(chk) {
		var chks = document.getElementsByName("user_sel");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}

	function updateUser() {
		//提交数据到服务器
		addUser();
		//更新页面显示
		var role = inputRole.options[inputRole.selectedIndex].value;
		var roleName = "管理员";
		if (role == "ROLE_CONDUCTER")
			roleName = "操作员";
		else if (role == "ROLE_USER")
			roleName = "用户";
		var uid = editUID.value;
		document.getElementById("role_" + uid).innerHTML = roleName;
		document.getElementById("uname_" + uid).innerHTML = inputUserName.value;
		document.getElementById("mobile_" + uid).innerHTML = inputMobile.value;
		document.getElementById("terminate_" + uid).innerHTML = inputTerminateNumber.value;

	}
	function addUser() {
		var role = inputRole.options[inputRole.selectedIndex].value;
		var url = "${context}/admin/user/edit";
		$.post(url, {
			username : inputUserName.value,
			userPwd : inputPasswd.value,
			mobile : inputMobile.value,
			terminateNumber : inputTerminateNumber.value,
			role : role
		}, function(result, status) {

			if (status == 'success') {
				if (result > 0) {

					txtResult.innerHTML = "操作成功";
					newUserBtn.style.display = "none";
					saveUserBtn.style.display = "";
				} else {
					txtResult.innerHTML = "操作失败，请确认已经登录，并拥有该权限。";
				}
			} else
				txtResult.innerHTML = "网络异常，或您无权访问。";

		});

	}
	//弹出密码重置矿口
	function chgPwd() {
		var uid = 0;
		var chks = document.getElementsByName("user_sel");
		for (var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				uid = chks[i].id.substr(9);//user_sel_7
				break;
			}
		}
		editUID.value = uid;
		//alert(uid);
		newUserBtn.style.display = "none";
		saveUserBtn.style.display = "";

		var role = document.getElementById("role_" + uid).innerHTML;

		//赋值
		for (i = 0; i < inputRole.options.length; i++) {
			if (inputRole.options[i].text == role) {
				inputRole.options[i].checked = true;
				break;
			}

		}
		inputUserName.value = document.getElementById("uname_" + uid).innerHTML;
		inputMobile.value = document.getElementById("mobile_" + uid).innerHTML;
		inputTerminateNumber.value = document
				.getElementById("terminate_" + uid).innerHTML;

		//隐藏密码输入
		inputConfirmPwd.value = "";
		inputPasswd.value = "";
		pwdRegion.style.display = "";
		userInfoRegion.style.display = "none";
		txtResult.innerHTML = "";
		$("#editUserModal").modal("show");
	}
	//点击弹出编辑框
	function editUser() {
		var uid = 0;
		var chks = document.getElementsByName("user_sel");
		for (var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				uid = chks[i].id.substr(9);//user_sel_7
				break;
			}
		}
		editUID.value = uid;
		//alert(uid);
		newUserBtn.style.display = "none";
		saveUserBtn.style.display = "";

		var role = document.getElementById("role_" + uid).innerHTML;

		//赋值
		for (i = 0; i < inputRole.options.length; i++) {
			if (inputRole.options[i].text == role) {
				inputRole.options[i].checked = true;
				break;
			}

		}
		inputUserName.value = document.getElementById("uname_" + uid).innerHTML;
		inputMobile.value = document.getElementById("mobile_" + uid).innerHTML;
		inputTerminateNumber.value = document
				.getElementById("terminate_" + uid).innerHTML;

		//隐藏密码输入
		inputConfirmPwd.value = "";
		inputPasswd.value = "";
		pwdRegion.style.display = "none";
		userInfoRegion.style.display = "";
		txtResult.innerHTML = "";
		$("#editUserModal").modal("show");
	}
	//点击新建按钮，弹出新建窗口
	function newUser() {
		newUserBtn.style.display = "";
		saveUserBtn.style.display = "none";

		inputUserName.value = "";
		inputMobile.value = "";
		inputTerminateNumber.value = "";
		inputConfirmPwd.value = "";
		inputPasswd.value = "";
		pwdRegion.style.display = "";
		userInfoRegion.style.display = "";
		txtResult.innerHTML = "";
		$("#editUserModal").modal("show");
	}

	
</script>