<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'operation.jsp' starting page</title>
    
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
    <h1>EL的功能二:执行运算</h1>
	<h3>EL执行算数运算</h3>
	<%
		pageContext.setAttribute("n1", "10");
		pageContext.setAttribute("n2", "20");
		pageContext.setAttribute("n3", "30");
		pageContext.setAttribute("n4", "40");
	%>
	${ n1 + n2 + n3 } 
	<h3>EL执行逻辑运算</h3> 
	${ n1 < n2 } - ${ n1 lt n2 } <!-- less than --><br/>
	${ n1 > n2 } - ${ n1 gt n2 } <!-- great than --><br/>
	${ n1 <= n2 } - ${ n1 le n2 } <!-- less equal --><br/>
	${ n1 >= n2 } - ${ n1 ge n2 } <!-- great equal --><br/>
	${ n1 == n2 } - ${ n1 eq n2 } <!-- equal --><br/>
	
	<h3>EL执行关系运算</h3> 
	${ n1<n2 && n3 < n4 } - ${ n1<n2 and n3 < n4 }<br/>
	${ n1<n2 || n3 < n4 } - ${ n1<n2 or n3 < n4 }<br/>
	${ !(n1 < n2) } - ${ not(n1<n2) }
	
	<h3>EL执行三元运算</h3>
	${ n1 < n2 ? "正确":"错误" }
	
	<h3>empty运算</h3>
	${ user == null } - ${ empty user }
	${ user != null } - ${ not empty user }
  </body>
</html>
