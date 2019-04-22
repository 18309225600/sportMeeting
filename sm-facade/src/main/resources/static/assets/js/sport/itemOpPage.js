$(document).ready(function(){

    bind();

});

var bind = function () {
    //提交按钮
    $("button.addBtn").on("click",function () {
        //获取变量
        var id = $("input.id").val();
        var itemName = $("input.itemName").val();
        var itemMaxUserNum = $("input.itemMaxUserNum").val();
        var itemDesc = $("textarea.itemDesc").val();
        var startAt = $("input.startAt").val();
        var endAt = $("input.endAt").val();

        var param = {"itemId":id,"itemName":itemName,"itemMaxUserNum":itemMaxUserNum,"itemDesc":itemDesc,"startAt":startAt,"endAt":endAt}

        var url = "/sport/saveItem";
        $.ajax(url,{
            async: true,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(param),
            success: function (data) {
                alert(data);
                window.location.reload();
            }
        })
    });
}

