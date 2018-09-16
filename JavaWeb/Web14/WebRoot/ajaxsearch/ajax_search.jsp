<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax_search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>	
	<script type="text/javascript" src="${ pageContext.request.contextPath }/ajaxsearch/ajax_search.js"></script>	
  </head>
  
  <body>
	<center>
		<h1>Search</h1>
		<input type="text" id="content" name="content" style="width:400px;height:25px;" >
		<input type="button" id="search" name="content" value="Search" style="width:80px;height:25px;">
		<div id="d1" style="display:none;position:absolute;top:110px;left:440px;border:1px solid gray;width:400px;height:200px"></div>
	</center>
  </body>
</html>
