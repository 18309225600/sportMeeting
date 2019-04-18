$(document).ready(function(){

    bind();

});

var bind = function () {

    //运动会选择了之后，请求接口拿到运动会对应的运动会项目
    $("select.sport").on("change",function () {
        var sportId = $(this).val();

        $.ajax("/sport/" + sportId + "/sportItems", {
            async: true,
            success: function (msg) {
                //拼装select
                $("select.sportItem").empty();
                $("select.sportItem").append("<option value='"+0+"'>"+"请选择"+"</option>")
                for (var i = 0; i < msg.length; i++) {
                    $("select.sportItem").append("<option value='"+msg[i].id+"'>"+msg[i].itemName+"</option>")
                }
            },
            error: function (data) {
                alert("err" + data);
            }
        });
    });

    //项目选择了之后，请求接口拿到报名人员
    $("select.sportItem").on("change",function () {
        var sportId = $("select.sport").val();
        var sportItemId = $(this).val();


        $.ajax("/sport/sportItemUsers", {
            async: true,
            data:  {"sportId":sportId,"sportItemId":sportItemId},
            success: function (msg) {
                //拼装select
                $("select.joinUser").empty();
                $("select.joinUser").append("<option value='"+0+"'>"+"请选择"+"</option>")
                for (var i = 0; i < msg.length; i++) {
                    $("select.joinUser").append("<option value='"+msg[i].userId+"'>"+msg[i].userName+"</option>")
                }
            },
            error: function (data) {
                alert("err" + data);
            }
        });
    });

    //报名
    $("button.scoreBtn").on("click",function () {
        //获取变量
        var sportId = $("select.sport").val();
        var sportItemId = $("select.sportItem").val();
        var userId = $("select.joinUser").val();
        var realScore = $("input.realScore").val();
        var score = $("input.score").val();

        var param = {"sportId":sportId,"sportItemId":sportItemId,"userId":userId,"score":score,"realScore":realScore}
        var url = "/sport/score";
        $.ajax(url,{
            async: true,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(param),
            success: function (data) {
                alert(data);
                // window.location.reload();
            }
        })
    });
}

