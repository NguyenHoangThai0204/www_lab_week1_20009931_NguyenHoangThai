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
<div style="width: 80%; border-radius: 20px; margin: auto" >
    <div id="divBody1">
            <form action="login?action=nextHome" method="POST" id="formLogIn" style="border:1px solid blue; padding: 20px">
                <h3>Đăng nhập tài khoản</h3>
                <input type="text" name="email" value="thaidp" placeholder="Email"><br>
                <input type="password" name="password" value="123" placeholder="password"><br><br>
                <input type="hidden" name="action" value="nextHome">
                <input type="submit" style="background-color: aqua;padding: 5px; border: 1px solid aqua;" value="LogIn">
            </form>
    </div>
</div>
</body>
</html>