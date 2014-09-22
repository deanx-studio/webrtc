<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:url var="keyExist" value="/event/article/keyexist"></s:url>
<script type="text/javascript">
	function check() {
		var reg = new RegExp("^[0-9]*$");

		if ($("#key_value")[0].value == ""
				|| !reg.test($("#key_value")[0].value)) {
			alert("请在键值编号框内输入数字。");
			$("#key_value")[0].focus();
			return false;
		}

		if (parseInt($("#key_value")[0].value) < 100) {
			if (!confirm("当前为系统专题目录，确认新增吗？")) {
				return false;
			}

		}

		if ($("#key_name")[0].value == "") {
			alert("请输入专题目录的标题。");
			$("#key_name")[0].focus();
			return false;
		}
		if ($("#key_descript")[0].value == "") {
			alert("请输入专题目录的描述。");
			$("#key_descript")[0].focus();
			return false;
		}
		return true;
	}
	function key_exist() {
		var keyIdObj = document.getElementById("key_value");
		var url = "${keyExist}?keyValue=" + keyIdObj.value;
		//alert(url);
		var result = true;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0) {

					alert("编号重复，请修改。");
					keyIdObj.focus();
				}
			}
		});

	}
</script>

<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="home" value="/home" />
	<s:url var="forget" value="/forget" />

	<s:url var="key_add" value="/event/article/addNew" />
	<form class="form-horizontal" role="form" action="${key_add}"
		method="post" onsubmit="return check()">
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<h3>新增专题目录</h3>
			</div>

		</div>
		<div class="control-group">
			<label class="control-label" for="exampleInputEmail1">专题目录编号</label>
			<div class="controls">
				<input type="text" class="form-control" id="key_value"
					name="key_value" value="" placeholder="专题目录编号"
					onblur="javascript:key_exist();" /><br />对应微信事件,菜单点击事件、关注事件、注销事件等<br/>
					特别事件代码：<br/>
					关注事件：1<br/>
					注销事件：2<br/>
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">专题目录名称</label>
			<div class="controls">
				<input type="text" class="form-control" id="key_name"
					name="key_name" value="" placeholder="专题目录名称" />
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">专题目录描述</label>
			<div class="controls">
				<textarea rows="8" cols="80" placeholder="专题目录描述" id="key_descript"
					class="form-control" name="key_descript"></textarea>
			</div>

		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">新增专题目录</button>
			</div>

		</div>


	</form>
</div>