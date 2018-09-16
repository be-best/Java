<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>用户注册</title>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css"/>

<style>
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
 
font .regist {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
 <script type="text/javascript">
 
 $(function() {
 				
				$("form input").blur(function(){
					//获得该元素的父元素
					var parents = $(this).parent();
					//清除原来的提示
					parents.find(".formtips").remove();
					 /* if($(this).is("#username")) {
						if(this.value == "") {
							parents.append("<span class='formtips onError'>用户名不能为空</span>");
						}
						else {
							parents.append("<span class='formtips onSuccess'>用户名正确</span>")
						} 
					}  */
					
					if($(this).is("#password")) {
						if(this.value == "") {
							//$("#p1").html("<font color='red'>密码不能为空</font>");
							
							parents.append("<span class='formtips onError' style='color:red'>密码不能为空</span>");
						}else {
							//$("#p1").html("<font color='green'>密码正确</font>");
							
							parents.append("<span class='formtips onSuccess' style='color:green'>密码正确</span>")
						}
					}
					
					if($(this).is("#repassword")) {
						//先获取第一次输入的密码,然后再比较
						var passWd = $("#password").val();
						if(this.value == passWd && this.value != "") {
							//$("#rp").html("<font color='green'>密码正确</font>");
							
							parents.append("<span class='formtips onSuccess' style='color:green'>密码正确</span>");
						}
						else {
							//$("#rp").html("<font color='red'>密码不一致</font>");
							
							parents.append("<span class='formtips onError' style='color:red'>密码不一致</span>");
						}
					}
					
					if($(this).is("#email")) {
						if(this.value == "") {
							parents.append("<span class='formtips onError' style='color:red'>邮箱不能为空</span>");
						}
						
					}
					
					if($(this).is("#name")) {
						if(this.value == "") {
							parents.append("<span class='formtips onError' style='color:red'>姓名不能为空</span>");
						}
						
					}
					
					if($(this).is("#telephone")) {
						if(this.value == "") {
							parents.append("<span class='formtips onError' style='color:red'>电话不能为空</span>");
						}
						
					}
					
					if($(this).is("#birthday")) {
						if(this.value == "") {
							parents.append("<span class='formtips onError' style='color:red'>生日不能为空</span>");
						}
						
					}
					
				}).keyup(function(){
					//会实时监测输入框内容是否合法，比如输入内容后，会显示：用户名正确
					$(this).triggerHandler("blur");
				}).focus(function() {
					//点击时便会执行blur事件，比如点击输入框但还未输入时会立刻显示：输入不能为空。
					$(this).triggerHandler("blur");
				});
				
				$("form").submit(function(){
					//执行表单中的blur事件
					$("form input").trigger("blur");
					//然后检查onError的个数
					var errorLength = $(".onError").length;
					if(errorLength > 0) {
						//返回false不提交，此时无法注册
						//$("#regBut").attr("disabled",false);
						return false;
					}
				});
			});
			
 </script>

<!-- 异步校验用户名 -->
 <script type="text/javascript">
 	$(function() {
 		//鼠标离开文本框时
 		$("#username").blur(function() {
 			//获取文本框的值
 			var $value = $(this).val();
 			if($value == null) {
 				$("#s1").html("<font color='red'>用户名为空</font>");
 				$("#regBut").attr("disabled",true);
 			}
 			else if($value != null) {
 				//传到UserServlet里，注意要带method参数，父类BaseServlet需要获取方法名method
 				$.post("${ pageContext.request.contextPath}/UserServlet",{"method":"checkUsername","username":$value},function(data){
 					if(data == 1) {
 						//Servlet响应输出1时用户名可用
 						$("#s1").html("<font color='green'>用户名可使用</font>");
 						$("#regBut").attr("disabled",false);
 					} else if(data == 0) {
 						//Servlet响应输出0时用户名不可用
 						$("#s1").html("<font color='red'>用户名不可用</font>");
 						$("#regBut").attr("disabled",true);
 					}
 				});
 			}
 		});
 	});
 	
 </script>
</head>
<body>


<%@ include file="menu.jsp" %>

<div class="container" style="width:100%;background:url('${ pageContext.request.contextPath }/images/backgd1.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font color="#3164af" size="5px">用户注册</font>USER REGISTER
		<form class="form-horizontal" style="margin-top:5px;" action="${ pageContext.request.contextPath }/UserServlet" method="post">
			
			<!-- 这边要有一个隐藏的input,得把method值传过去，父类BaseServlet才能获取到方法名method -->
			 <input type="hidden" name="method" value="regist">     
			
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" class="required" id="username" name="username" placeholder="请输入用户名"><span id="s1"></span>
			    </div><span style="color:red">*</span>
			  </div>
			  <!--  <div class="form-group" >
				    <label for="username" class="col-sm-2 control-label"></label>
				    <div class="col-sm-6">
						<span id="s1"></span>
				    </div>
			  </div> -->
			    
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" class="required" id="password" name="password"  placeholder="请输入密码">
			    </div><span style="color:red">*</span>
			    
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" class="required" id="repassword" name="repassword"  placeholder="请输入确认密码">
			    </div><span style="color:red">*</span>
			   
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" id="email" name="email"  placeholder="格式为：x@x.x">
			    </div><span style="color:red">*</span>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="name" name="name"  placeholder="请输入姓名">
			    </div><span style="color:red">*</span>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="男" checked> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
			</label>
			</div>
			  </div>	
			 <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入电话号码" >		      
			    </div><span style="color:red">*</span>
			  </div>	
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="birthday"  name="birthday" placeholder="格式为：2000-05-03" >		      
			    </div><span style="color:red">*</span>
			  </div>
			  
			 <!--  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control"  >
			      
			    </div>
			    <div class="col-sm-2">
			    <img src="./image/captcha.jhtml"/>
			    </div>
			    
			  </div> -->
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			    <button type="submit" class="btn btn-info" id="regBut" name="add">注册</button>
			      <%-- <input type="submit"  id="regBut" width="100" value="注册" border="0"
				    style="background: url('${ pageContext.request.contextPath }/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;"> --%>
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${ pageContext.request.contextPath }/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
				<li><a href="${ pageContext.request.contextPath }/admin/index.jsp">管理员权限</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2018  搞机Store 版权所有
		</div>

</body></html>




