<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function uploadFile()
{
	var frm = document.getElementById("frmSpecial");
	frm.action="${context}/special/upfile";
	frm.enctype="multipart/form-data";
	frm.submit();
}
function addNewPic()
{
	var new_pic = document.getElementById("new_smart_pic");
	if(new_pic.value == null || new_pic.value.length==0)
		{
		alert("请输入有效的图片地址。");
		return;
		}
	var frm = document.getElementById("frmSpecial");
	frm.action="${context}/special/addnewpic";
	frm.submit();
}
function saveKeys()
{
	var url = "${context}/drive/updateKey";
	txtResult.innerHTML = "正在上传中......";
	$.post(url, {
		id : keyId.value,
		keys : spec_key.value
	}, function(result, status) {

		if (status == 'success') {
			if (result.length > 0) {
				txtResult.innerHTML = "更新成功。";
				
			}
		} else {
			txtResult.innerHTML = "网络异常";
			return;
		}

	});
}
function inputKeyUp(specId)
{
	var keyCode = ('which' in event) ? event.which : event.keyCode;
    if(keyCode == 13)
    	saveKeys(specId);
}
function getKey(specId) {
	var url = "${context}/drive/getSpecKey?specId=" + specId;
	$.get(url, function(data, status) {
		if (status == 'success') {

			var obj = eval(data);
			if (obj.length > 0) {
				keyId.value = obj[0].id;
				spec_key.value = 
				 decodeURIComponent(obj[0].keywords);
			}
		}
	});
}
function delete_special(id, itemCode)
{
	
	var url = "${context}/special/deleteItem?id="+id+"&code=" + itemCode;
	$.get(url, function(data, status) {
		if (status == 'success') {
			if (data == 0 ) {
				alert("删除成功。");
				var tr_obj = document.getElementById("special_"+itemCode);
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
function move_up(id, itemCode)
{
	var url = "${context}/special/moveItem?id="+id+"&code=" + itemCode;
	$.get(url, function(data, status) {
		if (status == 'success') {
			if (data == 0 ) {
				//重新刷屏
				location.href="${context}/special/detail?id="+id;
			} else if (data == 1)
				alert("亲，已经到顶了！");
			else
				alert("请先登录。");
		}

		else
			alert("服务器未响应！");
	});
}
function state_special(id, itemCode, chkObj)
{
	var url = "${context}/special/stateItem?id="+id+"&code=" + itemCode+"&state="+chkObj.checked;
	$.get(url, function(data, status) {
		if (status == 'success') {
			if (data == 0 ) {
				alert("设置成功。");
				
				var td_obj = document.getElementById("td_special_"+itemCode);
				if (td_obj != null)
				{ 
					if(chkObj.checked)
						td_obj.style.display = "block";
					else
						td_obj.style.display = "none";
				}
				
			} else if (data == 1)
				alert("设置失败。");
			else
				alert("请先登录。");
		}

		else
			alert("服务器未响应！");
	});
	
}
function sel(img)
{
	
	//alert(img.getAttribute("img_id"));
	document.getElementById("new_smart_pic").value = img.src;
	img.style.border="2px solid red";
	
	var id=document.getElementById("last_sel_id").value;
	
	if(img.id == "img"+id)
	{
		return;	
	}
	//alert(id);
	//将原来的设置为未选中状态
	if(id.length != 0)
	{
		document.getElementById("img"+id).style.border="";
	}
	
	//alert(img.id.substr(3));
	document.getElementById("last_sel_id").value = img.id.substr(3);
	
}
function search(page)
{
	var sobj = document.getElementById("s");
	var url = "${context}/media/search?page="+page+"&t=title&s=" + sobj.value;//encodeURIComponent(sobj.value);
	//alert(url);
	$.get(url, function(data, status) {
		if (status == 'success') {
			
			data = eval(data);
			for(var i=0; i<8; i++)
			{
				document.getElementById("img_sel_"+i).style.display="none";
				//document.getElementById("pager").style.display="none";
			}
			//alert(data.length);
			for(var i=0; i<data.length; i++)
			{
				var imgObj = document.getElementById("img"+i);
				imgObj.src="${context}/"+data[i]['media_url'];
				imgObj.alt=decodeURIComponent(data[i]['originalFileName']);
				imgObj.title=decodeURIComponent(data[i]['originalFileName']);
				document.getElementById("txt"+i).innerText=decodeURIComponent(data[i]['title']);
				var div = document.getElementById("img_sel_"+i);
				div.style.display="";
				
				//div.className="span3";
				
				//imgObj.title=decodeURIComponent(data[i]['title']);
				imgObj.setAttribute("img_id", i);
			}
			if(data.length>0)
			{
				document.getElementById("pager").style.display="";
				if(page<0) page=0;
				document.getElementById("prevPage").href="javascript:search("+(page-1)+")";
				document.getElementById("nextPage").href="javascript:search("+(page+1)+")";
			}
			else
			{
				alert("没有找到相关数据。");	
			}
		}
		else
			alert("服务器未响应！");
	});
	
}

function preview(id)
{
	//alert(".${context}/show/spec?id="+id);
	var url = "${context}/show/spec?id="+id;
	window.location.href=url;
	//alert(window.location.href);
	
}

function AutoSave(textObj, hashCode)
{
	var id=document.getElementById("id").value;
	//alert(id);
	//"smart_text_${item.hashCode}
	var url = "${context}/special/autoSave";
	//alert(url);
	var textObj = document.getElementById("smart_text_"+hashCode);
	var text = encodeURIComponent(document.getElementById("smart_text_"+hashCode).value);//textObj.value);
	var title = encodeURIComponent(document.getElementById("smart_title_"+hashCode).value);
	var subhead = encodeURIComponent(document.getElementById("smart_subhead_"+hashCode).value);
	//alert(text);
	var postData = "id="+id+"&item="+textObj.id.substr(11)+"&text="+text+
	"&title="+title+"&subhead="+subhead;
	//alert(url+"######"+postData);
	$.post(url, postData, function(data, status) {
		if (status == 'success') {
			if(data != 0)
			{
				alert("自动保存失败，请选择点击保存信息按钮，以免信息丢失。");
			}
		}
		else
			alert("自动保存失败！");
	});
}
</script>
<style>
.float_up {
	min-width: 50px;
	position: absolute;
	z-index: 990;
	margin-left: 39px;
	background-color: white;
	border: 1px solid gray;
	margin-top: 15px;
	max-height: 80px;
}
</style>
<div class="row row-offcanvas row-offcanvas-right">
	<s:url var="save_special" value="/special/update/action" />
	<form id="frmSpecial" action="${save_special}" method="post"
		class="form-horizontal">
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<h3>专题资料编辑</h3>
				<input type="hidden" name="id" id="id" value="${id}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"></label>
			<div class="controls">
				<c:choose>
					<c:when test="${not empty msg}">
						<span class="label label-important">提示：</span>${msg}
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专题资料标题</label>
			<div class="controls">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="专题资料标题" value="${title}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">作者</label>
			<div class="controls">
				<input type="text" class="form-control" id="writer" name="writer"
					placeholder="作者名称" value="${writer}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文本对齐方式</label>
			<div class="controls">
				<select name="align">
					<option value="center"
						<c:if test="${align=='center'}">selected</c:if>>居中</option>
					<option value="left" <c:if test="${align=='left'}">selected</c:if>>左对齐</option>
					<option value="right"
						<c:if test="${align=='right'}">selected</c:if>>右对齐</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专题关键词</label>
			<div class="controls">
			<input type="hidden" id="keyId"/>
				<input type="text" class="form-control" id="spec_key"
					name="spec_key" placeholder="专题关键词" onblur="saveKeys(${id})"
					onkeyup="inputKeyUp(${id})" value="" /><br/>
					<span id="txtResult"></span>
				<script type="text/javascript">
					getKey(${id});
					</script>
			</div>
		</div>
		<div class="control-group">

			<table class="table">

				<c:forEach var="item" items="${content_list}" varStatus="state">
					<tr id="special_${item.hashCode}">
						<td class="float_up"
							<c:if test="${state.count==1 }">style="display:none;"</c:if>><c:choose>
								<c:when test="${state.index>1 }">
									<input type="button" value="上移"
										onclick="move_up(${id}, ${item.hashCode})"
										class="btn btn-info" />
									<br />
								</c:when>
							</c:choose> <c:choose>
								<c:when test="${state.index>0}">
									<input type="button" value="删除"
										onclick="delete_special(${id},${item.hashCode})"
										class="btn btn-danger" />
									<br />
									<div class="switch switch-large">
										<input type="checkbox"
											<c:choose><c:when test="${item.is_show==1}">checked</c:when></c:choose>
											onclick="state_special(${id}, ${item.hashCode},this)" />显示
									</div>
									<br />

								</c:when>
							</c:choose></td>
						<td <c:if test="${state.count==1 }">colspan="2"</c:if>
							id="td_special_${item.hashCode}"><c:if
								test="${not empty item.smart}">
								<img src="${item.smart}" style="max-width: 405px;" />
							</c:if> <br /> <input type="text" id="smart_title_${item.hashCode}"
							onblur="AutoSave(this, '${item.hashCode}');"
							placeholder="本图片说明的标题" value="${item.title }"
							style="width: 170px;" /> <input type="text"
							id="smart_subhead_${item.hashCode}"
							onblur="AutoSave(this, '${item.hashCode}');"
							placeholder="本图片说明的附属标题" value="${item.subhead }" /> <br /> <textarea
								placeholder="填写说明文字"
								style="width: 405px; height:80px;text-align: ${align};"
								onblur="AutoSave(this, '${item.hashCode}');"
								name="smart_text_${item.hashCode}"
								id="smart_text_${item.hashCode}">${item.smart_text}</textarea>
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td>文本标签用法：<br />1、预订标签：#C产品编号=产品名称#<br />2、景区详情链接标签：#J景区编号=景区名称#<br />3、专题链接：#Z专题编号=专题标题#<br />备注：上述标签中如不特别指定名称可以不输入，此时系统选择产品库中的名称，最简单的标签为标签类型字母加编号，形如#C94#或者#J65#
					</td>
				</tr>
				<tr>
					<td style="height: 60px;"></td>
					<td>
						<div class="btn-group">
							<button type="submit" class="btn btn-primary">保存信息</button>
							<button class="btn dropdown-toggle" data-toggle="dropdown">
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="${context}/show/spec?id=${id}">手机预览</a></li>
								<li><a href="${context}/custom/detail?id=${id}">PC预览</a></li>
							</ul>
						</div> <input type="text" class="search" id="s" name="s"
						placeholder="输入图片关键字" /><input type="hidden" id="last_sel_id" />
						<button type="button" class="btn" onclick="search(0)">查找图片</button>

						<p></p>

						<ul class="nav nav-tabs">
							<c:forEach var="i" begin="0" end="7" step="1">
								<li id="img_sel_${i}" style="display: none; text-align: center;">
									<div style="width: 80px;">
										<img src="" id="img${i}" style="width: 60px; height: 60px;"
											onclick="sel(this)" />
										<p id="txt${i}" style="text-align: center;"></p>
									</div>
								</li>
							</c:forEach>
						</ul> <!-- 
						<div class="row-fluid">
							<c:forEach var="i" begin="0" end="7" step="1">
								<div class="span8" id="img_sel_${i}"
									style="display: none; text-align: center; max-width: 80px;">
									<img src="" id="img${i}" style="width: 60px; height: 60px;"
										onclick="sel(this)" />
									<p id="txt${i}" style="text-align: center;"></p>
								</div>
							</c:forEach>

						</div>
						 --> <input type="hidden" value="" name="new_smart_pic"
						id="new_smart_pic" placeholder="请输入图片的链接地址" />
						<ul class="pager" style="text-align: left; display: none;"
							id="pager">

							<li><button class="btn btn-primary"
									onclick="javascript:addNewPic();">新增图片</button></li>
							<li><a id="prevPage" href="javascript:search(0)">前一页</a></li>
							<li><a id="nextPage" href="javascript:search(1)">后一页</a></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td style="height: 60px;"></td>
					<td></td>
				</tr>

			</table>

		</div>
		<div class="control-group">
			<label for="exampleInputEmail1" class="control-label"></label>
			<div class="controls"></div>
		</div>
	</form>
</div>
