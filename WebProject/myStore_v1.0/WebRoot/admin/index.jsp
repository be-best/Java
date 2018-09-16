<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>搞机Store管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css" />
    
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
/* body {
  color: white;
} */
 body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
</style>
</head>
<body style="background: #278296">
<center></center>
<%-- <form method="post" action="${pageContext.request.contextPath }/AdminLoginServlet" target="_parent" name='theForm' onsubmit="return validate()">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr>
    <td style="padding-left: 50px">
      <table>
      <tr>
        <td>管理员账号：</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>管理员密码：</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr><td>&nbsp;</td>
      <td>
        <button type="submit" class="btn btn-info" id="add" name="add">登录管理中心</button>
      	<!-- <input type="submit" value="进入管理中心" class="button" /> -->
      </td></tr>
      </table>
    </td>
  </tr>
  </table>
</form> --%>

	<div class="container" style="width:100%;height:660px;background:#FF2C4C url('${ pageContext.request.contextPath }/img/houtaibg2.jpg' )  ;" >
				<div style="width:440px; height: 300px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;
					 margin: auto;
				    position: absolute;
				    top: 0;
				    left: 0;
				    right: 0;
				    bottom: 0;">
				<font>管理登录</font>ADMIN LOGIN<br/>
				<span style="color:red">${ msg }</span>
				<div>&nbsp;</div>
<form class="form-horizontal" action="${ pageContext.request.contextPath }/AdminLoginServlet" method="post">
 
  <!-- 隐藏的一个input,传method值 -->
  <input type="hidden" name="method" value="adminLogin">
 
 <div class="form-group">
    <label for="username" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号">
      
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="请输入密码">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn btn-info" id="add" name="add">登录管理中心</button>
  
    </div>
  </div>
</form>
</div>			
	</div>

<script language="JavaScript">
<!--
  document.forms['theForm'].elements['username'].focus();
  
  /**
   * 检查表单输入的内容
   */
  function validate()
  {
    var validator = new Validator('theForm');
    validator.required('username', user_name_empty);
    //validator.required('password', password_empty);
    if (document.forms['theForm'].elements['captcha'])
    {
      validator.required('captcha', captcha_empty);
    }
    return validator.passed();
  }
  
//-->
</script>
</body>