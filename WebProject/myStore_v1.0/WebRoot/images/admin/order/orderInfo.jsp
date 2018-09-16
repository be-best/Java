<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderInfo.jsp' starting page</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />
    
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
    <div class="container">
			<div class="row">

				<div style="margin:0 auto;margin-top:10px;width:950px;">
					<strong>订单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th colspan="5">订单编号:${ orders.oid } </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach var="orderItem" items="${ orders.orderItems }">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${ pageContext.request.contextPath }/${ orderItem.product.pimage }" width="70" height="60">
								</td>
								<td width="30%">
								    <p><a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${orderItem.product.pid }" style='color:blue'>${ orderItem.product.pname }</a></p>
									<%-- <a target="_blank"> ${ orderItem.product.pname } </a> --%>
								</td>
								<td width="20%">
									￥${ orderItem.product.shop_price }
								</td>
								<td width="10%">
									${ orderItem.count }
								</td>
								<td width="15%">
									<span class="subtotal">￥${ orderItem.subtotal }</span>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div style="text-align:right;margin-right:120px;">
					订单金额: <strong style="color:#ff6600;">￥${ orders.total }元</strong>
				</div>

			</div>
  </body>
</html>
