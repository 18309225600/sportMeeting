<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Sign Up</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<%--<!-- Bootstrap Core CSS -->--%>
<%--<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />--%>
<%--<!-- Custom CSS -->--%>
<%--<link href="css/style.css" rel='stylesheet' type='text/css' />--%>
<%--<link rel="stylesheet" href="css/morris.css" type="text/css"/>--%>
<%--<!-- Graph CSS -->--%>
<%--<link href="css/font-awesome.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="css/jquery-ui.css"> --%>
<%--<!-- jQuery -->--%>
<%--<script src="js/jquery-2.1.4.min.js"></script>--%>
<%--<!-- //jQuery -->--%>
<%--<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>--%>
<%--<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>--%>
<%--<!-- lined-icons -->--%>
<%--<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />--%>
 //lined-icons -->
</head>
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>欢迎注册运动会报名管理系统</h2>
		<form action="/login/regist" method="post">
			<div class="username">
				<span class="username">用户名:</span>
				<input type="text" name="name" class="name" placeholder="" required="true">
				<div class="clearfix"></div>
			</div>
			<div class="gender">
				<span>性别</span>
				<div class="col-sm-8">
					<select name="gender" id="gender" class="form-control1">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="username">
				<span class="username">邮箱:</span>
				<input type="text" name="email" class="name" placeholder="" required="true">
				<div class="clearfix"></div>
			</div>
			<div class="password-agileits">
				<span class="username">密码:</span>
				<input type="password" name="password" class="password" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			<div class="phone">
				<span class="phone">电话:</span>
				<input type="text" name="phone" class="phone" placeholder="" required="">
				<div class="clearfix"></div>
			</div>

			<div class="login-w3">
					<input type="submit" class="login" value="注册">
			</div>
			<div class="clearfix"></div>
		</form>
		<div class="back">
						<a href="/login/page">返回登录页</a>
				</div>
				<div class="footer">
					<p>&copy; 2016 Pooled . All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
				</div>
	</div>
	</div>
	</div>
</body>
</html>