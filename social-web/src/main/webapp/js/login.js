$(document).ready(function(){
	//绑定事件
	vali();
	var loginName = getCookieValue("userName");
	$("#loginName").val(loginName);
	var password = getCookieValue("password");
	$("#password").val(password);
	$("#images").bind("click",vali);
	$("#loginBtn").bind("click",login);
	
});

function vali(){
	$("#images").attr("src",Math.random()+".images");
}

function login(){
	$("#loginBtn").unbind("click");
	
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	var code = $("#code").val().toUpperCase();
	var cCode = getCookieValue("code");
	if(loginName==null || loginName==""){
		layer.msg("工号名不能为空！");
		$("#loginBtn").bind("click",login);
		return ;
	}	
	if(password==null || password==""){
		layer.msg("密码不能为空！");
		$("#loginBtn").bind("click",login);
		return ;
	}
	var reg = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
	if(password.match(reg)==null){
		layer.msg("密码6-16位字母数字混合！");
		$("#loginBtn").bind("click",login);
		return ;
	}
	
	var timestamp = new Date().getTime();
	$.ajax({
		url : $.ServiceHttp()+"platform/login/save",
		data : {
			"loginName" : loginName,
			"password" : password,
			"code":code,
			"time" : timestamp
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			if(data!=null && data!="" &&  data.success == true){
				if(code==null||code==""||code!=cCode){
					layer.msg("验证码输入错误！");
					$("#loginBtn").bind("click",login);
					return ;
				}
				if(sessionStorage.getItem("_user_id")!=null && sessionStorage.getItem("_user_id")!=""){
					sessionStorage.removeItem("_user_id");
				}
				if(sessionStorage.getItem("_user_name")!=null && sessionStorage.getItem("_user_name")!=""){
					sessionStorage.removeItem("_user_name");
				}
				if(sessionStorage.getItem("_dept_id")!=null && sessionStorage.getItem("_dept_id")!=""){
					sessionStorage.removeItem("_dept_id");
				}
				if(sessionStorage.getItem("funs")!=null && sessionStorage.getItem("funs")!=""){
					sessionStorage.removeItem("funs");
				}
				if(sessionStorage.getItem("key")!=null && sessionStorage.getItem("key")!=""){
					sessionStorage.removeItem("key");
				}
				if(sessionStorage.getItem("ip")!=null && sessionStorage.getItem("ip")!=""){
					sessionStorage.removeItem("ip");
				}
				if(sessionStorage.getItem("time")!=null && sessionStorage.getItem("time")!=""){
					sessionStorage.removeItem("time");
				}
				if(getCookieValue("_user_id")!=null&&getCookieValue("_user_id")!=""){
					deleteCookie("_user_id","/");
				}
				setCookie("_user_id",data.retObj.user.id,24,"/");  
				sessionStorage.setItem("_user_id",data.retObj.user.id);
				sessionStorage.setItem("_user_name",data.retObj.user.loginName);
				sessionStorage.setItem("_dept_id",data.retObj.user.deptId);
				sessionStorage.setItem("funs",JSON.stringify(data.retObj.funs));
				//alert(JSON.stringify(data.retObj.funs));
				sessionStorage.setItem("key",data.retObj.key);
				sessionStorage.setItem("ip",data.retObj.ip);
				sessionStorage.setItem("time",data.retObj.time);
				//alert($("#checkbox").checked);
				if($("#checkbox").prop("checked")){    
	                setCookie("userName",loginName,24,"/");  
	                setCookie("password",password,24,"/");  
	            }else{
	            	deleteCookie("userName","/");
	            	deleteCookie("password","/");  
	            }
				location.href ="mainframe.html";
			}else if(data!=null && data!="" &&  data.success == false){
				layer.msg(data.msg);
				$("#loginBtn").bind("click",login);
			}else {
				layer.msg('请求异常，请稍后重试。');
				$("#loginBtn").bind("click",login);
			}
		}
	});
	
	
	//新建cookie。  
	//hours为空字符串时,cookie的生存期至浏览器会话结束。hours为数字0时,建立的是一个失效的cookie,这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。  
	
}
function setCookie(name,value,hours,path){  
    var name = escape(name);  
    var value = escape(value);  
    var expires = new Date();  
    expires.setTime(expires.getTime() + hours*3600000);  
    path = path == "" ? "" : ";path=" + path;  
    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();  
    window.document.cookie = name + "=" + value + _expires + path;  
}  
//获取cookie值  
function getCookieValue(name){  
    var name = escape(name);  
    //读cookie属性，这将返回文档的所有cookie  
    var allcookies = document.cookie;         
    //查找名为name的cookie的开始位置  
    name += "=";  
    var pos = allcookies.indexOf(name);      
    //如果找到了具有该名字的cookie，那么提取并使用它的值  
    if (pos != -1){                                             //如果pos值为-1则说明搜索"version="失败  
        var start = pos + name.length;                  //cookie值开始的位置  
        var end = allcookies.indexOf(";",start);        //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置  
        if (end == -1) end = allcookies.length;        //如果end值为-1说明cookie列表里只有一个cookie  
        var value = allcookies.substring(start,end);  //提取cookie的值  
        return unescape(value);                           //对它解码        
        }     
    else return "";                                             //搜索失败，返回空字符串  
}  
//删除cookie  
function deleteCookie(name,path){  
    var name = escape(name);  
    var expires = new Date(0);  
    path = path == "" ? "" : ";path=" + path;  
    document.cookie = name + "="+ ";expires=" + expires.toUTCString() + path;  
}

function red(){
	var code = $("#code").val().toUpperCase();
	var cCode = getCookieValue("code");
	if(code!=cCode){
		$("#code").css("border-color","red");
	}
	else{
		$("#code").css("border-color","");
	}
	
}
