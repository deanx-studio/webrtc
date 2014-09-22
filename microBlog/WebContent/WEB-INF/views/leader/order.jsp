<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript"
	src="${context }/resources/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<link href="${context }/resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<style>
@media ( max-width : 480px) {
	.nav-collapse {
		-webkit-transform: translate3d(0, 0, 0);
	}
}
</style>
<div style="height: 0px;"></div>
<s:url var="orderURL" value="/leader/order?id="></s:url>
<c:choose>
	<c:when test="${isMobile==true }">
		<s:url var="detailURL" value="/show/spec?id="></s:url>
	</c:when>
	<c:otherwise>
		<s:url var="detailURL" value="/custom/detail?id="></s:url>
	</c:otherwise>
</c:choose>
<div class="container" style="max-width: 960px;">
	<h3>订单预订</h3>
	<form class="form-horizontal">
		<input type="hidden" id="orderId" value="${orderId }" /> <input
			type="hidden" id="productID" value="${pid }" />
		<div class="control-group">
			<label class="control-label">产品名称：</label>
			<div class="controls">
				<label>${productName }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产品售价：</label>
			<div class="controls">
				<label><span style="color: gold; font-size: 18px;">￥${salePrice
						}元</span>起<br /> <span style="color: gray">(具体价格随出发时参团人数而定)</span></label>

			</div>
		</div>
		<div class="control-group">
			<label class="control-label">优惠额度：</label>
			<div class="controls">
				<label style="color: red; font-size: 18px;">￥${offPrice }元</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputEmail">客人姓名：</label>
			<div class="controls">
				<input type="text" id="userName" placeholder="客户姓名"
					onkeyup="onUserName(this);"><br /> <label
					style="color: red" id="txtunameResult"></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客人联系手机：</label>
			<div class="controls">
				<input type="text" id="userMobile" placeholder="客人联系手机号码"
					onkeyup="onUserMobile(this);"><br /> <label
					style="color: red" id="txtMobileResult"></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参团总数：</label>
			<div class="controls inline">
				<input id="del" class="" type="button" value="-"
					onclick="chgNumber('totalCount',-1)"> <input type="number"
					id="totalCount" class="input-mini" name="text"
					value="${totalCount }"> <input id="plus" class=""
					type="button" value="+" onclick="chgNumber('totalCount',1)">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">儿童人数：</label>
			<div class="controls inline">
				<input id="del" class="" type="button" value="-"
					onclick="chgNumber('childrenCount',-1)"> <input type="text"
					id="childrenCount" class="input-mini" name="number"
					value="${childrenCount }"> <input id="plus" class=""
					type="button" value="+" onclick="chgNumber('childrenCount',1)"><br />
				<span style="color: gray">12岁以下（含12岁）不占床免房差<br />12岁以下儿童机票根据航空公司实际优惠政策收取（可自行购买）
				</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputEmail">出发日期：</label>
			<div class="controls date form_datetime">
				<span class="add-on"> <i class="icon-calendar"></i></span><input
					size="16" type="text" id="startDate" value="${startDate }"
					name="startDate" class="input-medium" readonly
					style="background-color: white;">
			</div>
			<script type="text/javascript">
				//alert(g("startDate").value);
				<c:if test="${empty startDate}">
				startDate.value = CurentTime(20);
				</c:if>
				//alert(g("startDate").value);	
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

				function onUserName(uname) {
					txtResult.innerHTML = "";
					if (uname.value.length > 0)
						txtunameResult.innerHTML = "";
				}
				function onUserMobile(mobile) {
					txtResult.innerHTML = "";
					if (mobile.value.length > 0)
						txtMobileResult.innerHTML = "";
				}
				function chgNumber(objName, num) {
					numberObj = document.getElementById(objName);
					var newDays = parseInt(numberObj.value);
					newDays += parseInt(num);
					if (newDays < 0) {
						alert("对不起，数量不能小于0，请重新设置");
						return;
					}
					numberObj.value = newDays;
					txtResult.innerHTML = "";
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
				function submitBook() {

					//数据校验
					if (userName.value.length <= 0) {
						txtunameResult.innerHTML = "请输入客人姓名。";
						userName.focus();
						return;
					}
					if (userMobile.value.length <= 0) {
						txtMobileResult.innerHTML = "请输入客人联系手机号码。";
						userMobile.focus();
						return;
					}
					txtResult.innerHTML = "请稍候，正在处理中......";
					var url = "${context}/leader/order/save";

					$.post(url, {
						startDate : startDate.value,
						productID : productID.value,
						orderId : orderId.value,
						userName : userName.value,
						userMobile : userMobile.value,
						adultCount : adultCount.value,
						oldCount : oldCount.value,
						childrenBedsCount : childrenBedsCount.value,
						childrenCount : childrenCount.value
					}, function(result, status) {

						if (status == 'success') {
							if (result == '0') {
								txtResult.innerHTML = "数据保存失败，请重试。";
							} else if (result == '-1') {
								txtResult.innerHTML = "订单已经生成，短信发送失败，请重试。";
							} else {
								txtResult.innerHTML = "订单已经生成，通知短信已经发送，请客户查收。";
								orderId.value = result;
							}
						}

					});
				}
			</script>
		</div>

		<div class="control-group">
			<div class="controls">
				<button type="button" class="btn btn-warning" onclick="submitBook()">报名</button>
				<label id="txtResult"></label>
			</div>
		</div>
	</form>
</div>