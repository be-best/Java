/**
 * get方法
 */
$(function() {
	$("#username").blur(function() {
		//获取文本框的值
		var username = $(this).val();
		//采用get方法
		$.get("/Web14/JqueryRegistServlet",{"username":username},function(data) {
			if(data == 1) {
				$("#s1").html("<font color='green'>用户名可用</font>");
				//设置注册按钮不可点击
				$("#regBut").attr("disabled",false);
			}
			else if(data == 0) {
				$("#s1").html("<font color='red'>用户名已被占用</font>");
				//设置注册按钮可以点击
				$("#regBut").attr("disabled",true);
			}
		});
	});
});


/**
 * load方法：
 * $(function() {
	$("#username").blur(function() {
		//获得文本框的值
		var username = $(this).val();
		//load方法
		$("#s1").load("/Web14/JqueryRegistServlet",{"username":username});
	});
});
*/
