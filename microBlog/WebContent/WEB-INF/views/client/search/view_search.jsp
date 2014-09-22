<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<s:url var="resource" value="/resources"></s:url>
<s:url var="go_pay" value="/order/go_pay"></s:url>
<s:url var="home" value="/home" />
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<%-- <li><a href="${complaint_ui}">个人中心</a> <span class="divider">/</span></li> --%>
	<li class="active">景区导览</li>
</ul>
<h3>景区搜索</h3>
<div class="page-head">
	<s:url var="searchurl" value="/search/do_view"></s:url>
	<form id="view_search_form" action="${searchurl}" method="post">
		<table>
			<tr>
				<td width="80px;"><select id="province" name="province"
					class="form-control">
						<option value="0"></option>
				</select></td>
				<td width="80px;"><select id="city" name="city"
					class="form-control">
						<option value="0"></option>
				</select></td>
				<td><select id="district" name="district" class="form-control">
						<option value="0"></option>
				</select></td>
				<td><input type="hidden" value="340000" id="pre_province" /> <input
					type="hidden" value="340400" id="pre_city" /> <input type="hidden"
					value="0" id="pre_district" /></td>

				<td class="navbar-form navbar-right"><table>
						<tr>
							<td>
								<button type="submit" class="btn btn-success">
									<img alt="" style="height: 20px;"
										src="${resource}/image/client/search.jpg">
								</button>
							</td>
							<td><input id="test" type="button" value="play" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	$('#test').click(function() {
		var search_form = $('#view_search_form');

		var province_val = $('#province').find('option:selected').text();
		var city_val = $('#city').find('option:selected').text();
		var district_val = $('#district').find('option:selected').text();

		$('#province').prop("province", province_val);
		alert($('#province').find('option'));
		alert($('#province').find('option:selected').val());
		search_form.submit();
	});
</script>
<script type="text/javascript"
	src="${resource}/js/json-array-of-city.js"></script>
<script type="text/javascript"
	src="${resource}/js/json-array-of-province.js"></script>
<script type="text/javascript"
	src="${resource}/js/json-array-of-district.js"></script>
<script type="text/javascript">
	var jsonProvince = "${resource}/js/json-array-of-province.js";
	var jsonCity = "${resource}/js/json-array-of-city.js";
	var jsonDistrict = "${resource}/js/json-array-of-district.js";
	$(function() {
		var citySelector = function() {
			var province = $("#province");
			var city = $("#city");
			var district = $("#district");
			var preProvince = $("#pre_province");
			var preCity = $("#pre_city");
			var preDistrict = $("#pre_district");

			var hasDistrict = true;
			var initProvince = "<option value='0'>请选择省份</option>";
			var initCity = "<option value='0'>请选择城市</option>";
			var initDistrict = "<option value='0'>请选择区县</option>";
			return {
				Init : function() {
					var that = this;
					that._LoadOptions(jsonProvince, preProvince, province,
							null, 0, initProvince);
					province.change(function() {
						that._LoadOptions(jsonCity, preCity, city, province, 2,
								initCity);
					});
					if (hasDistrict) {
						city.change(function() {
							that._LoadOptions(jsonDistrict, preDistrict,
									district, city, 4, initDistrict);
						});
						province.change(function() {
							city.change();
						});
					}
					province.change();
				},
				_LoadOptions : function(datapath, preobj, targetobj, parentobj,
						comparelen, initoption) {
					$.get(datapath, function(r) {
						var t = ''; // t: html容器 
						var s; // s: 选中标识 
						var pre; // pre: 初始值 
						if (preobj === undefined) {
							pre = 0;
						} else {
							pre = preobj.val();
						}

						for ( var i = 0; i < r.length; i++) {
							s = '';
							if (comparelen === 0) {
								if (pre !== "" && pre !== 0
										&& r[i].code === pre) {
									s = ' selected=\"selected\" ';
									pre = '';
								}
								t += '<option value=' + r[i].code + s + '>'
										+ r[i].name + '</option>';//r[i].code:为了接收属性而替换为r[i].name
							} else {
								var p = parentobj.val();
								if (p.substring(0, comparelen) === r[i].code
										.substring(0, comparelen)) {
									if (pre !== "" && pre !== 0
											&& r[i].code === pre) {
										s = ' selected=\"selected\" ';
										pre = '';
									}
									t += '<option value=' + r[i].code + s + '>'//这儿的留意
											+ r[i].name + '</option>';
								}
							}

						}
						if (initoption !== '') {
							targetobj.html(initoption + t);
						} else {
							targetobj.html(t);
						}
					}, "json");
				}
			};
		}();
		citySelector.Init();
	});
</script>
