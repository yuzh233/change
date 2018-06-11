<%--
  Created by IntelliJ IDEA.
  User: yu_zh
  Date: 2018/6/4
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form method="post" action="http://localhost:8888/${pageContext.request.contextPath}/ali/trans">
        <input name="outBizNo" value="24948716486000640">
        <input name="payeeAccount" value="hawnrn0618@sandbox.com">
        <input name="amount" value="500">
        <input name="payeeRealName" value="沙箱环境">
        <input name="payerShowName" value="退款">
        <input name="remark" value="remark...">
        <input type="submit">
    </form>

</body>
</html>
