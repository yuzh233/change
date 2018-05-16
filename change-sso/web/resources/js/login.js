$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {
	// 点击登录按钮
	$('#login-bt').click(function() {
		login();
	});
	// 回车事件
	$('#username, #password').keypress(function (event) {
		if (13 == event.keyCode) {
			login();
		}
	});
});
// 统一登陆中心
var BASE_PATH = "http://localhost:9999";
var BACK_URL = "";

// 登录
function login() {
    $.ajax({
        url: BASE_PATH + '/login',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val(),
            rememberMe: $('#rememberMe').is(':checked'),
            back_url: BACK_URL
        },
        beforeSend: function() {

        },
        success: function(result){
            var json = $.parseJSON(result);
            if (json.code == 1) {
                window.location.href = json.data;
            } else {
                if (10101 == json.code) {
                    $('#username').focus();
                }
                if (10102 == json.code) {
                    $('#password').focus();
                }
            }
        },
        error: function(error){
            console.log(error);
        }
    });
}