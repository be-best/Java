<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>我的订单</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body> 
		<%@ include file="menu.jsp" %>

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
					
					<!-- 订单的循环 -->
					<c:forEach var="order" items="${ pageBean.list }">
						
						<tbody>
							<tr class="success">
								
									
									 <th colspan="2">订单编号:${ order.oid } &nbsp;&nbsp;&nbsp; </th>
									 <th colspan="2">
									 <c:if test="${ order.state == 1 }">
										 <c:if test="${ order.total == 0.0 }"><span style="color:red">订单中有商品已下架</span></c:if>
										 <c:if test="${ order.total != 0.0 }">
										 <a href="${ pageContext.request.contextPath }/OrderServlet?method=findOrderByOid&oid=${ order.oid }">
												<button type="button" class="btn btn-info btn-sm" id="add" name="add">去付款</button>
										 </a>
										 </c:if>
									 </c:if>
									<c:if test="${ order.state == 2 }"><span style="color:blue">卖家未发货</span></c:if>
									<c:if test="${ order.state == 3 }">
									 	<a href="${ pageContext.request.contextPath }/OrderServlet?method=confirmGoods&oid=${ order.oid }&currPage=${ pageBean.currPage }">
												<button type="button" class="btn btn-success btn-sm" id="add" name="add">确认收货</button>
										 </a>
									</c:if>
									<c:if test="${ order.state == 4 }"><span style="color:green">交易结束</span></c:if>
									&nbsp;&nbsp;&nbsp; 
									总金额：<span style="color:red">￥${ order.total }</span>
									</th>
  								     <th align="right"><a href="${ pageContext.request.contextPath }/OrderServlet?method=deleteOrderByOid&oid=${ order.oid }&currPage=${ pageBean.currPage }">
  								     		<c:if test="${ order.state==1 }">
  								     			<button type="button" class="btn btn-danger btn-sm" id="add" name="add">删除订单</button>
  								     		</c:if>
  								     		<c:if test="${ order.state==4 }">
  								     			<button type="button" class="btn btn-danger btn-sm" id="add" name="add">删除订单</button>
  								     		</c:if>
  								     </a></th>
								<!-- </th> -->
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								
							</tr>
							
							<!-- 订单项的循环 -->
							<c:forEach var="orderItem" items="${ order.orderItems }">
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
							<tr height=8px>
							
							</tr>
						</tbody>
						</c:forEach>
						
						
					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">
			
			<!-- 页数为1时，上一页按钮失效，不为1时则有效 -->
				<c:if test="${ pageBean.currPage == 1 }"> 
					<li class="disabled">
						<a href="#" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span></a></li>
				</c:if>	
				<c:if test="${ pageBean.currPage != 1 }"> 
					<li>
						<a href="${ pageContext.request.contextPath }/OrderServlet?method=findOrderByUid&currPage=${ pageBean.currPage-1 }" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span></a></li>
				</c:if>	
					
					<!-- 当页数是当前页时按钮无效 -->
					<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
						<c:if test="${ pageBean.currPage != i }">
							<li>
								<a href="${ pageContext.request.contextPath }/OrderServlet?method=findOrderByUid&currPage=${ i }">${ i }</a>
							</li>
						</c:if>
						<c:if test="${ pageBean.currPage == i }">
							<li class="active">
								<a href="#">${ i }</a>	
							</li>
						</c:if>
					</c:forEach>
					
					<!-- 页数为最后一页时下一页按钮失效，否则有效 -->
					<c:if test="${ pageBean.totalPage == pageBean.currPage }">
						<li class="disabled">
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					<c:if test="${ pageBean.totalPage != pageBean.currPage }">
						<li>
							<a href="${ pageContext.request.contextPath }/OrderServlet?method=findOrderByUid&currPage=${ pageBean.currPage+1 }" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
				
				</ul>
			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="./image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
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