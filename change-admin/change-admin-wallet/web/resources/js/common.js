$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 数据表格动态高度
	$(window).resize(function () {
		$('#table').bootstrapTable('resetView', {
			height: getHeight()
		});
	});
	// 设置input特效
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// select2初始化
	$('select').select2();
});
// 动态高度
function getHeight() {
	return $(window).height() - 20;
}
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
// 初始化input特效
function initMaterialInput() {
	$('form input[type="text"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
}

function showMsg(text, position) {
    var show = $('.show_msg').length
    if (show > 0) {
    } else {
        var div = $('<div></div>');
        div.addClass('show_msg');
        var span = $('<span></span>');
        span.addClass('show_span');
        span.appendTo(div);
        span.text(text);
        $('body').append(div);
    }
    $(".show_span").text(text);
    if (position == 'bottom') {
        $(".show_msg").css('bottom', '5%');
    } else if (position == 'center') {
        $(".show_msg").css('top', '');
        $(".show_msg").css('bottom', '50%');
    } else {
        $(".show_msg").css('bottom', '90%');
    }
    $('.show_msg').hide();
    $('.show_msg').fadeIn(1500);
    $('.show_msg').fadeOut(1500);
}