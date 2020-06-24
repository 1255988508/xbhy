<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head></head>
<style>

</style>
<body>
<%@ include file="../common/top.jsp" %>
<%@ include file="../common/left.jsp" %>
<div id="right">
    <a href="/jsp/user/add.jsp" class="btn btn-success">添加</a>

    <form action="/user/listByMessage" method="post">
        用户名：<input type="text" name="username">
        <select name="sex" id="">
            <option value="-1">请选择</option>
            <option value="1">男</option>
            <option value="0">女</option>
        </select>
        <input type="submit" value="查询">
    </form>
    <br/>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>真实姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>注册时间</td>
            <td>操作</td>
        </tr>
        <c:forEach var="user" items="${list}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.username}</td>
                <td>${user.realName}</td>
                <td>${user.age}</td>
                <td><c:choose>
                    <c:when test="${user.sex==1}">男</c:when>
                    <c:when test="${user.sex==0}">女</c:when>
                    <c:otherwise>其他</c:otherwise>
                </c:choose>
                </td>
                <td>
                    <fmt:parseDate var="registerTime" value="${user.registerTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${registerTime}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
                </td>
                <td><a href="/user/toUpdate?id=${user.id}" class="btn btn-primary">修改</a>
                    <a href="/user/delete?id=${user.id}" class="btn btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <span>总页数${pageCount}</span>
    <span>总记录数${count}</span>
    <span>当前页数${page}</span>
    <a href="/user/list?page=${page-1}">上一页</a>
    <a href="/user/list?page=${page+1}">下一页</a>
</div>
</body>
</html>