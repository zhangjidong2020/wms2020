/*物流公司的下拉框*/
$(function () {
    $.ajax({
        url: '/logisticsxx/alllogistics',
        success: function (data) {
            var d = data.data;
            if (data.rs) {
                for (var i in d) {
                    $('#logisticsName:last').append("<option value=" + d[i].logisticsId + ">" + d[i].logisticsName + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }
        }
    })

})
/*
/!* 车辆下拉框change事件 *!/
$('#logisticsName').bind("change",function () {
    $('#vehicleId option').not(":first").remove();
    $.ajax({
        url:  '/vehicle/findallxx',
        data:{
            id:$("#logisticsName").val()
        },
        success:function (data) {
            for (var i in data) {
                $('#vehicleId:last').append("<option value="+data[i].vehicleId+">"+data[i].vehicleName+"</option>")
            }
        }
    })
})*/
