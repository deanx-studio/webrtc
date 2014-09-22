<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="${context }/resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${context }/resources/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="${context }/resources/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="${context }/resources/custom/js/bootstrap-alert.js"
	charset="UTF-8"></script>

<div style="height: 00px;"></div>
<div class="container" style="max-width: 960px;">

	<style type="text/css">

/* Featurettes
    ------------------------- */
.featurette-divider {
	margin: 10px 0; /* Space out the Bootstrap <hr> more */
}

.featurette { //
	padding-top: 120px;
	/* Vertically center images part 1: add padding above and below text. */
	overflow: hidden;
	/* Vertically center images part 2: clear their floats. */
}

.featurette-image {
	margin-top: -10px;
	/* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
}

/* Give some space on the sides of the floated elements so text doesn't run right into it. */
.featurette-image.pull-left {
	margin-right: 40px;
}

.featurette-image.pull-right {
	margin-left: 40px;
}

/* Thin out the marketing headings */
.featurette-heading {
	font-size: 30px;
	font-weight: 300;
	line-height: 1;
	letter-spacing: -1px;
}

.lead {
	font-size: 16px;
}

.intro_text {
	
}
</style>

	<!-- START THE FEATURETTES -->
	<h2 id="title">团期设置</h2>
	<div class="alert alert-info fade in hide" id="tishi">
		<strong>批量操作提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
	<!-- 
	<input id="touchMove" value="" /> <input id="touchStart" value="" />
 -->

	<table class="table table-striped">
		<!-- 
		<tr>
			<td colspan="9"><select onchange="mark(this);">
					<option value="0">--批量操作--</option>
					<option value="1">标记已满</option>
					<option value="2">删除</option>
			</select></td>
		</tr>
		 -->
		<tr>
			<th><input type="checkbox" onchange="sel_all(this)" /></th>
			<th>团号</th>
			<th>团名称</th>
			<th>产品名称</th>
			<th>产品编号</th>
			<th>状态</th>
			<th>报名人数</th>
			<th>满团人数</th>
			<th>发团时间</th>

		</tr>
		<tr>
			<td colspan="9">
				<button class="btn btn-small btn-primary" type="button"
					onclick="newGroup()">新建</button>&nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="editGroup()">编辑</button> &nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="markFullGroup()">标记满团</button> &nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="deleteGroup()">删除</button>
			</td>
		</tr>
		<c:forEach var="items" items="${groupList}" varStatus="status">
			<tr id="item_${items.groupId}">
				<td><input type="checkbox" name="groupSel"
					id="gsel_${items.groupId}" /></td>
				<td>${items.groupId}</td>
				<td id="groupName_${items.groupId }">${items.groupName}</td>
				<td id="productName_${items.groupId }">${items.productName}</td>
				<td id="productId_${items.groupId }">${items.productId}</td>
				<td id="status_${items.groupId }"><c:choose>
						<c:when test="${items.bookCount==items.totalCount}">已满</c:when>
						<c:otherwise>可报名</c:otherwise>
					</c:choose></td>
				<td id="bookCount_${items.groupId }">${items.bookCount}</td>
				<td id="totalCount_${items.groupId }">${items.totalCount }</td>
				<td id="startDate_${items.groupId }">${items.startDate }</td>

			</tr>

		</c:forEach>
		<tr>
			<th><input type="checkbox" onchange="sel_all(this)" /></th>
			<th>团号</th>
			<th>团名称</th>
			<th>产品名称</th>
			<th>产品编号</th>
			<th>状态</th>
			<th>报名人数</th>
			<th>满团人数</th>
			<th>发团时间</th>

		</tr>
		<tr>
			<td colspan="9">
				<button class="btn btn-small btn-primary" type="button"
					onclick="newGroup()">新建</button>&nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="editGroup()">编辑</button> &nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="markFullGroup()">标记满团</button> &nbsp;&nbsp;
				<button class="btn btn-small btn-primary" type="button"
					onclick="deleteGroup()">删除</button>
			</td>
		</tr>
	</table>

	<div class="pagination">
		<ul>
			<c:if test="${prevPage>=0}">
				<li><a
					href="${context}/drive/group/set?page=${prevPage}&t=${stype }&context=${sText}">上一页</a></li>
			</c:if>
			<c:forEach var="i" begin="0" end="${pageNo}" step="1">
				<li><a
					href="${context}/drive/group/set?page=${i}&t=${stype }&context=${sText}">第${i+1}页</a></li>
			</c:forEach>
			<c:if test="${fn:length(special_list)>0}">
				<li><a
					href="${context}/drive/group/set?page=${nextPage}&t=${stype }&context=${sText}">下一页</a></li>
			</c:if>
		</ul>
	</div>

	<!-- 消息提示框  -->
	<div class="modal hide fade" id="editGroup">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>团期编辑</h3>
		</div>
		<div class="modal-body form-horizontal">
			<input type="hidden" id="groupId" />
			<div class="control-group">
				<label class="control-label">团期名称</label>
				<div class="controls">
					<input type="text" id="inputGroupName" placeholder="团期名称">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">产品选择</label>
				<div class="controls">
					<select id="inputProductId">
						<c:forEach var="items" items="${productList}" varStatus="status">
							<option value="${items.productID}">${items.name}</option>
						</c:forEach>

					</select>

				</div>
			</div>
			<div class="control-group">
				<label class="control-label">出发日期</label>

				<div class="controls date form_datetime">
					<span class="add-on"> <i class="icon-calendar"></i></span><input
						size="16" type="text" id="startDate" value="2014-07-25"
						name="startDate" class="input-medium" readonly
						style="background-color: white; cursor: pointer;">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">报名人数</label>
				<div class="controls">
					<input type="text" id="inputBookCount" value="0" placeholder="报名人数">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">满团人数</label>
				<div class="controls">
					<input type="text" id="inputTotalCount" value="14"
						placeholder="满团人数">
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<span class="text-left" id="txtResult"></span>
			<!-- 
			<a href="javascript:$('#editGroup').modal('hide');" class="btn">关闭</a>
			 -->
			<a href="javascript:addGroup();" id="newGroupBtn"
				class="btn btn-primary">新增</a> <a href="javascript:updateGroup();"
				id="saveGroupBtn" class="btn btn-primary">保存</a>
		</div>
	</div>

</div>
<script type="text/javascript">
	function markFullGroup() {
		showPrompt("标记满团请求处理中。。。。。。。", true);
		var url = "${context}/drive/group/markFull";
		var chks = document.getElementsByName("groupSel");
		for ( var i = 0; i < chks.length; i++) {

			if (chks[i].checked) {
				var gid = chks[i].id.substr(5);

				$
						.post(
								url,
								{
									GroupId : gid
								},
								function(result, status) {

									if (status == 'success') {
										//debugger;

										var obj = eval("[" + result + "]");
										if (obj[0].id > 0) {

											document
													.getElementById("bookCount_"
															+ obj[0].id).innerHTML = obj[0].bookCount;
											document.getElementById("status_"
													+ obj[0].id).innerHTML = "已满";
										}
									} else {

										showPrompt("网络异常", false);
										return;
									}

								});

			}

		}
		showPrompt("已经标记完毕。", false);
	}
	function CurentTime(span) {

		var now = new Date();
		now = now.valueOf();
		now = now + span * 24 * 60 * 60 * 1000;
		now = new Date(now);

		var year = now.getFullYear(); //年
		var month = now.getMonth() + 1; //月
		var day = now.getDate(); //日

		//  var hh = now.getHours();            //时
		//  var mm = now.getMinutes();          //分

		var clock = year + "-";

		if (month < 10)
			clock += "0";

		clock += month + "-";

		if (day < 10)
			clock += "0";

		clock += day;
		/*
		clock +=  " ";
		 if(hh < 10)
		     clock += "0";
		    
		 clock += hh + ":";
		 if (mm < 10) clock += '0'; 
		 clock += mm;
		 */
		return (clock);
	}
	function sel_all(chk) {
		var chks = document.getElementsByName("groupSel");
		for ( var i = 0; i < chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}
	function addGroup() {

		//alert(inputGroupId.selectedIndex);
		//alert(inputGroupId.options[inputGroupId.selectedIndex].value);
		var productId = inputProductId.options[inputProductId.selectedIndex].value;
		var productName = inputProductId.options[inputProductId.selectedIndex].text;

		var url = "${context}/drive/group/add";
		$.post(url, {
			groupId : groupId.value,
			GroupName : inputGroupName.value,
			productName : productName,
			startDate : startDate.value,
			ProductId : productId,
			BookCount : inputBookCount.value,
			TotalCount : inputTotalCount.value,
		}, function(result, status) {

			if (status == 'success') {
				if (result > 0) {
					groupId.value = result;
					txtResult.innerHTML = "新增成功";
					newGroupBtn.style.display = "none";
					saveGroupBtn.style.display = "";
				} else {
					txtResult.innerHTML = "新增失败：" + result;
				}
			} else
				txtResult.innerHTML = "网络异常，或您无权访问。";

		});

	}
	//保存用户修改的数据
	function updateGroup() {
		var productId = inputProductId.options[inputProductId.selectedIndex].value;
		var productName = inputProductId.options[inputProductId.selectedIndex].text;

		var url = "${context}/drive/group/update";
		//alert(inputBookCount.value);
		var gid = groupId.value;
		$.post(url, {
			GroupId : groupId.value,
			ProductId : productId,
			GroupName : inputGroupName.value,
			ProductName : productName,
			BookCount : inputBookCount.value,
			TotalCount : inputTotalCount.value,
			StartDate : startDate.value,
		}, function(result, status) {

			if (status == 'success') {
				if (result == 0) {

					txtResult.innerHTML = "更新成功";
					document.getElementById("groupName_" + gid).innerHTML = inputGroupName.value;
					document.getElementById("startDate_" + gid).innerHTML = startDate.value;
					document.getElementById("bookCount_" + gid).innerHTML = inputBookCount.value;
					document.getElementById("totalCount_" + gid).innerHTML = inputTotalCount.value;
					document.getElementById("status_" + gid).innerHTML = inputTotalCount.value>=inputBookCount.value?'已满':'可报名';

				} else {
					txtResult.innerHTML = "更新失败：" + result;
				}
			} else
				txtResult.innerHTML = "网络异常，或您无权访问。";

		});
	}
	//点击新建按钮，弹出新建窗口
	function newGroup() {
		newGroupBtn.style.display = "";
		saveGroupBtn.style.display = "none";
		groupId.value = "";
		inputGroupName.value = "";
		startDate.value = CurentTime(60);
		inputBookCount.value = "0";
		inputTotalCount.value = "14";
		$("#editGroup").modal("show");
	}
	//点击编辑按钮，弹出编辑窗口
	function editGroup() {
		var chks = document.getElementsByName("groupSel");
		var gid = 0;
		for ( var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				gid = chks[i].id.substr(5);
				break;
			}
		}
		//alert(gid);
		//设置按钮
		newGroupBtn.style.display = "none";
		saveGroupBtn.style.display = "";
		//设置现有属性

		groupId.value = gid;
		inputGroupName.value = document.getElementById("groupName_" + gid).innerHTML;
		startDate.value = document.getElementById("startDate_" + gid).innerHTML;
		inputBookCount.value = document.getElementById("bookCount_" + gid).innerHTML;
		inputTotalCount.value = document.getElementById("totalCount_" + gid).innerHTML;

		var productId = document.getElementById("productId_" + gid).innerHTML;
		//alert(startDate);
		for ( var i = 0; i < inputProductId.options.length; i++) {

			//	alert(inputProductId.options[i].value);
			if (inputProductId.options[i].value == productId) {
				inputProductId.options[i].selected = true;
				break;
			}
		}
		$("#editGroup").modal("show");
	}
	//删除标记的团
	function deleteGroup() {
		showPrompt("删除请求处理中。。。。。。。", true);
		var url = "${context}/drive/group/delete";
		var chks = document.getElementsByName("groupSel");
		for ( var i = 0; i < chks.length; i++) {

			if (chks[i].checked) {
				var gid = chks[i].id.substr(5);
				$
						.post(
								url,
								{
									GroupId : gid
								},
								function(result, status) {

									if (status == 'success') {
										if (result > 0) {
											document.getElementById("item_"
													+ result).style.display = "none";
										}
									} else {
										showPrompt("网络异常", false);
										return;
									}

								});

			}

		}
		showPrompt("已经删除完毕。", false);

	}

	function showPrompt(msg, isShow) {
		txtTishi.innerHTML = msg;
		if (isShow) {
			$("#tishi").show('fade');
		} else {

			setTimeout(function() {
				$(".alert").hide('fade');
				//alert("OK");
			}, 5000);
		}
	}
	//设置出发初始日期
	$(".form_datetime").datetimepicker({
		format : 'yyyy-mm-dd',
		forceParse : 0,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		todayBtn : 1,
		language : 'zh-CN',
		autoclose : 1
	});

	
</script>