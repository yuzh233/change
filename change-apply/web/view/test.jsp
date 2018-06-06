<%--
  Created by IntelliJ IDEA.
  User: yu_zh
  Date: 2018/5/30
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        var transParam = {
            payeeRealName: "沙箱账户",
            amount: "5000",
            remark: "提现5000元",
            payeeAccount:"pbduln3011@sandbox.com"
        };
        //异步转账
        $.ajax({
            url: "${pageContext.request.contextPath}/trans/withdraw",
            method: "post",
            dataType: "json",
            data: transParam,
            success: function (result) {
                if (result) {
                    alert("提现成功！请留意支付宝到账通知。");
                    // window.location.reload();
                } else {
                    alert("提现失败！");
                }
            }
        });
    });
</script>
<head>
    <title>Title</title>
</head>
<body>
<h1>Test</h1>
</body>
</html>
