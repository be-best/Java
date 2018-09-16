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
    
    <title>My JSP 'object.jsp' starting page</title>
    
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
  <!-- 
	pageScope,requestScope,sessionScope,applicationScope - 获取JSP中域中的数据
	param,paramValues 	- 接收参数.
	header,headerValues - 获取请求头信息
	initParam			- 获取全局初始化参数
	cookie				- WEB开发中cookie
	pageContext			- WEB开发中的pageContext.
 -->
    <h3>接收请求的参数</h3>
    <!-- http://localhost:8080/Web12/demo2_el/object.jsp?id=111&name=aaa&hobby=soccer&hobby=basketball -->
    <%=request.getParameter("id") %>
    <%=request.getParameter("name") %>
    <!-- 遍历数组 -->
    <%=Arrays.toString(request.getParameterValues("hobby")) %>
    <hr/>
    ${param.id }
    ${param.name }
    ${paramValues.hobby[0] }
    ${paramValues.hobby[1] }
    
    <h3>获取请求头</h3>
    <%=request.getHeader("User-Agent") %>
    <hr/>
    <!-- header.xxx (特殊字符要用[]括起来) -->
    ${header["User-Agent"] }
    
    <h3>获取全局初始化参数</h3>
    ${ initParam.password }
    
    <h3>获取Cookie中的值</h3>
    <!-- cookies.名称.value -->
    ${cookies.history.value }
    
    <h3>获取PageContext中的对象</h3>
    IP地址：${ pageContext.request.remoteAddr }
    <br/>
            工程路径：${ pageContext.request.contextPath }
  </body>
</html>
