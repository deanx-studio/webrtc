<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url var="delete_news" value="/admin/article/delete"></s:url>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	function article_show(chkObj, newsId) {
		//alert(chkObj.checked +":"+newsId);
		var url = "./state?newsId=" + newsId + "&state=" + chkObj.checked;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0)
					alert("设置成功。");
				else if (data == 1)
					alert("设置失败。");
				else
					alert("请先登录。");
			}

			else
				alert("服务器未响应！");
		});
	}
	//删除文章
	function delete_news(newsId) {
		if(!confirm("确认删除该图文消息吗？"))
		{
			return;
		}
		var url = "${delete_news}?newsid=" + newsId;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0){
					var tr_obj = document.getElementById("news_id_"+newsId);
					if(tr_obj != null) tr_obj.style.display="none";
					alert("删除成功。");
				}
				else if (data == 1)
					alert("删除失败。");
				else
					alert("请先登录。");
			}

			else
				alert("服务器未响应！");
		});
	}
	
	function search() {
		var url = "${context}/admin/article/list?page=0&s="
				+ document.getElementById("search").value;
		//alert(url);
		location.href = url;
	}
</script>

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<h2>图文列表</h2>
		<div class="control-group">
			<input type="text" class="input-medium search-query"
				placeholder="输入关键字" id="search" value="${search}" />
			<button type="button" onclick="search()" class="btn">搜索</button>
		</div>
		<form style="border-top: 10px;">
			<div id="append_parent"></div>

			<table class="table table-striped table-bordered"
				style="max-width: 700px;">

				<tr>
					<th style="min-width: 120px;">图片</th>
					<th>图文信息</th>
					<!-- 
					<th width="4%">排序号</th>
					<th width="11%">标题</th>
					<th width="30%">链接</th>
					 -->

					<th style="width: 90px">图文说明</th>

				</tr>
				<c:choose>
					<c:when test="${fn:length(news_list)>0}">
						<c:forEach var="news" items="${news_list}">
							<tr id="news_id_${news.id}">
								<td class="altbg2"><input type="checkbox"
									onclick="article_show(this,${news.id})"
									<c:choose>
													<c:when test="${news.articleState==1}">
														 checked</c:when></c:choose> />显示&nbsp;
									<a
									href="${context}/admin/article/updateUI.do?news_id=${news.id}"
									class="text-info" role="button">详细</a>&nbsp;<a
									href="javascript:delete_news(${news.id});" class="text-info"
									role="button">删除</a><br /> <img src="${news.pic_url}"
									width="120px" /></td>
								<td class="altbg2"><br /> <strong>微信事件：</strong>&nbsp;${news.keyName}(${news.news_id})<br />
									<strong>排序编号：</strong>&nbsp;：${news.seq}<br /> <strong>消息标题：</strong>&nbsp;${news.title}<br />
									<strong>链接地址：</strong>&nbsp;<a href="${news.url}"
									title="${news.url}" target="_blank">${news.url}</a></td>
								<td class="altbg2">${news.description}</td>

							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3">没有找到相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</table>
			<div class="pagination ">
				<!-- text-center -->
				<ul>
					<c:if test="${prevpage>0}">
						<li><a
							href="${context}/admin/article/list.do?page=${prevPage}&s=${search}">上一页</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${pageNo}" step="1">
						<li><a
							href="${context}/admin/article/list.do?page=${i}&s=${search}">第${i}页</a></li>
					</c:forEach>
					<c:if test="${fn:length(news_list)>0}">
						<li><a
							href="${context}/admin/article/list.do?page=${nextPage}&s=${search}">下一页</a></li>
					</c:if>
				</ul>
			</div>

		</form>

	</div>
</div>
