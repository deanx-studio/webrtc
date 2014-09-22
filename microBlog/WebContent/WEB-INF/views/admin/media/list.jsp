<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="delete_news" value="/admin/article/delete"></s:url>
<script type="text/javascript">
	function special_show(chkObj, Id) {
		//alert(chkObj.checked +":"+newsId);
		var url = "./state?id=" + Id + "&state=" + chkObj.checked;
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
	//删除专题
	function delete_media(Id) {
		if (!confirm("确认删除该媒体资料吗？")) {
			return;
		}
		var url = "./delete?id=" + Id;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0 || data == -1) {
					var tr_obj = document.getElementById("media_id_" + Id);
					//alert(tr_obj);
					if (tr_obj != null)
						tr_obj.style.display = "none";
					alert("删除成功。");
				} else
					alert("请先登录。");
			}

			else
				alert("服务器未响应！");
		});
	}

	function search() {
		var url = "${context}/media/list?page=0&t=&s="
				+ document.getElementById("search").value;
		//	alert(url);
		location.href = url;
	}
</script>

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<h2>图片列表</h2>
		<div class="control-group">
			<input type="text" class="input-medium search-query"
				placeholder="输入关键字" id="search" value="${search}" />
			<button type="button" onclick="search()" class="btn">搜索</button>
			&nbsp;&nbsp;
			<button class="btn"
				onclick="javascript:location.href='${context}/media/add'">新增图片资料</button>
		</div>

		<form style="border-top: 10px;">
			<div id="append_parent"></div>

			<table class="table table-striped table-bordered"
				style="max-width: 600px;">

				<tr>
					<th>图片</th>
					<th>信息</th>
				</tr>
				<c:choose>
					<c:when test="${fn:length(media_list)>0}">
						<c:forEach var="item" items="${media_list}">
							<tr id="media_id_${item.id}">
								<td style="width: 120px;"><img
									src="${context}/${item.media_url}" style="width: 100%;" /></td>
								<td class="altbg2"><a
									href="javascript:delete_media(${item.id});" class="text-info"
									role="button"><span class="label label-important">删除</span></a>
									<strong>标题：</strong>&nbsp;<a
									href="${context}/media/edit?id=${item.id}">${item.title}</a><br />
								</td>
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
			<div class="pagination">
				<ul>
					<c:if test="${prevPage>=0}">
						<li><a
							href="${context}/media/list?page=${prevPage}&s=${search}&t=">上一页</a></li>
					</c:if>
					<c:forEach var="i" begin="0" end="${pageNo}" step="1">
						<li><a
							href="${context}/media/list?page=${i}&s=${search}&t=">第${i+1}页</a></li>
					</c:forEach>
					<c:if test="${fn:length(media_list)>0}">
						<li><a
							href="${context}/media/list?page=${nextPage}&s=${search}&t=">下一页</a></li>
					</c:if>
				</ul>
			</div>

		</form>

	</div>
</div>
