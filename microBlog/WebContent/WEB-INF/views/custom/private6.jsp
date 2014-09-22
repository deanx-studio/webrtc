<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px;">
	<!-- 个性定制开始 -->
	<div class="alert alert-block">
		<h4>感谢您，填写定制信息</h4>
	</div>

	<div class="control-group">

		<p>我们已经记下您的要求，请保持通信方式畅通，客服人员会尽快与您联系。</p>
		<p>有疑问请致电4006910800转1，我们竭诚为您提供服务。</p>
	</div>

	<div class="control-group">

		<input type="button" class="btn btn-primary" value="查询定制信息"
			onclick="location.href='${context}/custom/mine?sid=${sid }'">

	</div>

	<!-- 个性定制结束 -->

</div>