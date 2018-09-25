<#macro editItem>

<script type="text/javascript">
        function editItem(id){
            var name = $("#edit_name");
            var price = $("#edit_price");
            var pic = $("#edit_pic");
            var editItem = $("#editItem");

            //填充form
            editItem.form('load','/items/editItem/'+ id);

            //无法自动给<img src="" />填充数据，使用onLoadSuccess事件填充form
            editItem.form({
                onLoadSuccess: function (data) {
                    var pic_address = "/pic/" + $("#pic_name").val();
                    $("#edit_piccc").attr("src", pic_address);
                }
            });

            /*这样给img标签的src赋值，会出现延迟问题，总是显示上一次点击的图片
            var pic_address = "/pic/" + $("#pic_address").val();
            $("#edit_piccc").attr("src", pic_address);*/

            name.validatebox({
                required:true,
                validType:"length[3,30]",
                delay:800
            });
            price.validatebox({
                required:true,
                validType:"length[3,15]",
                delay:800
            });

            editItem.dialog({
                title: "编辑商品",
                iconCls:"icon-edit",
                modal: true,
                resizable: true,
                height: 600,
                width: 520,
                buttons: "#editItem_btn"
            });

            //点击提交商品修改
            $("#editItem_btn_save").click(function () {
                $("#editItem").form('submit',{
                    url:"/items/editItem",
                    onSubmit:function () {
                        return $(this).form('validate');
                    },
                    success:function (data) {
                        data = eval('(' + data + ')');
                        console.log("编辑成功");
                        $("#editItem").dialog('close');
                        $('#edit_all_items').datagrid('load');
//                        window.location.reload();
//                        location.href = "/items/product-details/" + data.id;
                    }
                })
            });
            $("#editItem_btn_close").click(function () {
                $("#editItem").dialog('close');
            });

            //预览图片
            $('#editItem_pic').change(function () {
                readURL(this);
            });
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function(e) {
                        $('#editItem_preView').attr('src', e.target.result);
                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }


        }

</script>

<body>
<div class="hidden">
    <form id="editItem" enctype="multipart/form-data" method="post" class="reg">
        <input type="hidden" name="id" class="text"/><br>
        <img src="" id="edit_piccc" style="width: 262px;height: 196px;"/><br>
        <#--<img src="" id="edit_piccc" onload="AutoResizeImage(300,200,this)"/><br>-->
        <input id="pic_name" type="hidden" name="pic" class="text"/><br>
        <p>
            <label for="edit_name">名称：</label>
            <input id="edit_name" type="text" name="name" class="text" />
        </p>
        <p>
            <label for="edit_price">价格：</label>
            <input id="edit_price" type="text" name="price" class="text" />
            <#--<span class="star">*</span>-->
        </p>
        <p>
            <label for="edit_detail">详细：</label>
            <input id="edit_detail" type="text" name="detail" class="text" />
        </p>
        <p>
            <label for="editItem_pic" class="easyui-linkbutton">上传图片</label>
            <#--<input id="edit_pic" name="piccc" class="easyui-filebox" data-options="prompt:'选择一张图片'" style="width:200px"/>-->
            <input id="editItem_pic" type="file" name="piccc" class="text" data-options="prompt:'选择一张图片'" style="position:absolute;clip:rect(0 0 0 0);"/>
            <#--<img id="editItem_preView" onload="AutoResizeImage(300,200,this)">-->
            <img id="editItem_preView" style="width: 262px;height: 196px;">
        </p>
        <div class="btn" id="editItem_btn">
            <a id="editItem_btn_save" class="easyui-linkbutton" iconCls="icon-save">保存</a>
            <a id="editItem_btn_close" class="easyui-linkbutton" iconCls="icon-clear">关闭</a>
        </div>
    </form>
</div>
</body>
</#macro>