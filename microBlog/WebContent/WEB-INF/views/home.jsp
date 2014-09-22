<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${context }/resources/custom/js/bootstrap-carousel.js"></script>
<div style="height: 15px;"></div>
<!--
//新的取值方法测试
<script type="text/javascript">
	function aaa() {
		alert(txtRealm.value);
	}
</script>
 
<input type="text" style="width: 100%; height: 100%" id="txtRealm" value="" placeholder="e.g. doubango.org" />
<input type="button" style="width: 100%; height: 100%"  value="aaa" onclick="aaa()" />
 -->
<div class="container" style="width:99%;">
	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide">
		<div class="carousel-inner">
			<div class="item ">
				<a href="${context }/custom/detail?id=119"><img
					src="${context }/resources/custom/images/slide-01.jpg" alt=""></a>
				<div class="container">
					<div class="carousel-caption">
						<h1 style="color: white;">美国西海岸、夏威夷12日浪漫之旅</h1>
						<p class="lead" style="color: gray;">真正的加州一号公路自驾路线；夏威夷欧胡岛大环岛游；热闹非凡的拉斯维加斯大道;</p>
						<!--
			  <a class="btn btn-large btn-primary" href="${context }/resources/custom/images/Carousel Template · Bootstrap.htm">Sign up today</a>
			  -->
					</div>
				</div>
			</div>
			<div class="item ">
				<a href="${context }/custom/detail?id=116"><img
					src="${context }/resources/custom/images/slide-02.jpg" alt=""></a>
				<div class="container">
					<div class="carousel-caption">
						<h1>美国西部大环线</h1>
						<p class="lead" style="color: gray;">大环线七大国家/部落公园观光；探索美国传奇公路-66号；美式巨无霸越野车自驾！专业自驾顾问全程陪同安全无忧。</p>

					</div>
				</div>
			</div>

			<div class="item active">
				<a href="${context }/custom/detail?id=115"><img
					src="http://xdujia.com/resources/media/201408/c09dc705c2aff207e4edbbe33f9f08b8.jpg"
					alt=""></a>
				<div class="container">
					<div class="carousel-caption">
						<h1>美国西海岸三城9日自驾体验之旅</h1>
						<p class="lead" style="color: gray;">旧金山-十七英里海岸-卡梅尔-大苏尔-丹麦城-拉斯维加斯-洛杉矶</p>

					</div>
				</div>
			</div>
			
		<div class="item">
			<a href="${context }/custom/detail?id=120"><img
				src="http://xdujia.com/resources/media/201408/fb5323bc9527de241e51fae3b46f2120.jpg" alt=""></a>
			<div class="container">
				<div class="carousel-caption">
					<h1>美东12日完美之旅去佛罗里达吧</h1>
					<p class="lead" style="color: gray;">佛罗里达双城及大沼泽国家公园+纽约曼哈顿岛住宿</p>

				</div>
			</div>
		</div>
		
			<div class="item">
				<a href="${context }/custom/detail?id=117"><img
					src="${context }/resources/custom/images/hawaii/hawaii_main.jpg"
					alt=""></a>
				<div class="container">
					<div class="carousel-caption">
						<h1>夏威夷7日精彩之旅</h1>
						<p class="lead" style="color: gray;">太平洋上的明珠-夏威夷</p>

					</div>
				</div>
			</div>

			<div class="item">
				<a href="${context }/custom/detail?id=118"><img
					src="${context }/resources/custom/images/huangshi05.jpg" alt=""></a>
				<div class="container">
					<div class="carousel-caption">
						<h1>黄石国家公园探秘之旅</h1>
						<p class="lead" style="color: gray;">著名的老忠实喷泉、大棱镜彩泉、黄石湖、黄石峡谷等多处著名景观。</p>

					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control"
			href="http://v2.bootcss.com/examples/carousel.html#myCarousel"
			data-slide="prev">‹</a> <a class="right carousel-control"
			href="http://v2.bootcss.com/examples/carousel.html#myCarousel"
			data-slide="next">›</a>
	</div>
</div>
<script type="text/javascript">
	$('#myCarousel').carousel();
	/*	!function($) {
	 $(function() {
	 // carousel demo
	
	 })
	 }(window.jQuery)*/
</script>
<!-- /.carousel -->