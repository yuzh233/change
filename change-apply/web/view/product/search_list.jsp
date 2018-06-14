<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/product/search_list.css"/>
</head>

<%-- 分类id --%>
<input type="hidden" id="fl" value="${param.fl}">
<input type="hidden" id="page" value="1">
<input type="hidden" id="count" value="20">
<input type="hidden" id="condition" value="16">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        var queryHelper = getQueryHelper();
        search(queryHelper, false);
        previousCick();
        nextCick();
    });

    //注册点击上一页事件
    function previousCick() {
        $("#previousPage").on('click', function () {
            var page = $("#page").attr("value");
            var pageNum = parseInt(page);
            queryHelper = {
                categoryId: $("#fl").attr("value"),
                page: pageNum - 1,
                count: $("#count").attr("value")
            };
            queryHelper = $.param(queryHelper);
            search(queryHelper, true);//清除之前的数据
        });
    };

    //注册点击下一页事件
    function nextCick() {
        $("#nextPage").on('click', function () {
            var page = $("#page").attr("value");
            var pageNum = parseInt(page);
            queryHelper = {
                categoryId: $("#fl").attr("value"),
                page: pageNum + 1,
                count: $("#count").attr("value")
            };
            queryHelper = $.param(queryHelper);
            search(queryHelper, true);//清除之前的数据
        });
    };

    //点击触发指定页码跳转
    function pageClick(page) {
        var pageNum = parseInt(page);
        queryHelper = {
            categoryId: $("#fl").attr("value"),
            page: pageNum,
            count: $("#count").attr("value")
        };
        queryHelper = $.param(queryHelper);
        search(queryHelper, true);
    }

    //返回查询参数
    function getQueryHelper() {
        queryHelper = {
            categoryId: $("#fl").attr("value"),
            page: $("#page").attr("value"),
            count: $("#count").attr("value")
        };
        return $.param(queryHelper); //json对象转url参数形式 categoryId=20476292537262080&page=1&count=12
    }

    //获取分类下的商品列表
    function search(queryHelper, replace) {
        if (replace) $("#productList").html("");
        $.ajax({
            url: "${pageContext.request.contextPath}/categoryAndProductData",
            method: "get",
            data: queryHelper,
            dataType: "json",
            success: function (QueryHelper) {
                //填充分页查询参数
                $("#page").attr("value", QueryHelper.page);//当前页

                //遍历集合生成产品列表
                var productList = QueryHelper.productPageResultList;
                $.each(productList, function (index, value) {
                    var product = value.product;
                    var productImage = value.productImage;
                    var html = "<div class='col-md-3 '><a href='/product/27145893731905536/" + product.id + "' class='item' target='_blank'><div class='text-center'><img class='img-fluid' src='http://change-data.oss-cn-shenzhen.aliyuncs.com/" + productImage.url + "?x-oss-process=image/resize,m_lfit,h_700,w_700' alt='" + product.name + "'/></div><div class='info'><span class='priceNum'>¥" + product.price + "<em><h4>" + product.name + "</h4><div class='addr-date'><div class='addr'>企业地址</div></div></div> <div class='user clearfix'> <img src='${pageContext.request.contextPath}/resources/img/user.png'/> <span>企业名</span></div></a></div>";
                    $("#productList").append(html);
                });
                /*
                    生成页码。页码规则：
                        1.显示固定的首页和尾页
                        2.显示当前页的前 7 页和后 7 页，多的不显示。
                            2.1 条件1：当前页码小于10 ->> 前面所有页码 + 后7条页码 + 尾页
                                eg.当前页 10 -> 1 3 4 5 6 7 8 9 [10] 11 12 13 14 15 16 17 50
                            2.2 条件2：当前页码大于 7 ->> 首页 + 从索引(当前页-7)开始 + 尾页
                                eg.当前页12 -> 1 5 6 7 8 9 10 11 [12] 13 14 15 16 17 18 19 50
                 */
                var totalPage = QueryHelper.totalPage;
                //第一页固定
                var temp = 1;
                if (temp == $("#page").attr("value")) temp = "[ " + $("#page").attr("value") + " ]";
                var page_num_html = "<li class='page-item page-num' value='1'><a class='page-link' href='javascript:pageClick(1)'>" + temp + "</a></li>";

                var current_page = QueryHelper.page;
                //开始遍历的索引号生成逻辑
                var start = 2;
                if (current_page < 10) {
                    start = 2;
                } else {
                    start = current_page - 7;
                }
                //结束遍历的索引号生成逻辑
                var end = 0;
                if (current_page + 7 < totalPage) {
                    end = current_page + 7;
                } else {
                    end = totalPage - 1;
                }
                for (var i = start; i <= end; i++) {
                    temp = i;
                    if (i == $("#page").attr("value")) {
                        temp = "[ " + $("#page").attr("value") + " ]";
                    }
                    page_num_html += "<li class='page-item page-num' value='" + i + "'><a class='page-link' href='javascript:pageClick(" + i + ")'>" + temp + "</a></li>";
                }
                if (totalPage > 0) {
                    //最后一页固定
                    var temp2 = totalPage;
                    if (totalPage == $("#page").attr("value")) temp2 = "[ " + totalPage + " ]";
                    page_num_html += "<li class='page-item page-num' value='" + totalPage + "'><a class='page-link' href='javascript:pageClick(" + totalPage + ")'>" + temp2 + "</a></li>";
                }
                $("#page_remark~li[class='page-item page-num']").html("");
                $("#page_remark").after(page_num_html); //在这个元素之后插入内容
            }
        });


    }
</script>

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
                    <div class="logo">Cheng</div>
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

<div class="container-fluid  mt-4">
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
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
</div>
<div class="hr mb-4"></div>

<div class="container-fluid">
    <!-- 分类 -->
    <div class="row no-gutters product-class">
        <div class="col-md-1 col-4">相关搜索:</div>
        <div class="col-md-11 col-8 key">
            <a href="#">笔记本电脑</a>
            <a href="#">创意笔记本</a>
            <a href="#">笔记本电脑</a>
            <a href="#">创意笔记本</a>
            <a href="#">笔记本电脑</a>
            <a href="#">创意笔记本</a>
        </div>
        <div class="col-md-1 col-4">筛选:</div>
        <div class="col-md-11 col-8 shaixuan">
            <input type="checkbox">包邮
            <input type="checkbox">48小时发货
        </div>
    </div>
    <!-- 搜索条件，有active修饰的class是选中状态 -->
    <div class="row no-gutters text-center query" id="conditionDiv">
        <div class="col-md-1 col">
            <a href="javascript:;" class="active" id="complex">综合</a>
        </div>
        <div class="col-md-1 col">
            <a href="javascript:;" id="sales_volume">成交额 </a>
        </div>
        <div class="col-md-1 col">
            <a href="javascript:;" id="new">上新 </a>
        </div>
        <div class="col-md-1 col">
            <a href="javascript:;" id="price">价格 </a>
        </div>
    </div>
    <!-- 搜索的商品 -->
    <div class="row no-gutters my-2 productlist" id="productList">

    </div>

    <nav aria-label="Page navigation example" class="my-4">
        <ul class="pagination justify-content-center" id="page_ul">
            <li class="page-item" id="page_remark">
                <a class="page-link" href="#" aria-label="Previous" id="previousPage">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <%-- 一个一个页码 --%>
            <%--     <li class="page-item page-num" value="1">
                     <a class="page-link" href="#">1</a>
                 </li>--%>

            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next" id="nextPage">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>