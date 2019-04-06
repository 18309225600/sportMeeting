<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Sign In</title>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
<%--<meta name="keywords" content="" />--%>
<%--<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>--%>
<%--<!-- Bootstrap Core CSS -->--%>
<%--<link href="/static/assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />--%>
<%--<!-- Custom CSS -->--%>
<%--<link href="/static/assets/css/style.css" rel='stylesheet' type='text/css' />--%>
<%--<link rel="stylesheet" href="/static/assets/css/morris.css" type="text/css"/>--%>
<%--<!-- Graph CSS -->--%>
<%--<link href="/static/assets/css/font-awesome.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="/static/assets/css/jquery-ui.css">--%>
<%--<!-- jQuery -->--%>
<%--<script src="/static/assets/js/jquery-2.1.4.min.js"></script>--%>
<%--<!-- //jQuery -->--%>
<%--<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>--%>
<%--<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>--%>
<%--<!-- lined-icons -->--%>
<%--<link rel="stylesheet" href="/static/assets/css/icon-font.min.css" type='text/css' />--%>
<!-- //lined-icons -->
</head> 
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>欢迎登录运动会报名系统</h2>
		<form action="/login/login" method="post">
			<div class="username">
				<span class="username" style="text-align: center;">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
				<input type="text" name="name" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			<div class="password-agileits">
				<span class="username">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
				<input type="password" name="password" class="password" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			<div class="rem-for-agile">
				<input type="checkbox" name="remember" class="remember">记住密码<br>
				<a href="/login/regist">还没有账号？前往注册</a><br>
			</div>
			<div class="login-w3">
					<input type="submit" class="login" value="登录">
			</div>
			<div class="clearfix"></div>
		</form>
				<div class="footer">
					<p>&copy; 2016 Pooled . All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
				</div>
	</div>
	</div>
	</div>
</body>
</html>