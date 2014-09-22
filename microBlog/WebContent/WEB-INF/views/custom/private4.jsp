<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 个性定制开始 -->
	<script type="text/javascript">
		function meatSel(selObj) {
			var index = selObj.selectedIndex;
			var value = selObj.options[index].value;
			//alert(value);
			if (value == "0")
				document.getElementById("meat_type").style.display = "block";
			else
				document.getElementById("meat_type").style.display = "none";
		}
		function check4() {

			return true;
		}
	</script>
	<form class="form-horizontal" onsubmit="return check4();"
		action="${context }/custom/private/submit?step=4" method="post">
		<div class="alert alert-block">
			<h4>5/6 您还有其他特别要求吗？</h4>
		</div>
		<div class="control-group">
			<h3>用餐需求</h3>
			<table>
				<tr>
					<td><select name="meat_sel" style="width: 120px;"
						onchange="meatSel(this);">
							<option value="0">旅行社安排</option>
							<option value="1">自理</option>
					</select></td>
					<td><select name="meat_type" id="meat_type"
						style="width: 120px; display: block">
							<option value="0">中餐</option>
							<option value="1">西餐</option>
					</select></td>
				</tr>
			</table>



			<h3>其他服务</h3>
			<table>
				<tr>
					<td><input type="checkbox" value="leader" name="elseService">需要领队</td>
					<td><input type="checkbox" value="shopping" name="elseService">购物</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="party" name="elseService">派对</td>
					<td><input type="checkbox" value="hunting" name="elseService">狩猎（仅限澳大利亚）</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="fire" name="elseService">实弹射击</td>
					<td><input type="checkbox" value="fishing" name="elseService">海钓（有条件实现）</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="diving" name="elseService">潜水（有条件实现）</td>
					<td><input type="checkbox" value="wild" name="elseService">野外（公园）烧烤</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="local" name="elseService">安排当地文化活动</td>
					<td><input type="checkbox" value="immigrant"
						name="elseService">移民考察</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="house" name="elseService">购房考察</td>
					<td><input type="checkbox" value="wine" name="elseService">酒庄品酒</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>


			<h3>特别要求信息</h3>
			<textarea rows="3" name="memo"></textarea>
		</div>
		<div class="control-group">
			<input type="button" onclick="javascript:history.back();"
				class="btn btn-primary" value="返回">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" class="btn btn-primary" value="下一步">
		</div>
	</form>

	<!-- 个性定制结束 -->
</div>
