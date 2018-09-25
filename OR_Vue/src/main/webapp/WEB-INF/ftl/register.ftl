<#macro register>
<script type="text/javascript">

    function register() {
        var usercode = $("#usercode");
        var rusername = $("#rusername");
        var rpassword = $("#rpassword");
        var password2 = $("#password2");

        $.extend($.fn.validatebox.defaults.rules, {
            equals:{
                validator:function (value,param) {
                    return value == $(param[0]).val();
                },
                message:'密码前后不一致'
            },
            minLength: {
                validator: function(value, param){
                    return value.length >= param[0];
                },
                message: '请至少输入{0}个字符'
            }
        });

        $("#register").dialog({
            iconCls: "icon-add",
            title: "注册",
            modal: true,
            resizable: true,
            height: 320,
            width: 320,
            buttons: "#register_btn"
        });
        usercode.validatebox({
            required: true,
            validType: ['minLength[3]','remote[\'/user/validate_usercode\',\'usercode\']'],
            delay:300
        });
        rusername.validatebox({
            required: true,
            validType: 'minLength[3]',
            delay:300
        });
        rpassword.validatebox({
            required: true,
            validType: 'minLength[3]',
            delay:300
        });
        password2.validatebox({
            required: true,
            validType: ['minLength[3]','equals[\'#rpassword\']'],
            delay:300
        });

        $("#register_save").click(function () {
            $("#register").form('submit', {
                url:"/user/register",
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function () {
                    alert("注册成功");
                    window.location.reload();
                }
            })
        });
    }
</script>

<body>
<div class="hidden">
    <form id="register" method="post" class="reg">
        <p>
            <label for="usercode">账户：</label>
            <input id="usercode" type="text" name="usercode" class="text"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="rusername">昵称：</label>
            <input id="rusername" type="text" name="username" class="text"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="rpassword">密码：</label>
            <input id="rpassword" type="password" name="password" class="text"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="password2">确认!：</label>
            <input id="password2" type="password" name="password2"  class="text" />
            <span class="star">*</span>
        </p>
        <!--<p>
    <label for="email">邮箱：</label>
    <input id="email" type="email" name="email" class="text" />
    <span class="star">*</span>
</p>-->
        <!--<p>
            <label for="male">性别：</label>
            <input id="male" type="radio" name="sex" value="1"  class="text" checked="checked"/><label for="male">男</label><input id="female" type="radio" name="sex" value="2"  class="text" checked="checked"/><label for="female">女</label>

        </p>
        <p>
            <label for="birthday">生日：</label>
            <input id="birthday" type="date" name="birthday" class="text" />
        </p>-->
        <div id="register_btn" class="btn">
            <a href="#" id="register_save" class="easyui-linkbutton">注册</a>
        </div>
    </form>
</div>

</body>


</#macro>