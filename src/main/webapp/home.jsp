<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>
    <div id="divBody">
        <h1>Chào mừng bạn đến với Account</h1><br>
        <table style="width: 100%;">
            <tr>
                <th><a methods="POST" style="margin-top: 10px;font-size: 25px" href="login?action=listAccount">Danh sách Account</a></th>
                <th><a methods="POST" style="margin-top: 10px;font-size: 25px" href="login?action=listRole">Danh sách Role</a></th>
            </tr>
        </table>
    </div>
</body>

</html>