<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="domain.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getData.jsp' starting page</title>
    
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
    <h3>1.存取是普通的单值数据</h3>
    <%
    	pageContext.setAttribute("pname", "pvalue");
    	request.setAttribute("rname", "rvalue");
    	session.setAttribute("sname", "svalue");
    	application.setAttribute("aname", "avalue");
     %>
     <%=pageContext.getAttribute("pname") %>
     <%=request.getAttribute("rname") %>
     <%=session.getAttribute("sname") %>
     <%=application.getAttribute("aname") %>
     <hr/>
     <!-- 采用el方式获取 -->
     ${ pageScope.pname } <!-- 返回的是"" -->
	 ${ requestScope.rname }
	 ${ sessionScope.sname }
	 ${ applicationScope.aname }
	 <h3>2.获取数组的数据</h3>
	 <%
	 	String[] arr = {"张三","李四","王五"};
	 	pageContext.setAttribute("Arrays", arr);
	  %>
	  ${ Arrays[0] }
	  ${ Arrays[1] }
	  ${ Arrays[2] }
	  <h3>3.获取List集合的数据</h3>
	  <%
	  	List<String> list = new ArrayList<String>();
	  	list.add("赵六");
	  	list.add("钱八");
	  	list.add("孙九");
	  	pageContext.setAttribute("List", list);
	   %>
	   ${ List[0] }
	   ${ List[1] }
	   ${ List[2] }
	  <h3>4.获取Map集合的数据</h3>
	  <%
	  	Map<String,String> map = new HashMap<String,String>();
	  	map.put("a", "张海");
	  	map.put("b", "钱素");
	  	map.put("c.1", "王时");
	  	pageContext.setAttribute("Map", map);
	   %>
	   ${ Map.a }
	   ${ Map.b }
	   ${ Map["c.1"] }
	   <h3>5.获取对象的数据</h3>
	 <%
	User user1 = new User(1,"aaa","123");
	User user2 = new User(2,"bbb","123");
	User user3 = new User(3,"ccc","123");
	
	List<User> userList = new ArrayList<User>();
	userList.add(user1);
	userList.add(user2);
	userList.add(user3);
	
	pageContext.setAttribute("userList", userList);
%>
${ userList[0].id } - ${ userList[0].username } - ${ userList[0].password }<br/>
${ userList[1].id } - ${ userList[1].username } - ${ userList[1].password }<br/>
${ userList[2].id } - ${ userList[2].username } - ${ userList[2].password }<br/>
	 
  </body>
</html>
