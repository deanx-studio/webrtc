<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources"></s:url>
<s:url var="go_pay" value="/order/go_pay"></s:url>

<div class="container">
	<h3>推荐列表</h3>

	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<c:if test="${empty view_list}">
				<h4 class="text-info">目前还没有相关推荐哦，继续关注我们的更新吧！</h4>
			</c:if>
			<c:forEach var="view" items="${view_list}">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-toggle="collapse"
							data-parent="#accordion" href="#${view.scenicId}">${view.scenicName}</a>
					</h4>
				</div>

				<div id="${view.scenicId}" class="panel-collapse collapse in">
					<div class="panel-body">
						<c:forEach var="ticket" items="${view.scenicTickets}">
							<div class="prettyprint">
								<div class="row-fluid">
									<div class="span2 text-right">
										<a href="#"> <img src="${ticket.imgUrl}"
											style="height: 70px;">
										</a>
									</div>
									<div class="span6 text-left">
										<div style="font-size: 20px;">${ticket.ticketName}</div>
										<div style='height: 15px;'></div>
										<div style="color: red;">
											[现价]￥${ticket.salePrice/100.0}&nbsp;&nbsp;
											[市场价]￥${ticket.marketPrice/100.0}&nbsp;&nbsp;
											[省]￥${(ticket.marketPrice-ticket.salePrice)/100.0} <span
												style="margin-left: 20px;"> <a
												href="${go_pay}?ticketId=${ticket.ticketId}&scenicId=${ticket.scenicId}"><img
													src="${resource}/image/client/pay_btn.png" alt="订购"
													style="width: 100px;" /></a>
											</span>
										</div>
									</div>

									<div class="span3 text-right"></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<table>
		<tr align="center">
			<td><button type="button" class="btn btn-info">${fn:length(view_list)}条</button></td>
		</tr>
	</table>
</div>
