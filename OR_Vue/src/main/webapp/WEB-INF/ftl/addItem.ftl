
<#macro addItem>
<script type="text/javascript">
    function addItem() {

        var name = $("#name");
        var price = $("#price");
        var addItem_btn = $("#addItem_btn");

        $("#addItem").dialog({
            iconCls:"icon-add",
            title: "添加商品",
            modal: true,
            resizable: true,
            height: 550,
            width: 400,
            buttons: "#addItem_btn"
        });
        name.validatebox({
            required: true,
            missingMessage: "请输入商品名称",
            delay:300
        })
        price.validatebox({
            required: true,
            missingMessage: "请输入商品价格",
            delay:300
        })

        $('#addItem_btn_save').click(function () {
            $("#addItem").form('submit', {
                url:"/items/addItems",
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (data) {
//                    alert("成功添加商品");
//                    $.messager.alert("添加成功");
                    //这是返回的data是字符串，需要解析成JSON对象才能读取属性
                    data = eval('(' + data + ')');//var data = JSON.parse(data);
//                    location.href = "/items/product-details/" + data.id;
                    $("#addItem").dialog('close');
//                    window.location.reload();
                }
            })
        });
        //按钮关闭dialog
        $('#addItem_btn_close').click(function () {
            $("#addItem").dialog('close');
        });

        //预览图片
        $('#addItem_pic').change(function () {
            readURL(this);
        });
        function readURL(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function(e) {
                    $('#addItem_preView').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }


    }
</script>

<body>
    <div class="hidden">
        <form id="addItem" class="reg" enctype="multipart/form-data" method="post">
            <p>
                <label for="name">名称：</label>
                <input id="name" type="text" name="name" class="text"/>
                <span class="star">*</span>
            </p>
            <p>
                <label for="price">价格：</label>
                <input id="price" type="text" name="price" class="text"/>
                <span class="star">*</span>
            </p>
            <p>
                <label for="detail">详细：</label>
                <input id="detail" type="text" name="detail" class="text"/>
            </p>
            <p>
                <label for="kind" class>类型：</label>
                <select name="classId" id="kind" class="text">
                    <option value="1" selected="selected">笔记本</option>
                    <option value="2">台式机</option>
                    <option value="3">平板</option>
                </select>
            </p>
            <p>
                <label for="addItem_pic" class="easyui-linkbutton">上传图片</label>
                <#--<input id="pic" name="piccc" class="easyui-filebox" data-options="prompt:'选择一张图片'" style="width:200px"/>-->
                <input id="addItem_pic" type="file" name="piccc" class="text" data-options="prompt:'选择一张图片'" style="position:absolute;clip:rect(0 0 0 0);"/>
                <#--<img id="addItem_preView" onload="AutoResizeImage(300,200,this)">-->
                <img id="addItem_preView" style="width: 262px;height: 196px;">
            </p>

            <div id="addItem_btn" class="btn">
                <a href="#" id="addItem_btn_save" class="easyui-linkbutton" iconCls="icon-save" >保存</a>
                <a href="#" id="addItem_btn_close" class="easyui-linkbutton" iconCls="icon-clear">关闭</a>
            </div>
        </form>
    </div>
</body>

</#macro>