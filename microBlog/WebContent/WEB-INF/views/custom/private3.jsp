<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:choose>
	<c:when test="${isMobile==true }">
		<s:url var="autoInfo" value="/show/spec?id="></s:url>
	</c:when>
	<c:otherwise>
		<s:url var="autoInfo" value="/custom/detail?id="></s:url>
	</c:otherwise>
</c:choose>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 个性定制开始 -->
	<script type="text/javascript">
		function trdipMode(obj) {
			//alert(obj.value);
			if (obj.value == "0")
				document.getElementById("autoSel").style.display = "block";
			else
				document.getElementById("autoSel").style.display = "none";
		}

		function check3() {
			if (sel_count("airCompany") <= 0) {
				alert("请选择您喜好的航空公司。");
				return false;
			}
			return true;
		}
	</script>
	<form class="form-horizontal" onsubmit="return check3()"
		action="${context }/custom/private/submit?step=3" method="post">
		<div class="alert alert-block">
			<h4>4/6 您对交通工具的要求？</h4>
		</div>
		<div class="control-group">
			<h3>航空要求</h3>
			<label class="radio inline"> <input type="radio"
				name="airCompany" id="optionsRadios1" value="可转机" checked> 可以转机
			</label> <label class="radio inline"> <input type="radio"
				name="airCompany" id="optionsRadios1" value="zhifei" >
				直飞
			</label> <br /> <label class="radio inline"> <input type="radio"
				name="radiosClassLevel" id="optionsRadios1" value="0" checked>
				经济舱
			</label> <label class="radio inline"> <input type="radio"
				name="radiosClassLevel" id="optionsRadios1" value="1">
				头等舱/公务舱
			</label>

			<h3>出行方式</h3>
			<label class="radio inline"> <input type="radio"
				name="radiosTripMode" value="0" onchange="trdipMode(this);" checked>
				自驾 &nbsp;<a target="_blank" href="${autoInfo}123">自驾车型参考</a>
			</label> <label class="radio inline"> <input type="radio"
				name="radiosTripMode" value="1" onchange="trdipMode(this);">
				非自驾 
			</label>

		</div>
		<div class="control-group">

			<input type="button" onclick="javascript:history.back();"
				class="btn btn-primary" value="返回">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" class="btn btn-primary" value="下一步">

		</div>
	</form>

	<!-- 个性定制结束 -->
</div>
