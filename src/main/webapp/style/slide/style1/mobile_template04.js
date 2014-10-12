/********************
@author:meibin
@date:2014-04-14
@功能描述:手机页面js
********************/

//手机触屏事件封装；
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) {
			d[e(c)] = k[c] || e(c)
		}
		k = [
			function(e) {
				return d[e]
			}
		];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) {
		if (k[c]) {
			p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
		}
	}
	return p
}('7 1w=j(a){a=a||{};7 5={L:a.L||"#1v",b:a.b||l,C:a.C||l,J:a.J||l,H:a.H||l,I:a.I||l,x:a.x||l,w:a.w||l};7 c=1i.1p(5.L.1f("#",""));6(!c)U k;7 4={D:2,E:2,i:0,m:0,S:0,T:0,y:0};7 18=(/1x-1s/1r).1q(1t.1u);7 o=\'1m\'1h 1g&&!18;7 16=o?\'1n\':\'1l\';7 O=o?\'1k\':\'\';7 P=o?\'1j\':\'1o\';7 s,A,n,F=k,u=c.17.1C,1e=c.17.1G;7 11=/\\-?[0-9]+\\.?[0-9]*/g;5.b==l?5.b=\'X\':5.b;7 d={G:j(y,14,8){6(!!8){8=8.z}q{8=c.z}8.1I=8.1J=8.1H=8.1E=8.1A=14+\'1z\';5.b==\'X\'?8[\'12\']=\'\'+y+\'15\':8[\'13\']=\'\'+y+\'15\'},1a:j(){6(v 5.x==\'j\'){5.x()}},1d:j(){6(v 5.w==\'j\'){5.w()}},Z:j(e){F=1c;s=B;A=B;4.i=0;7 p=o?e.t[0]:e;4.D=p.M;4.E=p.V;7 r=1B((5.b==\'X\'?c.z.12:c.z.13).1F(11));4.S=(r?r:0);4.T=(r?r:0);d.1a();c.W(O,d.Q,k);c.W(P,d.R,k)},Q:j(e){6(F){6(o){6(e.t.1D>1||e.19&&e.19!==1)U};7 p=o?e.1y[0]:e;4.i=p.M-4.D;4.m=p.V-4.E;6(v A==\'B\'&&f.h(4.i)>f.h(4.m)&&5.b!=\'Y\'){A=1c;e.K()}q 6(v s==\'B\'&&(f.h(4.m)>f.h(4.i))&&5.b!=\'X\'){s=k;e.K()}n=5.b==\'X\'?4.S+e.t[0].M-4.D:4.T+e.t[0].V-4.E;d.G((n>0&&n>u/3?u/3:n),N)}},R:j(e){6(4.i==0)U;e.K();6(!s){d.G(0,N);6(f.h(4.i)>f.h(4.m)&&f.h(4.i)>u/10&&5.b!=\'Y\'){6(4.i>0){6(5.C){5.C()}}q{6(5.J){5.J()}}}q 6(f.h(4.m)>f.h(4.i)&&f.h(4.m)>1e/10&&5.b!=\'X\'){6(4.m>0){6(5.I){5.I()}}q{6(5.H){5.H()}}}d.1d()}F=k;c.1b(O,d.Q,k);c.1b(P,d.R,k)}};d.G(0,N);c.W(16,d.Z,k)};', 62, 108, '||||defaults|options|if|var|ele|||direCtion|slideObj|that||Math||abs|distX|function|false|null|distY||hasTouch|point|else|transform|scrollY|targetTouches|slideW|typeof|endFun|startFun|dist|style|scrollX|undefined|swipeLeft|startX|startY|sTop|transForm|swipeUp|swipeDown|swipeRight|preventDefault|slideCell|pageX|200|touchMove|touchEnd|tMoveFun|tEndFun|nx|ny|return|pageY|addEventListener|||tStartFun||reg2|marginLeft|marginTop|speed|px|touchStart|parentNode|isTouchPad|scale|doStartFun|removeEventListener|true|doEndFun|slideH|replace|window|in|document|touchend|touchmove|mousedown|ontouchstart|touchstart|mouseup|getElementById|test|gi|tablet|navigator|appVersion|touchId|TouchSlide|hp|touches|ms|transitionDuration|Number|clientWidth|length|OTransitionDuration|match|clientHeight|msTransitionDuration|webkitTransitionDuration|MozTransitionDuration'.split('|'), 0, {}))

eval(function(p, a, c, k, e, r) {
	e = function(c) {
		return c.toString(36)
	};
	if ('0'.replace(0, e) == 0) {
		while (c--) r[e(c)] = k[c];
		k = [
			function(e) {
				return r[e] || e
			}
		];
		e = function() {
			return '[1-36-9i-v]'
		};
		c = 1
	};
	while (c--)
		if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
}('2 9=(3(){7{myAddEvent:3(c,a,b){1(c.n){c.n("on"+a,3(){b.o(c)})}6{c.addEventListener(a,b,i)}},j:3(b,a){1(b.p){7 b.p[a]}6{7 getComputedStyle(b,i)[a]}},getClass:3(e,f){2 a=[];2 d=e.getElementsByTagName("*");q(2 c=0,b=d.length;c<b;c++){1(d[c].className==f){a.push(d[c])}}7 a},startMove:3(c,a,b){2 d=null;r(c.k);c.k=setInterval(3(){2 g=s;q(2 e in a){2 h=0;1(e=="8"){h=l.round(parseFloat(9.j(c,e))*t)}6{h=parseInt(9.j(c,e))}2 f=(a[e]-h)/5;f=f>0?l.ceil(f):l.floor(f);1(h!=a[e]){g=i}1(e=="8"){c.m.filter="alpha(8:"+(h+f)+")";c.m.8=(h+f)/t}6{c.m[e]=h+f+"px"}}1(g){r(c.k);1(b){b.o(c)}}},30)},getAjax:3(a,c,b){1(window.u){2 d=v u()}6{2 d=v ActiveXObject("Microsoft.XMLHTTP")}d.open("GET",a,s);d.send();d.onreadystatechange=3(){1(d.readyState==4){1(d.status==200){c(d.responseText)}6{1(b){b()}}}}}}})();', [], 32, '|if|var|function|||else|return|opacity|moduleFun|||||||||false|getStyle|timer|Math|style|attachEvent|call|currentStyle|for|clearInterval|true|100|XMLHttpRequest|new'.split('|'), 0, {}));
/*-------------以上为框架方法--------*/

//判断是否pc，如果是给默认480px高度，否则读取设备屏幕高度*/
var isPc = /(WindowsNT)|(Windows NT)|(Macintosh)/i.test(navigator.userAgent);
var nHeight = !isPc?$(window).height():640,
    nWidth = $(window).width();
$('body').css('paddingTop', !isPc ? 0 : 20);
$('.content-box').height(nHeight);
$('.content-box').width(!isPc ? "100%" : 360);
$('#wrapid .tm-item').css('position',!isPc ? 'fixed' : 'absolute');

/*共有模块*/
var commFun = (function() {
	return {
		loadTips: moduleFun.getClass(document.getElementsByTagName('body')[0], 'load-msg')[0], // 加载提示的gif图提示标签;

		/*初始进入时计算每个模块的高度*/
		heightCalc: function() {
			var len = parseInt(document.getElementById('wrapid').getAttribute('data-len')),
				i = 1;
			for (i = 1; i <= len; i++) {
				(function(i) {
					var itemID = document.getElementById('item' + i); //每个模块的id;
					//itemID.style.cssText += 'width:' + ph.bodyW + 'px;height:' + (ph.bodyH >= 480 ? ph.bodyH : 480) + 'px'; //设置每个模块的样式；
					itemID.style.cssText += 'width:' + ph.bodyW + 'px;height:' + ph.bodyH + 'px'; //设置每个模块的样式；
				})(i);
			};
		}

	}; //return End;

})();

var animaTe = (function() {
	return {
		clickF: function() {

			$('.down-btn').on('click',function() {
				animaTe.downSlid();
			});
			$('.up-btn').on('click', function() {

				animaTe.upSlid();
			});
		},
		//上一张的动画方法
		upSlid: function() {
			if ($('#wrapid .item_show').prev('.tm-item').length) {

				$('#wrapid .item_show').prev('.tm-item').addClass('current');
			} else {
				$('#wrapid .tm-item').last().addClass('current');
			};
			$('#wrapid .current').css('top', '-' + $('#wrapid .current').height() + 'px').stop(true, true).animate({
				'top': 0
			}, "slow", function() {
				$(this).removeClass('current').addClass('item_show').siblings().removeClass('item_show');
				ph.lazy_img();//图片延迟加载
			});

		},
		//下一张的滑动方法;
		downSlid: function() {
			if ($('#wrapid .item_show').next('.tm-item').length) {

				$('#wrapid .item_show').next('.tm-item').addClass('current');
			} else {
				$('#wrapid .tm-item').first().addClass('current');
			};
			$('#wrapid .current').css('top', $('#wrapid .current').height()).stop(true, true).animate({
				'top': 0
			}, "slow", function() {
				$(this).removeClass('current').addClass('item_show').siblings().removeClass('item_show');
				ph.lazy_img();//图片延迟加载
			});
		}
	}; //return End;
})();
(function(window) {
	var itemH = $('#wrapid .tm-item').height(),
		pos = {},
		mousedown = null,
		direct = null,
		len = $('#wrapid .tm-item').size();

	var slide = {

		oBind: function(e) {
			$('#wrapid .tm-item').bind("mousedown touchstart", slide.touchStart);
			$('#wrapid .tm-item').bind("mousemove touchmove", slide.touchMove);
			$('#wrapid .tm-item').bind("mouseup touchend mouseout", slide.touchEnd);
		},

		swipeDirection:function(x1, x2, y1, y2) {
			return Math.abs(x1 - x2) >= Math.abs(y1 - y2) ? (x1 - x2 > 100 ? "left" : (x1 - x2 < -100 ? "right" : "middle")) : (y1 - y2 > 100 ? "up" : (y1 - y2 < -100 ? "down" : "middle"));
		},
		touchStart:function(e) {
			if (e.type == "touchstart") {
				pos.x1 = window.event.touches[0].pageX;
				pos.y1 = window.event.touches[0].pageY;
			} else {
				pos.x1 = e.pageX;
				pos.y1 = e.pageY;
			}
			mousedown = true;
		},

		touchMove:function(e) {
			if (!mousedown) {
				return false;
			}
			e.preventDefault();
			e.stopPropagation();
			if (e.type == "touchmove") {
				pos.x2 = window.event.touches[0].pageX;
				pos.y2 = window.event.touches[0].pageY;
			} else {
				pos.x2 = e.pageX;
				pos.y2 = e.pageY;
			}
			direct = slide.swipeDirection(pos.x1, pos.x2, pos.y1, pos.y2);
			switch (direct) {
				case "up":

					if ($('#wrapid .item_show').next('.tm-item').length) {

						$('#wrapid .item_show').next('.tm-item').addClass('current');
					} else {
						$('#wrapid .tm-item').first().addClass('current');
					};
					$('#wrapid .current').css("top", itemH).css("top", itemH + (pos.y2 - pos.y1));

					break;
				case "down":
					if ($('#wrapid .item_show').prev('.tm-item').length) {

						$('#wrapid .item_show').prev('.tm-item').addClass('current');
					} else {
						$('#wrapid .tm-item').last().addClass('current');
					};
					$('#wrapid .current').css("top", -itemH).css("top", -itemH - (pos.y1 - pos.y2));

					break;
				default:
					break
			};
			
		},
		touchEnd:function (e) {
			if (!mousedown) {
				return false;
			}
			if (e.type == "touchend") {
				pos.x2 = window.event.changedTouches[0].pageX;
				pos.y2 = window.event.changedTouches[0].pageY;
			} else {
				pos.x2 = e.pageX;
				pos.y2 = e.pageY;
			}
			direct = slide.swipeDirection(pos.x1, pos.x2, pos.y1, pos.y2);
			switch (direct) {
				case "up":

					if ((pos.y2 - pos.y1) >= 50) {
						$('#wrapid .current').stop(true, true).animate({
							'top': -itemH
						}, 100);
					} else {
						
						$('#wrapid .current').stop(true, true).animate({
							'top': 0
						}, "fast", function() {
							$(this).removeClass('current').addClass('item_show').siblings().removeClass('item_show');
							ph.lazy_img();//图片延迟加载
						});
					};

					mousedown = null;
					break;
				case "down":
					if ((pos.y1 - pos.y2) >= 50) {
						$('#wrapid .current').stop(true, true).animate({
							'top': itemH
						}, 100);

					} else {
						
						$('#wrapid .current').stop(true, true).animate({
							'top': 0
						}, "fast", function() {
							$(this).removeClass('current').addClass('item_show').siblings().removeClass('item_show');
							ph.lazy_img();//图片延迟加载
						});

					};
					mousedown = null;
					break;
				default:
					mousedown = null;
					break;
			};
			
		}
	};

	window.slide = slide;
})(window);

/*我要参加*/
(function(window){
	var leave={
		/*设置留言区的高度*/
		oHeight:function(){
			var curH = $('.item-three').outerHeight(true);
			// var formH = $('.item-three .m-leave-fill').outerHeight(true);
			$('.leave-con').css({'height':(curH*0.85),'top':(curH*0.15)});
			var oResult = (curH*0.85)-192;
			// console.log(formH+"=="+(curH*0.85))
			$('#leaveContent').height(oResult);
		},
		/*点击我要参加的按钮*/
		weekBox:function(){
			$('#myLeave').on('click',function(){
				
				$('.leave-con').addClass('leave_show').slideDown(function(){
					$(this).css('overflow','visible');
				});
			});
			$('.leave-con').delegate('.close_btn','click',function(){
				$('.leave-con').removeClass('leave_show').fadeOut('fast');

			});
		},
		toRgb:function(rgb){
			var oResult = rgb.replace(/[^\d,]/g, '').split(',');
			return oResult;
		},
		setColor:function(){
			var rgb = $('.leave_box').attr('data-color'),
				arr = this.toRgb(rgb);
         	$('.go_in,.ph-btn,.m-favour a').css('background-color','rgba('+arr[0]+','+arr[1]+','+arr[2]+',.7)');
         	$('#support').css('background-color','rgba('+arr[0]+','+arr[1]+','+arr[2]+',.4)');
			$('.leave-con,.close_btn,.m-leave-item .lea-time,.loading span').css('background-color','rgb('+arr[0]+','+arr[1]+','+arr[2]+')');
			$('.m-leave-item .name,.m-fill-btn').css('color','rgb('+arr[0]+','+arr[1]+','+arr[2]+')');
			$('.m-leave-item:even').find('.lea-time .after').css('border-color','transparent rgb('+arr[0]+','+arr[1]+','+arr[2]+') transparent transparent');
			$('.m-leave-item:odd').find('.lea-time .after').css('border-color','transparent transparent transparent rgb('+arr[0]+','+arr[1]+','+arr[2]+')');
		}
	};
	
	leave.weekBox();
	leave.setColor();
	window.leave = leave;
})(window);
//相册的左右点击事件;
var ph = (function() {

	return {
		oShop: true,
		bodyH: !isPc ? document.documentElement.clientHeight : $('.content-box').height(), //获取当前的设备的高度;
		bodyW: !isPc ? document.documentElement.clientWidth : $('.content-box').width() , //获取当前的设备的宽度;
		/*每个li的宽度赋值*/
		liWidth: function(par, li) {
			var i = 0,
				max = li.length;
			for (; i < max; i++) {
				(function(i) {
					li[i].style.cssText += 'width:' + ph.bodyW + 'px;height:' + par + 'px;overflow:hidden;';
				})(i);
			};
		},
		/*图片延迟加载*/

		lazy_img:function(){
			
			if(!$('#item2').hasClass('item_show')){
				console.log("返回了！");
				return false;
			};
			console.log("执行哦");
			var oUl = document.getElementById('photoList'),
			data = oUl.getAttribute('data-img').split(',');
			$.each($('#photoList li'),function(i){
				var that = $(this);
				var imgNew = new Image();
				imgNew.onload=function(){
					$('.loading').show();
					that.css({'background-image':'url('+this.src+')','background-position':''+((ph.bodyW/this.width)*this.height) >=ph.bodyH ? 'top center': 'center'+''});
					$('.loading').hide();
				};
				imgNew.src = data[i];
			});
		},

		/*计算图片是否大于最大高度*/
		imgSet: function(obj, cur) {

			var objHe = parseInt(obj.style['height']);

			var i = 0;
			for (; i < obj.children.length; i++) {
				(function(i) {
					var iImg = parseInt(obj.children[i].children[0].getAttribute('data-height'));
					if (iImg >= objHe) {

						obj.children[i].children[0].style['height'] = obj.children[i].style['height'];
					};
					obj.children[cur].children[0].style['height'] = '';
				})(i);

			}
		},

		/*初始进入时计算相册的宽度*/
		initialCalc: function() {

			var phModule = document.getElementById('item2');
			var phWrap = moduleFun.getClass(phModule, 'two-inner')[0],
				oUL = phWrap.getElementsByTagName('ul')[0], //li标签;
				aLi = phWrap.getElementsByTagName('li'), //li标签;
				max = aLi.length, //li的长度;
				aBtn = moduleFun.getClass(phWrap, 'ph-btn'), //左右点击的按钮;
				i = 0;

			if (aLi.length) {

				phWrap.style['overflow'] = 'hidden';

				oUL.style['width'] = '' + ph.bodyW * (max + 1) + 'px'; //ul总宽度计算;
				oUL.style['height'] = '' + parseInt(phModule.style['height']) + 'px'; //ul总宽度计算;
				//ph.transformSlide('.two-inner ul li',0);/*滑动计算*/
				//ph.imgSet(oUL, 0); /*计算图片是否大于最大高度*/
				ph.liWidth(parseInt(phModule.style['height']), aLi); //每个li的宽度赋值

				//上一张的滑动函数
				function prevSlide() {
					if (ph.oShop) {
						ph.oShop = false;
						i--;
						if (i < 0) {
							i = max - 1;
							
							$('.two-inner ul').css({'WebkitTransition':'0ms','transition':'0ms',
								'marginLeft': '-' + (ph.bodyW * i) + 'px'
							});
							ph.oShop = true;
							return false;
						}
						$('.two-inner ul').stop(true, true).animate({
							'marginLeft': '-' + (ph.bodyW * i) + 'px',
						}, 200, function() {
							//$(this).css('marginLeft',0);
							//$(this).append($(this).find('li').eq(0));
							ph.oShop = true;
						});

						//ph.imgSet(oUL, i); /*计算图片是否大于最大高度*/

					};
				}

				//下一张的滑动函数
				function nextSlide() {
					if (ph.oShop) {
						ph.oShop = false;
						i++;
						if (i == max) {
							i = 0;
							console.log(123)
							$('.two-inner ul').css({'WebkitTransition':'0ms','transition':'0ms',
								'marginLeft': 0
							});
							ph.oShop = true;
							return false;
						}
						$('.two-inner ul').stop(true, true).animate({
							'marginLeft': '-' + (ph.bodyW * i) + 'px',
						}, 200, function() {

							ph.oShop = true;
						});
						//ph.imgSet(oUL, i); /*计算图片是否大于最大高度*/
					};
				}

				//上一张;
				aBtn[0].addEventListener('click', function(event) {
					event.preventDefault();
					prevSlide(); //上一张的滑动函数

				}, false);

				//下一张;
				aBtn[1].addEventListener('click', function(event) {
					event.preventDefault();
					nextSlide(); //下一张的滑动函数
				}, false);

				//触摸滑动
				TouchSlide({
					slideCell: 'photoList',

					swipeRight: function() {
						nextSlide(); //下一张的滑动函数
					},
					swipeLeft: function() {
						prevSlide(); //上一张的滑动函数
					}
				});
			}
		},

		/*克隆一个元素添加到最后*/
		cloneHtml: function(data) {
			var lastLi = document.createElement('li');
			lastLi.className = "last-li";
			lastLi.innerHTML = data;
			return lastLi;

		}

	}; //return End;

})();

window.onload = function() {
	$('.loading').hide();
	/*共有模块*/
	commFun.heightCalc(); //调用--初始进入时计算每个模块的高度的方法
	slide.oBind();
	animaTe.clickF(); //第一、二屏的文字动画

	ph.initialCalc(); //初始进入时计算相册的宽度
	leave.oHeight();
};