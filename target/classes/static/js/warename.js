/*确定签收*/
$(function () {
    var id = $("#orderId").text()
    document.getElementById("orderId1").innerHTML = id;

    $.ajax({
        url: '/warehouse/allWareName',
        success: function (dd) {
            if (dd.rs) {
                var d = dd.data;
                for (var i in d) {
                    $('#wareName:last').append("<option value=" + d[i].id + ">" + d[i].wareName + "</option>")
                }
            } else {
                layer.msg(data, msg, {icon: 2, time: 2000});
            }

        }
    })
})