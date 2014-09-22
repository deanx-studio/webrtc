<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function check() {
		/*
		var tObj = document.getElementById("title");
		if (tObj.value == null || tObj.value.length == 0) {
			alert("请输入媒体标题");
			tObj.focus();
			return false;
		}
		*/
		return true;
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="add_media" value="/media/upload" />
	<form action="${add_media}" method="post" class="form-horizontal"
		enctype="multipart/form-data" onsubmit="return check()">
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>新增媒体</h3>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">媒体文件</label>
			<div class="controls">
				<input type="file" multiple="multiple" class="form-control" id="mediaFile"
					name="mediaFile" placeholder="上传" value="" /><br /> <span class="label label-info">重要提示：</span>&nbsp;可以一次选择多个图片上传
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">媒体资料标题</label>
			<div class="controls">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="媒体资料标题" value="${title}" /> <br />标题为必填项。是对上传媒体文件的描述性文字
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
