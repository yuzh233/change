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
		<link rel="stylesheet" href="<%=webapp %>/resources/css/bootstrap4.min.css">
		<link rel="stylesheet" type="text/css" href="<%=webapp %>/resources/css/base.css" />
		<link rel="stylesheet" type="text/css" href="<%=webapp %>/resources/css/product/search_list.css" />
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
							<input type="text" name="searchName" placeholder="输入关键词，搜索海量精选外贸货源" id='search' />
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
							<input type="submit" value="搜索" />
						</div>
					</div>
				</div>

				<!-- 特色图片 -->
				<div class="col-md-4 teseimg ">
					<img src="<%=webapp %>/resources/img/tese.png" class="img-fluid" />
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
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item active">
									<a class="nav-link" href="#">首页</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">品牌授权</a>
								</li>
								<li class="nav-item">
									<a class="nav-link " href="#">排行榜单</a>
								</li>
							</ul>
						</div>
						<div class="float-right nav-item">
							<span style="color: #a29d9a;font-size: 12px;margin:0 10px;">海外仓库 </span>
							<select class="custom-select custom-select-sm " style="width: 100px">
							<option selected>中国</option>
							<option value="1">美国</option>
							<option value="2">韩国</option>
							<option value="3">小日本</option>
						</select>
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
			<!-- 搜索条件 -->
			<div class="row no-gutters text-center query">
				<div class="col-md-1 col">
					<a href="javascript:;" class="active">综合</a>
				</div>
				<div class="col-md-1 col">
					<a href="javascript:;">成交额 </a>
				</div>
				<div class="col-md-1 col">
					<a href="javascript:;">上新 </a>
				</div>
				<div class="col-md-1 col">
					<a href="javascript:;">价格 </a>
				</div>
			</div>
			<!-- 搜索的商品 -->
			<div class="row no-gutters my-2 productlist">
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
				<div class="col-md-3 ">
					<a href="#" class="item">
						<div class="text-center">
							<img class="img-fluid" src="https://cbu01.alicdn.com/img/ibank/2017/236/902/7296209632_1782371762.220x220xz.jpg" alt="DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包" />
						</div>
						<div class="info">
							<span class="priceNum" title="¥22.50~23.90">
							 	¥22.50<em>∼</em>23.90
							 </span>
							<h4>DELL电脑包定制LOGO1680D牛津布商务电脑双肩背包</h4>
							<div class="addr-date">
								<div class="addr">广州市白云区</div>
								<div class="date">2018年3月上架</div>
							</div>
						</div>
						<div class="user clearfix">
							<img src="<%=webapp %>/resources/img/user.png" />
							<span>youjie</span>
						</div>
					</a>
				</div>
			</div>

			<nav aria-label="Page navigation example" class="my-4">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled">
						<a class="page-link" href="#" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
						</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">1</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">2</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">3</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>

		<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
		<script src="<%=webapp %>/resources/js/jquery-3.2.1.min.js"></script>
		<script src="<%=webapp %>/resources/js/popper.min.js"></script>
		<script src="<%=webapp %>/resources/js/bootstrap.min.js"></script>

</body>

</html>