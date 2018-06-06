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

// 登录
function login() {
    $.ajax({
        url: '/login',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val(),
            rememberMe: $('#rememberMe').is(':checked'),
        },
        beforeSend: function() {

        },
        success: function(result){
            var json = JSON.parse(result);
            if (json.code == 1) {
                window.location.href = json.data;
            } else {
                if (10101 == json.code) {
                    $('#username').focus();
                }
                if (10102 == json.code) {
                    $('#password').focus();
                }
                showMsg('用户名或密码错误, 请重新输入!', 'top');
            }
        },
        error: function(error){
            showMsg('貌似没有网络呢', 'top');
            console.log(error);
        }
    });
}