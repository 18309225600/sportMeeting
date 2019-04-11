$(document).ready(function(){

    bind();

});

var bind = function () {
    //提交按钮
    $("button.addBtn").on("click",function () {
        //获取变量
        var id = $("input.id").val();
        var name = $("input.name").val();
        var startAt = $("input.startAt").val();
        var endAt = $("input.endAt").val();
        var remark = $("textarea.remark").val();
        var $input = $('input[type=checkbox]:checked');

        var sportItems =[];
        for (i=0,len=$input.length;i<len;i++){
            sportItems.push($($input[i]).val());
        }

        var param = {"id":id,"name":name,"startAt":startAt,"endAt":endAt,"remark":remark,"sportItems":sportItems}

        var url = "/sport/saveSport";
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

