<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url var="keyDelete" value="/event/article/delete"></s:url>
<script type="text/javascript">
	//删除键值
	function delete_key(id) {

		var url = "${keyDelete}?id=" + id;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0 || data == -1) {
					alert("删除成功。");
					var tr_obj = document.getElementById("keys_" + id);
					if (tr_obj != null)
						tr_obj.style.display = "none";

				} else if (data == 1)
					alert("删除失败。");
				else
					alert("请先登录。");
			}

			else
				alert("服务器未响应！");
		});
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-12 col-sm-9">
		<h2>微信事件定义列表</h2>
		<input type="radio" name="optionsRadios" id="optionsRadios1" value="系统事件" onclick="javascript:location.href='${context}/event/article/keys?et=0'" checked>系统事件
		<input type="radio" name="optionsRadios" id="optionsRadios1" value="菜单事件" onclick="javascript:location.href='${context}/event/article/keys?et=1'" <c:if test="${et==1}">checked</c:if>>菜单事件<button class="btn"
			onclick="javascript:location.href='${context}/event/article/add'">新增事件定义</button>
	</div>
	<table class="table table-striped table-bordered">
		<tr>
			<th style="min-width: 120px;">微信事件定义信息</th>


			<th style="min-width: 40px;">操作</th>
		</tr>
		<c:forEach var="keys" items="${keys_list}">
			<tr id="keys_${keys.id}">
				<td><strong>编号：</strong>&nbsp;${keys.key_value}<br /> <strong>名称：</strong>&nbsp;${keys.key_name}<br />
					<strong>事件定义描述：</strong>${keys.key_descript}</td>
				<td><a href="javascript:delete_key(${keys.id})"><span
						class="label label-important">删除</span></a><br/><a
					href="${context}/event/article/detail?keyid=${keys.id}"><span
						class="label label-success">详细</span></a></td>
			</tr>
		</c:forEach>
	</table>
</div>