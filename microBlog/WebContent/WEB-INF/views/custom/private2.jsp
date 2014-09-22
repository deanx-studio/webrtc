<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<script type="text/javascript">
		function check2() {
			//alert('ddd');
			var adult = parseInt(g('adultNumber').value);
			var children = parseInt(g('childrenNumber').value);
			var old = parseInt(g('oldNumber').value);

			if (adult == 0 && children == 0 && old == 0) {
				alert("请重新选择人员组成。");
				return false;
			}
			var sel = g("hotelLevel");
			var level = parseInt(sel.options[sel.options.selectedIndex].value);
			//alert(level);
			if (level == 0) {
				alert("请重新选择满意的酒店星级。");
				return false;
			}
			sel = g('geogrophy');
			var geo = sel.options[sel.options.selectedIndex].value;
			//alert(geo);
			/*if (geo == '-') {
				alert("请重新选择喜好的酒店地理位置。");
				return false;
			}*/

			var standard = parseInt(g('standardNumber').value);
			var adaptment = parseInt(g('adaptmentNumber').value);
			var king = parseInt(g('kingNumber').value);
			//alert(standard + adaptment + king);
			if (standard == 0 && adaptment == 0 && king == 0) {
				alert("请重新选择房型需求。");
				return false;
			}
			return true;
		}
	</script>
	<!-- 个性定制开始 -->
	<form class="form-horizontal" onsubmit="return check2()"
		action="${context }/custom/private/submit?step=2" method="post">
		<div class="alert alert-block">
			<h4>3/6 有哪些人跟您一起去，您对住宿有什么要求？</h4>
		</div>
		<div class="control-group">

			<h3>人员组成</h3>

			<div class="inline">
				成年人：<input class="" type="button" value="-"
					onclick="chgNumber('adultNumber',-1)"> <input type="text"
					id="adultNumber" class="input-mini" name="adultNumber" value="0">
				<input id="plus" class="" type="button" value="+"
					onclick="chgNumber('adultNumber',1)">
				<c:if test="${isMobile==true }">
					<br />
				</c:if>
				儿&nbsp;&nbsp;&nbsp;&nbsp;童：<input class="" type="button" value="-"
					onclick="chgNumber('childrenNumber',-1)"> <input
					type="text" id="childrenNumber" class="input-mini"
					name="childrenNumber" value="0"> <input class=""
					type="button" value="+" onclick="chgNumber('childrenNumber',1)">
				<c:if test="${isMobile==true }">
					<br />
				</c:if>
				老年人：<input class="" type="button" value="-"
					onclick="chgNumber('oldNumber',-1)"> <input type="text"
					id="oldNumber" class="input-mini" name="oldNumber" value="0">
				<input class="" type="button" value="+"
					onclick="chgNumber('oldNumber',1)">
			</div>

			<h3>酒店星级要求</h3>
			<select name="hotelLevel" id="hotelLevel">
				<option value="0">星级</option>
				<option value="3">三星及以上</option>
				<option value="4">四星及以上</option>
				<option value="5">五星及以上</option>

			</select>
			<h3>酒店位置要求</h3>
			<select name="geogrophy" id="geogrophy">
				<option value="-">市区或郊区</option>
				<option value="city">市区</option>
				<option value="country">郊区</option>
			</select>
			<h3>房型需求</h3>

			<div class="inline">
				标准间：<input class="" type="button" value="-"
					onclick="chgNumber('standardNumber',-1)"> <input
					type="text" id="standardNumber" class="input-mini"
					name="standardNumber" value="0"> <input class=""
					type="button" value="+" onclick="chgNumber('standardNumber',1)">
				<c:if test="${isMobile==true }">
					<br />
				</c:if>
				套&nbsp;&nbsp;&nbsp;&nbsp;间：<input class="" type="button" value="-"
					onclick="chgNumber('adaptmentNumber',-1)"> <input
					type="text" id="adaptmentNumber" class="input-mini"
					name="adaptmentNumber" value="0"> <input class=""
					type="button" value="+" onclick="chgNumber('adaptmentNumber',1)">
				<c:if test="${isMobile==true }">
					<br />
				</c:if>
				大床房：<input class="" type="button" value="-"
					onclick="chgNumber('kingNumber',-1)"> <input type="text"
					id="kingNumber" class="input-mini" name="kingNumber" value="0">
				<input class="" type="button" value="+"
					onclick="chgNumber('kingNumber',1)">
			</div>

		</div>
		<div class="control-group">

			<input type="button" onclick="javascript:history.back();"
				class="btn btn-primary" value="返回">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" class="btn btn-primary" value="下一步">

		</div>
	</form>

	<!-- 个性定制结束 -->
</div>
