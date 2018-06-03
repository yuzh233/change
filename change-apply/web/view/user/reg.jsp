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
    <link rel="stylesheet" href="../resources/css/bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/base.css"/>

    <link rel="stylesheet" href="../resources/css/user/login.css"/>
    <link rel="stylesheet" href="../resources/css/user/reg.css"/>
</head>

<body>
    <div class="container mt-4">
        <div class="row title">
            <div class="col-md-4 col-12 head ">
                <div class="row no-gutters">
                    <div class="col-7 ">
                        <div class="logo">Change</div>
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
            <h3>用户注册</h3>
        </div>

        <div class="row no-gutters justify-content-center text-center reg-type ">
            <div class="col-4"><a href="javascript:;" class="active" data-index="0">企业账户注册</a></div>
            <div class="col-4"><a href="javascript:;" data-index="1">个人账户注册</a></div>
        </div>
        <!-- 企业账户注册 -->
        <div class="row no-gutters regfrom whitebag">
            <div class="col-12 mt-2">
                <h6>有企业营业执照（含个体工商户）的用户请注册。权益如下：做企业实名认证；作为卖家身份开店；作为买家身份采购。</h6>
            </div>
            <div class="col-md-6 col-12 offset-sm-3 mt-3">
                <form id="form">
                    <!-- 帐号类型-->
                    <input type="hidden" name="type" value="0">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-3 col-form-label">会员名:</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="请输入用户名" name="username">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="pwd" class="col-sm-3 col-form-label">登录密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="pwd" placeholder="请输入密码" name="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="pwdd" class="col-sm-3 col-form-label">密码确认:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="pwdd" placeholder="请确认密码" name="passwordd">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="username" class="col-sm-3 col-form-label">联系人姓名:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="username" placeholder="请输入真实姓名" name="name">
                        </div>
                    </div>
                    <div class="form-group row enterprise">
                        <label for="Company" class="col-sm-3 col-form-label">企业名称:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="Company" placeholder="请输入企业名称" name="company.name">
                        </div>
                    </div>
                    <div class="form-group row service">
                        <label for="Company" class="col-sm-3 col-form-label">业务范围:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="service" placeholder="请输入业务范围" name="company.service">
                        </div>
                    </div>
                    <div class="form-group row address">
                        <label for="Company" class="col-sm-3 col-form-label">企业地址:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="address" placeholder="请输入企业地址" name="company.address">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col-sm-3 col-form-label">手机号码:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="phone" placeholder="请输入常用电话号码" name="phone">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword3" class="col-sm-3 col-form-label">邮箱:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="inputPassword3" placeholder="请输入验证码" name="email">
                        </div>
                    </div>
                    <fieldset class="form-group">
                        <div class="row">
                            <legend class="col-form-label col-sm-3 pt-0">Radios</legend>
                            <div class="col-sm-9">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
                                    <label class="form-check-label" for="gridRadios1">
                                        First radio
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                                    <label class="form-check-label" for="gridRadios2">
                                        Second radio
                                    </label>
                                </div>
                                <div class="form-check disabled">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
                                    <label class="form-check-label" for="gridRadios3">
                                        Third disabled radio
                                    </label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="form-group row">
                        <div class="col-sm-3"></div>
                        <div class="col-sm-9">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck1">
                                <label class="form-check-label" for="gridCheck1">
                                    创建网站账号的同时，我同意遵守：
                                    <a href="#" title="">《阿里巴巴服务条款》</a>及 <a href="#" title="">《隐私声明》</a>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row justify-content-center">
                        <div class="col-sm-6">
                            <button type="button" class="btn btn-primary btn-block" id="regbtn">注册</button>
                        </div>
                    </div>
                    <p id="msg" class="text-center text-success"></p>
                </form>
            </div>
        </div>

        <!-- 个人账户注册 -->
    </div>
    
    


    <!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">-->
        <!--Launch demo modal-->
    <!--</button>-->

    <!--注册协议 -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">注册协议</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    【审慎阅读】您在申请注册流程中点击同意前，应当认真阅读以下协议。请您务必审慎阅读、充分理解协议中相关条款内容，其中包括：

                    1、与您约定免除或限制责任的条款；

                    2、与您约定法律适用和管辖的条款；

                    3、其他以粗体下划线标识的重要条款。

                    如您对协议有任何疑问，可向1688服务中心（请点击）咨询

                    【特别提示】 您已充分理解，阿里巴巴中国站是一个商业贸易采购平台，而并非面向消费者的消费购买市场，当您按照注册页面提示填写信息、阅读并同意协议且完成全部注册程序后，即表示您已充分阅读、理解并接受协议的全部内容，并将基于您的真实贸易需求而使用阿里巴巴服务。如您因阿里巴巴服务与阿里巴巴发生争议，应适用《阿里巴巴服务条款》处理；如您在使用阿里巴巴服务中与其他用户发生争议，依您与其他用户达成的协议处理。

                    阅读协议的过程中，如果您不同意相关协议或其中任何条款约定，您应立即停止注册程序。

                    《阿里巴巴服务条款》

                    《隐私政策》

                    《支付宝服务协议》
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS  -->
<script src="../resources/js/jquery-3.2.1.min.js"></script>
<script src="../resources/js/popper.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var h6innerhtml = [
    '有企业营业执照（含个体工商户）的用户请注册。权益如下：做企业实名认证；作为卖家身份开店；作为买家身份采购。',
    '无企业营业执照的个人用户请注册个人账户。权益如下：做个人实名认证；作为买家身份采购；']
    $('.reg-type').on("click","a",function() {
        $('.reg-type a').removeClass('active');
        $(this).addClass('active')
        var index = $(this).data('index');
        $('.regfrom>.col-12 h6').text(h6innerhtml[index])

        if(index==0){
            $('.enterprise').show();
            $('.service').show();
            $('.address').show();
        }else{
            $('.enterprise').hide();
            $('.service').hide();
            $('.address').hide();
        }
    })

    $(function () {
        $('#regbtn').on("click",function () {
            $.ajax({
                url: "./reg",
                type: "POST",
                contentType: "application/x-www-form-urlencoded",
                dataType: "json",
                data: $("#form").serialize(), //传递表单值
                success: function (result) {
                    console.log(result)
                    var $msg = $('#msg');
                    if(result.status<0)
                    {
                        $msg.text(result.msg)
                    }else{//成功
                        $msg.text(result.msg)
                    }
                }
            });
        })
    })
</script>

</body>
</html>