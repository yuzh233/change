<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/resources/css/base.css"/>
    <title>Hello, world!</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            newProduct();
            rankingList();
            companyList();
            categoryProductList("女装", "category_1");
            categoryProductList("男装", "category_2");
            categoryProductList("办公文教", "category_3");
            categoryProductList("美妆护肤", "category_4");
            categoryProductList("玩具", "category_5");
            categoryProductList("日用百货", "category_6");
        });

        //加载最新产品
        function newProduct() {
            $.ajax({
                url: "${pageContext.request.contextPath}/newProduct",
                method: "get",
                dataType: "json",
                success: function (data) {
                    $.each(data, function (index, option) {
                        var product = option.product;
                        var productImage = option.productImage;
                        var productDiv = "<div class='col-6 col-md-3'><a href='http://www.baidu.com' class='commodity' target='_blank'><img class='img-fluid' src='http://change-data.oss-cn-shenzhen.aliyuncs.com/" + productImage.url + "?x-oss-process=image/resize,m_lfit,h_300,w_300' alt=''><p class='name'>" + product.name + "</p><div class='info clearfix'><span class='money'>￥:" + product.price + "</span><span class='number'>10010件</span></div><button type='button' class='btn btn-primary btn-lg btn-block'>立即抢批</button></a></div>";
                        $("#newProduct").append(productDiv);
                    });
                }
            });
        }

        //加载商品排行榜
        function rankingList() {
            $.ajax({
                url: "${pageContext.request.contextPath}/rankingList",
                method: "get",
                dataType: "json",
                success: function (data) {
                    var i = 1;
                    $.each(data, function (key, value) {
                        var product = value.product;
                        var productImage = value.productImage;
                        var productDiv = "<a href='http://www.baidu.com' class='item' target='_blank'><div class='row no-gutters'><div class='col-3 img-fluid text-center'><img src='http://change-data.oss-cn-shenzhen.aliyuncs.com/" + productImage.url + "?x-oss-process=image/resize,m_lfit,h_80,w_80'></div><div class='col-9 name'><div class='number'>" + key + "</div><div>" + product.name + "</div></div></div> </a>";
                        if (i > 0 && i < 5) $("#rankingList1").append(productDiv);
                        if (i > 4 && i < 9) $("#rankingList2").append(productDiv);
                        if (i > 8 && i < 13) $("#rankingList3").append(productDiv);
                        i++;
                    });
                }
            });
        }

        // 加载优选企业
        function companyList() {
            $.ajax({
                url: "${pageContext.request.contextPath}/companyList",
                method: "get",
                dataType: "json",
                success: function (data) {
                    $.each(data, function (key, value) {
                        var html = "<a href='http://www.baidu.com' class='item' target='_blank'><img src='${pageContext.request.contextPath}/resources/img/user.png'><h6>" + value.name + "</h6></a>";
                        $("#rec_company").append(html);
                    });
                }
            });
        }

        //根据分类加载产品
        function categoryProductList(categoryName, idName) {
            $.ajax({
                url: "${pageContext.request.contextPath}/categoryProductList",
                method: "get",
                dataType: "json",
                data: {"categoryName": categoryName},
                success: function (data) {
                    // var htmlDiv = "<div class=\"row mt-2 mb-2 no-gutters\">";
                    $.each(data, function (key, value) {
                        var product = value.product;
                        var productImage = value.productImage;
                        var htmlDiv = "<div class='col-md-3 col-6 text-center'><a href='http://www.baidu.com' class='module-commodity' target='_blank'><img src='http://change-data.oss-cn-shenzhen.aliyuncs.com/" + productImage.url + "?x-oss-process=image/resize,m_lfit,h_300,w_300' class='img-fluid'><p>" + product.name + "</p><div>¥:" + product.price + "</div></a></div>";
                        $("#" + idName + "").append(htmlDiv);
                    });
                    // htmlDiv =
                }
            });
        }
    </script>
</head>

<body>
<!-- 头部广告 -->
<a href="#" class="top-banner d-none d-md-block">
    <div class="top-bannerimg"></div>
    <span class="top-banner-close">x</span>
</a>
<!-- 头部信息  -->
<div class="container-fluid mt-4 mb-4 scroll-head ">
    <div class="row mt-3 no-gutters">
        <!-- logo -->
        <div class="col-md-3 col-12 head ">
            <div class="row no-gutters">
                <div class="col-7 ">
                    <div class="logo">Change</div>
                </div>
                <div class="col-5 ">
                    <div class="title ml-2">
                        <div class="name">跨境专供</div>
                        <div class="addr">kj.cheng.com</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 搜索栏 -->
        <div class="col-md-5 col-12">
            <div class="row search no-gutters">
                <div class="col-md-8 col-8 searchInput">
                    <input type="text" name="searchName" placeholder="输入关键词，搜索海量精选外贸货源" id='search'/>
                    <div class="searchKey d-none">
                        <ul>
                            <li>
                                <a href="#">aaaa</a>
                            </li>
                            <li>
                                <a href="#">bbbb</a>
                            </li>
                            <li>
                                <a href="#">cccc</a>
                            </li>
                            <li>
                                <a href="#">dddd</a>
                            </li>
                            <li>
                                <a href="#">eeeee</a>
                            </li>
                            <li>
                                <a href="#">eeeee</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4 col-4">
                    <input type="submit" value="搜索"/>
                </div>
            </div>
        </div>

        <!-- 特色图片 -->
        <div class="col-md-4 teseimg ">
            <img src="${pageContext.request.contextPath}/resources/img/tese.png" class="img-fluid"/>
        </div>
    </div>
</div>

<div class="container-fluid  mt-4 mb-4">
    <!-- 导航条 -->
    <div class="row mynav no-gutters">
        <div class="col-md-2 d-none d-md-block">
            <div class="slogan">出口电商一站式货源服务平台</div>
        </div>
        <div class="col-md-10 col-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand d-md-none d-block" href="#">导航</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">首页</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">品牌授权</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">
                                海外代发
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">中国</a>
                                <a class="dropdown-item" href="#">美国</a>
                                <a class="dropdown-item" href="#">日本</a>
                                <a class="dropdown-item" href="#">韩国</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">更多</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#">排行榜单</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <!--轮播图&分类-->
    <div class="row no-gutters ">
        <!-- 一级分类 -->
        <div class="col-md-2 d-none d-md-block" style="position: relative;" id="menu">
            <ul class="menu" id="oneLevelCategory">
                <c:forEach items="${categoryMap}" var="map">
                    <li data-cid='${map.key}'>
                        <a href="#" class="">${map.value}</a>
                    </li>
                </c:forEach>
            </ul>
            <!-- 二级菜单 -->
            <div class="menu2 d-none" id="twoLevelCategory">

            </div>
        </div>
        <script type="text/javascript">
            //通过事件冒泡给每个一级分类注册鼠标悬停事件，鼠标悬停显示二级分类。
            $("#oneLevelCategory").on("mouseover", "li", function () {
                var id = $(this).attr("data-cid");
                $.ajax({
                    url: "${pageContext.request.contextPath}/twoLevelCategory",
                    method: "get",
                    dataType: "json",
                    data: {"ids": id},
                    success: function (data) {
                        var html = "";
                        $.each(data, function (key, value) {
                            html += "<h6>" + key + "</h6>";
                            $.each(value, function (index, option) {
                                html += "<a href='${pageContext.request.contextPath}/view/product/search_list.jsp?fl="+option.id+"' style='margin-bottom: 30px;' target='_blank'>" + option.name + "</a>";
                            })
                        });
                        $("#twoLevelCategory").html(html);
                        return data;
                    }
                });
            });
        </script>
        <!-- 轮播图 -->
        <div class="col-md-8 col-12">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/lb1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/lb2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/lb3.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <!-- 用户信息&公告 -->
        <div class="col-md-2">
            <div class="user-gg row no-gutters">
                <!-- 用户信息 -->
                <div class="d-none d-md-block">
                    <div class="user row justify-content-center no-gutters ">
                        <img src="${pageContext.request.contextPath}/resources/img/user.png">
                        <div class="col-12 text-center info">
                            Hi~欢迎来到Cheng！
                        </div>
                        <div class="col-6">
                            <a href="${pageContext.request.contextPath}/resources/view/user/login.jsp" class="btn btn-primary btn-block">登陆</a>
                        </div>
                        <div class="col-6">
                            <a href="${pageContext.request.contextPath}/resources/view/user/reg.jsp" class="btn btn-outline-success btn-block">注册</a>
                        </div>
                        <div class="col-12 mt-2 text-center">
                            <img src="${pageContext.request.contextPath}/resources/img/baoz.png" alt="" class="img-fluid">
                        </div>

                        <div class="hr"></div>
                    </div>
                </div>
                <!-- 公告-->
                <div class="col-6 gg active">
                    公告
                </div>
                <div class="col-6 hd">
                    活动
                </div>
                <div class="ggtab">
                    <ul>
                        <li>
                            <a href="#">我们可以传给 v-bind:class 一个对象，以动态地切换 class</a>
                        </li>
                        <li>
                            <a href="#">上面的语法表示 active 这个 class</a>
                        </li>
                        <li>
                            <a href="#">你可以在对象中传入更多属性来动态切换多个 class</a>
                        </li>
                        <li>
                            <a href="#">结果渲染为</a>
                        </li>
                        <li>
                            <a href="#">Documentation ootstrap</a>
                        </li>
                        <li>
                            <a href="#">我们可以传给 v-bind:class 一个对象，以动态地切换 class</a>
                        </li>
                        <li>
                            <a href="#">上面的语法表示 active 这个 class</a>
                        </li>
                        <li>
                            <a href="#">你可以在对象中传入更多属性来动态切换多个 class</a>
                        </li>
                        <li>
                            <a href="#">结果渲染为</a>
                        </li>
                    </ul>
                </div>
                <div class="hdtab d-none">
                    <p>
                        <br/>
                        一场盛大的活动,往往需要精心的准备!!!
                        <br/>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid  mt-4 mb-4">
    <h3 class="mt-2 mb-2">每日上新
        <img src="${pageContext.request.contextPath}/resources/img/new.png">
    </h3>
    <div class="row no-gutters" id="newProduct">
        <%-- 每个产品是一个div --%>
    </div>
</div>

<!-- 排行榜 -->
<div class="container-fluid phn mt-4 mb-4">
    <div class="module-title row no-gutters justify-content-between">
        <h3 class="name">排行榜</h3>
        <a href="http://www.baidu.com" class="more">更多>></a>
    </div>
    <div class="row no-gutters" id="rankingList">
        <%-- 第一列 --%>
        <div class="col-md-4 col-12">
            <div class="phblist phb1" id="rankingList1">
                <%-- 每一项 --%>
            </div>
        </div>
        <%-- 第二列 --%>
        <div class="col-md-4 col-12">
            <div class="phblist phb2" id="rankingList2">
            </div>
        </div>
        <%-- 第三列 --%>
        <div class="col-md-4 col-12">
            <div class="phblist phb3" id="rankingList3">
            </div>
        </div>
    </div>
</div>
<!-- 提供商推荐 -->
<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">优选供应商</h3>
        <a href="http://www.baidu.com" class="more">更多>></a>
    </div>
    <div class="row no-gutters">
        <div class="col-md-12 gys">
            <div class="content" id="rec_company">

            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">女装</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12">
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_1">

            </div>
        </div>
    </div>
</div>

<!--广告-->
<div class="container-fluid">
    <div class="row  no-gutters text-center">
        <div class="col-6">
            <img src="${pageContext.request.contextPath}/resources/img/b1.jpg" class="img-fluid"/>
        </div>
        <div class="col-6">
            <img src="${pageContext.request.contextPath}/resources/img/b2.png" class="img-fluid"/>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">男装</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12" >
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_2">

            </div>
        </div>
    </div>
</div>

<!--广告-->
<div class="container-fluid">
    <div class="row  no-gutters text-center">
        <div class="col-6">
            <img src="${pageContext.request.contextPath}/resources/img/b3.jpg" class="img-fluid"/>
        </div>
        <div class="col-6">
            <img src="${pageContext.request.contextPath}/resources/img/b4.png" class="img-fluid"/>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">美妆护肤</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12 ">
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_4">

            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">玩具</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12 ">
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_5">

            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">日用百货</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12 ">
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_6">

            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-4 mb-4">
    <div class="module-title row justify-content-between">
        <h3 class="name">办公文教</h3>
        <a href="#" class="more">更多>></a>
    </div>
    <div class="row module no-gutters">
        <!-- 广告 -->
        <div class="col-md-2 d-none d-md-block">
            <img src="${pageContext.request.contextPath}/resources/img/commodity/b1.png" class="img-fluid">
        </div>
        <!-- tab栏 -->
        <div class="col-md-10 col-12 ">
            <div class="row tab justify-content-center no-gutters">
                <a href="#" class="col active">潮流配饰</a>
                <a href="#" class="col">运动户外</a>
                <a href="#" class="col">数码家电</a>
                <a href="#" class="col">男装新品</a>
                <a href="#" class="col">童装新品</a>
            </div>
            <!-- tab内容 -->
            <div class="row mt-2 mb-2 no-gutters" id="category_3">

            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <a href="javascript:;" class="top-banner d-none d-md-block">
        <div class="top-bannerimg"></div>
        <span class="top-banner-close">x</span>
    </a>
</div>
<footer>
    <p>
        © 2010-2018 change.com 版权所有
    </p>
    <div class="channel-common-footer-bulist ">

        <a href="http://www.alibabagroup.com/cn/global/home" class="follow-item noborder " target="_blank"
           title="阿里巴巴集团">阿里巴巴集团</a>

        <a href="//www.alibaba.com/" class="follow-item " target="_blank" title="阿里巴巴国际站">阿里巴巴国际站</a>

        <a href="//www.1688.com/" class="follow-item " target="_blank" title="1688">1688</a>

        <a href="//www.aliexpress.com" class="follow-item " target="_blank" title="全球速卖通">全球速卖通</a>

        <a href="//www.taobao.com/" class="follow-item " target="_blank" title="淘宝网">淘宝网</a>

        <a href="//www.tmall.com/" class="follow-item " target="_blank" title="天猫">天猫</a>

        <a href="//ju.taobao.com/" class="follow-item " target="_blank" title="聚划算">聚划算</a>

        <a href="//www.etao.com/" class="follow-item " target="_blank" title="一淘">一淘</a>

        <a href="//www.fliggy.com/" class="follow-item " target="_blank" title="飞猪">飞猪</a>

        <a href="//www.alimama.com/" class="follow-item " target="_blank" title="阿里妈妈">阿里妈妈</a>

        <a href="//www.xiami.com/" class="follow-item " target="_blank" title="虾米">虾米</a>

        <a href="//www.aliyun.com/" class="follow-item " target="_blank" title="阿里云计算">阿里云计算</a>

        <a href="//www.yunos.com/" class="follow-item " target="_blank" title="YunOS">YunOS</a>

        <a href="//aliqin.tmall.com/" class="follow-item " target="_blank" title="阿里通信">阿里通信</a>

        <a href="//wanwang.aliyun.com" class="follow-item " target="_blank" title="万网">万网</a>

        <a href="http://www.uc.cn/" class="follow-item " target="_blank" title="UC">UC</a>

        <a href="//www.alipay.com/" class="follow-item " target="_blank" title="支付宝">支付宝</a>

        <a href="//www.dingtalk.com" class="follow-item " target="_blank" title="钉钉">钉钉</a>

        <a href="http://www.alijk.com" class="follow-item " target="_blank" title="阿里健康">阿里健康</a>

        <a href="//onetouch.alibaba.com" class="follow-item " target="_blank" title="一达通">一达通</a>

        <a href="http://taobao.lazada.sg" class="follow-item " target="_blank" title="Lazada">Lazada</a>

    </div>
</footer>

<!-- 右侧导航
    <div class="nav-right d-none d-md-block">
        <ul>
            <li>我</li>
            <li>单</li>
            <li>服</li>
        </ul>
    </div> -->
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>

</body>

</html>