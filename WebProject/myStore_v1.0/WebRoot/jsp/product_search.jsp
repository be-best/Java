<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.store.domain.Product"%>
<%@page import="com.store.service.imple.ProductServiceImple"%>
<%@page import="com.store.service.ProductService"%>
<%@page import="com.store.utils.CookieUtils"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品页面</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />

		
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			h6 {
			    color: #666;
			    font-size: 18px;
			    font-weight: normal;
			    padding-right:17px;
			}
		</style>
	</head>

	<body>
		
			<%@ include  file="menu.jsp" %>


		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="#">商品列表</a></li>
				</ol>
			</div>

		<c:forEach var="p" items="${ pageBean.list }">
			<div class="col-md-2" style="height:250px">
				<a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid }">
					<img src="${ pageContext.request.contextPath }/${ p.pimage }" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid }" style='color:green'>${ fn:substring(p.pname,0,15) }</a></p>
				<p><font color="#FF0000">搞机价：&yen;${ p.shop_price }</font></p>
			</div>
		</c:forEach>
			

		</div>

		<!--分页 -->
		<!-- 写这段代码的时候在一个cid后面漏了一个'}'找了半天，我擦... -->
		<div style="width:380px;margin:0 auto;margin-top:10px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				<!-- 页数为第一页时，上一页按钮失效 -->
				<c:if test="${ pageBean.currPage == 1 }">
					<li class='disabled'>
						<a href="#">&laquo;</span></a>
					</li>
				</c:if>
				<c:if test="${ pageBean.currPage != 1 }">
					<li>
						<a href="${ pageContext.request.contextPath }/ProductServlet?method=method=searchProduct&currPage=${ pageBean.currPage-1 }&productKeywords=${ productKeywords }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
					</li>
				</c:if>
				
				<!-- 当点击的页数是当前页时无效,不是当前页则可以跳转 -->
				<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
					<c:if test="${ pageBean.currPage == i }">
						<li class="active"><a href="#">${ i }</a></li>
					</c:if>
					
					<c:if test="${ pageBean.currPage != i }">
						<li><a href="${ pageContext.request.contextPath }/ProductServlet?method=searchProduct&currPage=${ i }&productKeywords=${ productKeywords }">${ i }</a></li>
					</c:if>	
				</c:forEach>
				
				<!-- 当页数为最后一页时，下一页按钮失效 -->
				<c:if test="${ pageBean.currPage == pageBean.totalPage }">
					<li class='disabled'>
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${ pageBean.currPage != pageBean.totalPage }">
					<li>
						<a href="${ pageContext.request.contextPath }/ProductServlet?method=searchProduct&currPage=${ pageBean.currPage + 1 }&productKeywords=${ productKeywords }" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>  
	
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h6 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录history</h6> 
<!-- 			<h5 style="width: 50%;float: left;font: 14px/30px ">浏览记录Browsing history</h5>
 -->			<div style="width: 50%;float: right;text-align: right;"><a href="#"></a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">

				<ul style="list-style: none;">
					<%
						Cookie[] cookies = request.getCookies();
						Cookie cookie = CookieUtils.findCookie(cookies, "history");
						if(cookie == null) {
							out.println("<h3>您还没有浏览记录！</h3>");
						} else {
							String value = cookie.getValue();
							String[] ids = value.split("-");
							ProductService productService = new ProductServiceImple();
							for(String pid:ids) {
								Product p = productService.findByPid(pid);
								//存入当前域
								pageContext.setAttribute("p", p);
							%>
							
							<div class="col-md-2" style="height:250px">
								<a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid }">
									<img src="${ pageContext.request.contextPath }/${ p.pimage }" width="170" height="170" style="display: inline-block;">
								</a>
								<p><a href="${ pageContext.request.contextPath }/ProductServlet?method=findByPid&pid=${ p.pid }" style='color:green'>${ fn:substring(p.pname,0,15) }</a></p>
							</div>						
						
						<% 
							}
						}
					 %>
				</ul>

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