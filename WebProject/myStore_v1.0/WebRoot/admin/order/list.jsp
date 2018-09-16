<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			function showDetail(oid){
				var $val = $("#but"+oid).val();
				if($val == "订单详情"){
					$.post("${pageContext.request.contextPath}/AdminOrderServlet",{"method":"showDetail","oid":oid},function(data){
						$(data).each(function(i,n){
							// 显示图片,名称,单价,数量
							$("#div"+oid).append("<img width='60' height='65' src='${pageContext.request.contextPath}/"+n.product.pimage+"'>&nbsp;"+n.product.pname+"&nbsp;"+n.product.shop_price+"<br/>");
						});
					},"json");
					
					$("#but"+oid).val("关闭");
				}else{
					$("#div"+oid).html("");
					$("#but"+oid).val("订单详情");
				}
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form action="${ pageContext.request.contextPath }/AdminOrderServlet?method=searchOrder&currPage=1" class="navbar-form navbar-right" method="post" role="search">
								<div class="form-group">
									<input type="text" name="oidKeywords" class="form-control" placeholder="查询订单">
								</div>
								<button type="submit" class="btn btn-default">Search</button>
							</form><br/>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table class="table table-bordered" cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										收货人电话
									</td>
									<td align="center" width="10%">
										收货人地址
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
								<c:forEach var="o" items="${ pageBean.list }" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												${ status.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="25%">
												${ o.oid }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="12%">
												${ o.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												${ o.telephone }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												${ o.address }
											</td>
											
											<td style="CURSOR: hand; HEIGHT: 40px" align="center"
												width="11%">
												<c:if test="${ o.state==1 }">
													<span style="color:red">未付款</span>
												</c:if>
												<c:if test="${ o.state==2 }">
													<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=send&oid=${o.oid}&currPage=${ pageBean.currPage }">
													<button type="button" class="btn btn-primary btn-xs">发货</button>
													</a>
												</c:if>
												<c:if test="${ o.state==3 }">
													<span style="color:green">已发货</span>
												</c:if>
												<c:if test="${ o.state==4}">
													<span style="color:blue">订单完成</span>
													<%-- <a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=deleteOrder&oid=${o.oid}&currPage=${ pageBean.currPage }">
													<button type="button" class="btn btn-danger btn-xs">删除</button>
													</a> --%>
												</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px" width="15%">
											<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=showDetail&oid=${ o.oid }">
<%-- 												<input type="button" value="订单详情" id="but${o.oid}" onclick="showDetail('${o.oid}')"/>
 --%>												<button type="button" class="btn btn-primary btn-sm">订单详情</button>
											</a>	
												<%-- <input type="button" value="订单详情" id="but${o.oid}" onclick="showDetail('${o.oid}')"/>
												<div id="div${o.oid}">
													
													<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
														
													</table>
												</div> --%>
											</td>
							
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
					<%-- 	<td colspan="7">
							第${ pageBean.currPage }/${ pageBean.totalPage }页 &nbsp; &nbsp; &nbsp;
							总记录数:${ pageBean.totalCount }  &nbsp; 每页显示:${ pageBean.pageSize }
							<c:if test="${ pageBean.currPage != 1 }">
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=1&state=${ state }">首页</a>|
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ pageBean.currPage - 1}&state=${ state }">上一页</a>|
							</c:if>
							&nbsp; &nbsp;
							
							<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
								<c:if test="${ pageBean.currPage == i }">
									[${ i }]
								</c:if>
								<c:if test="${ pageBean.currPage != i }">
									<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ i}&state=${ state }">[${ i }]</a>
								</c:if>
							</c:forEach>
							
							&nbsp; &nbsp;
							<c:if test="${ pageBean.currPage != pageBean.totalPage }">
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ pageBean.currPage + 1}&state=${ state }">下一页</a>|
								<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ pageBean.totalPage}&state=${ state }">尾页</a>|
							</c:if>	
						</td>
					</tr> --%>
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
									<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ pageBean.currPage - 1}&state=${ state }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								</li>
							</c:if>
							
							
							<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
								<c:if test="${ pageBean.currPage == i }">
									<li class="active"><a href="#">${ i }</a></li>
								</c:if>
								<c:if test="${ pageBean.currPage != i }">
									<li><a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ i}&state=${ state }">${ i }</a></li>
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
									<a href="${ pageContext.request.contextPath }/AdminOrderServlet?method=findAll&currPage=${ pageBean.currPage + 1}&state=${ state }" aria-label="Next">
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

