<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %></h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Document</title>
</head>
<body>
<div style="width: 100%;" >
    <div id="divBody">

        <div>
            <form action="action" id="formLogIn">
                <h3>Đăng nhập tài khoản</h3>
                <input type="text" placeholder="user"><br>
                <input type="text" placeholder="password"><br>
                <input type="submit" value="Login"></input><br>
                <a href="signin" style="margin:auto ; padding: 5px;">Sign in</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>