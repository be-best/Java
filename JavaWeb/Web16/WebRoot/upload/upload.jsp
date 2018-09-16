<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <!-- 
	* 表单的提交的方式必须是POST.
	* 表单中需要有文件上传的表单元素:这个元素这个元素必须有name属性和值:<input type=”file” name=”upload”>
	* 表单的enctype属性的值必须是multipart/form-data.
 -->
  <body>
    <form action="/Web16/UploadServlet" method="post" enctype="multipart/form-data">
    	<table border="1px" width="600">
    		<tr>
    			<td>文件描述</td>
    			<td><input type="text" name="filedesc"></td>
    		</tr>
    		<tr>
    			<td>文件上传</td>
    			<td><input type="file" name="uploadfile"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="上传"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
