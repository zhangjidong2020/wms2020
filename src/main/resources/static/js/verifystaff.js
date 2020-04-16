/*手机号码的正则表达式*/
function phone(a) {
    var reg = a.value;
    var atx = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
    var tel = document.getElementById("t1");
    var tel1 = document.getElementById("t2");
    tel.innerHTML = "";
    tel1.innerHTML = "";

    if (!atx.test(a.value)) {
        a.value = "";
        alert("手机号码格式有误，请重填");
        return false;
    } else {
        $(function () {
            var data = {};
            data.userTel = reg;
            $.ajax({
                url: '/staff/verify',
                type: 'post',
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json; charset=utf-8',
                success: function (data) {
                    if (data.rs) {
                        var data = data.data

                        if (data.userTel == 1) {
                            /* alert("该手机号已存在，请重填");*/
                            tel.innerHTML = "号码已存在"
                            tel.style.color = "#FF0000";

                            tel1.innerHTML = "号码已存在"
                            tel1.style.color = "#FF0000";
                            a.value = "";
                            return false;
                        } else {
                            tel.innerHTML = "";
                            tel1.innerHTML = "";
                            return true;
                        }
                    } else {
                        layer.msg(data.msg, {icon: 2, time: 2000})
                    }
                }

            })
        })
    }
}


function logisticszc(a) {
    var reg = a.value;
    $(function () {
        var data = {};
        data.userName = reg;
        $.ajax({
            url: '/staff/verify',
            type: 'post',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                if (data.userName == 1) {
                    alert("该账号已存在，请重填");
                    a.value = "";
                    return false;
                } else {
                    return true;
                }
            }

        })
    })

}


function logno(a) {
    var reg = a.value;
    $(function () {
        var data = {};
        data.no = reg;
        $.ajax({
            url: '/staff/verify',
            type: 'post',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                if (data.no == 1) {
                    alert("该编号已存在，请重填");
                    a.value = "";
                    return false;
                } else {
                    return true;
                }
            }
        })
    })
}

