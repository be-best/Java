	function ajax_post() {
		//创建异步对象
		var xhr = createXMLHttp();
		//设置状态改变的监听，回调函数，响应请求返回执行
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) { //请求发送成功
				if(xhr.status == 200) { //响应成功
					//获得响应数据
					var data = xhr.responseText;
					//将数据写到div中
					document.getElementById("id1").innerHTML = data;
				}
			}
		}
		//设置请求路径
		xhr.open("POST","/Web14/AjaxServlet1",true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//发送请求
		xhr.send("name=post&pass=123");
	}

//创建异步对象
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