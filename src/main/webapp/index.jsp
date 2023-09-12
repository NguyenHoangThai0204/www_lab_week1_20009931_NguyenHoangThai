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
            <form id="formLogIn" style="border:1px solid blue; padding: 20px">
                <h3>Đăng nhập tài khoản</h3>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="password" name="password" placeholder="password"><br><br><br>
                <a href="login?action=nextHome" type="submit" style="margin:15px auto ;width:30%; background-color: aqua; padding:7px; text-decoration: none; font-size: xx-large; font-weight: bold;" >LogIn</a><br>
            </form>
        </div>
    </div>
</div>
</body>
</html>