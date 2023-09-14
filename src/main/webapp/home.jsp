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
<div id="divBody" style="background-color: #effcfc;width: 60%;padding: 15px;border-radius: 25px;margin-top: 25px;border:1px solid #effcfc">
    <h1>Chào mừng bạn </h1><br>
    <table style="width: 100%;">
        <tr>
            <th><a methods="POST" style="margin-top: 10px;font-size: 25px" href="login?action=listAccount">Danh sách Account</a></th>
            <th><a methods="POST" style="margin-top: 10px;font-size: 25px" href="login?action=listRole">Danh sách Role</a></th>
            <th><a methods="POST" style="margin-top: 10px;font-size: 25px" href="index.jsp">Đăng xuất</a></th>
        </tr>
    </table>
    <br>
    <form style="width: 60%; margin: auto;" method="POST" >
        <h1 align="center">Information Account</h1><br>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  ID</label>
            <input name="idAccount" value="${upAccHome.account_id}" type="text" style="border: #666 ;font-size: 25px;padding:4px ;width: 65%; background-color: #f0f0f0; color: #666; opacity: 0.7; " size="35" readonly />
        </div>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  Full name</label>
            <input name="nameAcc" value="${upAccHome.full_name}" type="text" style="border: #666;background-color: #f0f0f0; color: #666; opacity: 1;font-size: 25px;padding:4px ;width: 65%;" size="45" readonly/>
        </div>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  Password</label>
            <input name="passAcc" value="${upAccHome.password}" type="text" style="border: #666 ;background-color: #f0f0f0; color: #666; opacity: 0.7;font-size: 25px;padding:4px ;width: 65%;" size="45" readonly/>
        </div>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  Email</label>
            <input name="email" value="${upAccHome.email}" type="text" style="border: #666 ;background-color: #f0f0f0; color: #666; opacity: 0.7;font-size: 25px;padding:4px ;width: 65%;" size="45" readonly/>
        </div>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  Phone</label>
            <input name="phone" value="${upAccHome.phone}" type="text" style="border: #666 ;background-color: #f0f0f0; color: #666; opacity: 0.7;font-size: 25px;padding:4px ;width: 65%;" size="45" readonly/>
        </div>
        <div class="row">
            <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
            >  Status</label>
            <input name="status" value="${upAccHome.status}" type="text" style="border: #666 ;background-color: #f0f0f0; color: #666; opacity: 0.7;font-size: 25px;padding:4px ;width: 65%;" size="45" readonly/>
        </div><br>
    </form>
</div>
</body>

</html>