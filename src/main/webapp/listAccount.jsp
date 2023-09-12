<%@ page import="vn.edu.iuh.www_lab_week1.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Document</title>
</head>
<body>
    <div id="divBody">
        <h1>Danh sách Account</h1><br>
        <table style="width: 100%;">
            <tr>
                <th>Id</th>
                <th>Full name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Status</th>
                <th></th>
            </tr>
            <%  List<Account> list;
                list = (List<Account>) request.getAttribute("listAccount");
                for ( Account account: list) {%>
            <tr>
                <td><%= account.getAccount_id() %></td>
                <td><%= account.getFull_name() %></td>
                <td><%= account.getPassword() %></td>
                <td><%= account.getEmail() %></td>
                <td><%= account.getPhone() %></td>
                <td><%= account.getStatus() %></td>
                <td><a href="#">Sửa</a> | <a href="#">Xóa</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>