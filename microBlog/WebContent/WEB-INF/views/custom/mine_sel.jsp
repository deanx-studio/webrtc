<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 定制列表 -->

	<form class="form-inline">
		<input type="text" id="QueryMobile" class="input-small"
			placeholder="输入手机号码">
		<button type="button" class="btn" onclick="query();">查询</button>
	</form>
	<table id="customize" class="table table-striped" style="display:none">
		<tr>
			<th></th>
			<th>启程日期</th>
			<th>出行天数</th>
			<th>出行人数</th>
			<th>定制日期</th>
		</tr>
	</table>
</div>
<script type="text/javascript">
	function query() {
		var url = "${context}/custom/mine/list";
		$
				.post(
						url,
						{
							mobile : QueryMobile.value,
							page : 0
						},
						function(result, status) {

							if (status == 'success') {
								var list = eval(result);
								var head = "<tr><th></th><th>启程日期</th><th>出行天数</th><th>出行人数</th><th>定制日期</th></tr>";
								var body = "";
								for ( var i = 0; i < list.length; i++) {
									body += "<tr>";
									body += "<td><a href='mine?sid="
											+ list[i].sessionID + "'>详情</td>";
									body += "<td>" + list[i].startDate
											+ "</td>";
									body += "<td>" + list[i].tripDays + "</td>";
									body += "<td>"
											+ (parseInt(list[i].adultPerson)
													+ parseInt(list[i].childrenPerson) + parseInt(list[i].oldPerson))
											+ "</td>";
									body += "<td>" + list[i].makeTime + "</td>";
									body += "</tr>";
								}
								customize.innerHTML = head + body;
								customize.style.display="table";
							}

						});

	}
</script>