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
		/*
		if (level_obj.value == "0")
			typeObj.style.display = "none";
		else
			typeObj.style.display = "block";
		 */
		typeObj.style.display = "block";
	}
</script>
<div class="row row-offcanvas row-offcanvas-right">

	<s:url var="update_menu" value="/menu/update/action" />
	<form class="form-horizontal" action="${update_menu}" method="post">
		<input type="hidden" name="id" value="${menu.id}" />
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<h3>菜单编辑</h3>
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">父菜单编号</label>
			<div class="controls">
			<input type="hidden" name="toUserName" value="${toUserName }"/>
				<select name="parentId" onchange="javascript:chg_level(this);">
					<option value="0">顶级菜单</option>
					<c:forEach var="parent_list" items="${parentIds}">
						<c:choose>
							<c:when test="${parent_list.id==menu.parentId }">
								<option value="${parent_list.id}" selected>${parent_list.menuName}</option>
							</c:when>
							<c:otherwise>
								<option value="${parent_list.id}">${parent_list.menuName}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label">菜单名称</label>
			<div class="controls">
				<input type="text" class="form-control" id="menuName"
					name="menuName" placeholder="菜单名称" value="${menu.menuName}" /><br />菜单的显示名称
			</div>
		</div>
		<div class="control-group" id="sel_menu_type"
			<c:choose>
						<c:when test="${menu.parentId == 0 }">style="display: block;"</c:when></c:choose>>
			<label for="exampleInputEmail1" class="control-label">菜单类型</label>

			<div class="controls">
				<select name="menuType" onchange="javascript:chg_menu_type(this);">
					<option value="0">--菜单类型选择--</option>
					<option value="click"
						<c:choose>
						<c:when test="${menu.menuType == 'click' }">selected
					</c:when>
					</c:choose>>点击类型</option>
					<option value="view"
						<c:choose>
						<c:when test="${menu.menuType == 'view' }">selected
					</c:when>
					</c:choose>>视图类型</option>
				</select><br />点击类型：点击后系统发送消息到微信客户；视图类型：点击后直接进入指定的页面
			</div>
		</div>
		<div class="control-group" id="sel_menu_key"
			<c:choose>
						<c:when test="${menu.menuType == 'view' }">style="display: none"
					</c:when></c:choose>>
			<label for="exampleInputEmail1" class="control-label">菜单点击编号</label>
			<div class="controls">

				<select name="menuKey">
					<option value="0">--菜单点击--</option>
					<c:forEach var="key_list" items="${keys}">
						<c:choose>
							<c:when test="${key_list.key_value == menu.menuKey }">
								<option value="${key_list.key_value}" selected>${key_list.key_name}</option>
							</c:when>
							<c:otherwise>
								<option value="${key_list.key_value}">${key_list.key_name}</option>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</select>
				<s:url var="add_message" value="/admin/article/add.do" />
				<s:url var="edit_message"
					value="/admin/article/update2?aid=" />&nbsp;
				<c:choose><c:when test="${msgId < 0}">
						<a href="${add_message}?keyId=${menu.menuKey}">建立新的图文消息</a>
					</c:when>
					<c:otherwise>
						<a href="${edit_message}${menu.menuKey}">编辑图文消息</a>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="control-group" id="sel_menu_url"
			<c:choose>
						<c:when test="${menu.menuType == 'click' }">style="display:none"
					</c:when></c:choose>>
			<label for="exampleInputEmail1" class="control-label">菜单视图地址</label>
			<div class="controls">
				<input type="text" class="form-control" id="seq" name="menuUrl"
					placeholder="菜单视图地址" value="${menu.menuUrl}" /><br />点击后直接转到该地址
			</div>
		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls">
				<button type="submit" class="btn btn-primary">修改</button>
			</div>
		</div>


	</form>
</div>
