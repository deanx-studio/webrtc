<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function show_pic(pic_url_obj) {
		var img_obj = document.getElementById("news_img");
		img_obj.src = pic_url_obj.value;
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">

	<s:url var="update_news" value="/admin/article/update/action.do" />
	<s:url var="list_art" value="/admin/article/list.do"></s:url>
	<form action="${update_news}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${requestScope.news.id}" />
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>编辑图文消息</h3>
				<c:if test="${not empty message }">
					<div class="alert">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>提示</strong>${message }
					</div>
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图文标题</label>
			<div class="controls">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="图文标题" value="${requestScope.news.title}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微信事件</label>
			<div class="controls">
				<select name="news_id">
					<option value="-1">--微信事件--</option>
					<c:forEach var="key_list" items="${keys}">
						<c:choose>
							<c:when test="${key_list.key_value==requestScope.news.news_id}">
								<option value="${key_list.key_value}" selected>${key_list.key_name}</option>
							</c:when>
							<c:otherwise>
								<option value="${key_list.key_value}">${key_list.key_name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> <br />每个单图文消息和多图文消息对应一个微信事件，单图文时，图文消息和微信事件是一一对应的，多图文消息时，多个图文消息对应一个微信事件，序号最大的为主题。
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图文序号</label>
			<div class="controls">
				<input type="text" class="form-control" id="seq" name="seq"
					value="${requestScope.news.seq}" placeholder="图文序号" /><br />当多图文时，序号最大的将作为主题显示，即图文消息的第一条
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图文正文</label>
			<div class="controls">
				<textarea rows="8" cols="80" placeholder="图文正文描述" id="description"
					class="form-control" name="description">${requestScope.news.description}</textarea>
				<br />当没有"图片链接地址"时作为文本显示
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片预览</label>
			<div class="controls">
				<img src="${requestScope.news.pic_url}" id="news_img"
					style="width: 128px;" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片链接地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="pic_url" name="pic_url"
					value="${requestScope.news.pic_url}" onblur="show_pic(this);"
					placeholder="图图片链接地址" /><br />请写入以http开始的全地址
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">消息响应地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="url" name="url"
					value="${requestScope.news.url}" placeholder="消息转向地址" /> <br />客户点击此消息后的响应跳转地址
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">修改</button>
				&nbsp;&nbsp; <a href="${list_art}" class="btn btn-info">返 回</a>
			</div>
		</div>
	</form>
</div>