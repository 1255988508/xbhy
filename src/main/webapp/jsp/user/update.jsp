<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head></head>
<script>
    /*$(function () {
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
    })*/

    // function checkName() {
    //     var name = $("#username").val();
    //     $.ajax({
    //         url: "/checkName",
    //         type: "post",
    //         data: {"name": name},
    //         dataType: "text",
    //         success: function (data) {
    //             if (data == 1) {
    //                 $("span").attr("hidden", false);
    //             }
    //         }
    //     })
    // }

</script>
<body>
<%@ include file="../common/top.jsp" %>
<%@ include file="../common/left.jsp" %>
<div id="right">

    <form action="/user/update" method="post">

        <input type="text" name="id" value="${user.id}" hidden/>
        用户名：<input type="text" name="username" onblur="checkName()" id="username" value="${user.username}">
        <span style="color:red;"  hidden>账号已存在，请重新输入</span><br/><br/>
        <%--密码：<br/><br/>--%>
        <input type="password" name="password" value="${user.password}" hidden>
        邮箱：<input type="password" name="email" value="${user.email}"><br/><br/>
        真实姓名：<input type="text" name="realName" value="${user.realName}"><br/><br/>
        年龄：<input type="text" name="age" value="${user.age}"><br/><br/>

        性别：<input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if>>男

        <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>>女<br/><br/>

        简介：<textarea name="description" cols="30" rows="10">${user.description}</textarea><br/><br/>
        部门信息：<select name="deptId" id="deptId">
        <c:forEach var="dept" items="${deptList}">
            <option value="${user.id}" <c:if test="${dept.id==user.id}">selected</c:if>>${dept.name}</option>
        </c:forEach>
    </select>
        <input type="submit" value="保存">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>