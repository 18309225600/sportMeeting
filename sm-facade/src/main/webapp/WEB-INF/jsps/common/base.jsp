<!-- 引入c标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 定义一个项目变量ctx -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<style>
	.error{
		font-size:3px;
		color:red;
	}
</style>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>