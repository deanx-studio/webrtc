<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<script type="text/javascript">
		function check0() {

			if (sel_count("radioNational") <= 0) {
				alert("请选择您想去的国家。");
				return false;
			}

			if (sel_count("chkCity") <= 0) {
				alert("请选择您想去城市或者景点。");
				return false;
			}
			return true;
		}
	</script>
	<!-- 个性定制开始 -->
	<form class="form-horizontal" onsubmit="return check0()"
		action="${context }/custom/private/submit?step=0" method="post">
		<div class="alert alert-block">
			<h4>1/6您此次出行的目的地是哪里？</h4>
		</div>
		<c:if test="${fn:length(msg)>0 }">
			<div class="alert alert-error">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${msg }
			</div>
		</c:if>
		<div class="control-group">
			<h3>出行国家</h3>
			<label class="checkbox "> <input type="checkbox"
				name="radioNational" value="USA" checked> 美国
			</label>
			<!-- 
		<label class="radio "> <input type="checkbox"
			name="radiosDestion" id="optionsRadios1" value="option1" checked>
			澳大利亚
		</label>
		 -->

		</div>
		<div class="control-group">
			<h3>城市或景区</h3>

			<label class="checkbox "> <input type="checkbox"
				name="chkCity" value="maiami"> 迈阿密
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="yanhucheng"> 盐湖城
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="lasiweijiasi"> 拉斯维加斯
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="luoshanji">洛杉矶
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="newyork"> 纽约
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="feicheng"> 费城
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="jiujinshan"> 旧金山
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="aolanduo"> 奥兰多
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="huashengdun"> 华盛顿
			</label> <br /> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="huangshi">黄石公园
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="bulaisi"> 布莱斯国家公园
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="daxiagu"> 大峡谷
			</label> <label class="checkbox "> <input type="checkbox"
				name="chkCity" value="lingyanggu"> 羚羊谷
			</label>

		</div>

		<div class="control-group">
			<h3>您此次旅行的目的？</h3>

			<label class="checkbox "> <input type="checkbox" name="goal"
				value="xiuxian"> 休闲度假
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="qinzi"> 亲子游
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="peilaoren"> 陪老人
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="miyue">蜜月游
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="touzi"> 投资移民考察
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="tanqin"> 探亲访友
			</label> <label class="checkbox "> <input type="checkbox" name="goal"
				value="liuxue"> 留学考察
			</label>

		</div>

		<div class="control-group">

			<input type="submit" class="btn btn-primary" value="下一步">

		</div>


	</form>

	<!-- 个性定制结束 -->
</div>
