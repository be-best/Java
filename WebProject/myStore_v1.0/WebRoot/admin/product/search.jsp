<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />
    
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/AdminProductServlet?method=saveUI";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form action="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=1" class="navbar-form navbar-right" method="post" role="search">
			<div class="form-group">
				<input type="text" name="productKeywords" class="form-control" placeholder="查询商品">
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		<div style="padding-left:20px">
			<button type="button" class="btn btn-info" id="add" name="add" onclick="addProduct()">添加商品</button>
		</div>
		<br/>
		
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table class="table table-bordered" cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<%-- <td align="left">
							<form action="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=1" class="navbar-form navbar-right" method="post" role="search">
								 <div class="form-group"> 
									<input type="text" name="productKeywords" class="form-control" placeholder="查询商品">
									<button type="submit" class="btn btn-default">Search</button>
								</div> 
							</form>
						</td> --%>
						<td class="ta_01" align="right">
						<%-- <form action="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=1" class="navbar-form navbar-right" method="post" role="search">
								 <div class="form-group"> 
									<input type="text" name="productKeywords" class="form-control" placeholder="查询商品">
									<button type="submit" class="btn btn-default">Search</button>
								</div> 
							</form>
							<button type="button" class="btn btn-info" id="add" name="add" onclick="addProduct()">添加</button> --%>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="17%">
										商品图片
									</td>
									<td align="center" width="17%">
										商品名称
									</td>
									<td align="center" width="17%">
										商品价格
									</td>
									<td align="center" width="17%">
										是否推荐
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										下架
									</td>
								</tr>
								<c:forEach var="p" items="${ pageBean.list }" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${ status.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<img width="40" height="45" src="${ pageContext.request.contextPath }/${p.pimage}">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${ p.pname }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${ p.shop_price }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${ p.is_hot == 1 }">
													是
												</c:if>
												<c:if test="${ p.is_hot == 0 }">
													否
												</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/AdminProductServlet?method=editProduct&pid=${ p.pid }">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/AdminProductServlet?method=pushDown&pid=${p.pid}">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
										</c:forEach>
							</table>
						</td>
					</tr>
					
					<tr align="center">
						<td colspan="7">
					<div style="width:380px;margin:0 auto;margin-top:10px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
						<c:if test="${ pageBean.currPage == 1 }">
							<li class='disabled'>
								<a href="#">&laquo;</span></a>
							</li>
						</c:if>
						<c:if test="${ pageBean.currPage != 1 }">
								<li>
									<a href="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=${ pageBean.currPage - 1}&productKeywords=${ productKeywords }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								</li>
							</c:if>
							
							
							<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
								<c:if test="${ pageBean.currPage == i }">
									<li class="active"><a href="#">${ i }</a></li>
								</c:if>
								<c:if test="${ pageBean.currPage != i }">
									<li><a href="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=${ i }&productKeywords=${ productKeywords }">${ i }</a></li>
								</c:if>
							</c:forEach>
							
							<c:if test="${ pageBean.currPage == pageBean.totalPage }">
								<li class='disabled'>
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>
							<c:if test="${ pageBean.currPage != pageBean.totalPage }">
								<li>
									<a href="${ pageContext.request.contextPath }/AdminProductServlet?method=searchProduct&currPage=${ pageBean.currPage + 1}&productKeywords=${ productKeywords }" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>
						
							</ul>
						</div>  
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

