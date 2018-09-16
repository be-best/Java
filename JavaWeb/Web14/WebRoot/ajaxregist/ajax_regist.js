function checkUsername() {
	//设置异步请求
	var xhr = createXMLHttp();
	//获取文本框的值
	var username = document.getElementById("username").value;
	//回调函数
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				var data = xhr.responseText;
				if(data == 1) {
					document.getElementById("s1").innerHTML = "<font color='green'>用户名可用</font>";
				}
				if(data == 0) {
					document.getElementById("s1").innerHTML = "<font color='red'>用户名已被占用</font>";
				}
			}
		}
	}
	//设置请求路径
	xhr.open("GET","/Web14/AjaxRegistServlet?username="+username,true);
	//发送请求
	xhr.send(null);
}


function createXMLHttp() {
	var xmlHttp;
	try { // Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {// Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}

	return xmlHttp;
}