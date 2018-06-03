<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String webapp = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>支付信息</title>
    <link rel="stylesheet" href="<%=webapp%>/resources/css/bootstrap4.min.css">
    <link rel="stylesheet" href="<%=webapp%>/resources/css/user/login.css">
    <link rel="stylesheet" href="<%=webapp%>/resources/css/payment/payment.css">

    <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">

</head>

<body>

<div class="container mt-4" id="app">
    <div class="row title">
        <div class="col-md-4 col-12 head ">
            <div class="row no-gutters">
                <div class="col-7 ">
                    <div class="logo">Cheng</div>
                </div>
                <div class="col-5 ">
                    <div class="title ml-2 ">
                        <div class="name">跨境专供</div>
                        <div class="addrurl">kj.cheng.com</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="vhr1"></div>
        <h3>支付失败</h3>
    </div>

    <div class="info clearfix mb-2">
        <div v-if="flag">
            <p class="text-success" style="font-size: 16px;"><b>失败原因：${message}</b></p>
            <p>您可能需要：<a href="http://localhost:8080/">首页</a> | <a href="#">查看余额</a> | <a href="#">订单中心</a></p>
        </div>
    </div>

</div>

<script src="<%=webapp%>/resources/js/jquery-3.2.1.min.js"></script>
<script src="<%=webapp%>/resources/js/popper.min.js"></script>
<script src="<%=webapp%>/resources/js/bootstrap.min.js"></script>
<script src="<%=webapp%>/resources/js/vue.min.js"></script>
</body>

</html>
