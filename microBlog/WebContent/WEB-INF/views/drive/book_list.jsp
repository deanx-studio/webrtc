<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript"
	src="${context }/resources/custom/js/bootstrap-alert.js"
	charset="UTF-8"></script>
<div style="height: 0px;"></div>

<div class="container" style="max-width: 960px;">
	<h3>预订查询</h3>
	<div class="alert alert-info fade in hide" id="tishi">
		<strong>批量操作提示：</strong><span id="txtTishi">正在处理中......</span>
	</div>
	<form class="form-search" action="${context }/drive/book/list">
		<select onchange="mark(this);">
			<option value="-1">-批量操作-</option>
			<option value="6">标记为已消费</option>
			<option value="4">标记为撤单</option>
			<option value="5">标记为已退款</option>
		</select> <select name="t">
			<option value="-1">搜索方式</option>
			<option value="0" selected>客人姓名</option>
			<option value="1">客人手机号</option>
			<option value="2">领队姓名</option>
		</select> <input name="context" type="text" class="input-medium search-query">
		<button type="submit" class="btn">搜索</button>
	</form>

	<table class="table table-striped">
		<tr>
			<th><input type="checkbox" id="sel_all" onchange="sel_all(this)"
				style="margin-top: -3px;">选择</th>
			<th>操作</th>
			<th>订单号</th>
			<th>客户姓名</th>
			<th>客户联系电话</th>
			<th>预订产品名称</th>
			<th>参团人数(儿童)</th>
			<th>出发日期</th>
			<th>预订人</th>
			<th>预订日期</th>
		</tr>
		<c:forEach var="items" items="${bookList}">
			<tr>
				<td><input type="checkbox" name="orderSel"
					id="${items.orderId }"></td>
				<td><a
					href="javascript:pay('${items.orderId}','${items.userName }', '${items.productName }', ${items.productPrice/100 });">缴费</a></td>
				<td>${items.orderId }</td>
				<td>${items.userName }</td>
				<td>${items.userMobile }</td>
				<td>${items.productName }</td>
				<td>${items.amount }(${items.childrenCount })</td>
				<td>${items.arriveDate }</td>
				<td>${items.bookerName }</td>
				<td>${items.orderDate }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<ul>
			<c:if test="${prevPage>=0}">
				<li><a
					href="${context}/drive/book/list?page=${prevPage}&t=${stype }&context=${sText}">上一页</a></li>
			</c:if>
			<c:forEach var="i" begin="0" end="${pageNo}" step="1">
				<li><a
					href="${context}/drive/book/list?page=${i}&t=${stype }&context=${sText}">第${i+1}页</a></li>
			</c:forEach>
			<c:if test="${fn:length(special_list)>0}">
				<li><a
					href="${context}/drive/book/list?page=${nextPage}&t=${stype }&context=${sText}">下一页</a></li>
			</c:if>
		</ul>
	</div>
</div>
<div class="modal hide fade" id="payWin">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h3>客户缴费</h3>
	</div>
	<div class="modal-body">
		<p id="userName"></p>
		<p id="desc"></p>
		<input type="text" id="payMoney" value="" />元
		<p id="txtResult"></p>
	</div>
	<div class="modal-footer">
		<a href="javascript:$('#payWin').modal('hide');" class="btn">关闭</a> <a
			href="javascript:confirmPay();" id="payBtn" class="btn btn-primary">确认</a>
	</div>
</div>
<script type="text/javascript">
	function sel_all(chk) {
		var chks = document.getElementsByName("orderSel");
		for ( var i = 0; i < chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}
	function mark(selObj) {
		var status = selObj.options[selObj.selectedIndex].value;
		if (status < 0) {
			alert("请选择具体的批量操作。")
			return;
		}
		var url = "${context}/drive/finish";
		var chks = document.getElementsByName("orderSel");
		//alert(chks.length);

		$("#tishi").show('fade');
		
		for ( var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				$.post(url, {
					orderId : chks[i].id,
					status : status
				}, function(result, status) {

					if (status == 'success') {
						if (result == '0') {
							txtResult.innerHTML = "缴费成功";
						} else {
							txtResult.innerHTML = "缴费失败：" + result;
						}
					}

				});

			}

		}
		txtTishi.innerHTML = "处理完毕。";
		setTimeout(function() {
			$(".alert").hide('fade');
			//alert("OK");
		}, 5000);

	}
	function confirmPay(orderId) {
		//alert("confirmPay:" + orderId + ":" + payMoney.value);
		var url = "${context}/drive/pay";
		txtResult.innerHTML = "缴费中.....";
		$.post(url, {
			orderId : orderId,
			payMoney : payMoney.value
		}, function(result, status) {

			if (status == 'success') {
				if (result == '0') {
					txtResult.innerHTML = "缴费成功";
				} else {
					txtResult.innerHTML = "缴费失败：" + result;
				}
			}

		});
	}
	function pay(orderId, uname, pname, defaultPayMoney) {
		userName.innerHTML = "客户姓名：" + uname;
		desc.innerHTML = "产品名称：" + pname;
		payMoney.value = defaultPayMoney;
		payBtn.href = "javascript:confirmPay(" + orderId + ");";
		$('#payWin').modal("show");
	}
	//$(".alert").alert('close');

	
</script>