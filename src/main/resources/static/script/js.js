$(function () {
    //--
    $('.header').hover(function () {
        $(this).addClass('hov');
        $('.header .logo img').attr('src', '/images/logo3.png');
    }, function () {
        $(this).removeClass('hov');
        $('.header .logo img').attr('src', '/images/logo.png');
    });
    //--
    $('.sNavA').each(function (i) {
        $(this).hover(
		   function () {
		       $('.sNav').eq(i).show();
		       $('.header').addClass('hov');
		       $('.sNav').eq(i).animate({ top: '93px', opacity: '1' }, 500);
		       $(this).addClass('on');
		   },
		   function () {
		       $('.sNav').hide();
		       $('.header').addClass('hov');
		       $(this).removeClass('on');
		   }
		)
        $('.sNav').eq(i).hover(
		   function () {
		       $(this).show();
		       $('.header').addClass('hov');
		       $('.header .logo img').attr('src', '/images/logo3.png');
		       $('.sNavA').eq(i).addClass('on');
		   },
		   function () {
		       $(this).animate({ top: '-552px', opacity: '0' }, 500);
		       $('.header').removeClass('hov');
		       $('.header .logo img').attr('src', '/images/logo.png');
		       $('.sNavA').eq(i).removeClass('on');
		   }
		)
    });
    //--
    $('.tabContentDiv').find('.tabContent:first').show();
    $('.tab').each(function (i) {
        $(this).find('li').each(function (ii) {
            $(this).hover(
			function () {
			    $('.tab').eq(i).find('li').removeClass('liNow');
			    $(this).addClass('liNow');
			    $('.tabContentDiv').eq(i).find('.tabContent').hide();
			    $('.tabContentDiv').eq(i).find('.tabContent').eq(ii).show();
			},
			function () { }
				)
        })
    })
    //--
    $('.tabContentDiv2').find('.tabContent2:first').show();
    $('.tab2').each(function (i) {
        $(this).find('li').each(function (ii) {
            $(this).click(
			function () {
			    $('.tab2').eq(i).find('li').removeClass('liNow');
			    $(this).addClass('liNow');
			    $('.tabContentDiv2').eq(i).find('.tabContent2').hide();
			    $('.tabContentDiv2').eq(i).find('.tabContent2').eq(ii).show();
			}
				)
        })
    })
    //--
    $('.tabContentDiv3').find('.tabContent3:first').show();
    $('.tab3').each(function (i) {
        $(this).find('dd').each(function (ii) {
            $(this).hover(
			function () {
			    $('.tab3').eq(i).find('dd').removeClass('ddNow');
			    $(this).addClass('ddNow');
			    $('.tabContentDiv3').eq(i).find('.tabContent3').hide();
			    $('.tabContentDiv3').eq(i).find('.tabContent3').eq(ii).show();
			},
			function () { }
				)
        })
    })
    //--
    $('.navIco').click(function () {
        $('.navLayer').animate({ right: "0", width: "100%" }, 500);
        $('.pageBg').fadeIn(500);
    })
    $('.navLayer').find('.closeBtn').click(function () {
        $('.navLayer').animate({ right: "-100%", width: 0 }, 500);
        $('.subNav1').siblings(".navContent").slideUp(500);
        $('.subNav1').removeClass("currentDt");
    })
    //--
    $(".subNav1").click(function () {
        $(this).toggleClass("currentDt").siblings(".subNav1").removeClass("currentDt")
        $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(500)
    })
    //--
    $('.sideBar').find('li').hover(
	   function () {
	       $(this).addClass('liNow');
	   },
	   function () {
	       $(this).removeClass('liNow');
	   }
	)
    //--
    $('.listHover').find('li').hover(
	   function () {
	       $(this).addClass('on');
	   },
	   function () {
	       $(this).removeClass('on');
	   }
	)
    //--
    if ($('.topA').length > 0) {
        $(window).scroll(function () {
            if ($(window).scrollTop() > 200) {
                $('.topA').fadeIn(200);
            } else {
                $('.topA').fadeOut(200);
            }
        })
    }
    //--
    $('.topA').click(function () {
        $('body,html').animate({ scrollTop: 0 }, 500);


    })
    //--
    $('.job').find('li').each(function (i) {
        $(this).find('a').click(function () {
            if ($(this).hasClass('liNow')) {
                $('.job').find('li').find('a').removeClass('liNow');
                $('.job').find('li').removeClass('liNow');
                $('.job').find('.hideBox').slideUp(500);
            } else {
                $('.job').find('li').find('a').removeClass('liNow');
                $('.job').find('li').removeClass('liNow');
                $('.job').find('.hideBox').slideUp(500);
                $(this).addClass('liNow');
                $('.job').find('li').eq(i).addClass('liNow');
                $('.job').find('.hideBox').eq(i).slideToggle(500);
            }
        })
    })
    //--
    $('.sideTitleTel .tan').click(function () {
        $(".sideTitleNav").toggle();

    })
//  $('.sideTitleTel').find('.tan').toggle(
//	   function () {
//	       $('.sideTitleNav').show();
//	       $('.sideTitleTel').find('.con').addClass('on');
//	   },
//	   function () {
//	       $('.sideTitleNav').hide();
//	       $('.sideTitleTel').find('.con').removeClass('on');
//	   }
//	)
    //--
    $('.sideTitleNav').find('.li01').find('em').find('a').toggle(
	   function () {
	       $('.sideTitleNav').find('.li01').find('em').find('a').addClass('on1');
	       $('.sideTitleNav').find('dl').show();
	   },
	   function () {
	       $('.sideTitleNav').find('.li01').find('em').find('a').removeClass('on1');
	       $('.sideTitleNav').find('dl').hide();
	   }
	)
    $('.indexPart3').find('.rightDiv').find('li:first').addClass('li01');
    $('.indexPart3').find('.rightDiv').find('li:last-child').addClass('li02');
    //--
    if ($(window).width() >= 1004) {
        $(".indexPart3").find('.leftDiv').find('.detail').hover(
		   function () {
		       $(this).find('.hideBox').height($(this).find('.imgDiv').height());
		       $(this).find('.hideBox').fadeIn(200);
		   },
		   function () {
		       $(this).find('.hideBox').fadeOut(200);
		   }
		)
    }
    //--
    if ($(window).width() >= 1004) {
        $(".indexPart3").find('.rightDiv').find('li').hover(
		   function () {
		       $(this).find('.hideBox').height($(this).find('.imgDiv').height());
		       $(this).find('.hideBox').fadeIn(200);
		   },
		   function () {
		       $(this).find('.hideBox').fadeOut(200);
		   }
		)
    }
    //--
    $('.vision').find('.list').find('li').each(function (i) {
        $(this).click(function () {
            prompt_fun('.visionLayer');
        })
    })
    //--
    if ($(window).width() >= 1004) {
        $(".news").find('.list').find('li').hover(
		   function () {
		       $(this).find('.hideBox').height($(this).find('.imgDiv').height());
		       $(this).find('.hideBox').fadeIn(200);
		   },
		   function () {
		       $(this).find('.hideBox').fadeOut(200);
		   }
		)
    }
    //--
    $(".case").find('.list').find('li').hover(
	   function () {
	       $(this).find('.hideBox').height($(this).find('.box').height());
	       $(this).find('.hideBox').fadeIn(200);
	   },
	   function () {
	       $(this).find('.hideBox').fadeOut(200);
	   }
	)
    //下拉通用
    // 产品详情下拉功能
    $('.select').each(function (i) {
        function showFn(selectObj) { //展开效果
            // 把其他的下拉收起
            $('.select').children("dd").slideUp(200);
            selectObj.children("dd").slideDown(200);
            $('.select').removeClass('on');
            selectObj.addClass('on');
        }
        function hideFn(selectObj) { //关闭效果
            selectObj.children("dd").slideUp(200);
            selectObj.removeClass('on');
        }
        function hideAll(selectObj) {
            $('.select dd').slideUp(200);
            $('.select').removeClass('on');
        };


        $(this).children('dt').click(function () {
            var index = $(this).parent().index();
            // var z = selectObj.css("z-index");
            var selectObj = $(this).parent();
            $(this).next().is(":hidden") ? showFn(selectObj) : hideFn(selectObj);
        });
        $(this).children('dd').find("li").click(function () {
            var index = $(this).closest('.select').index();
            var dataId = $(this).attr('data-id');
            var selectObj = $(this).closest('.select');
            $(this).closest('.select').children("dt").find('a').html($(this).html());
            $(this).closest('.select').children("dt").find('a').attr('data-id', dataId);
            hideFn(selectObj);
            search();
        });
        $("body").click(function (i) {
            !$(i.target).parents(".select").first().is($(".select")) ? hideAll() : "";

            
        });


    });
    //--
    var bolExec = false;
    if ($(".LineNum").length > 0) {
        $(window).scroll(function () {

            var winheight = $(window).height() / 1.1;
            var Current = $(".LineNum").offset().top;

            if ($(document).scrollTop() > Current / 1.3 && bolExec == false) {

                var line = $(".LineNum"), len = line.length;
                line.each(function (index, element) {
                    var t = $.trim($(this).text()).replace(" ", "").length;
                    var text = "";
                    for (var j = 0; j < t; j++)
                        text += 0;
                    $(this).text(text);
                });

                function Animate(i) {
                    if (i < len) {
                        var _this = line.eq(i), a = 0, v = _this.attr("rel") - 0, _time = 100, vLen = (v + "").length;
                        var t = setInterval(function () {
                            a += 1;
                            var pi = parseInt(v / 100 * a);
                            var text = "";
                            for (var j = 0; j < vLen - (pi + "").length; j++)
                                text += 0;
                            _this.text(text + pi);
                            if (a == _time / 2)
                                Animate(i + 1);
                            if (a >= _time)
                                clearInterval(t);
                        }, 1);
                    }
                }
                Animate(0);

                bolExec = true;
            }

        })
    }

    if ($(window).width() >= 1004) {
        $(".video").find('.list').find('li').hover(
		   function () {
		       $(this).find('.hideBox').height($(this).find('.imgDiv').height());
		       $(this).find('.hideBox').fadeIn(200);
		   },
		   function () {
		       $(this).find('.hideBox').fadeOut(200);
		   }
		)
    }
    //--
    $('.video').find('.list').find('li').each(function (i) {
        $(this).click(function () {
            prompt_fun('.videoLayer');
        })
    })
})

// window.onresize=function(){
// 	var bigheight=$('.indexPart3').find('.leftDiv').find('img').height();
// 	$('.indexPart3').find('.rightDiv').height(bigheight+'px');
// 	}


// window.onload=function(){
// 	var bigheight=$('.indexPart3').find('.leftDiv').find('img').height();
// 	$('.indexPart3').find('.rightDiv').height(bigheight+'px');
// 	}


jQuery(document).ready(function ($) {
    // browser window scroll (in pixels) after which the "back to top" link is shown
    var offset = 300,
		//browser window scroll (in pixels) after which the "back to top" link opacity is reduced
		offset_opacity = 1200,
		//duration of the top scrolling animation (in ms)
		scroll_top_duration = 700,
		//grab the "back to top" link
		$back_to_top = $('.cd-top');

    //hide or show the "back to top" link
    $(window).scroll(function () {
        ($(this).scrollTop() > offset) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        if ($(this).scrollTop() > offset_opacity) {
            $back_to_top.addClass('cd-fade-out');
        }
    });

    //smooth scroll to top
    $back_to_top.on('click', function (event) {
        event.preventDefault();
        $('body,html').animate({
            scrollTop: 0,
        }, scroll_top_duration
		);
    });

});



function search() {
    var keys = document.getElementById("txtk").value;
    location.href = "/NewsCenter/search.aspx?a=n&keys=" + keys;
}
function entersearch() {
    //alert(dd);
    var keys = document.getElementById("txtk").value;
    var event = window.event || arguments.callee.caller.arguments[0];
    if (event.keyCode == 13) {
        //search();
        window.location.href = "/NewsCenter/search.aspx?a=n&keys=" + keys;
        return false;
    }
}

