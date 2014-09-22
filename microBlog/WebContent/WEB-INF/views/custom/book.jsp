<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="${context }/resources/custom/js/bootstrap-carousel.js"></script>
<c:if test="${IsMobile==false }">
<div style="height: 10px;"></div>
</c:if>
<s:url var="orderURL" value="/custom/order?productID="></s:url>
<c:choose>
	<c:when test="${isMobile==true }">
		<s:url var="detailURL" value="/show/spec?id="></s:url>
	</c:when>
	<c:otherwise>
		<s:url var="detailURL" value="/custom/detail?id="></s:url>
	</c:otherwise>
</c:choose>
<style type="text/css">
.alert {
	height: 20px;
	font-size: 18px;
	overflow: hidden;
	border: 0px solid #333;
	/*
	width: 500px;
	margin: 50px auto 0;
	*/
}

.alert li {
	width: 600px;
	height: 25px;
	line-height: 25px;
	overflow: hidden;
}

.mobile_alert {
	height: 24px;
	overflow: hidden;
	border: 0px solid #333;
	/*
	width: 500px;
	margin: 50px auto 0;
	*/
}

.mobile_alert li { //
	width: 500px;
	height: 25px; //
	font-size: 18px;
	line-height: 25px;
	overflow: hidden;
	margin-left: -25px;
}
</style>
<div class="container" style="max-width: ${maxWidth}px;">

	<c:choose>
		<c:when test="${isMobile == true}">
			<h3>热门自驾团:</h3>
			<div class="mobile_alert">

				<ul class="list" onmouseover="javascript:isContinue=false;"
					onmouseleave="javascript:isContinue=true;">
					<c:forEach var="items" items="${groupList}">
						<li><a
							href="${context }/custom/order?productID=${items.productId}&gdate=${items.startDate}"
							title="${items.productName }">${items.startDate}&nbsp;${items.productName
								}</a></li>
					</c:forEach>
				</ul>
			</div>
		</c:when>
		<c:otherwise>

			<div class="alert">
				<ul class="list" onmouseover="javascript:isContinue=false;"
					onmouseleave="javascript:isContinue=true;">
					<c:forEach var="items" items="${groupList}">
						<li><strong>热门自驾团:</strong> <a
							href="${context }/custom/order?productID=${items.productId}&gdate=${items.groupDate}"
							title="${items.productName }">${items.startDate}&nbsp;&nbsp;${items.productName
								}</a></li>
					</c:forEach>
				</ul>

			</div>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		var isContinue = true;
		function autoScroll(obj) {
			if (!isContinue)
				return;
			$(obj).find(".list").animate({
				marginTop : "-25px"
			}, 500, function() {
				$(this).css({
					marginTop : "0px"
				}).find("li:first").appendTo(this);
			})
		}

		<c:choose>
		<c:when test="${isMobile == true}">
		$(function() {
			setInterval('autoScroll(".mobile_alert")', 3000)
		});
		</c:when>
		<c:otherwise>
		$(function() {
			setInterval('autoScroll(".alert")', 3000)
		});
		</c:otherwise>
		</c:choose>
	</script>



	<ul class="nav nav-tabs" style="border-bottom: 0px;">
		<c:forEach var="items" items="${productList}">
			<li id="img_sel_0" style="text-align: left; min-height: 180px;">
				<div style="width: 285px; min-height: 255px;">
					<a target="_blank" href="${detailURL}${items.mediaID}"><img
						src="${items.img}" style="width: 278px;" title="${items.name}"></a>

					<table style="width: 100%;">
						<tr>
							<td colspan="5">${items.name}</td>
						</tr>
						<tr>
							<td><span style="color: rgb(255, 145, 0); font-size: 20px">￥${items.lowPrice
									}/</span><span style="color: rgb(255, 145, 0)">人起</span></td>
							<td style="text-align: right;"><a
								href="javascript:book(${items.productID });"
								style="margin-right: 10px; margin-top: 0px;"
								class="btn btn-warning pull-right">报名</a></td>
						</tr>
					</table>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>

<div class="modal hide fade" id="groupDate">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h3>参团日期选择</h3>
	</div>
	<div class="modal-body">
		<p>请选择适合您出发的日期</p>
		<p id="groupList"></p>
	</div>
	<div class="modal-footer">
		<a href="#" onclick="javascript:closeGroup();" class="btn">关闭</a> <a
			id="freeBook" href="#" class="btn btn-warning">个性定制</a>
	</div>
</div>
<script type="text/javascript">
	function closeGroup() {
		$('#groupDate').modal('hide');
	}
	function confirmPay() {

		location.href = "${context}/";
	}
	function book(productId) {
		var url = "${context}/custom/group/list";

		$
				.post(
						url,
						{
							productID : productId
						},
						function(result, status) {

							if (status == 'success') {

								//alert(result);
								var gs = eval(result);
								if (gs.length > 0) {
									var list = "<table class='table'><tr><th>产品名称</th><th>出发日期</th><th></th></tr>";
									for ( var i = 0; i < gs.length; i++) {
										//alert(gs[i].bookCount+";"+gs[i].TotalCount); 
										var line = "<tr>";
										line += "<td>";
										if (gs[i].bookCount == gs[i].TotalCount)
											line += "<span style='color:red'>[已满]</span>";
										line += decodeURIComponent(gs[i].productName)
												+ "</td>";
										line += "<td>"
												+ decodeURIComponent(gs[i].startDate)
												+ "</td>";
										line += "<td>";
										if (gs[i].bookCount != gs[i].TotalCount)
											line += "<a class='btn btn-warning' href='${context}/custom/order?productID="
													+ gs[i].productId
													+ "&gdate="
													+ gs[i].startDate
													+ "'>报名</a>";
										line += "</td>";
										line += "</tr>";
										//alert(line);
										list += line;
									}
									groupList.innerHTML = list + "</table>";
									//alert(groupList.innerHTML);
								} else {
									groupList.innerHTML = "目前无发团计划，请选择自由报名，填写您期望的出发日期。";

								}
							}

						});
		//获取团期数据
		$('#groupDate').modal("show");
		freeBook.href = "${context}/custom/order?productID=" + productId;
		//$('#myCarousel').carousel();

	}

	
</script>