<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String webapp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
${request.context}
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>
    <link rel="stylesheet" href="<%=webapp%>/resources/css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="<%=webapp%>/resources/css/base.css"/>

    <link rel="stylesheet" href="<%=webapp%>/resources/css/product/detail.css"/>
</head>

<body>
<div id="app">
    <div class="head d-none d-md-block">
        <div class="container">
            <a href="#">
                <h1 class="logo">
                    Change
                </h1>
                <div class="title">
                    <div class="name">跨境专供</div>
                    <div class="addr">kj.change.com</div>
                </div>
            </a>
            <div class="supplier mx-4">
                <img src="<%=webapp%>/resources/img/lb4.jpg" alt=""/>
                <div class="name ml-2" >
                    <%--<span v-if="product.brandQuotient!=null">{{product.brandQuotient.name}}</span>--%>
                    <br/>
                    <img src="https://cbu01.alicdn.com/cms/upload/2016/790/696/2696097_1254399316.png" alt="诚信"/>
                    <span class="text-danger">
							3年
						</span>
                    <img src="https://cbu01.alicdn.com/cms/upload/2015/797/334/2433797_1490276829.png" alt="卖家保证"/>
                    <img src="https://cbu01.alicdn.com/cms/upload/2015/157/534/2435751_1490276829.png" alt="企业认证"/>
                </div>
                <div class="info mx-4 text-center">
                    <div class="item">
                        <div>回头率</div>
                        <div class="text-danger">5%</div>
                    </div>
                    <div class="item">
                        <div>响应速度</div>
                        <div class="text-success">5%</div>
                    </div>
                    <div class="item">
                        <div>级别</div>
                        <div class="text-primary">小白供应商</div>
                    </div>
                    <div class="item">
                        <div>成交量</div>
                        <div class="text-info">5%</div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!--广告-->
    <div class="d-none d-sm-block">
        <img src="<%=webapp%>/resources/img/b4.jpg" alt="" class="img-fluid gg1"/>
    </div>
    <div class="container-fluid product my-sm-2">

        <!--商品信息-->
        <h5 class="d-none d-md-block" v-if="product.selectProduct!=null">{{product.selectProduct.name}}</h5>
        <!-- 商品图片&商品信息 -->
        <div class="row no-gutters">
            <!--商品图片-->
            <div class="col-md-4 pimg">
                <img :src="'https://change-data.oss-cn-shenzhen.aliyuncs.com/'+product.productCover.url"
                     class="img-fluid" id="preImg"/>
                <div class="imglist">
                    <div class="row no-gutters mt-2">
                        <div class="col-2" v-for="(item, index) in product.productImages">
                            <img class="img-fluid" :src="'https://change-data.oss-cn-shenzhen.aliyuncs.com/'+item.url"
                                 alt="" @mouseenter="preimg(index)">
                        </div>
                    </div>
                </div>
            </div>
            <!--商品信息-->
            <h6 class="d-block d-md-none py-2 px-2">6593夏季新款男士短袖衬衣 韩版条纹修身衬衫男 商务休闲男装</h6>
            <div class="col-md-6 pinfo">
                <div class="row price no-gutters">
                    <div class="col-md-2">价格</div>
                    <div class="col-md-10">
                        <div class="row priceNum no-gutters">
                            <div class="col-4">¥ {{product.storehouseProductStock.price}}</div>
                            <div class="col-4">¥ {{product.storehouseProductStock.price}}</div>
                            <div class="col-4">¥ {{product.storehouseProductStock.price}}</div>
                        </div>
                    </div>
                    <div class="col-md-2 my-1">起批价</div>
                    <div class="col-md-10 my-1">
                        <div class="row no-gutters">
                            <div class="col-4">1-1件</div>
                            <div class="col-4">1-1件</div>
                            <div class="col-4">1-1件</div>
                        </div>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">仓库</div>
                    <div class="col">{{product.country.name}} {{product.storehouse.name}}</div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">成交\评价</div>
                    <div class="col">
                        <span class="wjx">★★★★</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="text-warning">--</span>件成交&nbsp;&nbsp;&nbsp;&nbsp;<span
                            class="text-danger">{{product.reviewCount}}</span>条评价
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">颜色</div>
                    <div class="col">
                        <img src="https://cbu01.alicdn.com/img/ibank/2017/299/535/4269535992_2124983987.32x32.jpg"
                             alt="红色">
                        <img src="https://cbu01.alicdn.com/img/ibank/2017/552/055/4269550255_2124983987.32x32.jpg"
                             alt="浅蓝色"
                             data-spm-anchor-id="a261y.7663282.0.i35.243a6c18Dm7CKi">
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">库存</div>
                    <div class="col">{{product.storehouseProductStock.stock}}</div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2" style="line-height: 38px;">数量</div>
                    <div class="col-3"><input type="number" class="form-control" value="1" v-model="productCount"/>
                    </div>
                </div>
                <div class="row no-gutters d-none d-md-flex">
                    <div class="col-md-2"></div>
                    <div class="col">
                        <form action="<%=webapp%>/order/preview" method="post">
                            <input type="hidden" :value="product.selectProduct.id" name="orderItems[0].productId"/>
                            <input type="hidden" :value="productCount" name="orderItems[0].count"/>
                            <input type="hidden" :value="product.storehouse.id" name="storehouseId"/>
                            <button type="submit " class="btn btn-block btnb1">立即订购</button>
                        </form>
                    </div>
                    <div class="col">
                        <button type="button" class="btn  btn-block btnb2">加入订购单</button>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">买家服务</div>
                    <div class="col icon">
                        <a href="#" target="_blank" trace="cxbzhelp"
                           style="background:url('https://cbu01.alicdn.com/cms/upload/2015/177/505/2505771_1964054271.png') no-repeat 0 2px;"
                           title="该卖家已开通48小时发货服务，承诺在支付成功后48小时内为您发货。">48小时发货</a>
                        <a href="#" target="_blank" trace="cxbzhelp"
                           style="background:url('https://cbu01.alicdn.com/cms/upload/2015/577/505/2505775_1964054271.png') no-repeat 0 2px;"
                           title="该卖家已开通15天包换服务，您可在签收货物后的15天内更换商品。">15天包换</a>
                        <a href="#" target="_blank" trace="cxbzhelp"
                           style="background:url('https://cbu01.alicdn.com/cms/upload/2015/423/215/2512324_329576842.png') no-repeat 0 2px;"
                           title="卖家支持先行赔付，保障买家交易安全。">买家保障</a>
                        <a href="#" target="_blank" trace="cxbzhelp"
                           style="background:url('https://cbu01.alicdn.com/cms/upload/2015/188/805/2508881_1265251585.png') no-repeat 0 2px;"
                           title="该产品已支持诚e赊， 为买家提供确认收货后30天免费赊账。">免费赊账</a>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-2">支付方式</div>
                    <div class="col ">
                        支付宝
                    </div>
                </div>
            </div>
            <!--买家还看了 -->
            <div class="col-md-2 px-4 d-none d-md-block other">
                <p style="font-size: 13px;">买家还看了:</p>
                <div class="row">
                    <div class="col-12">
                        <a href="#">
                            <img src="<%=webapp%>/resources/img/commodity/6.webp.jpg" class="img-fluid" alt="">
                        </a>
                    </div>
                    <div class="col-12">
                        <a href="#">
                            <img src="<%=webapp%>/resources/img/commodity/6.webp.jpg" class="img-fluid" alt="">
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- 店主推荐 -->
        <div class="d-none d-md-block my-4">
            <div class="row  tj no-gutters">
                <div class="col-12"><h5>店主推荐</h5></div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>
                <div class="col-md-2 p-2">
                    <a href="#" title="">
                        <img src="<%=webapp%>/resources/img/commodity/4.webp.jpg" alt="" class="img-fluid">
                    </a>
                </div>

            </div>
        </div>


        <!-- 卖家信息&商品详细&评论 -->
        <div class="row no-gutters mt-4">
            <div class="d-supplier col-md-2">
                <h6>商家详细信息</h6>
                <a href="#">
                    <div class="row text-center justify-content-center no-gutters mt-3">
                        <img src="<%=webapp%>/resources/img/detail/logo.png" class="img-fluid" alt="">
                        <p>EnllerviiD/英雷威官方旗舰店</p>
                    </div>
                    <div class="row no-gutters justify-content-center">
                        <i class="icon "></i> 5年
                        <i class="icon quality"></i>
                        <i class="icon shipment"></i>
                        <i class="icon exchange"></i>
                    </div>
                </a>

                <div class="row no-gutters mt-2 info">
                    <div class="col-4">联系卖家：</div>
                    <%--<div class="col-8">{{product.brandQuotient.name}}</div>--%>
                    <div class="col-4">卖家电话：</div>
                    <%--<div class="col-8">{{product.brandQuotient.phone}}</div>--%>
                    <div class="col-4">经营模式：</div>
                    <div class="col-8">生产厂家</div>
                    <div class="col-4">所在地区：</div>
                    <div class="col-8">福建 泉州</div>
                </div>
                <div class="row no-gutters mt-2 text-center">
                    <div class="col text-secondary">
                        <div>回头率</div>
                        <p class="text-danger">5%</p>
                    </div>
                    <div class="col">
                        <div>响应速度</div>
                        <p class="text-success">5%</p>
                    </div>
                    <div class="col">
                        <div>成交量</div>
                        <p class="text-info">5%</p>
                    </div>

                </div>
                <div class="row no-gutters mt-2">
                    <div class="col-12 px-4 text-center">
                        <button class="btn btn-block btn-info">进入店铺</button>
                    </div>
                </div>
            </div>
            <!-- 商品详细&评论 -->
            <div class="d-product col-md-10 mt-4 mt-md-0 ">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" @click="detail()">详细信息</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" @click="review()">成交(100)</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
                           @click="review()">评论({{product.reviewCount}})</a>
                    </li>
                </ul>
                <div class="tab-content" id="pills-tabContent">
                    <!-- 商品详细 -->
                    <div class="tab-pane fade show active" id="pills-home">
                        <!-- 商品属性 -->
                        <div class="row attribute no-gutters">
                            <div class="col-md-4" v-for="item in product.propertyKeyValues">
                                <div class="row">
                                    <div class="col-5">{{item.key}}</div>
                                    <div class="col-7">{{item.val}}</div>
                                </div>
                            </div>

                        </div>
                        <!-- 详细介绍 -->
                        <div class="detail my-4">
                            {{product.selectProduct.description}}
                        </div>
                    </div>
                    <div class="tab-pane fade" id="pills-profile">...</div>

                    <div class="tab-pane fade" id="pills-contact">
                        <!-- <div class="row mb-3 no-gutters">
                            <div class="col-10">
                                <textarea class="form-control"  rows="3"></textarea>
                            </div>
                            <div class="col-2">
                                <button class="btn btn-primary btn-block">评论</button>
                            </div>
                        </div> -->
                        <!-- 评论列表 -->
                        <ul class="list-unstyled ">
                            <li class="media" v-for="(item,index) in reviewdata" >
                                <img class="mr-3" src="<%=webapp%>/resources/img/user.png"
                                     alt="Generic placeholder image">
                                <div class="media-body">
                                    <h5 class="mt-0 mb-1" v-if="item.shopkeeper!=null&&item.shopkeeper.name!=null">{{item.shopkeeper.name}}</h5>
                                    <h6><span class="pldate">{{item.createDate}}</span><span class="wjx">★★★★★</span></h6>
                                    {{item.content}}
                                </div>
                            </li>
                        </ul>
                        {{reviewMesg}}
                    </div>
                </div>

            </div>
        </div>

    </div>

    <!-- 手机端的下单&收藏&购物车 -->
    <div class="op d-block d-sm-none">
        <div class="row no-gutters">
            <div class="col-2">
                <button type="button" class="btn  btn-block btnb3">☆</button>
            </div>
            <div class="col">
                <button type="button" class="btn  btn-block btnb2">加入订购单</button>
            </div>
            <div class="col">
                <button type="button " class="btn  btn-block btnb1">立即订购</button>
            </div>
        </div>
    </div>
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
            product: {},
            productCount: 1,

            page:1,
            reviewdata:[],
            reviewPage:0,
            isReview:false,
            reviewMesg:'下拉加载......',
            isclickReview:false
        },
        created: function () {
            //获取数据
            let _this = this;
            // 商品信息
            axios.get('<%=webapp%>/product/data/${storehouse}/${id}')
                .then(function (response) {
                    _this.product = response.data
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        methods: {
            preimg: function (i) {
                this.product.productCover.url = this.product.productImages[i].url
            },
            review: function () {
                this.isReview = true;
                if(this.isclickReview) {
                    return;
                }
                let _this = this;
                this.isclickReview = true
                axios.get('<%=webapp%>/product/review/${id}/'+_this.page+'/5')
                    .then(function (response) {
                        _this.reviewdata = response.data.rows
                        _this.reviewPage = response.data.total%5==0?parseInt(response.data.total/5):parseInt(response.data.total/5)+1;
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log("error");
                    });
            },
            detail() {
                this.isReview = false;
            }
        }

    })

    $(window).scroll(function(){
        var scrollTop = $(this).scrollTop();
        var scrollHeight = $(document).height();
        var windowHeight = $(this).height();
        if(parseInt(scrollTop + windowHeight)+5 >= scrollHeight){
            console.log("已经到最底部了！");
            if(vue.page>=vue.reviewPage) {
                vue.reviewMesg = '没有更多数据了。。。。'
                return null;
            }else if(vue.isReview==false)
                return;
            vue.isReview=false
            vue.reviewMesg = '正在加载。。。。'
            vue.page = vue.page+1;
            axios.get('<%=webapp%>/product/review/${id}/'+vue.page+'/5')
                .then(function (response) {
                    response.data.rows.forEach(function(e) {
                        vue.reviewdata.push(e)
                    })
                    vue.isReview=true
                })
                .catch(function (error) {
                    console.log("error");
                });
        }

    });
</script>

</body>

</html>