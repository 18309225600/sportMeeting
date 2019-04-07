$(document).ready(function () {
    bind();
});

var bind = function () {
    $("a.editPerson").on("click",function () {
        $("input.username").removeAttr("disabled");
        $("input.phone").removeAttr("disabled");
        $("div.headImg").removeAttr("hidden");

        $("div.headImg").find("input.headImg").on("change",function () {
            uploadImg();
        })
    })

    $("a.savePerson").on("click",function () {
        var id = $("input.userId").val();
        var username = $("input.username").val();
        var phone = $("input.phone").val();
        var img = $("input.img").val();

        var url = "/user/edit/"+id;
        var param = {"username":username,"phone":phone,"img":img};
        $.ajax(url,{
            async: true,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(param),
            success: function (data) {
                $("input.username").attr("disabled","disabled");
                $("input.phone").attr("disabled","disabled");
                $("div.headImg").attr("hidden","hidden");
                alert(data);
            }
        });
    });
}

function uploadImg() {
    $.ajaxFileUpload({
        url : '/toolbox/fileupload', //用于文件上传的服务器端请求地址
        fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
        type : 'post',
        dataType : 'string', //返回值类型 一般设置为json
        success : function(data, status) //服务器成功响应处理函数
        {
            $("input.img").val("/static/assets/img/"+data);
            $("img.headImgSucc").removeAttr("src").attr("src","/static/assets/img/"+data);
            $("div.headImg").find("input.headImg").on("change",function () {
                uploadImg();
            })
        },
        error : function(data, status, e)//服务器响应失败处理函数
        {
            alert("图片上传失败");
            $("div.headImg").find("input.headImg").on("change",function () {
                uploadImg();
            })
        }
    });
}