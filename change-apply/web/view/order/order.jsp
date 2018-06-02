<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String webapp = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>确认订单</title>
    <link rel="stylesheet" href="<%=webapp%>/resources/css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="<%=webapp%>/resources/css/base.css"/>

    <link rel="stylesheet" href="<%=webapp%>/resources/css/order/order.css"/>
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
        <h3>确认订单</h3>
    </div>

    <div class="row bg1 no-gutters addr p-3">
        <div class="col-md-2 col-12">海外仓库：</div>
        <div class="col-md-8 col-12">
            <div class="custom-control custom-radio ">
                <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input py-md-4 py-2"
                       checked="checked">
                <label class="custom-control-label d-block py-md-4 py-2" for="customRadio1" v-if="order!=null">
                    <div class="info">
                        <span>{{order.country.name}} {{order.storehouse.name}}</span>
                    </div>
                    <div class="op">
                        <a href="#" title="">修改</a>
                        <a href="#" title="">设为默认</a>
                    </div>
                </label>
            </div>

        </div>
    </div>

    <!-- 订单信息 -->
    <div class="row bg2 no-gutters mt-3">
        <div class="col-12 py-3 px-3">
            <a href="#" v-if="order!=null">卖家: {{order.brandQuotient.name}}</a>
        </div>
    </div>
    <form action="<%=webapp%>/order/addOrder" method="post">
        <!-- 订单列表 -->
        <div class="row no-gutters bg1 py-4 px-4">
            <div class="col-12">
                <div class="row no-gutters text-center border2 py-2 px-2 d-none d-md-flex">
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

                <template v-if="order!=null">
                    <div class="row no-gutters justify-content-center align-items-center text-center border1"
                         v-for="(item,index) in order.order.orderItems">
                        <input type="hidden" :name="'orderItems['+index+'].productId'" :value="item.product.id"/>
                        <input type="hidden" :name="'orderItems['+index+'].count'" :value="item.count"/>

                        <div class="col-md-4 col-12">
                            <a class="d-flex py-md-3 align-items-center product" :href="'<%=webapp%>/product/${order.storehouseId}/'+item.product.id+''">
                                <img :src="'https://change-data.oss-cn-shenzhen.aliyuncs.com/'+order.imgs[index].url"
                                     style="width:100px;height: 100px;margin: 8px;">
                                <span>{{item.product.name}}</span>
                            </a>
                        </div>
                        <div class="col d-none d-md-block" v-if="order!=null">
                            {{item.unitPrice}}
                        </div>
                        <div class="col text-center order-md-0 order-9">
                            <span class="d-md-none d-inline"><b>X</b> </span><input type="number"
                                                                                    class="form-control d-inline"
                                                                                    style="width: 70px;"
                                                                                    v-model="item.count">
                        </div>
                        <div class="col order-2 order-md-0">
                            <span class="d-md-none d-inline">优惠：</span>--
                        </div>
                        <div class="col order-md-0 order-1">
                            <span class="d-md-none d-inline">总价：</span><b class="text-orange">{{item.unitPrice *
                            item.count}}</b>
                        </div>
                        <div class="col d-none d-md-block">
                            <span class="d-md-none d-inline">运费：</span><b class="text-orange">--</b>
                        </div>
                    </div>
                </template>

                <div class="row no-gutters my-4">
                    <div class="col-md-2 col-4">支付方式:</div>
                    <div class="col">
                        <div class="custom-control custom-radio">
                            <input type="radio" id="p1" name="ppp" class="custom-control-input" checked="checked">
                            <label class="custom-control-label" for="p1">支付宝</label>
                        </div>
                    </div>
                </div>

                <div class="row no-gutters my-4">
                    <label for="liuyan" class="col-sm-2 col-form-label">给卖家留言:</label>
                    <div class="col-sm-5">
                        <input id="liuyan" type="text" class="form-control" placeholder="给卖家留言" name="message">
                    </div>
                </div>
            </div>
        </div>

        <!-- 总计 -->
        <div class="row no-gutters mt-3 bg1  py-4 px-4 gj">
            <h6>总计:</h6>

            <div class="col-12 text-right">
                <p>运费共计： <b>0.00</b> 元</p>
                <p>货物总金额： <b v-if="order!=null">{{allMoney}}</b> 元</p>
                <p>应付总额（含运费）： <b class="text-orange" v-if="order!=null">{{allMoney}}</b> 元</p>
            </div>
        </div>

        <div class="row no-gutters mt-3 bg1 justify-content-end tjdd">
            <div class="col info">
                <span v-if="order!=null">应付总额（含运费）： <b class="text-orange">{{allMoney}}</b> 元</span>
                <span v-if="order==null">订单错误，商品不存在 或 库存不足</span>
            </div>
            <div class="col-md-4">
                <input type="hidden" :value="order.storehouse.id" name="storehouseId" v-if="order!=null"/>
                <button type="submit" class="btn btn-block btnb1" :disabled="order==null">提交订单</button>
            </div>
        </div>
    </form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="<%=webapp%>/resources/js/jquery-3.2.1.min.js"></script>
<script src="<%=webapp%>/resources/js/popper.min.js"></script>
<script src="<%=webapp%>/resources/js/bootstrap.min.js"></script>
<script src="<%=webapp%>/resources/js/vue.js"></script>
<script src="<%=webapp%>/resources/js/axios.min.js"></script>

<script>

    let vue = new Vue({
        el: '#app',
        data: {
            order: {
                "country": {
                    "id": "",
                    "name": "",
                    "createDate": "",
                    "updateDate": "",
                    "tableIndex": 0
                },
                "imgs": [
                    {
                        "id": 0,
                        "url": "",
                        "type": 0,
                        "createDate": "",
                        "updateDate": null,
                        "tableIndex": 0,
                        "productId": 0,
                        "product": {
                            "id": "0",
                            "name": "",
                            "subTitle": null,
                            "price": 15.0,
                            "description": null,
                            "status": 0,
                            "createDate": "0",
                            "updateDate": null,
                            "tableIndex": 0,
                            "productCategoryId": 0,
                            "companyId": 0,
                            "brandQuotientId": 0,
                            "productCategory": null,
                            "company": null,
                            "brandQuotient": null
                        }
                    }
                ],
                "storehouseProductStock": {
                    "id": "0",
                    "stock": 50,
                    "price": 99.0,
                    "createDate": "",
                    "updateDate": "",
                    "tableIndex": 0,
                    "productId": "",
                    "storehouseId": "",
                    "productCategoryId": "",
                    "companyId": "",
                    "storehouse": null,
                    "product": null,
                    "productCategory": null,
                    "company": null
                },
                "brandQuotient": {
                    "id": "",
                    "username": "",
                    "password": "",
                    "name": "",
                    "phone": "",
                    "email": "",
                    "createDate": "",
                    "updateDate": "",
                    "status": 0,
                    "tableIndex": 0,
                    "companyId": "",
                    "company": null
                },
                "storehouse": {
                    "id": "1",
                    "name": "",
                    "address": "",
                    "description": "",
                    "createDate": "",
                    "updateDate": "",
                    "tableIndex": 0,
                    "storehouseCountryId": "",
                    "storehouseCountry": null
                },
                "order": {
                    "id": "0",
                    "orderCode": null,
                    "totalPrice": 0.0,
                    "message": null,
                    "createDate": null,
                    "updateDate": null,
                    "tableIndex": 0,
                    "storehouseId": "0",
                    "shopkeeperId": "0",
                    "brandQuotientId": "0",
                    "storehouse": null,
                    "shopkeeper": null,
                    "brandQuotient": null,
                    "orderItems": []
                }
            }
            ,
        },
        mounted: function () {
            //获取数据
            let _this = this;
            var params = new URLSearchParams();
            <c:forEach items="${order.orderItems}" var="item" varStatus="status">
                params.append('orderItems[${status.index}].productId', '${item.productId}');
                params.append('orderItems[${status.index}].count', '${item.count}');
            </c:forEach>
            params.append('storehouseId', '${order.storehouseId}');
            axios.post('<%=webapp%>/order/previewdata', params)
                .then(function (response) {
                    _this.order = (response.data == '' || response.data == null) ? null : response.data;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        computed: {
            allMoney: function () {
                let sum = 0;
                if (this.order == null) return 0;
                this.order.order.orderItems.forEach(function (value, index, array) {
                    sum += value.unitPrice * value.count;
                });
                return sum;
            }
        },
        methods: {}
    })
</script>
</body>
</html>