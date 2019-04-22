<!-- 引入c标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 定义一个项目变量ctx -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<style>
    .error{
        font-size:3px;
        color:red;
    }
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="/static/assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="/static/assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="/static/assets/css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="/static/assets/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="/static/assets/css/jquery-ui.css">
<!-- jQuery -->
<script src="/static/assets/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="/static/assets/css/icon-font.min.css" type='text/css' />

<script src="/static/assets/js/jquery/jquery.ui.widget.js"></script>
<script src="/static/assets/js/jquery/jquery.iframe-transport.js"></script>
<script src="/static/assets/js/jquery/jquery.fileupload.js"></script>
<script src="/static/assets/js/ajax-upload/ajaxfileupload.js"></script>