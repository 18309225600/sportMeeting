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
                for (var i = 0; i < msg.length; i++) {
                    $("select.sportItem").append("<option value='"+msg[i].id+"'>"+msg[i].itemName +"       "+ Format(msg[i].startAt,'yyyy-MM-dd HH:mm') +"---"+ Format(msg[i].endAt,'yyyy-MM-dd HH:mm') +"</option>")
                }
            },
            error: function (data) {
                alert("err" + data);
            }
        });
    });

    //报名
    $("button.joinBtn").on("click",function () {
        //获取变量
        var sportId = $("select.sport").val();
        var sportItemId = $("select.sportItem").val();

        var param = {"sportId":sportId,"sportItemId":sportItemId}
        var url = "/sport/join";
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

    function Format(now,mask)
    {
        var d = now;
        var zeroize = function (value, length)
        {
            if (!length) length = 2;
            value = String(value);
            for (var i = 0, zeros = ''; i < (length - value.length); i++)
            {
                zeros += '0';
            }
            return zeros + value;
        };

        return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
        {
            switch ($0)
            {
                case 'd': return d.getDate();
                case 'dd': return zeroize(d.getDate());
                case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
                case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
                case 'M': return d.getMonth() + 1;
                case 'MM': return zeroize(d.getMonth() + 1);
                case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
                case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
                case 'yy': return String(d.getFullYear()).substr(2);
                case 'yyyy': return d.getFullYear();
                case 'h': return d.getHours() % 12 || 12;
                case 'hh': return zeroize(d.getHours() % 12 || 12);
                case 'H': return d.getHours();
                case 'HH': return zeroize(d.getHours());
                case 'm': return d.getMinutes();
                case 'mm': return zeroize(d.getMinutes());
                case 's': return d.getSeconds();
                case 'ss': return zeroize(d.getSeconds());
                case 'l': return zeroize(d.getMilliseconds(), 3);
                case 'L': var m = d.getMilliseconds();
                    if (m > 99) m = Math.round(m / 10);
                    return zeroize(m);
                case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
                case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
                case 'Z': return d.toUTCString().match(/[A-Z]+$/);
                // Return quoted strings with the surrounding quotes removed
                default: return $0.substr(1, $0.length - 2);
            }
        });
    };
}

