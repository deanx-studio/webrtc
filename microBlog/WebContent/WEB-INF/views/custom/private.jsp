<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 个性定制开始 -->
	<form class="form-horizontal">
		<table class="table">

			<tr>
				<td>出行目的地</td>
				<td><label class="radio "> <input type="radio"
						name="radiosDestion" id="optionsRadios1" value="option1" checked>
						美国
				</label> <label class="radio "> <input type="radio"
						name="radiosDestion" id="optionsRadios1" value="option1" checked>
						澳大利亚
				</label></td>
			</tr>

			<tr>
				<td>出行城市</td>
				<td><label class="checkbox "> <input
						type="checkbox" id="Checkbox1" value="option1"> 迈阿密
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 旧金山
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 悉尼
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 昆士兰
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 旧金山
				</label></td>
			</tr>

			<tr>
				<td>出发日期</td>
				<td>


					<div class="accordion-heading span9"></div>
					<div class="input-append date form_datetime">
						<span class="add-on"> <i class="icon-calendar"></i></span><input
							size="16" type="text" id="startDatePrice" value="2014-07-25"
							name="startDate" onchange="getPrice();" class="input-medium"
							readonly="" style="background-color: white;">
					</div> <script type="text/javascript">
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
					</script>


				</td>
			</tr>

			<tr>
				<td>出行人员</td>
				<td style="text-align: left;">
					<div class="">
						成年人：<input id="del" class="" type="button" value="-"
							onclick="but('-1')"> <input type="text" id="number"
							class="input-mini" name="number" value="2" placeholder="数量"
							onchange="getPrice()"> <input id="plus" class=""
							type="button" value="+" onclick="but('1')"> <br />
						儿&nbsp;&nbsp;&nbsp;童：<input id="del" class="" type="button"
							value="-" onclick="but('-1')"> <input type="text"
							id="number" class="input-mini" name="number" value="2"
							placeholder="数量" onchange="getPrice()"> <input id="plus"
							class="" type="button" value="+" onclick="but('1')"> <br />
						老年人：<input id="del" class="" type="button" value="-"
							onclick="but('-1')"> <input type="text" id="number"
							class="input-mini" name="number" value="2" placeholder="数量"
							onchange="getPrice()"> <input id="plus" class=""
							type="button" value="+" onclick="but('1')">
					</div>
				</td>
			</tr>


			<tr>
				<td>航空要求</td>
				<td><label class="checkbox "> <input
						type="checkbox" id="Checkbox2" value="option2">
						阿联酋航空
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 大韩航空
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 中国南方航空
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 新加坡航空
				</label> <label class="checkbox "> <input type="checkbox"
						id="Checkbox2" value="option2"> 香港国泰航空
				</label> <br /> <label class="radio "> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="option1"
						checked> 经济舱
				</label> <label class="radio "> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="option1"
						checked> 公务舱
				</label> <label class="radio "> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="option1"
						checked> 头等舱
				</label></td>
			</tr>

			<tr>
				<td>出行天数</td>
				<td style="text-align: left;">
					<div class="">
						<input id="del" class="" type="button" value="-"
							onclick="but('-1')"> <input type="text" id="number"
							class="input-mini" name="number" value="2" placeholder="数量"
							onchange="getPrice()"> <input id="plus" class=""
							type="button" value="+" onclick="but('1')">
					</div>
				</td>
			</tr>


			<tr>
				<td>出行方式</td>
				<td><label class="radio "> <input type="radio"
						name="radiosTripMode" id="optionsRadios1" value="option1" checked>
						自驾
				</label> <label class="radio "> <input type="radio"
						name="radiosTripMode" id="optionsRadios1" value="option1" checked>
						非自驾
				</label></td>
			</tr>

			<tr>
				<td>车型选择</td>
				<td>
					<table>
						<tr>
							<td><select multiple="multiple">
									<option>SUV</option>
									<option selected>房车</option>
									<option>跑车</option>
							</select></td>
							<td><img
								src="http://img4.cache.netease.com/auto/2014/7/25/2014072510240718524.jpg"
								style="width: 300px;">
								</div></td>
					</table>

				</td>
			</tr>


			<tr>
				<td>酒店需求</td>
				<td><select>
						<option>星级</option>
						<option>三星</option>
						<option>四星</option>
						<option>五星</option>
				</select> <!--
<select>
		<option>当地</option>
		<option>国际</option>
</select>
--> <select>
						<option>位置</option>
						<option>市区</option>
						<option>郊区</option>
				</select></td>
			</tr>


			<tr>
				<td>房型需求</td>
				<td>
					<div class="">
						标准间：<input id="del" class="" type="button" value="-"
							onclick="but('-1')"> <input type="text" id="number"
							class="input-mini" name="number" value="2" placeholder="数量"
							onchange="getPrice()"> <input id="plus" class=""
							type="button" value="+" onclick="but('1')"> <br />
						套&nbsp;&nbsp;&nbsp;间：<input id="del" class="" type="button"
							value="-" onclick="but('-1')"> <input type="text"
							id="number" class="input-mini" name="number" value="2"
							placeholder="数量" onchange="getPrice()"> <input id="plus"
							class="" type="button" value="+" onclick="but('1')"> <br />
						大床房：<input id="del" class="" type="button" value="-"
							onclick="but('-1')"> <input type="text" id="number"
							class="input-mini" name="number" value="2" placeholder="数量"
							onchange="getPrice()"> <input id="plus" class=""
							type="button" value="+" onclick="but('1')">
					</div>
				</td>
			</tr>


			<tr>
				<td>用餐需求</td>
				<td><select multiple="multiple">
						<option>陆行摄安排</option>
						<option>自理</option>
				</select> <select multiple="multiple">
						<option>中餐</option>
						<option>西餐</option>
				</select></td>
			</tr>

			<tr>
				<td>个人信息</td>
				<td style="text-align: left;">

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i></span> <input
								type="text" name="inputName" placeholder="您的姓名">

						</div>
						<span>请填写您的真实姓名</span>
					</div>

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-star"></i></span> <input
								type="text" name="inputMobile" placeholder="您的手机号码">
						</div>
					</div>

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-envelope"></i></span> <input
								type="text" name="inputEmail" placeholder="您的电子邮件地址">
						</div>
					</div>

				</td>
			</tr>

			<tr>
				<td>其他需求</td>
				<td><label class="checkbox "> <input
						type="checkbox" value="">需要领队
				</label> <label class="checkbox "> <input type="checkbox"
						value="">要求购物
				</label></td>
			</tr>

			<tr>
				<td>其他服务</td>
				<td><label class="checkbox"> <input type="checkbox"
						value="">派对
				</label> <label class="checkbox"> <input type="checkbox" value="">狩猎（仅限澳大利亚）
				</label> <label class="checkbox"> <input type="checkbox" value="">海钓（有条件实现）
				</label> <label class="checkbox"> <input type="checkbox" value="">潜水（有条件实现）
				</label> <label class="checkbox"> <input type="checkbox" value="">野外（公园）烧烤
				</label> <label class="checkbox"> <input type="checkbox" value="">安排当地文化活动
				</label> <label class="checkbox"> <input type="checkbox" value="">移民考察
				</label> <label class="checkbox"> <input type="checkbox" value="">购房考察
				</label> <label class="checkbox"> <input type="checkbox" value="">酒庄品酒
				</label></td>
			</tr>

			<tr>
				<td>特别要求信息</td>
				<td><textarea rows="3"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" class="btn btn-primary" value="重置"></td>
			</tr>

		</table>

	</form>

	<!-- 个性定制结束 -->

</div>