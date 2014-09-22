<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("keyId", request.getParameter("keyId"));
%>
<script type="text/javascript">
	function show_pic(pic_url_obj) {
		var img_obj = document.getElementById("news_img");
		img_obj.src = pic_url_obj.value;
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">

	<div>
		<h3></h3>
	</div>
	<s:url var="add_news" value="/admin/article/add/action.do" />
	<form action="${add_news}" method="post" class="form-horizontal">
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>新增图文消息</h3>
				<span class="label label-important">提示：</span>在增加新的图文消息前请确保已经设置了相关的微信事件，<a
					href="${context}/event/article/add">新建微信事件</a> <label></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图文消息标题</label>
			<div class="controls">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="图文标题" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">对应的微信事件</label>
			<div class="controls">
				<select name="news_id">
					<option value="-1">--微信事件选择--</option>
					<c:forEach var="key_list" items="${keys}">
						<c:choose>
							<c:when test="${key_list.key_value == keyId}">
								<option value="${key_list.key_value}" selected>${key_list.key_name}</option>
							</c:when>
							<c:otherwise>
								<option value="${key_list.key_value}">${key_list.key_name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select><br />每个单图文消息和多图文消息对应一个微信事件，单图文时，图文消息和微信事件是一一对应的，多图文消息时，多个图文消息对应一个微信事件，序号最大的为主题。
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">图文显示序号</label>
			<div class="controls">
				<input type="text" class="form-control" id="seq" name="seq"
					value="0" placeholder="图文序号" /><br />当多图文时，序号最大的将作为主题显示，即图文消息的第一条
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">图文正文</label>
			<div class="controls">
				<textarea rows="8" cols="80" placeholder="图文正文描述" id="description"
					class="form-control" name="description"></textarea>
				<br />当没有"图片链接地址"时作为文本显示
			</div>
		</div>

		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">图片预览</label>
			<div class="controls">
				<img src="" id="news_img" style="width: 128px;" />
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">图片链接地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="pic_url" name="pic_url"
					onblur="show_pic(this);" placeholder="图图片链接地址" /><br />请写入http开始的全地址
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">消息转向地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="url" name="url"
					placeholder="消息转向地址" /><br />客户点击此消息后的响应跳转地址
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">添加</button>
			</div>
		</div>
	</form>
</div>
