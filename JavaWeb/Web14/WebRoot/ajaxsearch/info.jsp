<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table border="0" width="100%">
	<c:forEach var="w" items="${ list }">
		<tr>
			<td>
				${ w.content }
			</td>
		</tr>
	</c:forEach>
</table>