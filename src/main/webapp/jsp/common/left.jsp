<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head></head>
<script src="/static/js/jquery-3.5.0.js"></script>
<script>
    window.onload = function (ev) {
        $.ajax({
            url: "/menu",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var parent=data.parent;
                var son=data.son;
                var htm="";
                for (var i = 0; i < parent.length; i++) {
                    htm+=parent[i].name;
                    htm+="<ul>";
                    for (var j = 0; j < son.length; j++) {
                        if(parent[i].id==son[j].pId){
                        htm+="<li><a href="+son[j].url+">"+son[j].name+"</a></li>"
                        }
                    }
                    htm+="</ul>";
                }
                $("#left").append(htm);
            }
        })
    }
    // window.onload = function (ev) {
    //     $.ajax({
    //         url: "/menu",
    //         type: "get",
    //         data: "",
    //         dataType: "json",
    //         success: function (data) {
    //             var htm = "";
    //             for (var i = 0; i < data.length; i++) {
    //                 var menu_1 = data[i];
    //                 if (menu_1.type == 1) {
    //                     htm += menu_1.name;
    //                     htm += "<ul>"
    //                     for (var j = 0; j < data.length; j++) {
    //                         var menu_2 = data[j];
    //                         console.log(data[j].pId);
    //                         if (menu_1.id == menu_2.pId) {
    //                             htm += "<li><a href=" + menu_2.url + ">" + menu_2.name + "</a></li>"
    //                         }
    //                     }
    //                     htm += "</ul>"
    //                 }
    //             }
    //             $("#left").append(htm);
    //         }
    //     })
    // }
</script>
<body>
<div id="left">
    <%--系统管理
    <ul>
        <li><a href="">用户管理</a></li>
        <li><a href="">部门管理</a></li>
    </ul>
    权限管理
    <ul>
        <li><a href="">角色管理</a></li>
        <li><a href="/jsp/authority/authority.jsp">权限管理</a></li>
    </ul>--%>
</div>
</body>
</html>