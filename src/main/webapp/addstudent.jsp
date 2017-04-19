<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <title>添加学生信息</title>
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
<h1 class="text-center">学生信息表</h1>
<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <form action="/addstudent" method="post">
            <h4>学号：</h4>
            <input type="text" class="form-control" id="id" name="id">
            <h4>姓名：</h4>
            <input type="text" class="form-control" id="name" name="name">
            <h4>平均成绩：</h4>
            <input type="text" class="form-control" id="avgscore" name="avgscore">

            <h4>出生日期：</h4>
            <input type="text" class="form-control" id="birthday" placeholder="yyyy-mm-dd" name="birthday">

            <div class="form-group">
                <h4>备注：</h4>
                <textarea class="form-control" rows="4" id="description" name="description"></textarea>
            </div>
            <br>
            <div class="btn-group pull-right">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="reset" class="btn btn-danger">重置</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3"></div>
</div>

<script src="bootstrap/js/jQuery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

</body>
</html>
