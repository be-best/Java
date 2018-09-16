$(function() {
	//为文本框绑定事件
	$("#content").keyup(function() {
		//获取文本框的值
		var content = $(this).val();
		//异步发送请求
		if(content != null) { //文本框有值
			$.post("/Web14/SearchServlet",{"content":content},function(data) {
				//将内容显示到div上
				$("#d1").show().html(data);
			});
		}
		else if (content == null) { //文本框没值
			//隐藏div
			$("#d1").hide();
		}
	});
});

