<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
String webapp = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title></title>
    <link rel="stylesheet" href="<%=webapp%>/resources/css/bootstrap4.min.css">
    <link href="<%=webapp%>/resources/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=webapp%>/resources/css/base.css" />

    <link rel="stylesheet" href="<%=webapp%>/resources/css/user/shopkeeper/center.css" />
    <link rel="stylesheet" type="text/css" href="<%=webapp%>/resources/css/user/shoppingcart.css" />

    <link href="http://www.jq22.com/demo/jqueryMobiscroll201803142314/css/mobiscroll.custom.min.css" rel="stylesheet" type="text/css"
    />
</head>

<body>

    <div id="app">
        <!-- 导航栏 -->
        <div class="head">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light ">
                    <a class="navbar-brand" href="#">Change 工作平台</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="./center.jsp">卖家
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./shangjia.html">商家</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">设置</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    服务
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="请输入你要搜索的服务">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                        </form>
                    </div>
                </nav>
            </div>
        </div>

        <div class="container mt-3">
            <div class="row no-gutters">
                <!-- 左侧导航 -->
                <div class="col-md-2 whitebag">
                    <div class="left-op pr-3">
                        <h6>卖家快捷入口</h6>
                        <ul>
							<li>
								<a href="#0" :class="{'active':leftIndex==0}" @click="tapleftIndex(0)">账号信息</a>
							</li>
                            <li>
                                <a href="#1" :class="{'active':leftIndex==1}" @click="tapleftIndex(1)">网店推送</a>
                            </li>
                            <li>
                                <a href="#2" :class="{'active':leftIndex==2}" @click="tapleftIndex(2)">已买到的货品</a>
                            </li>
                            <li>
                                <a href="./shoppingcart.html">进货单</a>
                            </li>
                            <li>
                                <a href="./collection.html">收藏夹</a>
                            </li>
                            <li>
                                <a href="#4" data-index='5'>发布询价单</a>
                            </li>
                        </ul>

                        <h6>卖家账号管理</h6>
                        <ul>
                            <li>
                                <a href="#">账号安全</a>
                            </li>
                            <li>
                                <a href="#">交易资料管理</a>
                            </li>
                        </ul>

                    </div>
                </div>
                <!-- 右侧内容 -->
                <div class="tab-content col-md-10 col-12 whitebag ">
                    <!-- 帐户信息-->
					<div class="tab-pane fade " :class="{'show active':leftIndex==0}">
						<h6 class="p-3">基本信息</h6>
						<div class="row user">
							<div class="col-md-6 col-12">
								<form>
								<div class="form-group row">
									<label for="username" class="col-sm-2 col-form-label">用户名</label>
									<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext" id="username" :value="userInfo!=null?userInfo.user.username:''">
									</div>
								</div>
								<div class="form-group row">
									<label for="name" class="col-sm-2 col-form-label">姓名</label>
									<div class="col-sm-10">
										<input type="text" readonly class="form-control-plaintext" id="name" :value="userInfo!=null?userInfo.user.name:''">
									</div>
								</div>
								<div class="form-group row">
									<label for="phone" class="col-sm-2 col-form-label">电话</label>
									<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext" id="phone" :value="userInfo!=null?userInfo.user.phone:''">
									</div>
								</div>
								<div class="form-group row">
									<label for="email" class="col-sm-2 col-form-label">邮箱</label>
									<div class="col-sm-10">
									<input type="text" readonly class="form-control-plaintext" id="email" :value="userInfo!=null?userInfo.user.email:''">
									</div>
								</div>
								<div class="form-group row">
                                        <label for="createDate" class="col-sm-2 col-form-label">注册时间</label>
                                        <div class="col-sm-10">
                                            <input type="text" readonly class="form-control-plaintext" id="createDate" :value="userInfo!=null?userInfo.user.createDate:''">
									</div>
								</div>
								<div class="form-group row">
									<label for="oldpassword" class="col-sm-2 col-form-label">旧密码</label>
									<div class="col-sm-10">
									<input type="password" class="form-control" id="oldpassword" placeholder="请输入旧密码" v-model="userOldPwd">
									</div>
								</div>
								<div class="form-group row">
									<label for="inputPassword" class="col-sm-2 col-form-label">新密码</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="inputPassword" placeholder="请输入你的新密码" v-model="userNewPwd">
									</div>
								</div>
                                 <span class="text-success mx-3">{{msg}}</span>
								<button class="btn btn-danger float-right" @click="userUpdate">确认修改</button>
								</form>
							</div>
							<div class="col-md-6 col-12">
								<div class="userimg">
									<img src="<%=webapp%>/resources/img/user.png" alt="">
								</div>
								<div class="info">
									<a href="#1" class="item" @click="tapleftIndex(2)">
										<img src="<%=webapp%>/resources/img/icon/order.png" />
										<p>我的订单<b><span class="badge badge-pill badge-primary">{{userInfo.orderCount}}</span></b></p>
									</a>
									<a href="#2" class="item" @click="tapleftIndex(1)">
										<img src="<%=webapp%>/resources/img/icon/onlin.png" />
										<p>我的网店<b><span class="badge badge-pill badge-warning">{{userInfo.onCount}}</span></b></p>
									</a>
									<a href="./shoppingcart.html" class="item">
										<img src="<%=webapp%>/resources/img/icon/cart.png" />
										<p>我的购物车</p>
									</a>
									<a href="#" class="item">
										<img src="<%=webapp%>/resources/img/icon/money.png" />
										<p>2399.00 元</p>
									</a>
								</div>
								<p>
									支付宝：<a href="#">绑定支付宝账号</a> 
								</p>
								<p>
									<button class="btn btn-primary ">提现</button>
									<button class="btn btn-success ">充值</button>
								</p>
							</div>
						</div>
						
					</div>
					<!-- 网店列表 -->
                    <div class="tab-pane fade" :class="{'show active':leftIndex==1}">
                        <div class="p-4">
                            <h6 class="">M2B2C2模式 B2C店主可以将买到的商品推送至网店</h6>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#onlineStore" @click.prevent="onlineStorePre(0,1)">网店驻入</button>
                        </div>

                        <div class="onlineStoreList row">
                            <div class="col-md-4 col-6" v-for="(item,index) in onlineStore.list" :key="index">
                                <a href="./productPush.html" class="item">
                                    <div class="type">
                                        <span v-if="item.type==1">eb</span>
                                        <span v-if="item.type==2">亚马逊</span>
                                    </div>
                                    <div class="info">
                                        <div class="url">
                                            {{item.url}}
                                        </div>
                                        <div class="status clearfix">
                                            <span class="float-left">{{item.createDate}}</span>
                                            <span class="float-right">审核中</span>
                                        </div>
                                        <div class="op clearfix">
                                            <button class="btn btn-danger float-left" @click.prevent="onlineStoreDel(item.id)">
                                                <i class="fa fa-trash"></i>
                                            </button>
                                            <button class="btn btn-info float-left" data-toggle="modal" data-target="#onlineStore" @click.prevent="onlineStorePre(index)">
                                                <i class="fa fa-edit"></i>
                                            </button>
                                            <button class="btn float-right">
                                                <img src="<%=webapp%>/resources/img/icon/dian.png" alt="" class="icon-16">
                                            </button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- 订单列表 -->
                    <div class="tab-pane fade" :class="{'show active':leftIndex==2}">
                        <!--筛选条件-->
                        <div class="order-tab">
                            <a href="#" class="current">所有订单</a>
                            <a href="#">待付款</a>
                            <a href="#">待评价</a>
                            <a href="#">退货处理</a>
                            <a href="#">推送商品</a>
                        </div>
                        <div class="query">
                            <div class="row p-2">
                                <div class="col-md-3">
                                    <input type="text" class="" placeholder="根据商品名称或订单号" />

                                </div>
                                <div class="col-md-3">
                                    <input type="text" class="" placeholder="卖家昵称" />
                                </div>
                                <div class="col-md-3">
                                    <select>
                                        <option value="代付款">代付款</option>
                                        <option value="代付款">代付款</option>
                                        <option value="代付款">代付款</option>
                                        <option value="代付款">代付款</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" id="demo_datetime" ref="date" />
                                </div>
                            </div>
                        </div>

                        <!-- 订单信息-->
                        <div class="row justify-content-center no-gutters table-head text-center d-none d-md-flex">
                            <div class="col-md-4">
                                商品信息
                            </div>
                            <div class="col-md-2">单价 (元)</div>
                            <div class="col-md-1">数量</div>
                            <div class="col-md-2">实付款 (元)</div>
                            <div class="col-md-1">交易状态</div>
                            <div class="col-md-2">交易操作</div>
                        </div>
                        <div class="cart" v-for="(citem,index) in cart">
                            <div class="clearfix brand">
                                <div class=" float-right">
                                    <img src="<%=webapp%>/resources/img/shangjia.png">店铺：
                                    <a :href="'http://localthos/brand/'+citem.brand.id">{{citem.brand.name}}</a>
                                    <img src="<%=webapp%>/resources/img/liaotian.png" class="liaotian" />
                                </div>
                                <div class="orderInfo float-left font-weight-bold">
                                    <label>
                                        <input type="checkbox" />
                                        <span>2018-05-30 20:16:00</span>
                                        <span>订单号：374893274329843264326</span>
                                    </label>
                                </div>
                            </div>
                            <div class="row text-center justify-content-center align-items-center" v-for="(pitem,pindex) in citem.products">
                                <div class="col-md-4">
                                    <div class="d-flex align-items-center product">
                                        <img :src="pitem.pimg">
                                        <div>{{pitem.pname}}</div>
                                    </div>
                                </div>
                                <div class="col-md-2 col-6">
                                    <span class="d-md-none d-inline">单价:</span>
                                    ￥：
                                    <b>{{pitem.pmoney}}</b>
                                </div>
                                <div class="col-md-1 col-6 d-flex number justify-content-center">
                                    {{pitem.pnumber}}
                                </div>
                                <div class="col-md-2 col-6">
                                    <template v-if="pindex==0">
                                        <span class="d-md-none d-inline">总价:</span>
                                        ￥：
                                        <b>{{(pitem.pmoney*pitem.pnumber).toFixed(2)}}</b>
                                    </template>
                                </div>
                                <div class="col-md-1 col-6">
                                    <template v-if="pindex==0">
                                        待付款
                                        <div></div>
                                        <a href="#">订单详细</a>
                                    </template>
                                </div>
                                <div class="col-md-2 op col-6 mt-mo-0 mt-2">
                                    <template v-if="pindex==0">
                                        <button class="btn btn-danger btn-block">付款</button>
                                        <div></div>
                                        <a href="#">关闭订单</a>
                                    </template>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
		<!-- 网店申请、修改 -->
		<div class="modal fade" id="onlineStore" ref="onlineStore">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">网店</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				<form>
				  <div class="form-group">
					<label for="onlineStoreUrl">网店地址</label>
					<textarea class="form-control" id="onlineStoreUrl"placeholder="请输入网店的地址" v-model="onlineStore.os.url"></textarea>
				  </div>
				  <div class="form-group">
					<label for="onlineStoreType">网店类型</label>
					<select class="custom-select" id="onlineStoreType" v-model="onlineStore.os.type">
					  <option value="1" selected>eb</option>
					  <option value="2">亚马逊</option>
					  <option value="3">淘宝</option>
					  <option value="4">京东</option>
					</select>
				  </div>
				</form>
			  </div>
			  <div class="modal-footer">
                  <span class="mx-3">{{msg}}</span>
				<button type="button" class="btn btn-primary" @click="onlineStorereg()" v-show="onlineStore.type==0">申请</button>
                  <button type="button" class="btn btn-danger" @click="chageOnlineStore()" v-show="onlineStore.type==1">修改</button>
			  </div>
			</div>
		  </div>
		</div>
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS  -->
    <script src="<%=webapp%>/resources/js/jquery-3.2.1.min.js"></script>
    <script src="<%=webapp%>/resources/js/popper.min.js"></script>
    <script src="<%=webapp%>/resources/js/bootstrap.min.js"></script>

    <script src="<%=webapp%>/resources/js/mobiscroll.custom.min.js"></script>

    <script src="<%=webapp%>/resources/js/vue.js"></script>
    <script src="<%=webapp%>/resources/js/axios.min.js"></script>
    <script type="text/javascript" src="<%=webapp%>/resources/js/shopkeeper/center.js"></script>

</body>

</html>
