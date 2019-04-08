<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>

<div class="sidebar-menu">
    <header class="logo1">
        <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
    </header>
    <div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
    <div class="menu">
        <ul id="menu" >
            <li><a href="${ctx}/index"><i class="fa fa-tachometer"></i> <span>个人信息</span><div class="personal"></div></a></li>
            <li><a href="${ctx}/sport/pages"><i class="fa fa-envelope nav_icon"></i><span>活动管理</span><div class="clearfix"></div></a></li>
            <li><a href="#"><i class="fa fa-picture-o"></i><span>比赛项目管理</span><div class="clearfix"></div></a></li>
            <li><a href="#"><i class="fa fa-bullhorn"></i><span>项目报名</span><div class="clearfix"></div></a></li>
            <li><a href="#"><i class="fa fa-glide-g"></i><span>录入分数</span><div class="clearfix"></div></a></li>
            <li><a href="#"><i class="fa  fa-yoast"></i><span>查看排行</span><div class="clearfix"></div></a></li>
            <li><a href="/log/list"><i class="fa  fa-universal-access"></i><span>操作日志</span><div class="clearfix"></div></a></li>
            <li><a href="/user/list"><i class="fa   fa-male"></i><span>用户管理</span><div class="clearfix"></div></a></li>
            <li><a href="${ctx}/login/exit"><i class="fa   fa-dot-circle-o"></i><span>登出系统</span><div class="clearfix"></div></a></li>
        </ul>
    </div>
</div>