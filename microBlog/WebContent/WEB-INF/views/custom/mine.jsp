<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">

	<!-- 个性定制开始 -->
	<form class="form-horizontal">
		<table class="table">

			<tr>
				<td style="min-width:100px;">个人信息</td>
				<td style="text-align: left;">

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i></span> <input
								type="text" name="inputName" placeholder="您的姓名"
								value="${p.userName }">

						</div>
						<span></span>
					</div>

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-star"></i></span> <input
								type="text" name="inputMobile" placeholder="您的手机号码"
								value="${p.mobile }">
						</div>
					</div>

					<div class="control-group">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-envelope"></i></span> <input
								type="text" name="inputEmail" placeholder="您的电子邮件地址"
								value="${p.email }">
						</div>
					</div>

				</td>
			</tr>
			<tr>
				<td>出行目的地</td>
				<td><label class="checkbox inline"> <input
						type="checkbox" name="radiosDestion" id="optionsRadios1"
						value="USA"
						<c:if test="${fn:contains(p.national,'USA') }">checked</c:if>>
						美国
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="radiosDestion" id="optionsRadios1" value="AUS"
						<c:if test="${fn:contains(p.national,'AUS') }">checked</c:if>>
						澳大利亚
				</label></td>
			</tr>

			<tr>
				<td>出行城市</td>
				<td><label class="checkbox inline"> <input
						type="checkbox" name="chkCity" value="maiami"
						<c:if test="${fn:contains(p.cities,'maiami') }">checked</c:if>>
						迈阿密
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="yanhucheng"
						<c:if test="${fn:contains(p.cities,'yanhucheng') }">checked</c:if>>
						盐湖城
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="lasiweijiasi"
						<c:if test="${fn:contains(p.cities,'lasiweijiasi') }">checked</c:if>>
						拉斯维加斯
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="luoshanji"
						<c:if test="${fn:contains(p.cities,'luoshanji') }">checked</c:if>>洛杉矶
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="newyork"
						<c:if test="${fn:contains(p.cities,'newyork') }">checked</c:if>>
						纽约
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="feicheng"
						<c:if test="${fn:contains(p.cities,'feicheng') }">checked</c:if>>
						费城
				</label><br /> <label class="checkbox inline"> <input
						type="checkbox" name="chkCity" value="huangshi"
						<c:if test="${fn:contains(p.cities,'huangshi') }">checked</c:if>>黄石公园
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="bulaisi"
						<c:if test="${fn:contains(p.cities,'bulasi') }">checked</c:if>>
						布莱斯国家公园
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="chkCity" value="jiujinshan"
						<c:if test="${fn:contains(p.cities,'jiujinshan') }">checked</c:if>>
						旧金山
				</label></td>
			</tr>

			<tr>
				<td>出发日期</td>
				<td>


					<div class="accordion-heading span9"></div>
					<div class="input-append date form_datetime">
						<span class="add-on"> <i class="icon-calendar"></i></span><input
							size="16" type="text" id="startDate" value="${p.startDate }"
							name="startDate" class="input-medium" readonly
							style="background-color: white;">
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
				<td>出行天数</td>
				<td style="text-align: left;">
					<div class="inline">
						<input class="" type="button" value="-"
							onclick="chgNumber('tripDays',-1)"> <input type="text"
							id="tripDays" class="input-mini" name="tripDays"
							value="${p.tripDays }"> <input type="button" value="+"
							onclick="chgNumber('tripDays',1)">
					</div>
				</td>
			</tr>


			<tr>
				<td>出行人员</td>
				<td style="text-align: left;">
					<div class="">
						成年人：<input class="" type="button" value="-"
							onclick="chgNumber('adultNumber', -1)"> <input
							type="text" id="adultNumber" class="input-mini"
							name="adultNumber" value="${p.adultPerson }"> <input
							id="plus" class="" type="button" value="+"
							onclick="chgNumber('adultNumber',1)">&nbsp;&nbsp;&nbsp;
						儿童：<input class="" type="button" value="-"
							onclick="chgNumber('childrenNumber', -1)"> <input
							type="text" id="childrenNumber" class="input-mini"
							name="childrenNumber" value="${p.childrenPerson }"> <input
							class="" type="button" value="+"
							onclick="chgNumber('childrenNumber', 1)">&nbsp;&nbsp;&nbsp;
						老年人：<input class="" type="button" value="-"
							onclick="chgNumber('oldNumber', -1)"> <input type="text"
							id="oldNumber" class="input-mini" name="oldNumber"
							value="${p.oldPerson }"> <input class="" type="button"
							value="+" onclick="chgNumber('oldNumber', 1)">
					</div>
				</td>
			</tr>

			<tr>
				<td>酒店需求</td>
				<td><select name="hotelLevel">
						<option value="0" <c:if test="${p.hotelLevel==0 }">selected</c:if>>星级</option>
						<option value="3" <c:if test="${p.hotelLevel==3 }">selected</c:if>>三星</option>
						<option value="4" <c:if test="${p.hotelLevel==4 }">selected</c:if>>四星</option>
						<option value="5" <c:if test="${p.hotelLevel==5 }">selected</c:if>>五星</option>
				</select> <select name="geogrophy">
						<option value="-"
							<c:if test="${p.hotelGeogrophy=='-' }">selected</c:if>>位置</option>
						<option value="city"
							<c:if test="${p.hotelGeogrophy=='city' }">selected</c:if>>市区</option>
						<option value="country"
							<c:if test="${p.hotelGeogrophy=='contry' }">selected</c:if>>郊区</option>
				</select></td>
			</tr>


			<tr>
				<td>房型需求</td>
				<td>
					<div class="">
						标准间：<input class="" type="button" value="-"
							onclick="chgNumber('standard',-1)"> <input type="text"
							id="standard" class="input-mini" name="standard"
							value="${p.standardNumber }"> <input class=""
							type="button" value="+" onclick="chgNumber('standard',1)">
						&nbsp;&nbsp;&nbsp; 套间：<input class="" type="button" value="-"
							onclick="chgNumber('adaptment', -1)"> <input type="text"
							id="adaptment" class="input-mini" name="adaptment"
							value="${p.adaptmentPerson }"> <input class=""
							type="button" value="+" onclick="chgNumber('adaptment',1)">
						&nbsp;&nbsp;&nbsp; 大床房：<input class="" type="button" value="-"
							onclick="chgNumber('king', -1)"> <input type="text"
							id="king" class="input-mini" name="king" value="${p.kingNumber }">
						<input class="" type="button" value="+"
							onclick="chgNumber('king',1)">
					</div>
				</td>
			</tr>

			<tr>
				<td>航空要求</td>
				<td><label class="checkbox inline"> <input
						type="checkbox" name="airCompany" value="alianqiu"
						<c:if test="${fn:contains(p.airCompany,'alianqiu') }">checked</c:if>>
						阿联酋航空
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="airCompany" value="dahan"
						<c:if test="${fn:contains(p.airCompany,'dahan') }">checked</c:if>>
						大韩航空
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="airCompany" value="nanfang"
						<c:if test="${fn:contains(p.airCompany,'nanfang') }">checked</c:if>>
						中国南方航空
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="airCompany" value="xinjiapo"
						<c:if test="${fn:contains(p.airCompany,'xinjiapo') }">checked</c:if>>
						新加坡航空
				</label> <label class="checkbox inline"> <input type="checkbox"
						name="airCompany" value="guotai"
						<c:if test="${fn:contains(p.airCompany,'guotai') }">checked</c:if>>
						香港国泰航空
				</label> <br /> <label class="radio inline"> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="0"
						<c:if test="${p.airClass==0 }">checked</c:if>> 经济舱
				</label> <label class="radio inline"> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="1"
						<c:if test="${p.airClass==1 }">checked</c:if>> 公务舱
				</label> <label class="radio inline"> <input type="radio"
						name="radiosClassLevel" id="optionsRadios1" value="2"
						<c:if test="${p.airClass==2 }">checked</c:if>> 头等舱
				</label></td>
			</tr>



			<tr>
				<td>出行方式</td>
				<td><label class="radio inline"> <input type="radio"
						name="radiosTripMode" id="optionsRadios1" value="0"
						<c:if test="${p.tripMode==0 }">checked</c:if>> 自驾
				</label> <label class="radio inline"> <input type="radio"
						name="radiosTripMode" id="optionsRadios1" value="1"
						<c:if test="${p.tripMode==1 }">checked</c:if>> 非自驾
				</label></td>
			</tr>

			<tr>
				<td>车型选择</td>
				<td>
					<table>
						<tr>
							<td><select name="autoModelType" multiple="multiple">
									<option value="SUV"
										<c:if test="${p.autoModel=='SUV' }">selected</c:if>>SUV</option>
									<option value="car"
										<c:if test="${p.autoModel=='car' }">selected</c:if>>房车</option>
									<option value="sport"
										<c:if test="${p.autoModel=='sport' }">selected</c:if>>跑车</option>
							</select></td>
							<!-- 
						<td><img
							src="http://img4.cache.netease.com/auto/2014/7/25/2014072510240718524.jpg"
							style="width: 300px;">
							</div></td>
							 -->
					</table>

				</td>
			</tr>





			<tr>
				<td>用餐需求</td>
				<td><select multiple="multiple" name="meat_sel">
						<option value="0"
							<c:if test="${p.mealProvider==0 }">selected</c:if>>旅行社安排</option>
						<option value="1"
							<c:if test="${p.mealProvider==1 }">selected</c:if>>自理</option>
				</select> <select multiple="multiple" name="meat_type">
						<option value="0" <c:if test="${p.mealType==0 }">selected</c:if>>中餐</option>
						<option value="1" <c:if test="${p.mealType==1 }">selected</c:if>>西餐</option>
				</select></td>
			</tr>




			<tr>
				<td>其他服务</td>
				<td><table>
						<tr>
							<td><input type="checkbox" value="leader" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'leader') }">checked</c:if>>需要领队</td>
							<td><input type="checkbox" value="shopping"
								name="elseService"
								<c:if test="${fn:contains(p.elseService, 'shopping') }">checked</c:if>>购物</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="party" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'party') }">checked</c:if>>派对</td>
							<td><input type="checkbox" value="hunting"
								name="elseService"
								<c:if test="${fn:contains(p.elseService, 'hunting') }">checked</c:if>>狩猎</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="fire" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'fire') }">checked</c:if>>实弹射击</td>
							<td><input type="checkbox" value="fishing"
								name="elseService"
								<c:if test="${fn:contains(p.elseService, 'fishing') }">checked</c:if>>海钓</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="diving" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'diving') }">checked</c:if>>潜水</td>
							<td><input type="checkbox" value="wild" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'wild') }">checked</c:if>>野外（公园）烧烤</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="local" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'local') }">checked</c:if>>安排当地文化活动</td>
							<td><input type="checkbox" value="immigrant"
								name="elseService"
								<c:if test="${fn:contains(p.elseService, 'immigrant') }">checked</c:if>>移民考察</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="house" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'house') }">checked</c:if>>购房考察</td>
							<td><input type="checkbox" value="wine" name="elseService"
								<c:if test="${fn:contains(p.elseService, 'wine') }">checked</c:if>>酒庄品酒</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</table></td>
			</tr>

			<tr>
				<td>特别要求信息</td>
				<td><textarea rows="3" name="memo">${p.memo }</textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" value="确认"></td>
			</tr>

		</table>

	</form>

	<!-- 个性定制结束 -->
</div>
