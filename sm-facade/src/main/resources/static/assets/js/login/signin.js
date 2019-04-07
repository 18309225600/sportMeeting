$(document).ready(function () {

    bind();
});

var bind = function () {

    //登录 用submit
    /*$("input.loginBtn").on("click",function () {
       var url = "/login/login";
       var email = $("input.emailName").val();
       var pass = $("input.password").val();
       var param = {"email":email,"password":pass};

       $.ajax(url,{
           async: true,
           type: "POST",
           data: JSON.stringify(param),
           success: function (data) {
               alert(data);
           },
           error: function (data) {
               alert(data);
           }
       });
    });*/
};