<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">	
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo1.jsp' starting page</title>
    
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
      <h1>jstl标签</h1>
      <c:set var="name" value="张三" scope="page"></c:set>
      ${name }
      
      <!-- 默认输出北京，但是如果有第一行则输出value中的上海 -->
      <c:set var="city" value="上海" scope="page"></c:set>
      <c:out value="${city }" default="北京"></c:out>
      <c:out value="<h1>标题一</h1>" escapeXml="false"></c:out>
      
      <c:set var="n1" value="10" scope="page"></c:set>
      <c:set var="n2" value="20" scope="page"></c:set>
      <c:if test="${n1<n2 }" var="flag" scope="page">
      	n1小于n2!
      </c:if>
       <c:if test="${flag }">
      	n1小于n2!
      </c:if>
      <br/>
       <c:set var="n1" value="30" scope="page"></c:set>
      <c:set var="n2" value="20" scope="page"></c:set>
      <c:if test="${n1>=n2 }" var="flag" scope="page">
      	n1大于等于n2!
      </c:if>
      <c:if test="${flag }">
      	n1大于等于n2!
      </c:if>
  </body>
</html>
