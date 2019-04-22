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

<jsp:include  page="/WEB-INF/jsps/common/navigator.jsp" flush="true"/>
<div class="page-container">
    <!--/content-inner-->
    <div class="left-content">
        <div class="mother-grid-inner">
            <div class="validation-system">
                <div class="validation-form">
                    <form>
                        <input type="hidden" name="id" class="id" value="${item.id}">
                        <div class="vali-form">
                            <div class="col-md-6 form-group1">
                                <label class="control-label">比赛项目名称</label>
                                <input type="text" name="itemName" placeholder="比赛项目名称" class="itemName" required="" value="${item.itemName}">
                            </div>
                        </div>

                        <div class="col-md-12 form-group1 group-mail">
                            <label class="control-label ">最大报名人数（不填默认10个）</label>
                            <input type="text" name="itemMaxUserNum" placeholder="最大报名人数" class="itemMaxUserNum" required="" value="${item.itemMaxUserNum}">
                        </div>


                        <div class="col-md-12 form-group1 ">
                            <label class="control-label">比赛项目说明</label>
                            <textarea name="itemDesc" class="itemDesc" placeholder="比赛项目说明" required="">${item.itemDesc}</textarea>
                        </div>

                        <div class="col-md-12 form-group1 group-mail">
                            <label class="control-label ">开始时间</label>
                            <input type="date" name="startAt" class="form-control1 ng-invalid ng-invalid-required startAt" ng-model="model.date" required="" value="${sport.startAt}">
                        </div>

                        <div class="col-md-12 form-group1 group-mail">
                            <label class="control-label ">结束时间</label>
                            <input type="date" name="endAt" class="form-control1 ng-invalid ng-invalid-required endAt" ng-model="model.date" required="" value="${sport.endAt}">
                        </div>

                        <div class="col-md-12 form-group">
                            <button type="button" class="btn btn-primary addBtn">Submit</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </div>
                        <div class="clearfix"> </div>
                    </form>

                    <!---->
                </div>

            </div>
        </div>
    </div>
</div>
<script src="/static/assets/js/sport/itemOpPage.js"></script>
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