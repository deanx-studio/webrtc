<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function check() {
		var tObj = document.getElementById("title");
		if (tObj.value == null || tObj.value.length == 0) {
			alert("请输入专题标题");
			tObj.focus();
			return false;
		}
		return true;
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="add_special" value="/special/add/action" />
	<form action="${add_special}" method="post" class="form-horizontal"
		onsubmit="return check()">
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>新增专题资料</h3>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专题资料标题</label>
			<div class="controls">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="专题资料标题" value="${title}" /> <br />标题为必填项。
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">作者/来源</label>
			<div class="controls">
				<input type="text" class="form-control" id="writer" name="writer"
					placeholder="作者名称" value="${writer}" /><br /> 此处可以不填写
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文字对齐方式</label>
			<div class="controls">
				<select name="align">
				<option value="center" selected>居中</option>
				<option value="left" >左对齐</option>
				<option value="right" >右对齐</option></select>

			</div>
		</div>
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
</div>
