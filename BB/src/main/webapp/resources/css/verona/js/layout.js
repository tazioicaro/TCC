/** 
 * PrimeFaces Verona Layout
 */
PrimeFaces.widget.Verona = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.wrapper = $(document.body).children('.layout-wrapper');
        this.topbar = this.wrapper.children('.topbar');
        this.menuWrapper = this.topbar.children('.layout-menu-wrapper');
        this.menuButton = $('#menu-button');
        this.userDisplay = $('#user-display');
        this.topbarMenu = $('#topbar-menu');
        this.topbarLinks = this.topbarMenu.find('a');
        this.searchInput = this.topbarMenu.find('input');
        this.menulinks = this.menuWrapper.find('a');
        this.expandedMenuitems = this.expandedMenuitems || [];     
        this.nano = this.menuWrapper.children('.nano');
        
        this.bindEvents();  
    },
    
    bindEvents: function() {
        var $this = this;
        
        this.menuButton.on('click', function(e) {
            if($this.menuWrapper.hasClass('layout-menu-wrapper-active')) {
                $this.hideMenu();
                $this.menuButton.removeClass('menu-button-active');
            }
            else {
                $this.menuWrapper.addClass('layout-menu-wrapper-active');
                $this.menuButton.addClass('menu-button-active');
            }
            
            $this.nano.nanoScroller();
            
            $this.menuButtonClick = true;
            e.preventDefault();
        });
        
        this.menulinks.off('click').on('click', function(e) {
            var link = $(this),
            item = link.parent(),
            submenu = item.children('ul');
            $this.menuClick = true;
                                     
            if($this.isStatic()) {
                $this.deactivateItems(item.siblings(), true);
                
                if(submenu.length) {
                    if(item.hasClass('active-menuitem')) {
                        $this.deactivateItems(item);
                        $this.menuActive = false;
                    }
                    else {
                        item.addClass('active-menuitem');
                        $this.menuActive = true;
                    }
                    
                    e.preventDefault();
                }
            }
            else {
                if(item.hasClass('active-menuitem')) {
                    if(submenu.length) {
                        item.removeClass('active-menuitem');
                    }
                }
                else {
                    $this.deactivateItems(item.siblings(), true);
                    item.addClass('active-menuitem');
                }
                
                setTimeout(function() {
                    $this.nano.nanoScroller();
                }, 500);
                                        
                if(submenu.length) {
                    e.preventDefault();
                }
            }
        })
        .off('mouseenter').on('mouseenter', function(e) {
            if($this.isStatic()) {
                var item = $(this).parent();

                if($this.menuActive && item.parent().hasClass('layout-menu')) {
                    $this.deactivateItems(item.siblings(), true);
                    item.addClass('active-menuitem');
                }
            }
        });
        
        this.userDisplay.on('click', function(e) {
            $this.topbarMenuButtonClick = true;

            if($this.topbarMenu.hasClass('topbar-menu-visible')) {
                $this.hideTopBar();
            }
            else {
                $this.topbarMenu.addClass('topbar-menu-visible fadeInDown');
            }
                        
            e.preventDefault();
        });
        
        this.topbarLinks.on('click', function(e) {
            var link = $(this),
            item = link.parent(),
            submenu = link.next();
            
            $this.topbarLinkClick = true;
            item.siblings('.menuitem-active').removeClass('menuitem-active');
            item.toggleClass('menuitem-active');
            
            if(submenu.length) {
                e.preventDefault();   
            }
        });
        
        this.searchInput.on('click', function(e) {
            $this.topbarLinkClick = true;
        });
        
        $(document.body).on('click', function() {       
            if(!$this.menuButtonClick && !$this.menuClick) {
                if($this.isStatic()) {
                    $this.deactivateItems($this.menuWrapper.find('li.active-menuitem'));
                    $this.menuActive = false;
                }
                else {
                    $this.hideMenu();
                    $this.menuButton.removeClass('menu-button-active');
                }
            }
            
            if(!$this.topbarMenuButtonClick && !$this.topbarLinkClick) {
                $this.hideTopBar();
            }

            $this.menuButtonClick = false;
            $this.menuClick = false;
            $this.topbarMenuButtonClick = false;
            $this.topbarLinkClick = false;
        });
    },
    
    hideTopBar: function() {
        var $this = this;
        this.topbarMenu.addClass('fadeOutUp');
        
        setTimeout(function() {
            $this.topbarMenu.removeClass('fadeOutUp topbar-menu-visible');
        },500);
    },
    
    hideMenu: function() {
        var $this = this;
        this.menuWrapper.addClass('fadeOutUp');
        
        setTimeout(function() {
            $this.menuWrapper.removeClass('fadeOutUp layout-menu-wrapper-active');
        },500);    
    },
            
    deactivateItems: function(items) {
        for(var i = 0; i < items.length; i++) {
            var item = items.eq(i),
            submenu = item.children('ul');
            
            if(submenu.length) {
                if(item.hasClass('active-menuitem')) {
                    item.removeClass('active-menuitem');
                    
                    item.find('.active-menuitem').each(function() {
                        $(this).removeClass('active-menuitem');
                    });
                }
                else {
                    item.find('.active-menuitem').each(function() {
                        var subItem = $(this);
                        subItem.removeClass('active-menuitem');
                    });
                }
            }
            else if(item.hasClass('active-menuitem')) {
                item.removeClass('active-menuitem');
            }
        }
    },
    
    isStatic: function() {
        return window.innerWidth > 1024 && this.wrapper.hasClass('layout-menu-static');
    }
    
});

/*!
 * jQuery Cookie Plugin v1.4.1
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2006, 2014 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD (Register as an anonymous module)
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// Node/CommonJS
		module.exports = factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			// If we can't parse the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write

		if (arguments.length > 1 && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setMilliseconds(t.getMilliseconds() + days * 864e+5);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {},
			// To prevent the for loop in the first place assign an empty array
			// in case there are no cookies at all. Also prevents odd result when
			// calling $.cookie().
			cookies = document.cookie ? document.cookie.split('; ') : [],
			i = 0,
			l = cookies.length;

		for (; i < l; i++) {
			var parts = cookies[i].split('='),
				name = decode(parts.shift()),
				cookie = parts.join('=');

			if (key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		// Must not alter options, thus extending a fresh object...
		$.cookie(key, '', $.extend({}, options, { expires: -1 }));
		return !$.cookie(key);
	};

}));

/* Issue #924 is fixed for 5.3+ and 6.0. (compatibility with 5.3) */
if(window['PrimeFaces'] && window['PrimeFaces'].widget.Dialog) {
    PrimeFaces.widget.Dialog = PrimeFaces.widget.Dialog.extend({
        
        enableModality: function() {
            this._super();
            $(document.body).children(this.jqId + '_modal').addClass('ui-dialog-mask');
        },
        
        syncWindowResize: function() {}
    });
}
    

