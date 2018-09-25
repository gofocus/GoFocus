
<#macro login>
<script type="text/javascript">
    function login() {
        var username = $("#username");
        var login = $("#login");
        var password = $("#password");
        var login_btn = $("#login_btn");
        login.dialog({
            iconCls: "icon-man",
            title: "登录",
            modal:true,
            resizable:true,
            width: 300,
            height: 250,
            buttons: "#login_btn"
        });
        username.validatebox({
            required: true,
            validType: 'length[3 ,15]',
            missingMessage: "请输入用户名",
            delay:300
        });
        password.validatebox({
            required: true,
            validType: 'length[3 ,20]',
            missingMessage: "请输入密码",
            delay:300
        });
        $("#login_ok").click(function () {
            $("#login").form('submit', {
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function () {
//                    location.href = "/";
                    window.location.reload();
                }
            });
        });

    }

</script>

<body>
<div class="hidden">
    <form id="login" action="/user/login" method="post" class="reg">
        <p>
            <label for="username">账号</label><span class="star">*</span>
            <input id="username" type="text" name="username" class="text" />
        </p>
        <p>
            <label for="password">密码</label><span class="star">*</span>
            <input id="password" type="password" name="password" class="text" />
        </p>
        <div id="login_btn" class="btn">
            <a id="login_ok" class="easyui-linkbutton" style="padding:0 12px 0 12px">登录</a>
            <#--<a href="/" class="easyui-linkbutton" iconCls="icon-clear" iconAlign="right">返回</a>-->
        </div>
    </form>
</div>
</body>

</#macro>