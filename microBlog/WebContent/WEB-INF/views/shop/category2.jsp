<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:url var="delete_news" value="/admin/article/delete"></s:url>

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">
		<h2>产品类别选择</h2>

		<c:forEach var="items" items="${cate_list}">
		<p>
		<c:choose>
		<c:when test="${step>=2 }">
						<a href="${context }/shop/upMainImg?cateId=${items.id }&pid=${pid}">${items.name
							}</a>
					</c:when>
		<c:otherwise>
		<a href="${context }/shop/category?cateId=${items.id }&step=${step}&pid=${pid}">${items.name }</a>
		</c:otherwise>
		</c:choose>
		</p>
		</c:forEach>

	</div>
</div>
