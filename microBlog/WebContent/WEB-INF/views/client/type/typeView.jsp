<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<s:url var="resource" value="/resources"></s:url>
<s:url var="home" value="/home" />
<s:url var="sub_enter" value="/sub/enter"></s:url>
<script type="text/javascript" src="${resource}/js/validate.js" charset="UTF-8"></script>
<!-- 
<div style="height: 60px;"></div>
<ul class="breadcrumb">
	<li><a href="${home}">主页</a> <span class="divider">/</span></li>
	<li><a href="${sub_enter}">在线订购</a> <span class="divider">/</span></li>
	<li class="active">支付详情</li>
</ul>
 -->
<s:url var="getPrice" value="/order/getPriceForDate.do"></s:url>
<s:url var="order_confirm" value="/order/confirm.do"></s:url>

<div class="container">
<h3>分类选择</h3>
<div class="row-fluid">
<ul class="thumbnails">
  <li class="span3">
  <div style="border:1px solid #ddd">
     
      <div class="caption" >
               <h3 style="color:blue;text-align:center;">采摘类</h3>
      </div>
     </div>
  </li>
  <li class="span3">
  <div style="border:1px solid #ddd">
     
      <div class="caption" >
               <h3 style="color:blue;text-align:center;">烧烤类</h3>
      </div>
     </div>
  </li>
  <li class="span3">
  <div style="border:1px solid #ddd">
     
      <div class="caption" >
               <h3 style="color:blue;text-align:center;">挖笋类</h3>
      </div>
     </div>
  </li>
  <li class="span3">
  <div style="border:1px solid #ddd">
     
      <div class="caption" >
               <h3 style="color:blue;text-align:center;">酒店类</h3>
      </div>
     </div>
  </li>
  <li class="span3">
  <div style="border:1px solid #ddd">
     
      <div class="caption" >
               <h3 style="color:blue;text-align:center;">采摘类</h3>
      </div>
     </div>
  </li>
</ul>
</div>

</div>

</body>
</html>