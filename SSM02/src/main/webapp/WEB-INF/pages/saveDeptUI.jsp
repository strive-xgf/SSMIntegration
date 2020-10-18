
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/dept/saveDept">
        <input type="text" name="dname" placeholder="请输入您要新增的部门名称"/><br/>
        <input type="submit" value="保存"/>      &emsp;&emsp;&emsp;
        <input type="reset" value="重置"/><br/>

    </form>
    <a href="${pageContext.request.contextPath}/dept/deptlist">返回部门列表页面</a>
</body>
</html>
