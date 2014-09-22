var page_no = 1;
window.onload = function() {
	var loc = (document.location + "").split("=");
	if((typeof loc[1])!="undefined"){
		var temp =Number(loc[1]);
		if(!isNaN(temp)){
			page_no = temp;
		}
	}
	var url = "/travel-core/order/my/list?page_no=";
	// 上一页
	$("#older").click(function() {
		if(page_no>1){
			page_no = page_no-1;
			window.location = url+page_no;
		}else{
			alert("请点击下一页查看更多数据");
		}
	});

	// 下一页
	$("#newer").click(function() {
		page_no = page_no+1;
		window.location = url+page_no;
	});
};
