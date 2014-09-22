<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${context }/resources/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<link href="${context }/resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 个性定制开始 -->
	<form class="form-horizontal" onsubmit="return check1()"
		action="${context }/custom/private/submit?step=1" method="post">
		<div class="alert alert-block">
			<h4>2/6 您打算什么时候出发呢，计划去几天？</h4>
		</div>
		<div class="control-group">

			<h3>计划启程日期</h3>
			<div class="input-append date form_datetime">
				<span class="add-on"> <i class="icon-calendar"></i></span><input
					size="16" type="text" id="startDate" value="2014-07-25"
					name="startDate" class="input-medium" readonly
					style="background-color: white;">
			</div>
			<script type="text/javascript">
				//alert(g("startDate").value);
				g("startDate").value = CurentTime();
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

				function tripDays(day) {
					numberObj = document.getElementById("number");
					var newDays = parseInt(numberObj.value);
					newDays += parseInt(day);
					if (newDays < 1) {
						alert("对不起，出行天数不能小于1，请重新设置");
						return;
					}
					numberObj.value = newDays;
				}
				function check1() {
					//alert(CurentTime());
					if (g("startDate").value < CurentTime()) {
						alert("对不起，计划出发日期距今天不能小于60天");
						return false;
					}

					return true;
				}
			</script>

			<h3>出行天数</h3>

			<div class="inline">
				<input id="del" class="" type="button" value="-"
					onclick="tripDays(-1)"> <input type="text" id="number"
					class="input-mini" name="number" value="3" placeholder="计划出行天数">
				<input id="plus" class="" type="button" value="+"
					onclick="tripDays(1)">
			</div>

		</div>
		<div class="control-group">

			<input type="button" onclick="history.back();"
				class="btn btn-primary" value="返回">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" class="btn btn-primary" value="下一步">

		</div>

	</form>

	<!-- 个性定制结束 -->
</div>
