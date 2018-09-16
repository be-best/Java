<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品详情</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />
		
		<script type="text/javascript">
			function subCartItem() {
			if(${product.pflag} == 0) {
				document.getElementById("form1").submit();
			} else {
				alert("不好意思，商品暂时下架了哟！");
			}
				
			}
		</script>
		<script type="text/javascript">
 function Add( node)
 {
  var inputs=node.parentNode.getElementsByTagName("input");
  var a= new Number(inputs[1].value);
  a=a+1;
  inputs[1].value=""+a;
  
 }
 function Sub( node)
 {
  //node.parentNode的类型为单元格
  var inputs=node.parentNode.getElementsByTagName("input");
  var a= new Number(inputs[1].value);
  a=a-1;
  inputs[1].value=inputs[1].value-1;
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
			
			
		</style>
	</head>

	<body>

		
		<%@ include file="menu.jsp" %>
		
		<div class="container">
			<div class="row">
				<div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
					<a href="${ pageContext.request.contextPath }/index.jsp">首页&nbsp;&nbsp;&gt;</a>
					<a>${ product.pname }</a>
				</div>

				<form id="form1" action="${ pageContext.request.contextPath }/CartServlet" method="post">
				<!-- 传递两个值：方法名,pid -->
				<input type="hidden" name="method" value="addCart">
				<input type="hidden" name="pid" value="${ product.pid }">
				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${ pageContext.request.contextPath }/${ product.pimage }">
																									
					</div>

					<div class="col-md-6">
						<div><strong>${ product.pname }</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>编号：${ product.pid }</div>
						</div>

						<div style="margin:10px 0 10px 0;">搞机价: <strong style="color:#ef0101;">￥：${ product.shop_price }元/台</strong> &nbsp;&nbsp; 市场参考价： <del>￥：${ product.market_price }元/台</del>
						</div>

						<div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)" style="background-color: #f07373;">限时抢购</a> </div>

						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							<div style="margin:5px 0 10px 0;"></div>
							
							
							

							<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px">购买数量:
<!-- 								<input id="count" name="count" value="1" maxlength="4" size="10" type="text"> 
 -->			
							
								<!-- <table >
									<tr>
									<td> -->
										<!-- <button type="button" class="btn btn-success" onclick="Sub(this)">-</button> -->
										 <input value="-"  type="button" onclick="Sub(this)"/> 
										 <input type="text" value="1" name="count" style="width:30px;height:25px"  />
										 <input value="+"  type="button" onclick="Add(this)"/> 
										<!-- <button type="button" class="btn btn-success" onclick="Add(this)">+</button> -->
									<!-- </td>
									</tr>
								</table> -->
							</div>

							<div style="margin:20px 0 10px 0;;text-align: center;">
								<a href="#" onclick="subCartItem()">
								<button type="button" class="btn btn-danger">加入购物车</button>
<%-- 									<input style="background: url('${ pageContext.request.contextPath }/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="button">
 --%>								</a> &nbsp;
								</div>
						</div>
					</div>
				</div>
				</form>
				
				<div class="clear"></div>
				
				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#E0FFFF;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>商品介绍</strong>
					</div>

					<div>
					<img  src="${pageContext.request.contextPath }/${ product.pdesc }">
						
					</div>

					<div style="background-color:#E0FFFF;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>价格说明</strong>
					</div>
					<div style="margin-top:10px;width:900px;">
					

<strong>I.划线价格指商品的专柜价、吊牌价、正品零售价、厂商指导价或该商品的曾经展示过的销售价等，并非原价，仅供参考。</strong><br>

<strong>II.未划线价格

指商品的实时标价，不因表述的差异改变性质。具体成交价格根据商品参加活动，或会员使用优惠券、积分等发生变化，最终以订单结算页价格为准。</strong><br>

<strong>III.商家详情页（含主图）以图片或文字形式标注的一口价、促销价、优惠价等价格可能是在使用优惠券、满减或特定优惠活动和时段等情形下的价格，具体请以结算页面的标价、优惠条件或活动规则为准。</strong><br>

<strong>IV.此说明仅当出现价格比较时有效，具体请参见《搞机Store价格发布规范》。若商家单独对划线价格进行说明的，以商家的表述为准。</strong><br>
						<!-- <table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th colspan="2">基本参数</th>
								</tr>
								<tr>
									<th width="10%">级别</th>
									<td width="30%">标准</td>
								</tr>
								<tr>
									<th width="10%">标重</th>
									<td>500</td>
								</tr>
								<tr>
									<th width="10%">浮动</th>
									<td>200</td>
								</tr>
							</tbody>
						</table> -->
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<!-- <table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品评论</strong></th>
								</tr>
								<tr class="warning">
									<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
								</tr>
							</tbody>
						</table> -->
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<!-- <table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品咨询</strong></th>
								</tr>
								<tr class="warning">
									<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
								</tr>
							</tbody>
						</table> -->
					</div>
				</div>

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