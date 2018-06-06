<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../../resources/css/bootstrap4.min.css">
    <link rel="stylesheet" href="../../../resources/css/user/login.css">
	<style>
		body{background: #f1f1f1;font-size: 14px;}
		.onlinInfo{
			padding: 20px;
			background: #fff;
		}
		.onlinInfo .info{
			display: flex;
			justify-content: space-between;
			color: #555;
			text-align: right;
			
		}
		.content{
			margin: 10px 0;
			background: #fff;
			padding: 20px 0;
		}
		.products .item {
			display: flex;
			padding:8px 0;
			border-bottom:1px solid #eee;
		}
		.products .item>img {
			flex: 1;
			height: 100px;
		}
		.products .item>.info{
			display: flex;
			flex-direction: column;
			justify-content: space-between;
			flex: 9;
			padding: 5px;
			color: #868686;
			font-size: 12px;
		}
		.products .item>.info>.name{
			color: #333;
		}
		.products .item>.op{
			flex: 1;
		}
		b{
			color: #f40;
		}
		
		
		
		.model{
			position: fixed;
			display: flex;
			justify-content: center;
			align-items: center;
			left: 0;
			top: 0;
			right: 0;
			bottom: 0;
			z-index: 999;
			background: rgba(0,0,0,.5);
		}
		.modelWindow{
			background: #fff;
			/*width: 500px;*/
			height: 100px;
		}
		.con{
			width: auto;
		}
	</style>
  </head>
  <body>
	<div class="container">
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
			<h3 >商品推送</h3>
		</div>
		
	  <div class="onlinInfo">
		  <h5>我的网店<span class="badge badge-pill badge-primary ml-4">taobao</span></h5>
		  <div class="info">
			  <span>网店地址：http://www.fjdskflsafd.com</span>
		  </div>
		  <div class="info">
			  <span>创建时间：2018-5-31 08:29:07</span>
			  <span>已推送商品：85 个</span>
		  </div>
	  </div>
	  
	  <div class="row content">
		<div class="col-md-6">
		  <p>可推送商品：</p>
		  <div class="products">
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 单价：¥3432</div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 单价：¥3432</div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 单价：¥3432</div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
		  </div>
		</div>
		<div class="col-md-6">
			<p>已推送商品：</p>
			<div class="products">
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn ">下架</button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			<div class="item">
				<img src="http://tpc.googlesyndication.com/daca_images/simgad/10059923993965401700" alt="">
				<div class="info">
					<div class="name">超薄12寸通话平板电脑10寸八核安卓二合一Uniscom/紫光电子 mz52</div>
					<div>数量：998 <b>上架单价：¥3432</b></div>
					<div>仓库：中国 九华1</div>
				</div>
				<div class="op align-self-center">
					<button class="btn "> 上架 </button>
				</div>
			</div>
			</div>
		</div>
		
	  </div>
	  
	</div>
	<!--<div class="model">
		<div class="modelWindow modal-dialog">
			<div class="con">
				
			</div>
		</div>
	</div>-->
    <!-- jQuery first, then Popper.js, then Bootstrap JS  -->
    <script src="../../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../../resources/js/popper.min.js"></script>
    <script src="../../../resources/js/bootstrap.min.js"></script>
  </body>
</html>