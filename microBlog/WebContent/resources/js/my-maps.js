/**
 * 测试坐标
 */
var ourCoords = {
		latitude:41.051226,
		longitude:116.328179
};

var watchId = null;
/**
 * 全局变量 map
 */
var map;
window.onload=getMyLocation;
function getMyLocation(){
	if(navigator.geolocation){
		//navigator.geolocation.getCurrentPosition(displayLocation,displayError);
		//var watchButton = document.getElementById("watch");
		//watchButton.onclick=watchLocation;
		$('#watch').click(watchLocation);
		var clearWatchButton = document.getElementById("clearWatch");
		clearWatchButton.onclick = clearWatch;
	}else{
		alert("你好！你的浏览器目前不支持定位功能。");
	}
}

function watchLocation(){
	watchId = navigator.geolocation.watchPosition(displayLocation,displayError);
}

function clearWatch(){
	if(watchId){
		navigator.geolocation.clearWatch(watchId);
		watchId = null;
	}
}

/**
 * 
 * @param position
 */
function displayLocation(position){
	var latitude = position.coords.latitude;
	var longitude = position.coords.longitude;
	var div = document.getElementById("location");
	div.innerHTML = "你所在位置的经度:"+longitude+",纬度:"+latitude;

	//精度测试
	div.innerHTML = "你的精度:"+position.coords.accuracy;
	
	//与Wickedly Smart距离的测试
	var km = computeDistance(position.coords,ourCoords);
	var distance = document.getElementById("distance");
	distance.innerHTML = "我们与Wickedly Smart总部相距:"+km;
	
	//显示地图
	if(map == null){
		showMap(position.coords);
	}else{
		scrollMapToPosition(position.coords);
	}
}

/**
 * 
 * @param error
 */
function displayError(error){
	var errorTypes = {
			0:"未知的错误",
			1:"用户已拒绝该权限",
			2:"定位功能不可用",
			3:"请求超时"
	};
	var errorMessage = errorTypes[error.code];
	//对于0或者2时，有时会返回更多详细的信息
	if(error.code==0||error.code==2){
		errorMessage = errorMessage+" "+error.message;
	}
	var div = document.getElementById("location");
	div.innerHTML = errorMessage;
}
/**
 * 展示地图
 */
function showMap(coords){
	var googleLatAndLong = new google.maps.LatLng(coords.latitude,coords.longitude);
	var mapOptions = {
		zoom:10,
		center:googleLatAndLong,
		mapTypeId:google.maps.MapTypeId.ROADMAP
	};
	/**
	 * 从DOM树中获取到map(div)节点，并将mapOptions一起传入Map构造函数，创建google.maps.Map对象。
	 * 将在页面上展示。
	 */
	var mapDiv = document.getElementById("map");
	map = new google.maps.Map(mapDiv,mapOptions);
	
	//大头钉设置
	var title = "你在这里";
	var content = "这儿的坐标对应的纬度:"+coords.latitude+"经度："+coords.longitude;
	addMarker(map, googleLatAndLong, title, content);
}

function scrollMapToPosition(coords){
	var latitude = coords.latitude;
	var longitude = coords.longitude;
	var LatLong = new google.maps.LatLng(latitude,longitude); 
	map.panTo(LatLong);
	addMarker(map, latlong, "你的新地址","你移动到:"+latitude+" ,"+longitude);
}


/**
 * 使用半正矢(Haversine)公式计算两个坐标的距离
 * 
 * 该函数取两个坐标，一个起点坐标和一个终点坐标，并返回两者之间的距离(单位为千米).
 */
function computeDistance(startCoords,destCoords){
	var startLatRads=degreesToRadians(startCoords.latitude);
	var startLongRads=degreesToRadians(startCoords.longitude);
	var destLatRads=degreesToRadians(destCoords.latitude);
	var destLongRads=degreesToRadians(destCoords.longitude);
	var Radius = 6371;//地球的半径，单位：km
	var distance = Math.acos(Math.sin(startLatRads)*Math.sin(destLatRads)+
			Math.cos(startLatRads)*Math.cos(destLatRads)*Math.cos(startLongRads-destLongRads))*Radius;
	return distance;
}
function degreesToRadians(degrees){
	var radians = (degrees*Math.PI)/180;
	return radians;
}

/**
 * 创建标记
 * map 地图
 * latlong 谷歌样式的纬度和经度
 * title 标记的主题
 * content 信息窗口中内容
 */
function addMarker(map,latlong,title,content){
	var markerOptions = {
			position:latlong,
			map:map,
			title:title,
			clickable:true //这里设置为true，因为我们希望点击这个大头钉时显示一个信息窗口
	};
	
	var infoWindowOptions = {
			content:content,
			position:latlong
	};
	var marker = new google.maps.Marker(markerOptions);
	var infoWindow = new google.maps.InfoWindow(infoWindowOptions);
	
	google.maps.event.addListener(marker,"click",function(){
		infoWindow.open(map);
	});
}


