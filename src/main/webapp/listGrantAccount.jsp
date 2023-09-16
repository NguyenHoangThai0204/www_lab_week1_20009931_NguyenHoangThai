<%@ page import="vn.edu.iuh.www_lab_week1.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.www_lab_week1.models.GrantAccess" %>
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
<div id="divBody" style="background-color: #effcfc; margin-top:10px;border: 1px solid blue; border-radius: 20px">
    <h1>Danh sách Role</h1>
    <table style="width: 100%;">
        <tr style="font-size: 20px">
            <th>Role_Id</th>
            <th>Account_Id</th>
            <th>Grant</th>
            <th>Note</th>
        </tr>
        <%  List<GrantAccess> list;
            list = (List<GrantAccess>) request.getAttribute("listGrantAcc");
            for ( GrantAccess grantAccess: list) {%>
        <tr class="trBody" style=" width: 100%;font-size: 20px">
            <td><%= grantAccess.getRole_id() %></td>
            <td><%= grantAccess.getAccount_id() %></td>
            <td><%= grantAccess.getIs_grant() %></td>
            <td><%= grantAccess.getNote() %></td>
        </tr><br>
        <%
            }
        %>
    </table>
    <div style="text-align: right">
        <br><br>
        <a methods="POST" href="login?action=nextHomeFromList" style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Back</a>
    </div>
</div>
</body>
</html>