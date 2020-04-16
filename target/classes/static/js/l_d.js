/*物流公司的下拉框*/
$(function () {
    $.ajax({
        url: '/logisticsxx/alllogistics',
        success: function (data) {
            var d = data.data;
            if (data.rs) {
                for (var i in d) {
                    $('#logisticsnameadd:last').append("<option value=" + d[i].logisticsId + ">" + d[i].logisticsName + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }

        }
    })
})
/* 驾驶员下拉框change事件 */
$('#logisticsnameadd').bind("change", function () {
    $('#driverNameadd option').not(":first").remove();
    $.ajax({
        url: '/driver/findalldriver',
        data: {
            id: $("#logisticsnameadd").val()
        },
        success: function (data) {

            var d = data.data;
            if (data.rs) {
                for (var i in d) {
                    $('#driverNameadd:last').append("<option value=" + d[i].driverId + ">" + d[i].driverName + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }

        }
    })
})