<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Document</title>
</head>
<body>
<div class="modal" id="myModal" style="margin-top: 25px;">
    <div class="butdangNhap">
        <div style="width: 100%;" >
            <div id="divBodyAddAndUpdate">
                <form method="post" action="login?action=addAccount">
                    <h1 align="center">Information Account</h1><br>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  ID</label>
                        <input name="idAccount" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="35" placeholder="Input ID: AX"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Full name</label>
                        <input name="nameAcc" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input full-name"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Password</label>
                        <input name="passAcc" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input password"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Email</label>
                        <input name="email" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input email"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Phone</label>
                        <input name="phone" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input number"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Status</label>
                        <input name="status" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input status"/>
                    </div><br>
                    <div class="row">
<%--                        <input type="submit" style="text-align: right;text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;" value="Add Account"></input>--%>
                        <button style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Add Account</button>
                        <a href="login?action=listAccount" style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Back</a>
                    </div><br>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function showOverlay() {
        document.getElementById('myModal').style.display = 'block';
    }

    function hideOverlay() {
        document.getElementById('myModal').style.display = 'none';
    }
</script>
</html>