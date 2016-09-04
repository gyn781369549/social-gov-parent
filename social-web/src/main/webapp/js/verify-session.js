$(document).ready(function(){
	if(sessionStorage.getItem("_user_name")==null||sessionStorage.getItem("_user_name")==""){
		//alert(top.location+"ss"+location);
		top.location.href= $.ServiceHttp()+"login.html";
		if(top.location != location){  
		    //top.location.href= $.ServiceHttp()+"sys/login.html";
		}  
	}
});
