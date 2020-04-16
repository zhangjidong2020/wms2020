$(function () {
    $("#openit").wmPop({target: "#WmPopWin"});
});
;(function ($) {
    $.fn.wmPop = function (options) {
        var defaults = {
            opacity: 0.5,
            target: null,
            drag: true,
            visibility: false,
            html: ''
        }, _this = this;
        this.WM = $.extend(defaults, options);
        var B = null, C = null, $win = $(window), $t = $(this);
        this.showpopWin = function () {
            B = $("<div id='mask' class='mark'></div>").css("opacity", _this.WM.opacity).dblclick(function () {
                _this.close();
            }).appendTo("body").fadeIn(200);
            C = $(_this.WM.target);
            setPosition();
            B.css("visibility", "visible")
            C.css("visibility", "visible").find('.popwin-close').click(_this.close);
        }

        function setPosition() {
            if (!C) {
                return false;
            }
            var width = C.width(), lt = calPosition(width);
            C.css({
                left: lt[0],
                top: lt[1]
            });
            var $h = $("body").height(), $wh = $win.height(), $hh = $("html").height();
            $h = Math.max($h, $wh);
            B.height($h).width($win.width())
        }

        function calPosition(w) {
            l = ($win.width() - w) / 2;
            t = $win.scrollTop() + $win.height() / 4;
            return [l, t];
        }

        this.close = function () {
            if (C) {
                B.fadeOut(100).remove();
                C.css("visibility", "hidden");
            }
        }
        $win.resize(function () {
            setPosition();
        });
        _this.WM.visibility ? _this.showpopWin() : $t.click(function () {
            _this.showpopWin();
            return false;
        });
        return this;
    }
})(jQuery);