<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<!-- 插入最终的功能页面 -->
		<table class="guide"
			style="cellSpacing: 0; cellPadding: 0; width: 100%; border: 0;">
			<tbody>
				<tr>
					<td><a href='#'>主页</a>&nbsp;/&nbsp; <a href='#'>图文设置</a>&nbsp;/&nbsp;热门推荐
					</td>
				</tr>
			</tbody>
		</table>
		<s:url var="recommend_do" value="/admin/article/recommend/action.do"/>
		<form action="${recommend_do}" method="post">
			<table>
				<tr>
					<td>改变:</td><td><input name="pointer"></td><td><input type="submit" value="发送"></td>
				</tr>
				
			</table>
		</form>
	</div>
	<!--/span-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
		role="navigation">
		<div class="list-group">
		<s:url var="list_article" value="/admin/article/list.do"/>
		<s:url var="add_article" value="/admin/article/add.do"/>
		<s:url var="recommend_article" value="/admin/article/recommend.do"/>
			<a href="${list_article}" class="list-group-item">列出可用图文</a> 
			<a href="${add_article}" class="list-group-item">添加</a> 
			<a href="${recommend_article}" class="list-group-item active">推荐</a> 
		</div>
	</div>
	<!--/span-->
</div>
<!--/row-->