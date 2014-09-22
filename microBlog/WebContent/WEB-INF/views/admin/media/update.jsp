<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function check() {
		var tObj = document.getElementById("title");
		if (tObj.value == null || tObj.value.length == 0) {
			alert("请输入媒体标题");
			tObj.focus();
			return false;
		}
		return true;
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="update_media" value="/media/update/action" />
	<form action="${update_media}" method="post" class="form-horizontal"
		enctype="multipart/form-data" onsubmit="return check()">
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>媒体编辑</h3>
				<c:choose>
					<c:when test="${not empty msg}">
						<c:if test="${ret==0}">
							<span class="label label-important">提示:</span>&nbsp;${msg}</c:if>
						<c:if test="${ret!=0}">
							<span class="label label-warning">提示:</span>&nbsp;${msg}</c:if>
					</c:when>
				</c:choose>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">媒体资料标题</label>
			<div class="controls">
				<input type="hidden" id="id" name="id" value="${id}" /> <input
					type="text" class="form-control" id="title" name="title"
					placeholder="媒体资料标题" value="${title}" /> <br />标题为必填项。是对上传媒体文件的描述性文字
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间</label>
			<div class="controls">
				<p>${makeTime}</p>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">相关图片</label>
			<div class="controls">
				<img src="${context}/${img_url}" style="max-width:200px;" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">保存</button>
			</div>
		</div>
	</form>
</div>
