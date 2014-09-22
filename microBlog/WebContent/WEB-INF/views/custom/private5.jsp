<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<script type="text/javascript">
		function check5() {
			if (g("userName").value.length <= 0) {
				alert("请填写您的真实姓名！");
				return false;
			}
			if (g("userMobile").value.length != 11) {
				alert("请输入正确的手机号码，便于我们能及时与您联系！");
				return false;
			}

			return true;
		}
	</script>
	<!-- 个性定制开始 -->
	<form class="form-horizontal" onsubmit="return check5()"
		action="${context }/custom/private/submit?step=5" method="post">
		<div class="alert alert-block">
			<h4>6/6 您还有其他特别要求吗？</h4>
		</div>
		<div class="control-group">
			<h3>个人信息</h3>
			<div class="control-group">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-user"></i></span> <input
						type="text" id="userName" name="userName" placeholder="您的姓名">

				</div>
				<span>请填写您的真实姓名</span>
			</div>

			<div class="control-group">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-star"></i></span> <input
						type="text" name="userMobile" id="userMobile" placeholder="您的手机号码">
				</div>
				<span>方便我们能找到您</span>
			</div>

			<div class="control-group">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i></span> <input
						type="text" name="userEmail" placeholder="您的电子邮件地址">
				</div>
				<span>通过电子邮件寄给您详细资料</span>
			</div>


		</div>
		<div class="control-group">

			<input type="button" onclick="javascript:history.back();"
				class="btn btn-primary" value="返回">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" class="btn btn-primary" value="最后一步">

		</div>
	</form>

	<!-- 个性定制结束 -->
</div>
