<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>运动会管理系统</title>
</head> 
<body>
	<div class="main-wthree">
	<div class="container">
	<div class="sin-w3-agile">
		<h2>欢迎登录运动会报名系统</h2>
		<form action="/login/login" method="post">
			<p style="color:red;">${msg}</p>
			<div class="username">
				<span class="username" style="text-align: center;">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
				<input type="text" name="email" class="name" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			<div class="password-agileits">
				<span class="username">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
				<input type="password" name="password" class="password" placeholder="" required="">
				<div class="clearfix"></div>
			</div>
			<div class="rem-for-agile">
				<a href="/login/regist">还没有账号？前往注册</a><br>
			</div>
			<div class="login-w3">
					<input type="submit" class="login loginBtn" value="登录">
			</div>
			<div class="clearfix"></div>
		</form>
				<div class="footer">
					<p>&copy; 运动会管理系统仅限运动会相关工作使用，切勿录入其他数据！</p>
				</div>
	</div>
	</div>
	</div>
</body>
<script src="/static/assets/js/login/signin.js"></script>
</html>