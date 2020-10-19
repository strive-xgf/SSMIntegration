<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
<head>
    <title>部门crud-ajax版本</title>

    <%-- 项目路径，简化${pageContext.request.contextPath}获取一长串 --%>
    <% pageContext.setAttribute("path",request.getContextPath());  %>

    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>

    <%-- ajax实现 --%>
    <script type="text/javascript">

        //ajax所有操作都在一个页面，点击增加、编辑的时候需要显示/隐藏div
        function switchDiv(part) {
            //隐藏所有内容
            $('#addDiv').css("display","none")
            $('#listDiv').css("display","none")
            $('#editDiv').css("display","none")
            if(1 == part){
                //点击添加，将添加页面设置为block显示
                $('#addDiv').css("display","block")
                $('#add_dname').val('')
            }else if(2 == part){
                //显示所有的部门列表
                $('#listDiv').css("display","block")
            }else if(3 == part){
                //点击编辑，将编辑页面设置为block显示
                $('#editDiv').css("display","block")
            }
        }

        //页面加载成功执行
        $(function () {
            //显示部门列表display -> block
            switchDiv(2)
            //显示所有
            deptListUI()
            //点击增加
            $('#btn_add').click(function () {
                //alert('btn_add') 普通的表单提交 did=1&dname=测试组
                //serialize()方法表单序列化，会将表单数据拼接成k1=v1&k2=v2
                var data = $('#add_form').serialize()
                $.post('${path}/deptv2/saveDept',data,function (resultMsg) {
                    console.info(resultMsg)
                    //页面切换，隐藏所有，显示增加页面
                    switchDiv(2)
                    //重新加载列表
                    deptListUI()
                    //切换页面
                    switchDiv(2)
                    alert(resultMsg.message)
                },'json')
            })
        })

        //显示部门列表
        function deptListUI() {
            //1. js发送请求，通过调用方法访问数据库，获取json数据（部门信息列表）
            $.get('${path}/deptv2/deptList', function (resultMsg){
                //2. js接收数据，打印到浏览器的控制台（后台转json数据格式了）
                console.info("resultMsg = " + resultMsg)

            //定义表格table标签的内容（最外层用''单引号防止转移字符\）
                var trs = ''
                //拼接表头
                trs += ' <tr>\n' +
                    '        <th>序号</th>\n' +
                    '        <th>部门编号</th>\n' +
                    '        <th>部门名称</th>\n' +
                    '        <th>操作</th>\n' +
                    '\n' +
                    '    </tr>'
                //返回状态码200正常，拼接数据
                if (200 == resultMsg.code) {

                    var items = resultMsg.data;
                    //3. js循环获取数据更新页面
                    for (var i = 0; i < items.length;i++) {
                        var dept = items[i]
                        //打印到控制台，查看数据是否获取
                        console.info(dept)
                        //进行拼接数据
                        trs += ' <tr>\n' +
                            '        <td>' + (i + 1) + '</td>\n' +
                            '        <td>' + dept.did + '</td>\n' +
                            '        <td>' + dept.dname + '</td>\n' +
                            '        <td><a href="javascript:deleteDept('+dept.did+')">删除 | </a><a href="javascript:updateDeptUI('+dept.did+')">修改</a></td>\n' +
                            '\n' +
                            '    </tr>'
                    }
                    //通过html将数据拼接到table中
                    $('#table').html(trs)
                }
            },'json')
        }

        //通过id删除部门，要传递参数
        function deleteDept(did) {
            $.get('${path}/deptv2/deleteDept?did='+did,function (resultMsg) {
                console.info(resultMsg)
                if(200==resultMsg.code){
                    //显示删除结果
                    alert(resultMsg.message)
                    deptListUI()//调用列表更新
                }else{
                    alert(resultMsg.message)
                }
            },'json')
        }



        //更新回显页面，查询数据库，将查询的信息回显到该页面上
        function updateDeptUI(did) {
            //alert(did)
            //页面切换，显示修改页面
            switchDiv(3)
            //获取被修改的数据作回显
            $.get('${path}/deptv2/findDeptById?did='+did,function (resultMsg) {
                if(200==resultMsg.code){
                    var dept = resultMsg.data;
                    //{"code":200,"message":null,"data":{"did":1,"dname":"Java开发部"}}
                    //查到数据给更新页面赋值
                    $('#u_did1').val(dept.did)
                    $('#u_did2').val(dept.did)
                    $('#u_dname').val(dept.dname)
                }else{
                    alert(result.message)//提示没有查询结果
                }
            },'json')
        }

        //执行更新
        function updateDept() {
            var data=$('#update_form').serialize();// k1=v1&k2=v2
            $.post('${path}/deptv2/updateDept',data,function (resultMsg) {
                console.info(resultMsg)
                alert(resultMsg.message)
                //刷新列表
                deptListUI()
                //切换页面
                switchDiv(2)
            },'json')
        }

    </script>

</head>
<body>





<br/>
<div id="listDiv" style="display: block">
    <a href="javascript:switchDiv(1)">新增部门</a>
    <table border="1px" width="100%" id="table"></table>
</div>

<div id="addDiv">
    <h1>添加部门页面</h1>
    <form id="add_form"  >
        <input type="hidden" name="did"/><br/>
        <input type="text" name="dname" id="add_dname"/><br/>
        <input id="btn_add" type="button" value="保存"/><br/>
    </form>
</div>

<div id="editDiv">
    <%--更新回显页面--%>
    <h1>编辑页面</h1>
    <form id="update_form">
        <%-- disabled的数据表单提交是不会发送给后台的，设置一个隐藏域 --%>
        <input id="u_did1" type="hidden" name="did"  >
        <input id="u_did2" type="text"   disabled="disabled"/><br/>
        <input id="u_dname" type="text" name="dname" /><br/>
        <input id="btn_update" onclick="updateDept()" type="button" value="保存修改"/><br/>
    </form>
</div>

</body>
</html>
