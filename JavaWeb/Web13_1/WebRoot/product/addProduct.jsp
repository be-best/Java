<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="bull.utils.UUIDUtils" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'appProduct.jsp' starting page</title>
    
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
  <%
  		//生成一个随机令牌
  		String token = UUIDUtils.getUUID();
  		//保存到session中
  		session.setAttribute("token", token);
   %>
	<form action="/Web13_1/AddProductServlet" method="post">
		<!-- 隐藏令牌 -->
		<input type="hidden" value="<%=token %>" name="token">
		<table border="1px" width=500>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>市场价格</td>
				<td><input type="text" name="market_price"></td>
			</tr>
			<tr>
				<td>商城价格</td>
				<td><input type="text" name="shop_price"></td>
			</tr>
			<tr>
				<td>是否热门</td>
				<td>
				<input type="radio" name="is_hot" value="1">是
				<input type="radio" name="is_hot" value="0">否
				</td>
			</tr>
			<tr>
				<td>是否下架</td>
				<td>
					<select name="pflag">
						<option value="0" selected>否</option>
						<option value="1">是</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><textarea rows="10" cols="10" name="pdesc"></textarea></td>
			</tr>
			<tr>
				<td>商品分类</td>
				<td>
					<select name="cid">
						<option value="1">手机数码</option>
						<option value="2">电脑办公</option>
						<option value="3">汽车用品</option>
						<option value="4">鞋靴箱包</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加"></td>
			</tr>
		</table>
	</form>
  </body>
</html>
