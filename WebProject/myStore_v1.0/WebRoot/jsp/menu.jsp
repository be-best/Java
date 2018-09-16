<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<head>
			<style>
				.divClass{
					width: 20px;
					
				}
			</style>
		</head>
<script>
	$(function() {
		 $.post("${ pageContext.request.contextPath}/CategoryServlet",{"method":"findAll"},function(data) {
			$(data).each(function(i,n) {
				//menuID返回一个方法名，当前页数currPage=1,还有一个cid 
			$("#menuID").append("<li><a href='${ pageContext.request.contextPath }/ProductServlet?cid="+n.cid+"&method=findByCid&currPage=1'>"+n.cname+"</a></li>");
			});
		},"json");
	}); 
	
</script>
			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${ pageContext.request.contextPath }/img/logo4.jpg" />
				</div>
				<div class="col-md-4">
					<img src="${ pageContext.request.contextPath }/img/header.png" />
				</div>
				
				<div class="col-md-4" style="padding-top:32px">
					<ol class="list-inline">
					
					<c:if test="${ empty existUser }">
				<img src="${ pageContext.request.contextPath }/img/guzhang3.gif" height="35px" width="35px">
						<li><a href="${ pageContext.request.contextPath }/UserServlet?method=loginUI">
							<button type="button" class="btn btn-info" id="add" name="add">登录</button>
						</a></li>
						<li><a href="${ pageContext.request.contextPath }/UserServlet?method=registUI">
							<button type="button" class="btn btn-info" id="add" name="add">注册</button>
						</a></li>
						<li><a href="${ pageContext.request.contextPath }/jsp/cart.jsp">
							<button type="button" class="btn btn-success" id="add" name="add">购物车</button>
						</a></li>
					</c:if>	
					<c:if test="${not empty existUser }">
						<li><strong>Hi!您好:<span style="color:blue">${ existUser.name }</strong></span></li>
						<li></li>
						<li><a href="${ pageContext.request.contextPath }/OrderServlet?method=findOrderByUid&currPage=1">
						<button type="button" class="btn btn-info" id="add" name="add">我的订单</button>
						</a></li>
						<li><a href="${ pageContext.request.contextPath }/jsp/cart.jsp">
							<button type="button" class="btn btn-success" id="add" name="add">购物车</button>
						</a></li>
						<li><a href="${ pageContext.request.contextPath }/UserServlet?method=logOut">
							<button type="button" class="btn btn-danger" id="add" name="add">退出</button>
						</a></li>
					</c:if>	
					</ol>
				</div>
			</div>
           
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${ pageContext.request.contextPath }/index.jsp">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul id="menuID" class="nav navbar-nav">
								<!-- <li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li> -->
							</ul>
							<form action="${ pageContext.request.contextPath }/ProductServlet?method=searchProduct&currPage=1" class="navbar-form navbar-right" method="post" role="search">
								<div class="form-group">
									<input type="text" name="productKeywords" class="form-control" placeholder="查询商品">
								</div>
								<button type="submit" class="btn btn-default">Search</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div> 