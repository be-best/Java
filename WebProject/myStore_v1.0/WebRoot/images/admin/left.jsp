<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />

<style type="text/css">
body {
  color: white;
  background:url("${pageContext.request.contextPath}/img/beijing1.jpg") no-repeat;
  background-size: 100%;
   width:100%;
    height:100%
}
</style>

</head>

<!-- <body style="background: #FAFAFA"> -->
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0" s>
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		
		d.add('0102','01','分类管理','','','mainFrame');
		d.add('010201','0102','分类管理','${pageContext.request.contextPath}/AdminCategoryServlet?method=findAll','','mainFrame');
		d.add('0104','01','商品管理');
		d.add('010401','0104','商品管理','${pageContext.request.contextPath}/AdminProductServlet?method=findByPage&currPage=1','','mainFrame');
		d.add('010402','0104','已下架商品管理','${pageContext.request.contextPath}/AdminProductServlet?method=findByPushDown&currPage=1','','mainFrame');
		d.add('0105','01','订单管理');
		d.add('010501','0105','订单管理','${pageContext.request.contextPath}/AdminOrderServlet?method=findAll&state=0&currPage=1','','mainFrame');
		d.add('010502','0105','未付款的订单','${pageContext.request.contextPath}/AdminOrderServlet?method=findAll&state=1&currPage=1','','mainFrame');
		d.add('010503','0105','已付款订单','${pageContext.request.contextPath}/AdminOrderServlet?method=findAll&state=2&currPage=1','','mainFrame');
		d.add('010504','0105','已发货的订单','${pageContext.request.contextPath}/AdminOrderServlet?method=findAll&state=3&currPage=1','','mainFrame');
		d.add('010505','0105','已完成的订单','${pageContext.request.contextPath}/AdminOrderServlet?method=findAll&state=4&currPage=1','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
