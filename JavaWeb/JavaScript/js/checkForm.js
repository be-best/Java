function checkForm() {
	//验证用户名
	var userName = document.getElementById("userName").value;
	if(userName == "") {
		alert("用户名不能为空！");
		return false;//表单不提交
	}
	
	//验证密码
	var password = document.getElementById("password").value;
	if(password == "") {
		alert("密码不能为空！");
		return false;
	}
	
	//再次验证密码
	var repassword = document.getElementById("repassword").value;
	if(repassword != password) {
		alert("两次密码不一致！");
		return false;
	}

	//验证邮箱
	/*
	 * JS中有两种匹配正则的方式:
	 * 使用String对象中的match方法.
	 * 使用正则对象中的test方法.
	 */
	var emali = document.getElementById("email").value;
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email)) {
		alert("邮箱格式不正确！");
		return false;
	}

}
