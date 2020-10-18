<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
<head>
    <title>部门crud</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/dept/saveDeptUI">新增部门</a>
<br/>
<table border="1px" width="100%">
    <tr>
        <td>序号</td>
        <td>部门编号</td>
        <td>部门名称</td>
        <td>操作</td>

    </tr>

    <c:forEach items="${depts}" var="dept" varStatus="vs">
         <tr>
             <td>${vs.index+1}</td>
             <td>${dept.did}</td>
             <td>${dept.dname}</td>
             <%-- 携带id过去进行删除和更新 --%>
             <td><a href="${pageContext.request.contextPath}/dept/deleteDept?did=${dept.did}">删除</a> | <a href="${pageContext.request.contextPath}/dept/updateDeptUI?did=${dept.did}">修改</a></td>
         </tr>
    </c:forEach>
</table>
</body>
</html>
