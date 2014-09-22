<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url var="menuDelete" value="/menu/delete"></s:url>
<s:url var="deploy" value="/menu/deploy"></s:url>
<s:url var="clear" value="/menu/clear"></s:url>
<script type="text/javascript">
	//删除文章
	function delete_menu(id) {
		if(!confirm("确认删除吗？"))
			return;
		var url = "${menuDelete}?id=" + id;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0 || data == -1) {
					alert("删除成功。");
					var tr_obj = document.getElementById("menu_" + id);
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
	function deploy() {
		if (confirm("确认将现在配置菜单同步到微信号吗？")) {
			var url = "${deploy}";
			$.get(url, function(data, status) {
				if (status == 'success') {
					if (data == 0 ) {
						alert("同步成功。");
						var tr_obj = document.getElementById("menu_" + id);
						if (tr_obj != null)
							tr_obj.style.display = "none";

					} else if (data == -2)
						alert("生成菜单数据失败");
					else if (data == -3)
						alert("删除现有菜单失败");
					else 
						alert("数据有异常，请检查数据。错误编号:"+data);
				}

				else
					alert("服务器未响应！");
			});
		}

	}
	function clearMenu() {
		if (confirm("确认清除现有微信号的菜单吗？")) {
			var url = "${clear}";
			$.get(url, function(data, status) {
				
				if (status == 'success') {
					if (data == 0 || data == -1) {
						alert("清除成功。");
						var tr_obj = document.getElementById("menu_" + id);
						if (tr_obj != null)
							tr_obj.style.display = "none";

					} else if (data == 1)
						alert("清除失败。");
					else
						alert("请先登录。");
				}

				else
					alert("服务器未响应！");
			});
		}
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">
	<div class="col-xs-12 col-sm-9">
		<h2>菜单列表</h2>
		
	</div>
	<table class="table table-striped table-bordered">
		<tr>
			<th style="min-width:150px;">菜单信息</th>
			<th>微信事件名称/菜单响应地址</th>
			<th style="min-widht:40px;">操作</th>
		</tr>
		<c:forEach var="menus" items="${menus_list}">
			<tr id="menu_${menus.id}">
				<td><strong>上级菜单：</strong>&nbsp;${menus.parentName}<br/>
				<strong>菜单名称：</strong><span class="label label-success">${menus.menuName}</span><br/>
				<strong>菜单类型：</strong>&nbsp;${menus.menuTypeStr}</td>
				<td>${menus.menuValue}</td>
				<td><a href="javascript:delete_menu(${menus.id})"><span class="label label-important">删除</span></a>&nbsp;<a
					href="${context}/menu/update?id=${menus.id}"><span class="label label-success">详细</span></a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button type="button" class="btn btn-primary" onclick="deploy()">发布菜单到微信</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-warning" = onclick="clearMenu()">清除微信菜单</button>
	</div>
</div>