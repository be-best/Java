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
	    <h1>JSTL常用标签:forEach</h1>
		<h3>遍历数组</h3>
		<%
			String[] arr = {"张三","李四","王五"};
			pageContext.setAttribute("Arr", arr);
		 %>
		 <c:forEach var="i" items="${Arr }">
		 	${i } 
		 </c:forEach>
		 
		 <h3>遍历List集合</h3>
		 <%
		 	List<String> list = new ArrayList<String>();
		 	list.add("孙六");
		 	list.add("钱六");
		 	list.add("赵七");
		 	pageContext.setAttribute("List", list);
		  %>
		  <c:forEach var="i" items="${List }">
		  	${i }
		  </c:forEach>
		  
		  <h3>遍历Map集合</h3>
		  <%
		  		Map<String,String> map = new HashMap<String,String>();
		  		map.put("a", "钱一");
		  		map.put("b", "刘二");
		  		map.put("c", "朱三");
		  		pageContext.setAttribute("Map", map);
		   %>
		   <c:forEach var="entry" items="${Map }">
		   	${entry.key }-${entry.value }
		   </c:forEach>
		   
		   <h3>遍历从1到10</h3>
		   <c:forEach var="i" begin="1" end="10">
		   	${ i }
		   </c:forEach>
		   
		   <h3>遍历从100到300,step=5</h3>
		   <!-- varStatus记录循环状态,这里隔三个标红一次 -->
		   <c:forEach var="i" begin="100" end="300" step="5" varStatus="status">
		   		<c:if test="${status.count % 3 == 0 }">
		   			<font color="red">${i }</font>
		   		</c:if>
		   		<c:if test="${status.count % 3 != 0 }">
		   			${i }
		   		</c:if>
		   </c:forEach>
  </body>
</html>
