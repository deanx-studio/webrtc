<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function chg_menu_type(type_obj) {
		//alert(type_obj.value);
		var keyObj = document.getElementById("sel_menu_key");
		var urlObj = document.getElementById("sel_menu_url");
		if (type_obj.value == "click") {
			keyObj.style.display = "block";
			urlObj.style.display = "none";
		} else {
			urlObj.style.display = "block";
			keyObj.style.display = "none";
		}
	}
	function chg_level(level_obj) {
		var typeObj = document.getElementById("sel_menu_type");

		if (level_obj.value == "0") {
			typeObj.style.display = "block";
			$("#menu_str").text("一级菜单名称");
		} else {
			typeObj.style.display = "block";
			$("#menu_str").text("二级菜单名称");
		}
	}
	function create_key_mode(chkObj)
	{
		//默认是手动选择
		//alert(chkObj.checked);
		var menuKeyObj = document.getElementById("menu_key_sel");
		if(chkObj.checked)//选择手动选择
		{
			//显示专题目录选择器
			menuKeyObj.style.display="block";
			chkObj.value="1";
		}
		else//自动建立键值关联
		{
			menuKeyObj.style.display="none";
			chkObj.value="2";
		}
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">

	<div></div>
	<s:url var="add_menu" value="/menu/add/action" />
	<form class="form-horizontal" action="${add_menu}" method="post">
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<h3>新增菜单</h3>
			</div>
		</div>

		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">菜单级别</label>
			<input type="hidden" name="toUserName" value="${toUserName }"/>
			<div class="controls">
				<select name="parentId" onchange="javascript:chg_level(this);">
					<option value="0">一级菜单</option>
					<c:forEach var="parent_list" items="${parentIds}">
						<option value="${parent_list.id}">${parent_list.menuName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label" id="menu_str">一级菜单名称</label>
			<div class="controls">
				<input type="text" class="form-control" id="menuName"
					name="menuName" placeholder="菜单名称" /><br />菜单的显示名称
			</div>
		</div>
		<div class="control-group" id="sel_menu_type" style="display: block;">
			<label for="exampleInputEmail1" class="control-label">菜单类型</label>

			<div class="controls">
				<select name="menuType" onchange="javascript:chg_menu_type(this);">
					<option value="0">--菜单类型选择--</option>
					<option value="click">点击类型</option>
					<option value="view">视图类型</option>
				</select><br />点击类型：点击后系统发送图文消息到微信客户端，客户点击后在转到指定的页面；视图类型：点击后直接跳转到指定的页面
			</div>
		</div>
		<div class="control-group" id="sel_menu_key" style="display: none;">
			<label for="exampleInputEmail1" class="control-label">菜单点击事件分类</label>
			<div class="controls">
				<input type="checkbox" onclick="create_key_mode(this);" name="createKeyMode" value="2"/>手动选择微信事件<br/>
				<select name="menuKey" id="menu_key_sel" style="display:none;">
					<option value="0">--菜单点击--</option>
					<c:forEach var="key_list" items="${keys}">
						<option value="${key_list.key_value}">${key_list.key_name}</option>
					</c:forEach>
				</select><br/>
				<span class="label label-important">提示：</span>在手动选择微信事件时，请确保已经建立了相关的图文消息。<a
					href="${context}/event/article/add">新建微信事件</a>
			</div>
		</div>
		<div class="control-group" id="sel_menu_url" style="display: none;">
			<label for="exampleInputEmail1" class="control-label">菜单响应URL地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="seq" name="menuUrl"
					placeholder="菜单视图地址" /><br />点击后直接转到该地址
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">添加</button>
				&nbsp;&nbsp;<a href="${context}/menu/list">菜单浏览</a>
			</div>
		</div>
	</form>
</div>
