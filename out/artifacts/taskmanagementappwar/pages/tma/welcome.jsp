<%@taglib uri="http://struts.apache.org/tags-html" prefix="s"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page language="java" import="java.util.*" %>
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("common");
    String English  = new String(resource.getString("English").getBytes("ISO-8859-1"), "UTF-8");
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="s"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
          crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <link rel="stylesheet" type="text/css" href="pages/feedbackform/jscss/formcss.css">

    <style>
        body {
            background: #555;
        }
        .content {
            max-width: 500px;
            margin: auto;
            background: white;
            padding: 10px;
        }
    </style>
</head>

<body>
<div class="content">
    <h1 class="html-editor-align-center"><%=English%></h1>

<br><br><br>

<header class="ccheader">

    <button class="btn btn-primary btn-lg search" onclick="location.href='add.do';"> Add </button>
    <br>
    <br>
    <button class="btn btn-primary btn-lg search" onclick="location.href='Delete.do';"> Delete </button>
    <br>
    <br>
    <button class="btn btn-primary btn-lg search" onclick="location.href='Update.do';"> Update </button>
    <br>
    <br>
    <button class="btn btn-primary btn-lg search" onclick="location.href='Get.do';"> Get </button>
    <br>
    <br>
    <button class="btn btn-primary btn-lg search" onclick="location.href='List.do';"> List </button>
    <br>
    <br>

</header>


<br><br><br>

<br>
<br>
<br>
<br>
</div>
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
