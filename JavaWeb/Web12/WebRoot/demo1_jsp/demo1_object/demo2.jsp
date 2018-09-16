<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo2.jsp' starting page</title>
    
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
    <h1>jsp的内置对象</h1>
    <%
	    pageContext.setAttribute("pname", "pvalue", PageContext.PAGE_SCOPE);
	    //pageContext.setAttribute("pname", "pvalue"); 
	    
	    pageContext.setAttribute("rname", "rvalue", PageContext.REQUEST_SCOPE); 
	    //request.setAttribute("rname", "rvalue"); 
	    
	    pageContext.setAttribute("sname", "svalue", PageContext.SESSION_SCOPE); 
	    //session.setAttribute("sname", "svalue"); 
	    
	    pageContext.setAttribute("aname", "avalue", PageContext.APPLICATION_SCOPE); 
	    //application.setAttribute("aname", "avalue"); 
    %>
    <!-- 在当前页面获取四个域的值:两种方法 -->
    <%=pageContext.getAttribute("pname",PageContext.PAGE_SCOPE) %>
    <%=pageContext.getAttribute("rname",PageContext.REQUEST_SCOPE) %>
    <%=pageContext.getAttribute("sname",PageContext.SESSION_SCOPE) %>
    <%=pageContext.getAttribute("aname",PageContext.APPLICATION_SCOPE) %>
    <hr/>
    <%=pageContext.getAttribute("pname") %>
    <%=request.getAttribute("rname") %>
    <%=session.getAttribute("sname") %>
    <%=application.getAttribute("aname") %>
    <hr/>
	<%
	 	pageContext.setAttribute("name", "pvalue");
		request.setAttribute("name", "rvalue");
		session.setAttribute("name", "svalue");
		application.setAttribute("name", "avalue"); 
	%>
	<%= pageContext.findAttribute("name") %>
  </body>
</html>
