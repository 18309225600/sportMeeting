$(document).ready(function () {

    bind();

});

function uploadImg() {
    $.ajaxFileUpload({
        url : '/toolbox/fileupload', //用于文件上传的服务器端请求地址
        fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
        type : 'post',
        dataType : 'string', //返回值类型 一般设置为json
        success : function(data, status) //服务器成功响应处理函数
        {
            $("input.img").val("/static/assets/img/"+data);
            $("img.headImgSucc").removeAttr("hidden");
            $("img.headImgSucc").attr("src","/static/assets/img/"+data);
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

var bind = function () {
    //上传头像
    $("div.headImg").find("input.headImg").on("change",function () {
        uploadImg();
    })
}