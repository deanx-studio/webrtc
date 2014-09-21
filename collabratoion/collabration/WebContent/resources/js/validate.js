//判断str是否为空，如果为空，则显示errorMessage,并返回false，如果不为空，则返回true
function isNotNull(str, errorMessage) {

	if (str.replace(/(^\s*)/g, "") == "") {

		alert(errorMessage);

		return false;
	}

	return true;

}

// 判断str是否为数字，如果不是返回假，否则返回真
function isStrNumber(str, errorMessage) {

	var r = /^\d+$/;

	if (r.test(str) == false) {
		alert(errorMessage);
		return false;
	}
	return true;

}

function isStr(str, errorMessage) {

	var r = /^\d+$/;

	if (r.test(str) == true) {
		alert(errorMessage);
		return true;
	}
	return false;

}

// 验证是否为正确的手机号码
function isValidatePhone(str) {

	var myreg = /^(((13[0-9]{1})|159|(15[0-9]{1}))+\d{8})$/;
	if (!myreg.test(str)) {
		alert("请输入正确的手机号码");
		return false;
	}
	return true;
}

// 判断两个字符是否相等
function isSame(str, str1, errorMessage) {

	if (str != str1) {

		alert(errorMessage);
		return false;
	}

	return true;
}

function CheckMobile(obj, errorMessage) {
	var pattern = /^(?:13\d|15[89])-?\d{5}(\d{3}|\*{3})$/;

	if (!pattern.test(obj.value)) {
		showMsg(errorMessage);
		return false;

	}

	return true;
}
