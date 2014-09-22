<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="home" value="/home" />
<div style="height: 80px;"></div>
<!-- 
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<%-- <li><a href="${complaint_ui}">个人中心</a> <span class="divider">/</span></li> --%>
	<li class="active">投诉</li>
</ul>
 -->
 <h3>我要投诉</h3>
<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<s:url var="save_complaint" value="/complaint/my/save"></s:url>
			<form method="post" action="${save_complaint}">
				<div class="caption">
					<h3>我要投诉</h3>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;对于您来到这里，我们表示真诚的道歉；您能提出宝贵的意见，我们表示感谢！</p>
					<p>
					<table class="table">
						<!-- <thead>
						<tr>
							<th>#</th>
							<th>Product</th>
							<th>Payment Taken</th>
							<th>Status</th>
						</tr>
					</thead> -->
						<tbody>
							<tr>
								<td>投诉项目：</td>
								<td><select id="type" name="type" class="form-control">
										<option value="0">其他相关</option>
										<option value="1">产品相关</option>
										<option value="2">价格相关</option>
										<option value="3">服务相关</option>
										<option value="4">售后相关</option>
										<option value="5">活动相关</option>
										<option value="6">网站相关</option>
								</select></td>
							</tr>
							<tr>
								<td>投诉详情：</td>
								<td rowspan="8"><textarea name="content"
										class="form-control" rows="5"></textarea></td>
							</tr>

						</tbody>
					</table>
					</p>
					<p><button class="btn btn-warning btn-lg" type="submit">提交</button></p>
					<s:url var="list_complaint" value="/complaint/my/list"></s:url>
					<p class='muted'>
						<i class='icon-user'></i>查看投诉历史&rarr;<a class="btn btn-success btn-xs" href="${list_complaint}">投诉记录</a>
					</p>
				</div>
			</form>
		</div>
	</div>
</div>


