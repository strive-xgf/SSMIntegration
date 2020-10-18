
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>
    <%-- form表单，不会将标记为disabled="disabled"作为参数提交到后台
         通过添加一个type="hidden"的input标签来传递id数据 --%>
    <form method="post" action="${pageContext.request.contextPath}/dept/updateDept">
        <input type="hidden" name="did" value="${dept.did}" >
        <input type="text"  value="${dept.did}" disabled="disabled"/><br/>
        <input type="text" name="dname" value="${dept.dname}"/><br/>
        <input type="submit" value="保存修改"/><br/>
    </form>
        <a href="${pageContext.request.contextPath}/dept/deptlist">返回部门列表页面</a>
</body>
</html>
