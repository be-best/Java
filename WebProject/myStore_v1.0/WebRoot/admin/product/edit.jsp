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
    
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/AdminUpdateProductServlet" method="post" enctype="multipart/form-data">
			
			<input type="hidden" name="pid" value="${ product.pid }" />
			&nbsp;
			
			
			<table class="table table-bordered"  cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑商品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<div class="form-group" style="width:300px">
							<input type="text" name="pname" value="${ product.pname }" id="userAction_save_do_logonName" class="form-control" placeholder="请输入商品名称">
						</div>					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否推荐：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<select name="is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<div class="form-group" style="width:200px">
							<input type="text" name="market_price" value="${ product.market_price }" id="userAction_save_do_logonName" class="form-control" placeholder="请输入市场价格">
						</div>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<div class="form-group" style="width:200px">
							<input type="text" name="shop_price" value="${ product.shop_price }" id="userAction_save_do_logonName" class="form-control" placeholder="请输入商城价格">
						</div>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" value="${ product.pimage }" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="cid">
							<c:forEach var="c" items="${ list }">
								<option value="${ c.cid }">${ c.cname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload1" value="${ product.pdesc }" />
					</td>
				</tr>
			<!-- 	<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr> -->
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" class="btn btn-info">确定</button>
						

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" id="userAction_save_do_submit" class="btn btn-info">重置</button>
 						
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="button" id="userAction_save_do_submit" class="btn btn-info" onclick="history.go(-1)">返回</button>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>