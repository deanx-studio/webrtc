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

		var isNeedDate = document.getElementById("isNeedDate").value;
		var number = document.getElementById("number").value;
		var singePrice = document.getElementById("singlePrice").innerText;

		if (isNeedDate == 2) {

			document.getElementById("total_price").innerText = singePrice
					* number + ".00元";

		} else {

			var startDatePrice = document.getElementById("startDatePrice").value;
			var endDatePrice = document.getElementById("endDatePrice").value;
			var productNo = document.getElementById("productNo").value;

			if (startDatePrice != "" && endDatePrice != "") {
				$
						.post(
								"${getPrice}",
								{
									startDate : startDatePrice,
									endDate : endDatePrice,
									productNo : productNo
								},
								function(result) {
									result = JSON.parse(result);
									//	var res=result.priceResult.distributePrice;
									//	if (isNeedDate == 0) {
									//			alert(singePrice);
									//			document.getElementById("total_price").innerText = singePrice
									//					* number + ".00元";

									//		} else {
									//	alert(res);
									document.getElementById("total_price").innerText = (result.priceResult.salePrice * number)
											/ 100 + "元";

									var tds = "";
									var tds1 = "";
									var weekday = new Array(7);
									weekday[0] = "星期日";
									weekday[1] = "星期一";
									weekday[2] = "星期二";
									weekday[3] = "星期三";
									weekday[4] = "星期四";
									weekday[5] = "星期五";
									weekday[6] = "星期六";

									for ( var i = 0; i < result.prices.length; i++) {
										var date = new Date(
												result.prices[i].date);
										tds = tds
												//+ "<label class='accordion-heading span2' for='number'>"
												+ "<li><div	style='min-height: 80px; min-width: 100px;'>"
												+ result.prices[i].date
												+ "</br>"
												+ weekday[date.getDay()]
												+ "</br>"
												+ (result.prices[i].salePrice)
												* (0.01) + "元" + "</div></li>";

										document.getElementById("time_add").innerHTML = tds;

									}

								});
			}
		}
	}

	function subtract() {

		var number = document.getElementById("number");

		if (number.value != 1) {

			number.value = --number.value;
		}

		getPrice();
	}

	function plus() {

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

	function but(i) {
		var del = document.getElementById("del").value;
		var plus = document.getElementById("plus").value;
		var num = document.getElementById("number").value;
		var singePrice = document.getElementById("singlePrice").innerText;
		var sum = parseInt(num) + parseInt(i);
		if (sum >= 1) {
			document.getElementById("number").value = sum;
			getPrice();

		} else {
			var message = "票数不能有0或者负数!";
			alert(message);
		}

	}
</script>

<div class="container">
	<div class="page-header"
		style="padding-bottom: 0px; border-bottom: 0px solid #eee;">
		<h4>${requestScope.Ticket.ticketName}</h4>
	</div>

	<div class="">
		<form role="form" class="form-horizontal" action="${order_confirm}"
			method="post">
			<!-- 订购份数头部bordercolor="#e1e1e8"-->
			<!-- 			<div class="prettyprint"> -->
			<div class="row">
				<div class="span6">
					<div class="accordion" id="accordion2">
						<table class="table" style="background-color: #f7f7f9;"><!-- table-striped table-bordered -->
							<!-- 单价 -->
							<tr>
								<td><label class="accordion-heading span2"
									style="color: red;" for="number">单&nbsp;&nbsp;&nbsp;&nbsp;价</label>

								</td>
								<td>
									<div class="accordion-heading span9" style="color: red;">
										<span id="singlePrice"><fmt:formatNumber
												value="${requestScope.Ticket.salePrice/100.0}"
												pattern="#0.00" /></span>元
									</div>
								</td>
							</tr>
							<!--  -->
							<tr>
								<td><label class="accordion-heading span2" for="number">
										到达日期 </label></td>
								<td><div class="accordion-heading span9"></div>
									<div class="input-append date form_datetime">
										<span class="add-on"> <i class="icon-calendar"></i></i></span><input
											size="16" type="text" id="startDatePrice"
											value="${requestScope.start_travel_date}" name="startDate"
											onchange="getPrice();" class="input-medium" readonly
											style="background-color: white;" />
									</div> <script type="text/javascript">
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
									</script></td>
							</tr>
							<!--  -->
							<c:choose>
								<c:when test="${requestScope.Ticket.isNeedDate == 1}">
									<tr>
										<td><label class="accordion-heading span2" for="number">
												离开日期 </label></td>
										<td>

											<div style="width: 30; float: left"></div>
											<div class="input-append date end_datetime">
												<span class="add-on"> <i class="icon-calendar"></i></i></span><input
													size="16" type="text" id="endDatePrice"
													value="${requestScope.end_travel_date}" name="endDate"
													onchange="return getPrice();" class="input-medium" readonly
													style="background-color: white;">

											</div> <script type="text/javascript">
												$('.end_datetime')
														.datetimepicker(
																{
																	format : 'yyyy-mm-dd',
																	forceParse : 0,
																	todayHighlight : 1,
																	startView : 2,
																	minView : 2,
																	todayBtn : 1,
																	autoclose : 1,
																	language : 'zh-CN'
																});
											</script>
										</td>
									</tr>
								</c:when>
							</c:choose>
							<tr>
								<td><label class="accordion-heading span2" for="number">预定数量</label>

								</td>
								<td><div class="controls"></div> <input id="del"
									class="btn btn-info" type="button" value="-"
									onclick="but('-1')" /><input type="text" id="number"
									class="input-mini" name="number" value="2" placeholder="数量"
									onchange="getPrice()"><input id="plus"
									class="btn btn-info" type="button" value="+" onclick="but('1')" /></td>
							</tr>
							<!--  -->
							<tr>
								<td><label class="accordion-heading span2"
									style="color: red;" for="number">应付金额</label></td>
								<td>
									<div class="accordion-heading span3"
										style="color: red; font-size: 18px">

										<span id="total_price"><strong>${requestScope.travel_price}元
										</strong></span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2"><c:choose>
										<c:when test="${requestScope.Ticket.isNeedDate == 1}">
											<!-- 开始时间——结束时间的单价 -->

											<ul class="nav nav-tabs"
												style="border-bottom: 0px solid #ddd;" id='time_add'>
												<li><div style="min-height: 60px; max-width: 100px;">
														${requestScope.start_travel_date} <br>
														<fmt:formatNumber
															value="${requestScope.Ticket.salePrice/100}"
															pattern="#0.00" />
														元
													</div></li>
											</ul>


										</c:when>
									</c:choose></td>
							</tr>
						</table>
					</div>
				</div>
			</div>


			<!-- 订购份数尾部-->

			<div style="height: 15px;"></div>
			<div class="prettyprint">
				<div class="row">
					<div class="span6">
						<p class="text-info">*请填写订购人信息</p>
						<p class="text-info">*请输入正确的手机号码凭验证码入园</p>

						<input type="hidden" name="preOrderDays"
							value="${requestScope.Ticket.preOrderDays}" /> <input
							type="hidden" name="isNeedDate" id="isNeedDate"
							value="${requestScope.Ticket.isNeedDate}" />

						<div class="control-group">
							<label class="control-label" for="user">订票人姓名</label>
							<div class="controls">
								<input type="text" id="user" name="user" placeholder="姓名" value="${username }">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="mobile">手机号码</label>
							<div class="controls">
								<input type="text" id="mobile" name="mobile" placeholder="手机号码"  value="${mobile}">
							</div>
							<input type="hidden" name="ticketId" id="productNo"
								value="${Ticket.ticketId}" /> <input type="hidden"
								name="scenicId" value="${Ticket.scenicId}" />
							<!--  <input type="hidden" name="startDate"
				value="${Ticket.startValidate}" />  -->
							<!-- <input type="hidden"
				name="endDate" value="${Ticket.endValidate}" /> 
				 -->
							<input type="hidden" name="ticketName"
								value="${Ticket.ticketName}" /> <input type="hidden"
								name="preOrderDays" value="${Ticket.preOrderDays}" /> <input
								type="hidden" name="needDate" id="isNeedDate"
								value='${Ticket.isNeedDate}' />
						</div>
						<div class="control-group">
							<label class="control-label" for="confirm_mobile">确认手机号码</label>
							<div class="controls">
								<input type="text" id="confirm_mobile" name="confirmMobile"
									placeholder="确认手机号码"  >
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="confirm_mobile"></label>
							<div class="controls">
								<input type="hidden" name="button" id="button">
								<button id="alipay_btn" type="submit" class="btn  btn-warning">支付宝支付</button>
								<!-- 
								<a href="${context}/wxpay/test" class="btn btn-warning">微信支付测试</a>
								 -->
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 购买须知-->
			<div style="height: 15px;"></div>
			<div class="prettyprint">
				<p class="text-info">购买须知</p>
				${Ticket.proReserve}
			</div>

		</form>

	</div>
	<div id="loading" class="modal hide fade" style="top:40%;width: 300px;left: 10%;">
		<div class="modal-header">
			<h3>提示</h3>
		</div>
		<div class="modal-body">
			<p>正在生成订单中，请稍候......</p>
		</div>

	</div>
	<script>

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
			var width =  document.body.clientWidth;//window.screen.width;
			document.getElementById("loading").style.left = (width - 300)/2 + "px";
			$('#loading').modal('show');
			return true;
		}
	});
	getPrice();
</script>
</div>
</html>