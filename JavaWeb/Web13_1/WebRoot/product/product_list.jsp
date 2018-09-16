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
    
    <title>My JSP 'product_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		function addProduct() {
			window.location.href="${pageContext.request.contextPath}/product/addProduct.jsp";
		}	
		
		function deleteById(pid) {		
			var flag = window.confirm("壮士，确定要搞我吗？")	
			if(flag == true) {
				window.location.href="${ pageContext.request.contextPath }/DeleteProductByIdServlet?pid="+pid;
			}
		}		
		
		//复选框全选
		$(function(){
			$("#selectAll").click(function() {
				$("input[id='ids']").prop("checked",this.checked);
			});
		});
		
		//点击全部删除提交表单
		function deleteAllProduct() {
			document.getElementById("form1").submit();
		}
		
		function search() {
			//获取文本框的值
			var pname = document.getElementById("pname").value;
			//获得表单,改变他的action属性
			document.getElementById("form1").action="${ pageContext.request.contextPath }/SearchProductServlet";
			//表单提交
			document.getElementById("form1").submit();
		}
							  
	</script>

  </head>
  
  <body>
  	<form action="${ pageContext.request.contextPath }/DeleteAllProductServlet" method="post" id="form1">
	<table border="1px" width="1000">
		<tr>
			<td colspan="8">
				商品名称：<input type="text" name="pname" id="pname"/><input type="button" value="查询" onclick="search()"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="添加" onclick="addProduct()">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="删除" onclick="deleteAllProduct()">
			</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="selectAll"></td> 
			<td>序号</td>
			<td>商品名称</td>
			<td>市场价格</td>
			<td>商城价格</td>
			<td>是否热门</td>
			<td>是否下架</td>
			<td>操作</td>
		</tr>
		<c:forEach var="p" items="${ list }" varStatus="status">
			<tr>
			    <td><input type="checkbox" name="ids" id="ids" value="${ p.pid }"/></td> 
				<td>${ status.count }</td>
				<td>${ p.pname }</td>
				<td>${ p.market_price }</td>
				<td>${ p.shop_price }</td>
				<td>
					<c:if test="${ p.is_hot == 1  }">
						是
					</c:if>
					<c:if test="${ p.is_hot == 0 }">
						否
					</c:if>
				</td>
				<td>
					<c:if test="${ p.pflag == 1 }">
						已下架
					</c:if>
					<c:if test="${ p.pflag == 0 }">
						未下架
					</c:if>
				</td>
				<!-- onclick="deleteById('${ p.pid }')" -->
				<td><a href="/Web13_1/EditProductServlet?pid=${ p.pid }">修改</a>|<input type="button" value="删除" onclick="deleteById('${ p.pid }')" ></td>
			</tr>                                                                
		</c:forEach>
	</table>
  	</form>
  </body>
</html>
