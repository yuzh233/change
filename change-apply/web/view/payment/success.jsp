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

<c:if test="${messg==null}">
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
            <h3>支付成功</h3>
        </div>

        <c:forEach var="orderItem" items="${orderItemList}">
            <div class="info mb-2">
                <p>商品名称：${orderItem.product.name}</p>
                <p>卖家昵称：${orderItem.product.brandQuotient.name}</p>
                <p>交易总额：${orderItem.totalPrice}元</p>
                <p>购买时间：<fmt:formatDate type="both" value="${order.createDate}"/></p>
                <p>交易类型：支付宝担保交易</p>
                <p>订单号：${orderItem.id}</p>
            </div>
            <p></p>
        </c:forEach>

        <div class="info clearfix mb-2">
            <div v-if="flag">
                <p class="text-success" style="font-size: 16px;"><b>您已成功付款${order.totalPrice}元</b></p>
                <p>您可能需要：<a href="http://localhost:8080/">首页</a> | <a href="#">查看余额</a> | <a href="#">订单中心</a></p>
            </div>
        </div>

        <div class="status" v-show="status" @click="close">
            <transition name="custom-classes-transition" enter-active-class="animated tada"
                        leave-active-class="animated bounceOutRight">
                <div class="model" v-show="status">
                    <embed src="<%=webapp%>/resources/img/pok.svg" type="image/svg+xml"
                           style="widht:100px;height: 100px;"/>
                    <p>
                        支付成功
                    </p>
                </div>
            </transition>
        </div>
    </div>
</c:if>

<form method="post" action="localhost:8888/ali/pcPayment">

</form>

<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="<%=webapp%>/resources/js/jquery-3.2.1.min.js"></script>
<script src="<%=webapp%>/resources/js/popper.min.js"></script>
<script src="<%=webapp%>/resources/js/bootstrap.min.js"></script>
<script src="<%=webapp%>/resources/js/vue.min.js"></script>
<script>
    ${orderId}
    let vue = new Vue({
        el: '#app',
        data: {
            status: true, //是否显示付款成功模态框
            flag: true//是否显示付款成功信息提示
        },
        methods: {
            paymentOrder: function () {
                //显示模态框
                this.status = true;
                //显示支付成功提示信息
                this.flag = true;
            },
            close: function () {
                this.status = false;
            }
        },
    })
</script>
</body>

</html>
