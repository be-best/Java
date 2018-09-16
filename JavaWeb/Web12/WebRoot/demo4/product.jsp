<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
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
	<table border="1px" width="1000">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>是否热门</td>
			<td>商品描述</td>
		</tr>
		<c:forEach var="p" items="${ list }">
			<tr>
			<td>${ p.pid }</td>
			<td>${ p.pname }</td>
			<td>${ p.shop_price }</td>
			<td>
				<c:if test="${ p.is_hot == 1  }">
					是
				</c:if>
				<c:if test="${ p.is_hot == 0 }">
					否
				</c:if>
			</td>
			<td>${ p.pdesc }</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
