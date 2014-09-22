<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px; text-align: left;">
	<table class="table  table-striped">
	<!-- 
		<tr>
			<td colspan="4">
				
				<h3>关键词设置</h3> <select name="t">
					<option value="-1">搜索方式</option>
					<option value="0">手机号码</option>
					<option value="1">用户名</option>
			</select> <input name="context" type="text" class="input-medium search-query">
				<button type="submit" class="btn">搜索</button>
				
			</td>
		</tr>
		 -->
		<tr>
			<th></th>
			<th>页面名称</th>
			<th>关键词</th>
			<th>修改结果</th>
			<th>修改时间</th>
		</tr>
		<c:forEach var="items" items="${keysList}" varStatus="status">
			<tr>
				<td>${items.id}</td>
				<td><c:if test="${fn:length(items.pageUri)==0}">所有页面</c:if> <c:if
						test="${items.pageUri== 'order'}">订单页</c:if> <c:if
						test="${items.pageUri== 'book'}">经典线路页</c:if> <c:if
						test="${items.pageUri== 'list'}">即刻发团页</c:if> <c:if
						test="${items.pageUri== 'private'}">私人订制页</c:if> <c:if
						test="${items.pageUri== 'detail'}">车队介绍、自驾须知等页面</c:if></td>
				<td><input id="newkey_${items.id}" title="按回车键或者离开即保存"
					onkeyup="javascript:changed(event, ${items.id });" type="text"
					onblur="AutoSave(${items.id}, this)" style="width: 100%;"
					value="${items.keywords }" /></td>
				<td><span id="result_${items.id}">未修改</span></td>
				<td><span id="modifyTime_${items.id}">${items.modifyTime }</span></td>
			</tr>
		</c:forEach>

	</table>
</div>
<style>
.warning {
	color: gold;
}

.save_fail {
	color: red;
}

.save_succ {
	color: green;
}
</style>
<script type="text/javascript">
function changed(event, id)
{
	var keyCode = ('which' in event) ? event.which : event.keyCode;
    //alert ("The Unicode key code of the released key: " + keyCode);
    if(keyCode == 13)
    {
    	AutoSave(id, document.getElementById("newkey_"+id));
    	return;
    }
	var obj = document.getElementById("result_"+id);
	obj.className="warning";
	obj.innerHTML = "已经修改";
}
function AutoSave(id, inputObj)
{
	var url = "${context}/drive/updateKey";
	$.post(url, {
		id : id,
		keys : inputObj.value
	}, function(result, status) {
		var obj = document.getElementById("result_"+id);
		if (status == 'success') {
			if (result.length > 0 ) {
				
				obj.className="save_succ";
				obj.innerHTML = "保存成功";
				var mObj = document.getElementById("modifyTime_"+id);
				//alert(mObj);
				mObj.innerHTML = result;
			}  else {
				obj.className="save_fail";
				obj.innerHTML = "保存失败";
			}
		}
		else
			{
			obj.style="color:red;";
			obj.innerHTML = "保存失败";
			}

	});
}
</script>