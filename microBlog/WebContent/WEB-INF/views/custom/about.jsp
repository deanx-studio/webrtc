<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="height: 10px;"></div>

<style type="text/css">
body { <
	c: choose> 
	<c:when test="${isMobile == true}"> 
	padding-top:  0px; </
	c: when> 
	<c:otherwise> 
	padding-top:  60px; </
	c: otherwise> 
	</c:choose> 
	
	padding-bottom:  40px;
	font-family: "Microsoft YaHei";
	background-color: #FCFDEF;
}
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
<div class="container" style="max-width: 960px;">
	<!-- START THE FEATURETTES -->
	<h2>关于冠行</h2>
	<hr class="featurette-divider">
	<div class="featurette">
		<img class="featurette-image pull-left"
			src="${context }/resources/custom/images/about/intro.png"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">俱乐部介绍</span>
			</h2>
			<p class="lead">冠行俱乐部是由一帮不愿意受拘束，追求人格独立和心性自由的旅行爱好者创建的结伴出行、旅行交友和旅游经验分享平台。我们凭借庞大的会员规模，和国内外旅行社、航空公司、租车公司及酒店联盟等旅行相关机构合作，根据自己的特定需求，从路线、方式、服务和价格着手，为会员量身定制最自由、最舒适，最省钱的旅行，诠释旅行新概念。</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="featurette">
		<img class="featurette-image pull-right"
			src="${context }/resources/custom/images/about/main.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">公司介绍</span>
			</h2>
			<p class="lead">冠行是北京青年旅行社股份有限公司旗下的自驾游品牌,有别于传统的集体参团旅游,我们出行的方式一般是小团体自驾游或半自驾游（巴士与自驾车结合），具有行程自由化与个性化、灵活性与舒适性等特点。我们的客户是不愿意受拘束,追求人格独立和心性自由的旅行者。</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="featurette">
		<img class="featurette-image pull-left"
			src="${context }/resources/custom/images/about/free.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">自由的旅行</span>
			</h2>
			<p class="lead">冠行倡导的旅行不是上车睡觉、下车拍照、只能跟着导游小旗走马观花的旅游。我们抛开旅游大巴和几十人一车的拥挤，开着自己的车，想去哪儿就去哪儿，自由无羁！</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="featurette">
		<img class="featurette-image pull-right"
			src="${context }/resources/custom/images/about/safe.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">安全的旅行</span>
			</h2>
			<p class="lead">冠行的出行方式一般是有引导的自驾游或半自驾游。车队由两、三辆全尺寸越野车组成。头车是导航车，由特聘资深领队驾驶，其他车由驾驶经验丰富，并通过培训和测试的游客驾驶。不会开车或不愿开车的人无需驾车。这样，即保证了自由的行程，又不用担心安全或迷路问题。</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="featurette">
		<img class="featurette-image pull-left"
			src="${context }/resources/custom/images/about/pure.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">纯粹的旅行</span>
			</h2>
			<p class="lead">旅游商店购物和强迫增加自费项目是目前旅游市场最大的病垢。冠行出品的所有行程和费用完全透明，谢绝团费陷阱和旅游购物欺骗，还原旅游本身的享受性和探索性。让大家有一个真正自由、轻松、享受的品质假期！</p>
		</div>
	</div>
	<div class="featurette">
		<img class="featurette-image pull-right"
			src="${context }/resources/custom/images/about/save0.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">省钱的旅行绍</span>
			</h2>
			<p class="lead">散客和团队的价格就像零售价和批发价，在同等标准的交通和住宿情况下，以旅行社的身份，向航空公司、租车公司及酒店连忙等机构预订服务，自然比个人作为散客直接预订要获得更大的折扣。冠行出行最大的优势是，能享受机票、酒店的团队价，同时又不影响出行品质。</p>
		</div>
	</div>
	<div class="featurette">
		<img class="featurette-image pull-left"
			src="${context }/resources/custom/images/about/spec.jpg"
			style="height: 250px;">
		<div class="intro_text">
			<h2 class="featurette-heading">
				<span class="muted">特色的旅行</span>
			</h2>
			<p class="lead">在国外旅行时，体验各种美食、酒吧或去当地居民家访问一直是冠行会员热衷的方式。相同的目的地旅行，在我们的方式下永远表现的更有意思。</p>
		</div>
	</div>
	<!-- /END THE FEATURETTES -->
</div>



<div class='span12'>
	<!-- <h5 style='font-size: 20px; margin-top: 10px;'></h5>  -->
	<div>
		<span style='font-size: 14px; float: left;'></span><span
			style='float: right;'><a
			style='background-color: #f60; color: white;'
			class='btn btn-lg active'
			href='http://www.xdujia.com/custom/order?productID=&gDate='>报名</a></span>
	</div>
</div>