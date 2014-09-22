<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
	function check() {
		var reg = new RegExp("^[0-9]*$");
		//alert(strlen($("#key_value")[0].value));
		if ($("#key_value")[0].value == ""
				|| !reg.test($("#key_value")[0].value)) {
			alert("请在专题目录编号框内输入数字。");
			$("#key_value")[0].focus();
			return false;
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
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="home" value="/home" />
	<s:url var="forget" value="/forget" />

	<s:url var="key_update" value="/event/article/update" />
	<form class="form-horizontal" role="form" action="${key_update}"
		method="post" onsubmit="return check()">
		<input type="hidden" value="${key.id}" name="id" id="id" />
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<h3>专题目录编辑</h3>
			</div>
			<c:if test="${not empty message }">
				<div class="alert">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>提示</strong>${message }
				</div>
			</c:if>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">专题目录编号</label>
			<div class="controls">
				<input type="text" class="form-control" id="key_value"
					name="key_value" value="${key.keyValue}" placeholder="专题目录编号" />
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">专题目录名称</label>
			<div class="controls">
				<input type="text" class="form-control" id="key_name"
					name="key_name" value="${key.keyName}" placeholder="键值名称" />
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">专题目录描述</label>
			<div class="controls">
				<textarea rows="8" cols="80" placeholder="图文正文描述" id="key_descript"
					class="form-control" name="key_descript">${key.keyDescript}</textarea>
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">修改</button>
			</div>
		</div>


	</form>
</div>