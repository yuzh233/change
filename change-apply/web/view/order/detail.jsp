<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>订单详细</title>
    <link rel="stylesheet" href="../../css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>

    <link rel="stylesheet" href="../../css/order/order.css"/>
</head>
<body>
<div class="container mt-4">
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
        <h3>订单详细</h3>
    </div>

    <div class="row bg1 no-gutters order-info">
        <div class="col-md-2 col-12">收货人：</div>
        <div class="col-md-4">youjie 13135314852</div>
        <div class="col-md-2 col-12">海外仓库：</div>
        <div class="col-md-4 col-12">
            中国跨境专供1号仓库 湖南省 长沙市 开福区 马栏山 洪山街道 月湖大市场C区3栋
        </div>
        <div class="col-md-2 col-12">订单编号：</div>
        <div class="col-md-4 col-12">
            3243284384832666
        </div>
        <div class="col-md-2 col-12">订单状态：</div>
        <div class="col-md-4 col-12">
            待付款
        </div>
        <div class="col-md-2 col-12">支付宝交易号：</div>
        <div class="col-md-4 col-12">
            3243284384832666
        </div>
        <div class="col-md-2 col-12">创建时间：</div>
        <div class="col-md-4 col-12">
            2018-5-8 12:29:12
        </div>
    </div>

    <!-- 订单信息 -->
    <div class="row bg2 no-gutters mt-3">
        <div class="col-12 py-3 px-3">
            <a href="#">卖家:湖南软件职业学院</a>
        </div>
    </div>
    <!-- 订单列表 -->
    <div class="row no-gutters bg1 py-4 px-4">
        <div class="col-12">
            <div class="row no-gutters text-center border2 py-2 px-2">
                <div class="col-4">
                    货品信息
                </div>
                <div class="col">
                    单价 (元)
                </div>
                <div class="col">
                    数量
                </div>
                <div class="col">
                    优惠 (元)
                </div>
                <div class="col">
                    金额 (元)
                </div>
                <div class="col">
                    运费 (元)
                </div>
            </div>
            <div class="row no-gutters justify-content-center align-items-center text-center border1">
                <div class="col-4">
                    <div class="d-flex py-3 align-items-center">
                        <a href="#" class="d-flex align-items-center product">
                            <img src="../../img/commodity/1.webp.jpg" alt=""
                                 style="width: 80px;height: 80px;margin: 0 8px 0 0;">
                            新款超厚短袖新款超厚短袖新款超厚短袖新款超厚短袖新款超厚短袖
                        </a>
                    </div>
                </div>
                <div class="col">
                    50.00
                </div>
                <div class="col">
                    1
                </div>
                <div class="col">
                    --
                </div>
                <div class="col">
                    <b class="text-orange">50</b>
                </div>
                <div class="col">
                    <b class="text-orange">8</b>
                </div>
            </div>
            <div class="row no-gutters justify-content-center align-items-center text-center border1">
                <div class="col-4">
                    <div class="d-flex py-3 align-items-center">
                        <a href="#" class="d-flex align-items-center product">
                            <img src="../../img/commodity/1.webp.jpg" alt=""
                                 style="width: 80px;height: 80px;margin: 0 8px 0 0;">
                            新款超厚短袖新款超厚短袖新款超厚短袖新款超厚短袖新款超厚短袖
                        </a>
                    </div>
                </div>
                <div class="col">
                    50.00
                </div>
                <div class="col">
                    12
                </div>
                <div class="col">
                    --
                </div>
                <div class="col">
                    <b class="text-orange">50</b>
                </div>
                <div class="col">
                    <b class="text-orange">8</b>
                </div>
            </div>
            <div class="row no-gutters my-4">
                <div class="col-2">支付方式:</div>
                <div class="col">
                    <div class="custom-control custom-radio">
                       支付宝
                    </div>
                </div>
            </div>

            <div class="row no-gutters my-4">
                <label for="liuyan" class="col-sm-2 col-form-label">给卖家留言:</label>
                <div class="col-sm-5">
                    <input id="liuyan" type="text" class="form-control" readonly placeholder="给卖家留言">
                </div>
            </div>
        </div>
    </div>

    <!-- 总计 -->
    <div class="row no-gutters mt-3 bg1  py-4 px-4 gj">
        <h6>总计:</h6>

        <div class="col-12 text-right">
            <p>运费共计： <b>9.00</b> 元</p>

            <p>货物总金额： <b>1110.00</b> 元</p>

            <p>应付总额（含运费）： <b class="text-orange">121.00</b> 元</p>
        </div>
    </div>

    <div class="row no-gutters mt-3 bg1 justify-content-end tjdd">
        <div class="col info">
            应付总额（含运费）： <b class="text-orange">121.00</b> 元
        </div>
        <div class="col-4">
            <button class="btn  btn-block btnb1">立即付款</button>
        </div>

    </div>


</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>

</body>
</html>