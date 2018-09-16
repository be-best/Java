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
    
    <title>My JSP 'demo3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>JSTL提供的EL的函数库</h1>
    <!-- 判断是否有Hello -->
    ${ fn:contains("Hello World","Hello") }
    ${ fn:length("Hello") }
    ${ fn:toLowerCase("ASDFG") }
    
    <!-- 引号要么外面单引里面双引，要么里面单引外面双引 -->
    <!-- c:forEach var="i" items="${ fn:split('a-c-b-d-r','-') }"-->
    <c:forEach var="i" items="${ fn:split('a-c-b-d-r','-') }">
      ${i }
    </c:forEach>
  </body>
</html>
