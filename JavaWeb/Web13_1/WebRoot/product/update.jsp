<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="bull.utils.UUIDUtils" %>
<%@ page import="bull01.Product.ProductDomain.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
		<h1>商品修改</h1>
		<form action="${ pageContext.request.contextPath}/UpdateProductServlet" method="post">
		<!-- pid的值,修改的时候根据pid查找商品（update） -->
		
		<input type="hidden" name="pid" value="${ product.pid }"/>
			<table border="1px" width=500>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="${ product.pname }"></td>
			</tr>
			<tr>
				<td>市场价格</td>
				<td><input type="text" name="market_price" value="${ product.market_price }"></td>
			</tr>
			<tr>
				<td>商城价格</td>
				<td><input type="text" name="shop_price" value="${ product.shop_price }"></td>
			</tr>
			<tr>
				<td>是否热门</td>
				<td>
				<input type="radio" name="is_hot" value="1" <c:if test="${ product.is_hot == 1 }">checked</c:if> >是
				<input type="radio" name="is_hot" value="0" <c:if test="${ product.is_hot == 0 }">checked</c:if>>否
				</td>
			</tr>
			<tr>
				<td>是否下架</td>
				<td>
					<select name="pflag">
						<option value="0" <c:if test="${ product.pflag == 0 }">selected</c:if> >否</option>
						<option value="1" <c:if test="${ product.pflag ==1 }">selected</c:if> >是</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><textarea rows="10" cols="10" name="pdesc" >${ product.pdesc }</textarea></td>
			</tr>
			<tr>
				<td>商品分类</td>
				<td>
					<select name="cid" >
						<option value="1" <c:if test="${ product.cid == 1 }">selected</c:if> >手机数码</option>
						<option value="2" <c:if test="${ product.cid == 2 }">selected</c:if> >电脑办公</option>
						<option value="3" <c:if test="${ product.cid == 3 }">selected</c:if> >汽车用品</option>
						<option value="4" <c:if test="${ product.cid == 4 }">selected</c:if> >鞋靴箱包</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"></td>
			</tr>
		</table>
		</form>
  </body>
</html>
