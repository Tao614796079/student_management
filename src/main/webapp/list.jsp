<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.biz.vo.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <title>学生列表</title>
    <!--[if lt IE 9]>
    <script src="scripts/html5shiv.js"></script>
    <script src="scripts/respond.js"></script>
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom css for this template -->
    <link rel="stylesheet" href="css/style.css">
    <![endif]-->
</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    String cur_page = (String) request.getAttribute("cur_page");
    int pagecount = (Integer) request.getAttribute("totalPage");
%>
<div>
    <h1 class="text-center">学生信息表</h1>
    <br>
</div>
<div style="padding-left: 2%;padding-right: 2%;">
    <button type="button" class="btn btn-default pull-right" onclick="window.location.href='addstudent.jsp'">添加学生信息
    </button>
    <br><br>
    <table class="table-bordered text-center" width="100%">
        <tr>
            <th width="10%" class="text-center">学号</th>
            <th width="15%" class="text-center">姓名</th>
            <th width="10%" class="text-center">平均分</th>
            <th width="15%" class="text-center">出生日期</th>
            <th width="40%" class="text-center">备注</th>
            <th width="10%" class="text-center">操作</th>
        </tr>
        <c:forEach items="${studentList}" var="bean">
            <tr>
                <td>${bean.id}</td>
                <td>${bean.name}</td>
                <td>${bean.avgscore}</td>
                <td><fmt:formatDate value="${bean.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${bean.description}</td>
                <td><a href="/delete?id=${bean.id}">删除</a>/<a href="/update?id=${bean.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="text-center">
        <button type="button" class="btn btn-default btn-inverse"
                onclick="last_page()"><
            <上一页
        </button>
        <span>&nbsp;&nbsp;<%=cur_page%>/<%=pagecount%>&nbsp;&nbsp;</span>
        <button type="button" class="btn btn-default btn-inverse"
                onclick="next_page()">下一页>>
        </button>

    </div>

</div>
<script>
    function next_page() {
        var cur = <%=cur_page%>;
        var count = <%=pagecount%>;
        if (cur < count) {
            window.location.href = "/studentlist?cur_page=" + (cur + 1);
        } else {
            alert("已经是最后一页了！");
        }
    }
    function last_page() {
        var cur = <%=cur_page%>;
        if (cur > 1) {
            window.location.href = "/studentlist?cur_page=" + (cur - 1);
        } else {
            alert("已经是第一页了！");
        }
    }
</script>
<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
