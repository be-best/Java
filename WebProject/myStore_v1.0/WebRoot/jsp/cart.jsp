<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购物车</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />
		
		<script type="text/javascript">
			function clearAll() {
				var flag = confirm("壮士，确定清除购物车吗？");
				if(flag == true) {
					window.location.href="${ pageContext.request.contextPath }/CartServlet?method=clearCart";
				}
			}
			
			function clearCartItem(pid) {
				var flag = confirm("且慢，确定赶我下车？");
				if(flag == true) {
					window.location.href="${ pageContext.request.contextPath }/CartServlet?method=clearCartItem&pid="+pid;
				}
			}
		</script>
		
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>

		<%@ include file="menu.jsp" %>

		<c:if test="${ fn:length(cart.map) == 0 }">
			<div style=" text-align: center;top: 0;left: 0;right: 0;bottom: 0;">
				<h3>这是辆空车，购物车表示饥渴难耐，赶快浏览商品装车吧！</h3>
				<img src="${ pageContext.request.contextPath }/img/cart2.jpg" width="150px" height="150px">
				<img src="${ pageContext.request.contextPath }/img/cart1.jpg">
				<img src="${ pageContext.request.contextPath }/img/cart2.jpg" width="150px" height="150px">
			</div>
		</c:if>
		<c:if test="${ fn:length(cart.map) != 0 }">
		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:forEach var="entry" items="${ cart.map }">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<!-- entyr.value等于map的值，也就是cartItem，cartItem.product获得商品，再继续获取属性 -->
									<img src="${ pageContext.request.contextPath }/${ entry.value.product.pimage }" width="70" height="60">
								</td>
								<td width="30%">
									<p><a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${entry.value.product.pid }" style='color:green'>${ entry.value.product.pname }</a></p>
									<%-- <a target="_blank">${ entry.value.product.pname }</a> --%>
								</td>
								<td width="20%">
									￥${ entry.value.product.shop_price }
								</td>
								<td width="10%">
										${ entry.value.count }
								</td>
								<td width="15%">
									<span class="subtotal">￥${ entry.value.subtotal }</span>
								</td>
								<td>
									<a href="#" onclick="clearCartItem('${ entry.value.product.pid }')" class="delete">
										<button type="button" class="btn btn-danger" id="add" name="add">删除</button>
									</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				登录后确认是否享有优惠&nbsp;&nbsp;
			</em> 赠送积分 <em style="color:#ff6600;"></em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${ cart.total }元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="#" id="clearAll" name="clearAll" onclick="clearAll()" class="clear">
						<button type="button" class="btn btn-danger" id="add" name="add">清空购物车</button>
					</a>
					<a href="${ pageContext.request.contextPath }/OrderServlet?method=creatOrder">
						<%-- <input type="submit" width="100" value="提交订单" name="orderSubmit" border="0" style="background: url('${ pageContext.request.contextPath }/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;"> --%>
						<button type="button"  class="btn btn-success" id="add" name="add">提交订单</button>
					</a>
				</div>
			</div>
		</div>
		</c:if>
		
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