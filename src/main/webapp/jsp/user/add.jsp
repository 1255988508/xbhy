<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head></head>
<script>
    $(function () {
        $("#deptId").empty();
        $.ajax({
            url: "/dept",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var html = "<option value=\"-1\">请选择</option>";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                $("#deptId").append(html);
            }
        })
    })

    function checkName() {
        var name = $("#username").val();
        $("span").attr("hidden", true);
        $.ajax({
            url: "/checkName",
            type: "post",
            data: {"name": name},
            dataType: "text",
            success: function (data) {
                if (data == 1) {
                    $("span").attr("hidden", false);
                }
            }
        })
    }
</script>
<body>
<%@ include file="../common/top.jsp" %>
<%@ include file="../common/left.jsp" %>
<div id="right" class="table table-bordered">

    <form action="/user/add" method="post">
        用户名：<input type="text" name="username" onblur="checkName()" id="username">
        <span style="color:red;" hidden>账号已存在，请重新输入</span><br/><br/>
        密码：<input type="password" name="password" value="1"  ><br/><br/>
        邮箱：<input type="password" name="email" value="1"  ><br/><br/>
        真实姓名：<input type="text" name="realName" value="1"  ><br/><br/>
        年龄：<input type="text" name="age" value="1" ><br/><br/>

        性别：<input type="radio" name="sex" value="1" checked>男
        <input type="radio" name="sex" value="0">女<br/><br/>

        简介：<textarea name="description" cols="30" rows="10" >测试</textarea><br/><br/>
        部门信息：<select name="deptId" id="deptId" >
    </select>
        <input type="submit" value="保存">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>