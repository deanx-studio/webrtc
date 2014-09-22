/*
function getXmlHttpRequest() {
	var xhr = null;
	if ((typeof XMLHttpRequest) != 'undefined') {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject('Microsoft.XMLHttp');
	}
	return xhr;
}
var loc = window.location.pathname;
$('#getvalidcode').click(function() {
	var xhr = getXmlHttpRequest();
	var temp = loc.length ? loc.split("/") : [];
	var send_loc = '/' + temp[1] + '/account/get_valid_code';
	var forget_mobile = $('#forget_mobile').val();
	var mobi = null;
	if ((typeof forget_mobile) != "undefined") {
		mobi = forget_mobile.trim();
	}
	if (mobi) {
		send_loc = send_loc + '?valid_mobile=' + mobi;
	}
	xhr.open('get', send_loc, true); // 必须添加一个消息头content-type
	
	xhr.onreadystatechange = function() {
		// 编写相应的处理代码
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var txt = xhr.responseText;
				$('#get_valid_info').text(txt);
			} else {
				$('#get_valid_info').text('系统错误，稍后重试');
			}
		} else {
			$('#get_valid_info').text('玩命发送...');
		}
	};
	xhr.send(null);
});
*/
function check_name(unameObj) {
	var uname = unameObj.value;
	var username_result = document.getElementById("username_result");
	var url = webRoot + "/sub/checkUname";
	if (uname.length == 0) {
		username_result.style.color = "red";
		username_result.innerText = "用户名不能为空。";
		return;
	}
	$.post(url, {
		"username" : uname
	}, function(data, status) {
		if (status == 'success')
			if (data == '0')// 用户已经存在
			{
				username_result.style.color = "red";
				username_result.innerText = "该用户名不可用。";
				unameObj.focus();
			} else {
				username_result.style.color = "green";
				username_result.innerText = "用户检查通过。";
			}
	});
}
function check_pwd(pwdConfirmObj) {
	var userPwd = document.getElementById("userPwd");
	var pwdConfirm_result = document.getElementById("pwdConfirm_result");
	// alert(userPwd.value.length);
	if (userPwd.value.length == 0 || pwdConfirmObj.value != userPwd.value) {
		pwdConfirm_result.style.color = "red";
		pwdConfirm_result.innerText = "密码和确认密码输入不一致请检查。";
		userPwd.focus();
	} else {
		pwdConfirm_result.style.color = "green";
		pwdConfirm_result.innerText = "密码检查通过。";
	}

}

function gotop() {
	$('body,html').animate({
		scrollTop : 0
	}, 1000);
}

function scroll_event(load) {

	if (document.body.scrollTop > 0 && load == 1) {
		// alert($('.shape'));
		$('.shape').css('display', '');
	} else {
		$('.shape').css('display', 'none');
	}
}
