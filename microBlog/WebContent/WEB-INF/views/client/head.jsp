<%@page import="java.security.Principal"%>
<%@page import="com.mdnet.travel.core.model.Traveler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<s:url var="quit" value="/static/j_spring_security_logout" />
<s:url var="signup" value="/signup"></s:url>
<s:url var="login" value="/login"></s:url>

<sec:authorize access="isAuthenticated()">
	<sec:authentication var="username" property="principal" />
</sec:authorize>
<!--
<div class="navbar  navbar-fixed-top" style="position: fixed;">
	
	<div class="navbar-inner navbar-inverse" style="height: 35px;">
		<form class="form-search" id="frmSearch"
			action="${context}/search/product" method="POST"
			style="margin-top: 7px;">

			<a href="${home}" style="padding-left: 30px;"><img alt=""
				src="${resource}/image/client/xzjz_tm.png" style="height: 30px;" /></a>

			<a href="${context}/catalog/list" class="btn"
				style="margin-right: 20px; margin-top: -2px; float: right;">更多</a> <input
				type="text" name="searchKey" class="input-medium search-query"
				placeholder="请输入关键字" size="10" style="width: 30%; margin-top: -3px;"
				value="${searchKey}" />&nbsp;&nbsp;<a href="javascript:submit_s(1)"
				class="btn" style="margin-top: -3px;">搜索</a>
		</form>
	</div>
</div>
-->
<div class="top_shape">

	<div class="container">
		<!-- 
			<form class="form-search" id="frmSearch"
				action="${context}/search/product" method="POST"
				style="margin-top: 7px;">
 -->
		<table style="width: 100%">
			<tr>
				<td style="text-align: right; width: 30px;"
					onclick="javascript:show_search()"><img
					style="height: 22px; margin-top: -2px;cursor: pointer;"
					src="${resource}/image/client/icon-search-main.png"></td>
				<td style="text-align: center"><a href="${home}"
					style="color: white; font-size: 22px; font-family: '微软雅黑', 'Microsoft YaHei'; TEXT-DECORATION: none">
						想走就走 <!-- 
				<img
						alt="" src="${resource}/image/client/xzjz_text.png"
						style="height: 22px" /> -->
				</a></td>

				<td style="text-align: right; width: 50px">
				<a
					href="${context}/catalog/list" ><img src="${resource}/image/client/more.png" style="margin-top:3px;height:30px;"></a></td>
			</tr>
		</table>


		<!--  
					<input
					type="text" name="searchKey" class="input-medium search-query"
					placeholder="请输入关键字" size="10"
					style="width: 30%; margin-top: -3px;" value="${searchKey}" />&nbsp;&nbsp;<a
					href="javascript:submit_s(1)" class="btn" style="margin-top: -3px;">搜索</a>
					 
			</form>
			-->
	</div>

</div>
<!--
<div class="search_shape" id="search_box" style="display: none">
	<div class="navbar-inner">
		<div class="container" style="height: 35px;">
			<form class="form-search" id="frmSearch"
				action="${context}/search/product" method="POST"
				style="margin-top: 7px;">

				<input type="text" name="searchKey" data-provide="typeahead"
					data-source="['宜兴','千岛湖']" class="input-medium search-query"
					placeholder="请输入目的名称或景区关键字" autocomplete="off"
					style="width: 50%; margin-top: -3px;" value="${searchKey}" /><a
					href="javascript:submit_s(1)" class="btn btn-warning"
					style="margin-top: -3px;">搜索</a>
			</form>
		</div>
	</div>
</div>
-->

<form class="form-search" id="frmSearch"
	action="${context}/search/product" method="POST"
	style="margin-top: 7px;">
	<div class="modal hide fade" id="search_box"
		style="width: 300px; top: 20%; margin: 0 auto;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4>目的地景区搜索</h4>
		</div>
		<div class="modal-body">
			<input type="text" name="searchKey" data-provide="typeahead"
				data-source="['宜兴','千岛湖']" class="input-large"
				placeholder="请输入目的名称或景区关键字" autocomplete="off" style=""
				value="${searchKey}" />
		</div>
		<div class="modal-footer">
			<a href="javascript:close_search();" class="btn">关闭</a> <a
				href="javascript:submit_s(1)" class="btn btn-warning">搜索</a>
		</div>
	</div>
</form>
<script type="text/javascript">
	function submit_s(pageNo) {
		//alert("ddd");
		var frm = document.getElementById("frmSearch");
		frm.action += "?pageNo=" + pageNo;
		frm.submit();
	}
	function close_search() {
		$('#search_box').modal('hide');
	}
	function show_search() {
		//设置搜索框X坐标
		//获得屏幕宽度,屏幕可见区域宽度
		var width = document.body.clientWidth;//window.screen.width;
		//alert(width);
		document.getElementById("search_box").style.left = (width - 300) / 2
				+ "px";
		//显示搜索框
		$('#search_box').modal('show');

	}
</script>
<div style="height: 50px;"></div>