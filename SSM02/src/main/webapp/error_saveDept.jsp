
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<font color="red">${error_msg}</font>
<br/><br/>
<a href="${pageContext.request.contextPath}/dept/saveDeptUI">返回新增</a><br/>
<a href="${pageContext.request.contextPath}/dept/deptlist">返回部门列表页面</a>
</body>
</html>
