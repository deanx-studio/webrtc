<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 30px;"></div>
<div class="container" style="max-width: 960px; text-align: left;">
	<form class="form-search" action="${context }/drive/private/list">
		<h3>私人订制查询</h3>
		<select name="t">
			<option value="-1">搜索方式</option>
			<option value="0">手机号码</option>
			<option value="1">用户名</option>
		</select> <input name="context" type="text" class="input-medium search-query">
		<button type="submit" class="btn">搜索</button>
	</form>
</div>