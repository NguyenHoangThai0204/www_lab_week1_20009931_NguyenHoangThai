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
                <form method="post" action="login?action=upDateAccount" style="background-color: #effcfc;">
                    <h1 align="center">Information Account</h1><br>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  ID</label>
                        <input name="idAccount" value="${upAcc.account_id}" type="text" style="border: #666 ;font-size: 25px;padding:4px ;width: 65%; background-color: #f0f0f0; color: #666; opacity: 0.7; " size="35" readonly />
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Full name</label>
                        <input name="nameAcc" value="${upAcc.full_name}" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Password</label>
                        <input name="passAcc" value="${upAcc.password}" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Email</label>
                        <input name="email" value="${upAcc.email}" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Phone</label>
                        <input name="phone" value="${upAcc.phone}" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Status</label>
                        <input name="status" value="${upAcc.status}" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45"/>
                    </div><br>
                    <div class="row">
                        <button style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Update Account</button>
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