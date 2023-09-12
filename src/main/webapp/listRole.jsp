<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.www_lab_week1.models.Role" %>
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
    <h1>Danh sách Role</h1><br>
    <table style="width: 100%;">
        <tr>
            <th>Id</th>
            <th>Role name</th>
            <th>Description</th>
            <th>Status</th>
            <th></th>
        </tr>
        <% List<Role> roleList;
            roleList = (List<Role>) request.getAttribute("listRole");
        for ( Role role: roleList ) {%>
            <tr>
                <td><%= role.getRole_id() %></td>
                <td><%= role.getRole_name() %></td>
                <td><%= role.getDescription() %></td>
                <td><%= role.getStatus() %></td>
                <td><a href="#">Sửa</a> | <a href="#">Xóa</a></td>
            </tr>
        <%}%>
    </table>
</div>
</body>
</html>