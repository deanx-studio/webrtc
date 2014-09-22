<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js"
	type="text/javascript" charset="utf-8"></script>
<div class="container">
	<c:choose>
		<c:when test="${not empty msg}">
			<span class="label label-important">提示：</span>${msg}
					</c:when>
		<c:otherwise>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><h3>${title}</h3></td>
				</tr>
				<tr>
					<td style="height: 50px;">${makeTime
						}&nbsp;&nbsp;${writer}&nbsp;&nbsp; <!-- 
						<a
						href="weixin://contacts/profile/${weixinId}">${weixinName}</a>  
						--> <i style="position: absolute; padding-left: 10px;"> <wb:share-button
								appkey="6EvTuZ" addition="simple" type="button"></wb:share-button>
					</i>
					</td>
				</tr>
 
				<c:forEach var="item" items="${content_list}" varStatus="state">
					<tr id="special_${item.hashCode}">
						<td id="td_special_${item.hashCode}"
							style="font-size: 18px;text-align:${align};width:100%;line-height: 24px;"><c:choose>
								<c:when test="${not empty item.smart }">
									<img src="${item.smart}" style="max-width: 100%;" alt="网客来" />
									<br />
								</c:when>
							</c:choose> <h3>${item.title}</h3><h4>${item.subhead}</h4>${item.smart_text}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<%
							String openid = request.getParameter("openid");
									request.setAttribute("openid", "");
						%> <c:choose>
							<c:when test="${empty openid}">
								<td style="height: 60px;"></td>
							</c:when>
							<c:otherwise>
								<td><img src="${context}/resources/image/client/finger.gif"
									style="" alt="想走就走" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>

			</table>
		</c:otherwise>
	</c:choose>
	<div style="text-align: center;">
		<c:if test="${not empty prevSpecial }">
			<p class="text-left">
				上一篇：<a href="${context }/show/spec?id=${prevSpecial.id }">${prevSpecial.title
					}</a>
			</p>
		</c:if>
		<c:if test="${not empty nextSpecial }">
			<p  class="text-left">
				下一篇：<a href="${context }/show/spec?id=${nextSpecial.id }">${nextSpecial.title
					}</a>
			</p>
		</c:if>
		<!-- 
		<img src="${context }/resources/image/client/join_me.gif" /><br /> <img
			src="${context }/resources/image/client/xzjz_dingyue.jpg"
			style="width: 350px;" />
			 -->
	</div>
</div>



