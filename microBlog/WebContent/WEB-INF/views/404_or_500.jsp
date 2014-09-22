<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" 
	uri="http://www.springframework.org/security/tags"%>
<s:url var="resource" value="/resources" />
<s:url var="home" value="/home" />
<s:url var="sub_enter" value="/sub/enter"></s:url>
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><h3><a href="${home}">回到主页</a></h3></li>
</ul>
<div class="row">
	<div class="col-md-12">
		<div class="thumbnail">
			<h2>${exception.content}</h2>
			<div class="caption">
				<img alt="600x200" width="100%" height="100%" src="${resource}${exception.src}" />
			</div>
		</div>
	</div>
</div>