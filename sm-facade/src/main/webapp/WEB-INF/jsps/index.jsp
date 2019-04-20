<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>运动会管理系统</title>
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
    <!-- jQuery -->
    <script src="/static/assets/js/jquery-2.1.4.min.js"></script>
    <!-- //jQuery -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href="/static/assets/css/icon-font.min.css" type='text/css' />
    <!-- //lined-icons -->
</head>
<body>
<div class="page-container">
    <!--/content-inner-->
    <div class="left-content">
        <div class="mother-grid-inner">
            <div class="inbox-mail">
                <div class="col-md-9 compose w3layouts">

                    <div class="table-img" style="text-align: center;">
                        <img class="headImgSucc" src="${ctx}${sessionScope.user.img}" alt="头像" width="200px" height="200px">
                    </div>

                    <div class="tab-content">
                        <div class="tab-pane active" id="horizontal-form">
                            <form class="form-horizontal">
                                <input type="hidden" class="userId" value="${sessionScope.user.id}">
                                <div class="form-group headImg" hidden>
                                    <div class="col-sm-8">
                                        <input type="file" id="file" name="file" class="headImg">
                                        <input type="hidden" name="img" class="img" value="${sessionScope.user.img}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput1" class="col-sm-2 control-label">姓名</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 username" id="disabledinput1" placeholder="${sessionScope.user.username}" value="${sessionScope.user.username}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput2" class="col-sm-2 control-label">性别</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 gender" id="disabledinput2"  placeholder="${sessionScope.user.gender}" value="${sessionScope.user.gender}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput3" class="col-sm-2 control-label">手机号</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 phone" id="disabledinput3" placeholder="${sessionScope.user.phone}" value="${sessionScope.user.phone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput4" class="col-sm-2 control-label">邮箱</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 email" id="disabledinput4" placeholder="${sessionScope.user.email}" value="${sessionScope.user.email}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput5" class="col-sm-2 control-label">角色</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 role" id="disabledinput5" placeholder="${sessionScope.user.role eq 'user' ? '普通用户' : '管理员'}" value="${sessionScope.user.role eq 'user' ? '普通用户' : '管理员'}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="disabledinput6" class="col-sm-2 control-label">注册时间</label>
                                    <div class="col-sm-8">
                                        <input disabled type="text" class="form-control1 createAt" id="disabledinput6" placeholder="<fmt:formatDate value="${sessionScope.user.createAt}" pattern="yyyy-MM-dd HH:mm:ss" />" value="<fmt:formatDate value="${sessionScope.user.createAt}" pattern="yyyy-MM-dd HH:mm:ss" />">
                                    </div>
                                </div>

                                <a class="hvr-icon-rotate col-23 editPerson">编辑</a>
                                <a class="hvr-icon-fade col-7 savePerson">保存</a>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!--//content-inner-->
    <!--/sidebar-menu-->
    <jsp:include  page="/WEB-INF/jsps/common/navigator.jsp" flush="true"/>
</div>
<script src="/static/assets/js/index/index.js"></script>
<script>
    var toggle = true;

    $(".sidebar-icon").click(function() {
        if (toggle)
        {
            $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
            $("#menu span").css({"position":"absolute"});
        }
        else
        {
            $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
            setTimeout(function() {
                $("#menu span").css({"position":"relative"});
            }, 400);
        }

        toggle = !toggle;
    });
</script>

<script>
    $(document).ready(function() {
        //BOX BUTTON SHOW AND CLOSE
        jQuery('.small-graph-box').hover(function() {
            jQuery(this).find('.box-button').fadeIn('fast');
        }, function() {
            jQuery(this).find('.box-button').fadeOut('fast');
        });
        jQuery('.small-graph-box .box-close').click(function() {
            jQuery(this).closest('.small-graph-box').fadeOut(200);
            return false;
        });

        //CHARTS
        function gd(year, day, month) {
            return new Date(year, month - 1, day).getTime();
        }
    });
</script>
</body>
</html>