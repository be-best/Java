function ajax_get(){
	//1.创建异步对象
	var xhr = createXMLHttp();
	//2.设置状态改变的监听，回调函数（服务器响应请求后返回执行该操作）
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) { //请求发送成功
			if(xhr.status == 200) { //响应成功
				//获得相应数据
				var data = xhr.responseText;
				//将数据写到div中
				document.getElementById("id1").innerHTML = data;
			}
		}
	}
	
	//3.设置请求路径
	xhr.open("GET","/Web14/AjaxServlet1?name=aaa&pass=123",true);
	//4.发送请求
	xhr.send(null);
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