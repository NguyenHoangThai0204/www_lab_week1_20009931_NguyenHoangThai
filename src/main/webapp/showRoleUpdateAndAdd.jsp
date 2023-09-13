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
                <form method="post" action="login?action=addRole">
                    <h1 align="center">Information Role</h1><br>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  ID</label>
                        <input name="idRole" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="35" placeholder="Input ID"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Role name</label>
                        <input name="nameRole" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input role-name"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Description</label>
                        <input name="desRole" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input description"/>
                    </div>
                    <div class="row">
                        <label class="title" style="margin-right: 5px;font-size: 25px;width: 30%;"
                        >  Status</label>
                        <input name="statusRole" type="text" style="font-size: 25px;padding:4px ;width: 65%;" size="45" placeholder="Input status"/>
                    </div>
                    <div class="row">
                        <button style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Add Role</button>
                        <a href="login?action=listRole" style="text-decoration: none;font-size: 25px;font-weight: bold; margin-bottom:5px;">Back</a>
                    </div>
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