// 导航栏鼠标悬浮显示隐藏
$(".dropdown").mouseenter(function() {
	$(this).find(".dropdown-menu").addClass('show')
})
$(".dropdown").mouseleave(function() {
	$(this).find(".dropdown-menu").removeClass("show")
})
// 顶部广告关闭
$(".top-banner-close").click(function() {
	$(this).parent().remove()
})
// 分类展开
$(".menu").find('li').mouseenter(function(){
	$(this).siblings().find('a').removeClass('active')
	$(this).find('a').addClass('active')

	// 获取li上的一级分类id
	let cid = $(this).data('cid');
	let $menu2 = $('.menu2')
	$menu2.removeClass('d-none')
	let width = $('#carouselExampleIndicators').width();
	$menu2.css({
		'width': width+'px',
		'right': -width+'px',
		'min-height':$("#menu").height()
	});
	// $menu2.html(cid)
})
// 分类隐藏
$("#menu").mouseleave(function() {
	$(this).find('a').removeClass('active')
	$('.menu2').addClass('d-none')
})
// 搜索框
$('#search').keyup(function() {
	let serchKey = $(this).val();
	console.log(serchKey)
	if(serchKey=='' || serchKey==null){
		$('.searchKey').addClass('d-none');
	}else{
		$('.searchKey').removeClass('d-none');
		
	}
})
// 鼠标离开输入框则消失
$('.search').mouseleave(function() {
	$('.searchKey').addClass('d-none');
})

// 公告活动tab
let $gg  = $('.gg');
let $hd  = $('.hd');
let $ggtab  = $('.ggtab');
let $hdtab  = $('.hdtab');
let ggf = function(event) {
	$(this).addClass('active');
	$hd.removeClass('active')
	$ggtab.removeClass('d-none');
	$hdtab.addClass('d-none');
}
let hdf = function(event) {
	$(this).addClass('active');
	$gg.removeClass('active')
	$('.hdtab').removeClass('d-none');
	$ggtab.addClass('d-none');
	
}
$gg.mouseenter(ggf);
$hd.mouseenter(hdf);
$gg.click(ggf)
$hd.click(hdf);
// 商品切换
$('.module .tab a').mouseenter(function(){
	$(this).siblings().removeClass('active');
	$(this).addClass('active')
})

// 供应商滚动
let widthRow = $('.gys').width() + 30;		// 滚动的行宽
let moveItem =parseInt( widthRow / 205 );	// 滚动多少个元素
let  itemc = $('.gys .content .item').length;	// 总共滚动的元素
let c=itemc%moveItem==0?parseInt(itemc/moveItem)-1:parseInt(itemc/moveItem); //滚动多少次
let i=0;

setInterval(()=>{
	i++;
	if(c==0){
		i=0;
		c=itemc%moveItem==0?parseInt(itemc/moveItem)-1:parseInt(itemc/moveItem);
	}else {
		c--;
	}
	$('.gys .content').animate({
		'left':'-'+(moveItem*205*i)+'px'
	},500)
},5000)
//
//$(document).scroll(function() {
//	if($(document).scrollTop()>=100){
//		$(".scroll-head").css({
//			'position':'fixed',
//			'left':'0',
//			'top':'0',
//			'z-index':'999',
//			'margin': '0 !important'
//		})
//		$(".scroll-head").removeClass('mt-4')
//		$(".scroll-head").removeClass('mb-4')
//		$(".scroll-head .mt-3").removeClass('mt-3')
//	}
//
//})

