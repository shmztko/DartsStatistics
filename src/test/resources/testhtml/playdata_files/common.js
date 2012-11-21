// アドレスバー隠し
$(function(){
	setTimeout(function(){
		if(document.body.scrollTop == 0){
			if( (navigator.userAgent.match(/iPhone/i)) || 
			(navigator.userAgent.match(/iPod/i)) || 
			(navigator.userAgent.match(/iPad/i)) ) {
				setTimeout(scrollTo, 100, 0, 1);
			}
			else if (navigator.userAgent.match(/Android/i)) {
				window.scrollTo(0,1);
			}
		}
	},1000);
});

// プルダウンメニュー開閉
$(function(){
	$(".menu").click(function () {
		$("div#mypMenu div.panel").slideToggle();			
	});
});

// スムーズスクロール(Androidのみバグのため除外) 
$(function(){
	$(".pagetop a,.transitLink a").click(function(){
		if (navigator.userAgent.match(/Android/i)) {
			window.scrollTo(0,1);
		}
		else {
    		$('html,body').animate({ scrollTop: $($(this).attr("href")).offset().top }, 'slow','swing');
		}
    	return false;
	});
});

/* yuga.js 0.7.1 */
(function($) {

	$(function() {
		$.yuga.tab();
	});
	//---------------------------------------------------------------------
	$.yuga = {
		// URIを解析したオブジェクトを返すfunction
		Uri: function(path){
			var self = this;
			this.originalPath = path;
			//絶対パスを取得
			this.absolutePath = (function(){
				var e = document.createElement('span');
				e.innerHTML = '<a href="../../js/' + path + '" />';
				return e.firstChild.href;
			})();
			//絶対パスを分解
			var fields = {'schema' : 2, 'username' : 5, 'password' : 6, 'host' : 7, 'path' : 9, 'query' : 10, 'fragment' : 11};
			var r = /^((\w+):)?(\/\/)?((\w+):?(\w+)?@)?([^\/\?:]+):?(\d+)?(\/?[^\?#]+)?\??([^#]+)?#?(\w*)/.exec(this.absolutePath);
			for (var field in fields) {
				this[field] = r[fields[field]];
			}
			this.querys = {};
			if(this.query){
				$.each(self.query.split('&'), function(){
					var a = this.split('=');
					if (a.length == 2) self.querys[a[0]] = a[1];
				});
			}
		},

		//タブ機能
		tab: function(options) {
			var c = $.extend({
				tabNavSelector:'.tabNav',
				activeTabClass:'active'
			}, options);
			$(c.tabNavSelector).each(function(){
				var tabNavList = $(this).find('a[href^=#], area[href^=#]');
				var tabBodyList;
				tabNavList.each(function(){
					this.hrefdata = new $.yuga.Uri(this.getAttribute('href'));
					var selecter = '#'+this.hrefdata.fragment;
					if (tabBodyList) {
						tabBodyList = tabBodyList.add(selecter);
					} else {
						tabBodyList = $(selecter);
					}
					$(this).unbind('click');
					$(this).click(function(){
						tabNavList.removeClass(c.activeTabClass);
						$(this).addClass(c.activeTabClass);
						tabBodyList.hide();
						$(selecter).show();
						return false;
					});
				});
				tabBodyList.hide()
				tabNavList.filter(':first').trigger('click');
			});
		}
	};
})(jQuery);

// その他のデータ表示用
$(function(){
	$("div.moreArea").hide();
	$("#other").click(function(){
		$("div.moreArea").slideToggle(200);
		$("#other").hide();
    	return false;
	});
});



//accordion
$(document).ready(function(){	
	$('.accordionHead').click(function() {
		$(this).next().slideToggle();
		if ( $(this).hasClass('opened') ) {
			$(this).removeClass("opened");
		}
		else {
			$(this).addClass("opened");
		}
	}).next().hide();
});