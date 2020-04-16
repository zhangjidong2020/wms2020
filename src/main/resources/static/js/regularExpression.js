/*手机号码的正则表达式*/
function phone(a) {
    if ((/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test(a.value))) {
        return true;
    } else {
        a.value = "";
        alert("手机号码有误，请重填");
        return false;
    }
}


/*添加价格的正则表达式*/
function money(a) {
    if (!(/(^[0-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/.test(a.value))) {
        a.value = "";
        alert("金额有误，请重填");
        return false;
    } else {
        return true;
    }
}


// 车牌号的正则表达式
function numberPlate(a) {
    //车牌号判断的正则表达式
    var regExp = /(^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$)/
    if (!regExp.test(a.value)) {
        a.value = "";
        alert("车牌号填写有误，请重填");
        return false;
    } else {
        console.log("车牌号正确")
    }
    return true;

}

//身份证正则表达式
function isCardNo(card) {
// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (reg.test(card.value) === false) {
        card.value = "";
        alert("身份证输入不合法");
        return false;
    }
}

//驾驶证正则表达式
function drivenum(a) {
    var reg = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}(\d|x|X)$/;
    if (reg.test(a.value) === false) {
        a.value = "";
        alert("驾驶证输入不合法");
        return false;
    }
}


function writegz(a) {
    var reg = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!reg.test(a.value)) {
        a.value = "";
        alert("只能是中文，英文");
        return false;
    } else {
        return true;
    }
}

//只能数字或小数 只能有一个小数点并且第一位不能为小数点
function numbergz(a) {
    var reg = /^\d*\.{0,1}\d{0,1}$/;
    if (!reg.test(a.value)) {
        a.value = "";
        alert("只能数字或小数 只能有一个小数点并且第一位不能为小数点");
        return false;
    } else {
        return true;
    }
}

//只能正整数
function zzs(a) {
    var reg = /^[0-9]*[1-9][0-9]*$/;
    if (!reg.test(a.value)) {
        a.value = "";
        alert("只能为正整数");
        return false;
    } else {
        return true;
    }
}

//长宽高
function ckg(a) {
    var reg = /\d+([.]?\d)*\*\d+([.]?\d)*\*\d+([.]?\d)*/;
    if (!reg.test(a.value)) {
        a.value = "";
        alert("格式错误，请按长*宽*高");
        return false;
    } else {
        return true;
    }
}


//检查重复
function logisticszc(a) {
    var reg = a.value;
    var atx = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    if (!atx.test(a.value)) {
        a.value = "";
        alert("只能是中文，英文");
        return false;
    } else {
        $(function () {
            $.ajax({
                url: '/logisticsxx/alllogistics',
                success: function (data) {
                    for (var i in data) {
                        if (reg == data[i].logisticsName) {
                            alert("该物流公司已经被注册，请换个公司名称");
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            })
        })
    }

}