//star
$(document).ready(function(){
    var stepW = 30;
    var stars = $("#star > li");
    $("#showb").css("width",0);
	var stars2 = $("#star2 > li");
    $("#showb2").css("width",0);
	var stars3 = $("#star3 > li");
    $("#showb3").css("width",0);
	
    stars.each(function(i){
        $(stars[i]).click(function(e){
            var n = i+1;
		   $(this).parent().next(".current-rating").css({"width":stepW*n});
		   $(this).parent().val(n);
            $(this).find('a').blur();
            return stopDefault(e);
        });
    });
	
	    stars2.each(function(i){
        $(stars2[i]).click(function(e){
            var n = i+1;
		   $(this).parent().next(".current-rating").css({"width":stepW*n});
		   $(this).parent().val(n);
            $(this).find('a').blur();
            return stopDefault(e);
        });
    });
	
		 stars3.each(function(i){
        $(stars3[i]).click(function(e){
            var n = i+1;
		   $(this).parent().next(".current-rating").css({"width":stepW*n});
		   $(this).parent().val(n);
            $(this).find('a').blur();
            return stopDefault(e);
        });
    });
	
	
});


function stopDefault(e){
    if(e && e.preventDefault)
           e.preventDefault();
    else
           window.event.returnValue = false;
    return false;
};
