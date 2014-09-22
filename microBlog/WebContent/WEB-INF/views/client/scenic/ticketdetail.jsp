<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<s:url var="go_pay" value="/order/go_pay.do"></s:url>
<script>
function goOrder(scenicId,ticketId){
	
	window.location.href='${go_pay}?scenicId='+scenicId+'&ticketId='+ticketId;
}
</script>

<div class="container" style="max-width:500px;">
		<h4>
			${ticketDetail[0].ticketName}
		</h4>
		<div class="accordion-group">
			<div class="accordion-heading" style="margin: 8px 16px;">
				<b>票价说明</b>
			</div>
		</div>
		<div style="background-color: #f5f5f5; padding: 13px 16px;">
		
		<span style="color:black;line-height:30px;">门市价</span>
									 		￥<del style="color: gray;"><fmt:formatNumber
													value="${ticketDetail[0].marketPrice/100}"
													pattern="#0.00" />
												</del> 
									<span style="float:right;font-size:14px;">
									<a href="${go_pay}?scenicId=${ticketDetail[0].scenicId}&ticketId=${ticketDetail[0].ticketId}"  style="background-color:#f60;color:white;" class="btn btn-lg active" style="color:red;" 
								 >￥<fmt:formatNumber value="${ticketDetail[0].salePrice/100}"
									pattern="#0.00" /></a></b></span>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading" style="margin: 8px 16px;">
				<b>产品说明</b>
			</div>
		</div>
		<div style="background-color: #f5f5f5; padding: 6px 8px;">

			<pre style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;line-height: 22px;font-size: 14px;">${ticketDetail[0].proDeclare}
			</pre>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading" style="margin: 8px 16px;">
				<b>订购说明</b>
			</div>
		</div>
		<div style="background-color: #f5f5f5; padding: 6px 8px;">
			<pre style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;;line-height: 22px;font-size: 14px;">${ticketDetail[0].proReserve}
			</pre>
		</div>
		<div style=" padding: 13px 16px;">
			<span class="span9">
			</span> <span >
			<a href="${go_pay}?scenicId=${ticketDetail[0].scenicId}&ticketId=${ticketDetail[0].ticketId}" style="background-color:#f60;color:white;" class="btn btn-lg active">￥<fmt:formatNumber value="${ticketDetail[0].salePrice/100}"
				pattern="#0.00" />&nbsp;抢购</a>
			</span>
</div>
	</div>
</html>