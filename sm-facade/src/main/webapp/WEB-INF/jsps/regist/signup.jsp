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
			<p>&copy; 运动会管理系统仅限运动会相关工作使用，切勿录入其他数据！</p>
		</div>
	</div>
	</div>
	</div>
</body>
</html>