<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <form action="login" method="post" id="formLogIn" style="border:1px solid blue; padding: 20px">
                <h3>Đăng nhập tài khoản</h3>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="text" name="password" placeholder="password"><br>
                <input type="submit" style="margin:15px auto ;width:30%; background-color: aqua; " value="Login"></input><br>
                <a href="signin" style="margin:auto ; padding: 5px;">Sign in</a>
                <a style="margin-top: 10px;" href="sdf">Danh sách Account</a><br>
                <a style="margin-top: 10px;" href="adsg">Danh sách Role</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>