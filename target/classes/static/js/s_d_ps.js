$(function () {
    $.ajax({
        url: "/staff/parentDepartments",
        success: function (data) {
            if (data.rs) {
                var data = data.data
                for (var i in data) {
                    $('#dId1:last').append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }

        }
    })

})
$('#dId1').bind("change", function () {
    $('#Pid option').not(":first").remove();
    $.ajax({
        url: "/staff/sonDepartments",
        data: {
            dId: $("#dId1").val()
        },
        success: function (data) {
            if (data.rs) {
                var data = data.data
                for (var i in data) {
                    $('#Pid:last').append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }
        }
    })
})


$('#Pid').bind("change", function () {
    $('#post option').not(":first").remove();
    $.ajax({
        url: "/staff/posts",
        data: {
            dId: $("#Pid").val()
        },
        success: function (data) {
            if (data.rs) {
                var data = data.data
                for (var i in data) {
                    $('#post:last').append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
                }
            } else {
                layer.msg(data.msg, {icon: 2, time: 2000})
            }
        }
    })
})

