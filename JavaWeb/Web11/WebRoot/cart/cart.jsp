<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<h1>购物车列表</h1>
   	<%
   		Map<String,Integer> map = (Map<String,Integer>)request.getSession().getAttribute("cart");
   		for(String product:map.keySet()) {
   			//获取购物车商品数量,一个product输出一次
   			Integer count = map.get(product);
   	 %>
   	 	<h3>您购买的商品是：<%=product %>  商品数量为：<%=count %></h3>
   	 <%
   	 	}
   	  %>
  </body>
</html>
