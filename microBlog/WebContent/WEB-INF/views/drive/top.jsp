<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function g(objName) {
		return document.getElementById(objName);
	}
	function chgNumber(objName, num) {
		numberObj = g(objName);
		var newDays = parseInt(numberObj.value);
		newDays += parseInt(num);
		if (newDays < 0) {
			alert("对不起，数量不能小于0，请重新设置");
			return;
		}
		numberObj.value = newDays;
	}
	function sel_count(objName) {
		var count = 0;
		var obj = document.getElementsByName(objName);
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].checked)
				count++;
		}
		return count;
	}
	function CurentTime() {
		var now = new Date();

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

		clock += day
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
</script>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<h3>
				<a class="brand" href="${context}/drive/home">境外自驾管理</a>
			</h3>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li <c:if test="${menuIndex==0}"> class="active"</c:if>><a
						href="${context }/drive/home"><h4>查询订制</h4></a></li>
					<!-- 
					<li <c:if test="${menuIndex==1}"> class="active"</c:if>><a
						href="${context}/custom/recommend"><h4>爆款产品</h4></a></li>
						  -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><h4>
								产品维护<strong class="caret"></strong>
							</h4></a>
						<ul class="dropdown-menu">
							<li><a href="${context }/special/list?page=0">专题管理</a></li>
							<li><a href="${context }/media/list?page=0&amp;s=&amp;t=">图片管理</a></li>
						</ul></li>

				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>