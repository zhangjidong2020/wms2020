/*仓库下拉框*/
$(function () {
    $.ajax({
        url: "/cargo/allWare",
        success: function (da) {
            if (!da.rs) {
                layer.msg(da.msg, {icon: 2, time: 2000})
                return;
            }
            var data = da.data;
            for (var i in data) {
                $('#allWarehouse:last').append("<option value=" + data[i].id + ">" + data[i].wareName + "</option>")
            }
        }
    })
})
/* 仓库下拉框change事件 */
$('#allWarehouse').bind("change", function () {
    $('#dam_id option').not(":first").remove();
    $.ajax({
        url: "/cargo/allCargoArea",
        data: {
            wareId: $("#allWarehouse").val()
        },
        success: function (da) {
            if (!da.rs) {
                layer.msg(da.msg, {icon: 2, time: 2000})
                return;
            }
            var data = da.data;
            for (var i in data) {
                $('#dam_id:last').append("<option value=" + data[i].id + ">" + data[i].goodsName + "</option>")
            }
        }
    })
})

/*货区下拉框change事件*/
$('#dam_id').bind("change", function () {
    $('#allShelves option').not(":first").remove();
    $.ajax({
        url: "/cargo/allShelves",
        data: {
            damId: $("#dam_id").val()
        },
        success: function (da) {
            if (!da.rs) {
                layer.msg(da.msg, {icon: 2, time: 2000})
                return;
            }
            var data = da.data;
            for (var i in data) {
                console.log(data[i].id)
                console.log(data[i].shelvesNo)
                $('#allShelves:last').append("<option value=" + data[i].id + ">" + data[i].shelvesNo + "</option>")
            }
        }
    })
})