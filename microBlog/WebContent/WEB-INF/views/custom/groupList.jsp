<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div style="height: 00px;"></div>
<div class="container" style="max-width: 960px;">

	<style type="text/css">

/* Featurettes
    ------------------------- */
.featurette-divider {
	margin: 10px 0; /* Space out the Bootstrap <hr> more */
}

.featurette { //
	padding-top: 120px;
	/* Vertically center images part 1: add padding above and below text. */
	overflow: hidden;
	/* Vertically center images part 2: clear their floats. */
}

.featurette-image {
	margin-top: -10px;
	/* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
}

/* Give some space on the sides of the floated elements so text doesn't run right into it. */
.featurette-image.pull-left {
	margin-right: 40px;
}

.featurette-image.pull-right {
	margin-left: 40px;
}

/* Thin out the marketing headings */
.featurette-heading {
	font-size: 30px;
	font-weight: 300;
	line-height: 1;
	letter-spacing: -1px;
}

.lead {
	font-size: 16px;
}

.intro_text {
	
}
</style>

	<!-- START THE FEATURETTES -->
	<h2 id="title">即刻发团</h2>
	<!-- 
	<input id="touchMove" value="" /> <input id="touchStart" value="" />
 -->

	<table class="table">
		<c:forEach var="items" items="${groupList}" varStatus="status">
			<tr 
				<c:if test="${items.bookCount != items.totalCount }">
				style="cursor: pointer;"
				onclick="javascript:location.href='${context }/custom/order?productID=${items.productId}&gdate=${items.startDate }'"
				</c:if>>
				<td style="width: 80px; height: 80px;"><img src="${items.img }"
					style="width: 70px; height: 70px;" title="${items.productName}
					<c:if test="${items.bookCount == items.totalCount }">[已满]
					</c:if>
					"></td>
				<td style="line-height: 25px; font-size: 14px;">发团日期：<span
					style="font-size: 16px; color: red;">${items.startDate }</span><br />
					产品名称：${items.productName }
					<c:if test="${items.bookCount == items.totalCount }">
					<br/>
					<span style="color:red">[已满]</span>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- /END THE FEATURETTES -->
</div>
<script type="text/javascript">
	/*
	 * 作者：程序员老刘
	 * 功能：计算手指在指定标签上的滑动的方向
	 */
	var tagId = "title";
	var pressX = 0, pressY = 0;
	var obj = document.getElementById(tagId);
	obj.addEventListener('touchmove', function(event) {
		// 如果这个元素的位置内只有一个手指的话
		if (event.targetTouches.length == 1) {
			var touch = event.targetTouches[0];
			var spanX = touch.pageX - pressX;
			var spanY = touch.pageY - pressY;
			var direct = "none";
			if (Math.abs(spanX) > Math.abs(spanY)) {
				//水平方向
				if (spanX > 0) {
					direct = "right";//向右
					//do right function
				} else {
					direct = "left";//向左
					//do left function
				}
			} else {
				//垂直方向
				if (spanY > 0) {
					direct = "down";//向下
					//do down function
				} else {
					direct = "up";//向上
					//do up function
				}
			}
			// 把元素放在手指所在的位置
			touchMove.value = direct;// + "(" + spanX + ';' + spanY + ")";
		}
	}, false);

	obj.addEventListener('touchstart', function(event) {
		// 如果这个元素的位置内只有一个手指的话
		if (event.targetTouches.length == 1) {
			var touch = event.targetTouches[0];
			// 把元素放在手指所在的位置
			pressX = touch.pageX;
			pressY = touch.pageY;

			touchStart.value = pressX + ';' + pressY;
		}
	}, false);

	/*
	obj.addEventListener('touchend', function(event) {
		// 如果这个元素的位置内只有一个手指的话
		if (event.targetTouches.length == 1) {
			var touch = event.targetTouches[0];
			// 把元素放在手指所在的位置
			touchEnd.value=touch.pageX + ';' + touch.pageY;
		}
	}, false);
	 */

	
</script>