<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="sub_enter" value="/sub/enter"></s:url>
<script type="text/javascript" src="${resource}/js/validate.js"
	charset="UTF-8"></script>
<s:url var="getPrice" value="/order/getPriceForDate.do"></s:url>
<s:url var="order_confirm" value="/order/confirm.do"></s:url>
<script>
	function getPrice() {

		var startDatePrice = document.getElementById("startDatePrice").innerText;
		var endDatePrice = document.getElementById("endDatePrice").innerText;
		var productNo = document.getElementById("productNo").value;
		var number = document.getElementById("number").value;
		var singePrice = document.getElementById("singlePrice").innerText;
		var isNeedDate = document.getElementById("isNeedDate").value;

		$.post("${getPrice}", {
			startDate : startDatePrice,
			endDate : endDatePrice,
			productNo : productNo
		}, function(result) {

			//	if (isNeedDate == 0) {

			document.getElementById("total_price").innerText = singePrice
					* number + "元";

			//		} else {
			//			document.getElementById("total_price").innerText = result
			//					* number + ".00元";
			//		}

		});

	}

	function subtractNumber() {

		var number = document.getElementById("number");

		if (number.value > 1) {

			number.value = --number.value;
		} else {
			alert("订购数量不能为0！");
		}

		getPrice();

	}

	function plusNumber() {

		var number = document.getElementById("number");

		number.value = ++number.value;

		getPrice();
	}

	function getNumber() {

		var number = document.getElementById("number");

		if (number.value <= 0) {

			alert("预订数量必须大于0");
			number.focus();
		}
	}
</script>

<div class="container">

	<div class="page-header"
		style="padding-bottom: 0px; border-bottom: 0px solid #eee;">
		<h4>${requestScope.Ticket.ticketName}</h4>
	</div>

</div>

<div class="container">

	<div class="prettyprint">
		<form role="form" class="form-horizontal" action="${order_confirm}"
			method="post">

			<input type="hidden" name="ticketId" id="productNo"
				value="${Ticket.ticketId}" /> <input type="hidden" name="scenicId"
				value="${Ticket.scenicId}" />
			<!-- <input type="hidden" name="startDate"
				value="${Ticket.startValidate}" />   -->
			<input type="hidden" name="endDate" value="${Ticket.endValidate}" />
			<input type="hidden" name="ticketName" value="${Ticket.ticketName}" />
			<input type="hidden" name="preOrderDays"
				value="${Ticket.preOrderDays}" /> <input type="hidden"
				name="startDate" value="${start_travel_date }" /> <input
				type="hidden" name="needDate" id="isNeedDate"
				value='${Ticket.isNeedDate}' />

			<div class="row">
				<div class="span6">
					<div class="accordion" id="accordion2">

						<table class="table" style="background-color: #f7f7f9;"><!--  table-striped table-bordered -->
							<tr>
								<td>有效日期</td>
								<td><span id="startDatePrice">${start_travel_date}</span> ~
									<span id="endDatePrice">${end_travel_date}</span></td>
							</tr>
							<tr>
								<td><label style="color: red;" for="number">门票单价</label></td>
								<td><span id="singlePrice"><fmt:formatNumber
											value="${requestScope.Ticket.salePrice/100.0}"
											pattern="#0.00" /></span>元</td>
							</tr>
							<tr>
								<td><label for="number">门票数量</label></td>
								<td><input class="btn btn-info" onclick="subtractNumber()"
									id="subtract" value="-" type="button" /> <input
									style="width: 40px; text-align: center;" value="2"
									name="number" id="number" type="text" onblur="getNumber();"
									onchange="javascript:getPrice();" /> <input
									class="btn btn-info" type="button" onclick="plusNumber()"
									id="plus" value="+" /></td>
							</tr>
							<tr>
								<td><label style="color: red;"> 应付金额 </label></td>
								<td><span style="color: red;" id="total_price">
										${travel_price}元 </span></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="prettyprint">


				<p class="text-info">*请填写订购人信息</p>
				<p class="text-info">*请输入正确的手机号码凭验证码入园</p>

				<div class="control-group">

					<label class="control-label" for="user">订票人姓名</label>
					<div class="controls">
						<input type="text" id="user" name="user" placeholder="姓名"
							required="required" value="${username }" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="mobile">手机号码</label>
					<div class="controls">
						<input type="text" id="mobile" name="mobile" placeholder="手机号码"
							required="required" value="${mobile}"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="confirm_mobile">确认手机号码</label>
					<div class="controls">
						<input type="text" id="confirm_mobile" name="confirmMobile"
							placeholder="再次输入手机号码" required="required"  value=""/>
					</div>

					<div id="mobile_rv"></div>
					<script>
						$('#confirm_mobile')
								.blur(
										function() {
											var mob = $('#mobile').val();
											if (mob != ($('#confirm_mobile')
													.val())) {
												$("#mobile_rv")
														.html(
																'<h5 class="text-danger">与上次输入不符合。</h5>')
														.show();
												return false;
											} else {
												$("#mobile_rv").hide();
												return true;
											}
										});
					</script>
				</div>


				<div class="control-group">
					<div class="controls">
						<button id="alipay_btn" type="submit"
							data-loading-text="Loading..." class="btn btn-warning">支付宝支付</button>
							<!-- 
							<a href="${context}/travel-weixin/wxpay/test" class="btn btn-warning">微信支付测试</a>
							 -->
					</div>
				</div>

			</div>
		</form>

		<div class="prettyprint">
		
			<div class="control-group" style="background-color: #f5f5f5;">
				<p class="text-info">预订须知</p>
				<div style="">${Ticket.proReserve}</div>
			</div>
		</div>
	</div>
	<div id="loading" class="modal hide fade" style="top:40%;width: 300px;left: 10%;">
		<div class="modal-header">
			<h3>提示</h3>
		</div>
		<div class="modal-body">
			<p>正在生成订单中，请稍候......</p>
		</div>

	</div>
</div>

<script>
//alert($(this).height() / 2);
//document.getElementById("loading").style="top:"+$(this).height() / 2+100;
	                
	//$('#loading').modal('toggle');
	$("form").submit(function() {
		var mobile = $('#mobile').val();
		var confirm_mobile = $('#confirm_mobile').val();
		var number = $('#number').val();
		var user = $('#user').val();
		if (!isNotNull(mobile, "订票手机号不能为空")) {
			return false;
		} else if (!isNotNull(confirm_mobile, "订票确认手机号不能为空")) {
			return false;
		} else if (!isSame(mobile, confirm_mobile, "手机号与确认手机号不一样")) {
			return false;
		} else if (!isNotNull(number, "门票数量不能为空")) {
			return false;
		} else if (!isStrNumber(number, "门票数量必须为数字")) {
			return false;
		} else if (!isNotNull(user, "订票人姓名不能为空")) {
			return false;
		} else if (isStr(user, "订票人姓名不能全为数字")) {
			return false;
		} else {
			document.getElementById('alipay_btn').disabled = true;
			//$('#valid_from_message').text("正在确认...").show();
			var width =  document.body.clientWidth;//window.screen.width;
			document.getElementById("loading").style.left = (width - 300)/2 + "px";
			$('#loading').modal('show');
			return true;
		}
	});
	//更新价格
	getPrice();
</script>

