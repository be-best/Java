<%@ page language="java" pageEncoding="UTF-8"%>
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
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/AdminCategoryServlet" method="post">
			<input type="hidden" name="method" value="update" />
			<input type="hidden" name="cid" value="${ category.cid }" />
			&nbsp;
			<table class="table table-bordered" cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<STRONG>编辑分类</STRONG>
						
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
					<div class="form-group" style="width:300px">
							<input type="text" name="cname" value="${ category.cname }" id="userAction_save_do_logonName" class="form-control" placeholder="请输入商品名称">
						</div>
						</td>
				</tr>
			
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" class="btn btn-info">确定</button>
						
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" id="userAction_save_do_submit" class="btn btn-info" >重置</button>
					
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="button" id="userAction_save_do_submit" class="btn btn-info"  onclick="history.go(-1)">返回</button>
						
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>