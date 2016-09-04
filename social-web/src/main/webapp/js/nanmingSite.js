$(document).ready(function(){
var page_h = $(window).height();
changeMainH (page_h);
});

$(window).bind('scroll resize', function(e){
var page_h = $(window).height();
changeMainH (page_h);
});

function changeMainH (page_h) {
	var mainLh = page_h - 81;
	var mainRh = page_h - 121;
   $(".mainR").css("height",mainRh+"px");
   $(".mainL").css("height",mainLh+"px");
   $(".mainB").css("height",mainLh+"px");
   $(".mainL_shijian").css("height",mainLh-15+"px");
   $("#zancunCon").css("max-height",mainLh-330 +"px");
   $("#mainRmapBox").css("max-height",mainLh-90 +"px");
   
	}
	
//--iframe
function reinitIframe(){  
var iframe = document.getElementById("iframepage");  
try{  
    var bHeight = iframe.contentWindow.document.body.scrollHeight;  
    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;  
    var height = Math.max(bHeight, dHeight);  
    iframe.height = height;  
}catch (ex){}  
}  
  
var timer1 = window.setInterval("reinitIframe()", 500); //定时开始  
  
function reinitIframeEND(){  
var iframe = document.getElementById("iframepage");  

try{  
    var bHeight = iframe.contentWindow.document.body.scrollHeight;  
    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;  
    var height = Math.max(bHeight, dHeight);  
    iframe.height = height;  
    
    
}catch (ex){}  
// 停止定时  
window.clearInterval(timer1);  
  
} 

function reinitIframeEND11(){  
	
	var iframe11 = document.getElementById("iframepage11"); 
	try{  
	    var height = screen.height;
	    var topheight = document.getElementById("header").offsetHeight
	  
	    iframe11.height = height - topheight;  
	}catch (ex){}  
	// 停止定时  
	window.clearInterval(timer1);  
	  
	 
}  
//-------------
$(".manageMenu a").click( function () {
	$('.manageMenu a').removeClass("dq");
	$(this).addClass("dq");
 $(".mainR").empty();
 $(".mainR").append(" <iframe src='"+$(this).attr("src")+"' id='iframepage' name='iframepage' frameBorder=0 scrolling=no width='100%' height='100%' onLoad='reinitIframeEND();'></iframe>");
	  });
	  
//$('.nav').click( function () {
//	$(".navTop").removeClass("navTopDq");
//  $(this).children(".navTop").toggleClass("navTopDq").next(".sonNav").toggle();
//});	  

$(".nav").hover(
  function () {	  
    $(".navTop").removeClass("navTopDq");
	$(this).children(".navTop").addClass("navTopDq").next(".sonNav").show();
  },
  function () {
    $(this).children(".sonNav").hide();
	$(".navTop").removeClass("navTopDq");
	$("#activeNav").addClass("navTopDq");
  }
);
//-----
$(".zancunBox .tit").click( function () { 
$(this).toggleClass("hide");
$(".zancunBox .sideLtable").toggle()
 });

$(".sideLtable tr").hover(
  function () {
    $(this).find("td").css("background","#08426f")
	$(this).find(".delBt").show();
  },
  function () {
    $(this).find("td").css("background","none")
	$(this).find(".delBt").hide();
  }
);