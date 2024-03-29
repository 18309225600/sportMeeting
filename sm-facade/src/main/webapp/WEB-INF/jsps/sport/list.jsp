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
    <link rel="stylesheet" type="text/css" href="/static/assets/css/table-style.css" />
    <link rel="stylesheet" type="text/css" href="/static/assets/css/basictable.css" />
    <script type="text/javascript" src="/static/assets/js/jquery.basictable.min.js"></script>
</head>
<body>
<jsp:include  page="/WEB-INF/jsps/common/navigator.jsp" flush="true"/>
<div class="page-container">
    <!--/content-inner-->
    <div class="left-content">
        <div class="w3l-table-info">
            <h2>运动会活动管理</h2>
            <table id="table">
                <thead>
                    <tr>
                        <th>活动名称</th>
                        <th>活动开始时间</th>
                        <th>活动结束时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list.list}" var="detail">
                        <tr>
                            <input type="hidden" class="id" value="${detail.id}">
                            <td data-th="Name"><span class="bt-content">${detail.name}</span></td>
                            <td data-th="Age"><span class="bt-content"><fmt:formatDate value="${detail.startAt}" pattern="yyyy-MM-dd"></fmt:formatDate></span></td>
                            <td data-th="Gender"><span class="bt-content"><fmt:formatDate value="${detail.endAt}" pattern="yyyy-MM-dd"></fmt:formatDate></span></td>
                            <td>
                                <a href="/sport/addSport?sportId=${detail.id}" class="hvr-icon-rotate col-12 editBtn">编辑</a>
                                <a class="hvr-icon-sink-away col-12 delBtn">删除</a>
                                <a href="/sport/items1?sportId=${detail.id}" class="hvr-icon-forward col-2">比赛项目</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

                <div class="col-md-2 agileits-w3layouts-bnt" style="float:right;">
                    <div class="bg-danger dark pv10 text-white fw100 text-center"><a class="addActivity" href="/sport/addSport">添加活动</a></div>
                </div>

            </table>

            <%--pageInfo--%>
            <br>
            <div style="text-align: center;">
                <input type="hidden" id="pageNo" value="${pageNo}"/>
                <input type="hidden" id="totalPage" value="${list.pages}"/>
                <div>
                    <strong style="float: left;">当前第${list.pageNum}/${list.pages}页，共记${list.total}条数据</strong>
                    <button type="buttom" id="firstPage" class="btn btn-secondary">首页</button>
                    <button type="buttom" id="proidPage" class="btn btn-success">上一页</button>
                    <button type="buttom" id="nextPage" class="btn btn-success">下一页</button>
                    <button type="buttom" id="endPage" class="btn btn-secondary">尾页</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/assets/js/sport/list.js"></script>
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