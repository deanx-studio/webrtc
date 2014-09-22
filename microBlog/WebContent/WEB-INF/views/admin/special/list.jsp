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
	function delete_special(Id) {
		if (!confirm("确认删除该专题资料吗？")) {
			return;
		}
		var url = "./delete?id=" + Id;
		$.get(url, function(data, status) {
			if (status == 'success') {
				if (data == 0) {
					var tr_obj = document.getElementById("special_id_" + Id);
					if (tr_obj != null)
						tr_obj.style.display = "none";
					alert("删除成功。");
				} else if (data == 1)
					alert("删除失败。");
				else
					alert("请先登录。");
			}

			else
				alert("服务器未响应！");
		});
	}
	function search() {
		var url = "${context}/special/list?page=0&s="
				+ document.getElementById("search").value;
		//	alert(url);
		location.href = url;
	}
	function showKeyWin(specId, specName, specKey) {

		upSpecId.value = specId;
		inputSpecName.innerHTML = specName;
		var url = "${context}/drive/getSpecKey?specId=" + specId;
		$.get(url, function(data, status) {
			if (status == 'success') {

				var obj = eval(data);
				if (obj.length > 0) {
					keyId.value = obj[0].id;
					inputSpecKey.value = decodeURIComponent(obj[0].keywords);
					$("#editSpecKey").modal("show");
				} else
					alert("数据未能获取到请联系管理员。");
			} else
				alert("服务器未响应！");
		});

	}
	function getKey(specId) {
		var url = "${context}/drive/getSpecKey?specId=" + specId;
		$.get(url, function(data, status) {
			if (status == 'success') {

				var obj = eval(data);
				if (obj.length > 0) {
					document.getElementById("specKey_"+specId).innerHTML = 
					 decodeURIComponent(obj[0].keywords);
				}
			}
		});
	}
	function updateKeyBtnUp()
	{
		var keyCode = ('which' in event) ? event.which : event.keyCode;
	    if(keyCode == 13)
			updateSpecKey();
	}
	function updateSpecKey() {
		var url = "${context}/drive/updateKey";
		txtResult.innerHTML = "正在上传中......";
		$.post(url, {
			id : keyId.value,
			keys : inputSpecKey.value
		}, function(result, status) {

			if (status == 'success') {
				if (result.length > 0) {
					txtResult.innerHTML = "更新成功。";
					
					getKey(upSpecId.value);
				}
			} else {
				showPrompt("网络异常", false);
				return;
			}

		});
	}
</script>

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<h2>专题列表</h2>
		<div class="control-group">
			<input type="text" class="input-medium search-query"
				placeholder="输入关键字" id="search" value="${search}" />
			<button type="button" onclick="search()" class="btn">搜索</button>
			&nbsp;
			<button class="btn"
				onclick="javascript:location.href='${context}/special/add'">
				新增专题资料
				</buttton>
		</div>

		<form style="border-top: 10px;">
			<div id="append_parent"></div>

			<table class="table table-striped table-bordered"
				style="max-width: 600px;">

				<tr>
					<th>信息</th>
					<th style="max-width: 100px; width: 60px">操作</th>

				</tr>
				<c:choose>
					<c:when test="${fn:length(special_list)>0}">
						<c:forEach var="items" items="${special_list}">
							<tr id="special_id_${items.id}">
								<td class="altbg2"><strong>标题：</strong>&nbsp;${items.title}<br />
									<strong>作者：</strong>&nbsp;${items.specialWriter}<br /> <strong>创建时间：</strong>&nbsp;${items.specialMaketime}<br />
									<!-- <strong>专题编号：</strong>${items.id}<br/> --> <strong>关键词：</strong><span
									id="specKey_${items.id}"></span></td>

								<td class="altbg2"><a
									href="javascript:delete_special(${items.id});"
									class="text-info" role="button"><span
										class="label label-important">删除</span></a><br /> <a
									href="${context}/special/detail?id=${items.id}"
									class="text-info" role="button"><span
										class="label label-info">编辑</span></a><br /> <a
									href="${context}/show/spec?id=${items.id}" class="text-info"
									role="button"><span class="label label-info">预览</span></a> <br />

									<a href="javascript:showKeyWin(${items.id},'${items.title}');"
									class="text-info" role="button"><span
										class="label label-info">关键词</span></a></td>

							</tr>
							<script type="text/javascript">
							getKey(${items.id});
							</script>
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
						<li><a href="${context}/special/list?page=${prevPage}">上一页</a></li>
					</c:if>
					<c:forEach var="i" begin="0" end="${pageNo}" step="1">
						<li><a href="${context}/special/list?page=${i}">第${i+1}页</a></li>
					</c:forEach>
					<c:if test="${fn:length(special_list)>0}">
						<li><a href="${context}/special/list?page=${nextPage}">下一页</a></li>
					</c:if>
				</ul>
			</div>

		</form>

	</div>
</div>
<div class="modal hide fade" id="editSpecKey">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h3>专题关键词编辑</h3>
	</div>
	<div class="modal-body form-horizontal">
		<input type="hidden" id="keyId" /> <input type="hidden" id="upSpecId" />
		<div class="control-group">
			<label class="control-label">专题名称</label>
			<div class="controls">
				<span id="inputSpecName"></span>
			</div>
		</div>


		<div class="control-group">
			<label class="control-label">关键词设置</label>
			<div class="controls">
				<input type="text" onblur="updateSpecKey()"
					onkeyup="updateKeyBtnUp()" id="inputSpecKey" value="0"
					placeholder="专题关键词">
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<span class="text-left" id="txtResult"></span> <a
			href="javascript:updateSpecKey();" id="saveGroupBtn"
			class="btn btn-primary">保存</a>
	</div>
</div>