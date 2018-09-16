<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<div class="container">
	<div style=" text-align: center;top: 0;left: 0;right: 0;bottom: 0;">
		<!-- <h1>哇哦，恭喜您注册成功！</h1>
		<h1>欢迎新机友加入搞机Store</h1> -->
		<h1 style="color:red">搞机Store官方贺电</h1>
		<h3>您的订单："<span style="color:green">${ msg1 }</span>"付款成功！</h3>
		<h3>付款金额为：<span style="color:red">￥${ msg2 }</span>元！恭喜您喜提新装备！欢迎您继续剁手！</h3>
		${ msg3 }
				
		
		<%-- <h3><a href="${ pageContext.request.contextPath }/index.jsp">首页</a></h3>
		<h3><a href="${ pageContext.request.contextPath }/UserServlet?method=loginUI">登录</a></h3>
		<h3><a href="${ pageContext.request.contextPath }/UserServlet?method=registUI">注册</a></h3> --%>
	</div>
	</div>
	
	<div style="margin-top:50px;">
			<img src="${ pageContext.request.contextPath }/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

			<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
				<li><a href="${ pageContext.request.contextPath }/admin/index.jsp">管理员权限</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2018  搞机Store 版权所有
		</div>
</body>
</html>