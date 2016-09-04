$(function () {
	var key = sessionStorage.getItem("key");
    $.extend({
    	ServiceHttp: function () {
    		return "http://localhost:8080/social-web/";
    		//return "http://192.168.1.15:8080/social-web/";
    		//return "http://192.168.101.107:8090/social-web/";
    		//return "http://115.159.155.232:8086/social-web/";
//    		return "http://115.159.155.232:8086/social-web/";
    		
		},
		Timestamp:function(){
	    	return new Date().getTime();
	    },
	    Token:function(timestamp){
	    	return $.md5(timestamp+key);		    	
	    }
	});
});

var userId = sessionStorage.getItem("_user_id");
var deptId = sessionStorage.getItem("_dept_id");

/**
 * 获取     事件来源(pc)     的下拉选择框内容
 * @returns {String}
 */
function getEventSourceOption(){
	var _html ="<option value='4'>12345</option>"
		      +"<option value='5'>筑城微治</option>"
		      +"<option value='6'>网上信箱</option>"
		      +"<option value='20'>其他</option>";
	return _html;
}
/**
 * 获取   所有的事件来源(pc)     的下拉选择框内容
 * @returns {String}
 */
function getAllEventSourceOption(){
	var _html ="<option value=''>请选择</option>"
		      +"<option value='1'>社区管家</option>"//1=iOS社区管家 and 2=Android社区管家
		      +"<option value='3'>社工平台</option>"
		      +"<option value='4'>12345</option>"
		      +"<option value='5'>筑城微治</option>"
		      +"<option value='6'>网上信箱</option>"
		      +"<option value='20'>其他</option>";
	return _html;
}
/**
 * 根据  事件来源(pc)   类型获取 事件来源(pc)
 * @param type
 * @returns {String}
 */
function getEventSourceValue(type) {
	var v = parseInt(type);
	var name = "";
	switch (v) {
	case 1:
		name = "社区管家";//iOS社区管家
		break;
	case 2:
		name = "社区管家";//Android社区管家
		break;
	case 3:
		name = "社工平台";
		break;
	case 4:
		name = "12345";
		break;
	case 5:
		name = "筑城微治";
		break;
	case 6:
		name = "网上信箱";
		break;
	case 20:
		name = "其他";
		break;
	}
	return name;
}

/**
 * 获取    事件等级     的下拉选择框内容
 * @returns {String}
 */
function getEventLevelOption(){
	var _html ="<option value=''>请选择</option>"
		      +"<option value='1'>日常</option>"
		      +"<option value='2'>一般</option>"
		      +"<option value='3'>严重</option>"
		      +"<option value='4'>重大</option>";
	return _html;
}
/**
 * 根据  事件等级   类型获取 事件等级
 * @param type
 * @returns {String}
 */
function getEventLevelValue(type) {
	var v = parseInt(type);
	var name = "";
	switch (v) {
	case 1:
		name = "日常";
		break;
	case 2:
		name = "一般";
		break;
	case 3:
		name = "严重";
		break;
	case 4:
		name = "重大";
		break;
	}
	return name;
}



/**
 * 获取  事件状态     的下拉选择框内容
 * @returns {String}
 */
function getEventPhaseOption(){
	var _html ="<option value=''>请选择</option>"
		      +"<option value='1'>待接录</option>"   //10(未接录) 
		      +"<option value='2'>待核查</option>"  //11(已接录)20(已派发核查事件真伪)
		      +"<option value='3'>待受理</option>"  //21(真伪核查完成)  
		      +"<option value='4'>待派发</option>"   //30(中心受理) 40(已派发事件处理)
		      +"<option value='5'>待反馈</option>"   //51(处理完成) 60(已派发反馈结果核查)
		      +"<option value='6'>待办结</option>"    // 70(结果核查完成)
		      +"<option value='7'>待评价</option>"    //80(办结完成) 90(公众评价完成) 91(中心业务人员评价完成)
		      +"<option value='8'>已归档</option>";  //100(归档完成) 92(中心业务人员和公众评价完成)
	return _html;
}
/**
 * 根据  事件状态   类型获取 事件状态
 * @param type
 * @returns {String}
 */
function getEventPhaseValue(type) {
	var v = parseInt(type);
	var name = "";
	switch (v) {
	case 10:
		name = "待接录";
		break;
	case 11:
		name = "待核查";
		break;
	case 20:
		name = "待核查";
		break;
	case 21:
		name = "待受理";
		break;
	case 30:
		name = "待派发";
		break;
	case 40:
		name = "待派发";
		break;
	case 51:
		name = "待反馈";
		break;
	case 60:
		name = "待反馈";
		break;
	case 70:
		name = "待办结";
		break;
	case 80:
		name = "待评价";
		break;
	case 90:
		name = "待评价";
		break;
	case 91:
		name = "待评价";
		break;
	case 92:
		name = "已归档";
		break;
	case 100:
		name = "已归档";
		break;
	}
	return name;
}
function HashMap(){
	//定义长度
	var length = 0;
	//创建一个对象
	var obj = new Object();

	/**
	* 判断Map是否为空
	*/
	this.isEmpty = function(){
		return length == 0;
	};

	/**
	* 判断对象中是否包含给定Key
	*/
	this.containsKey=function(key){
		return (key in obj);
	};

	/**
	* 判断对象中是否包含给定的Value
	*/
	this.containsValue=function(value){
		for(var key in obj){
			if(obj[key] == value){
				return true;
			}
		}
		return false;
	};

	/**
	*向map中添加数据
	*/
	this.put=function(key,value){
		if(!this.containsKey(key)){
			length++;
		}
		obj[key] = value;
	};

	/**
	* 根据给定的Key获得Value
	*/
	this.get=function(key){
		return this.containsKey(key)?obj[key]:null;
	};

	/**
	* 根据给定的Key删除一个值
	*/
	this.remove=function(key){
		if(this.containsKey(key)&&(delete obj[key])){
			length--;
		}
	};

	/**
	* 获得Map中的所有Value
	*/
	this.values=function(){
		var _values= new Array();
		for(var key in obj){
			_values.push(obj[key]);
		}
		return _values;
	};

	/**
	* 获得Map中的所有Key
	*/
	this.keySet=function(){
		var _keys = new Array();
		for(var key in obj){
			_keys.push(key);
		}
		return _keys;
	};

	/**
	* 获得Map的长度
	*/
	this.size = function(){
		return length;
	};

	/**
	* 清空Map
	*/
	this.clear = function(){
		length = 0;
		obj = new Object();
	};
}

function popTree(){
	
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var setting = {
		view: {
			showLine: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		
		callback:{
			onClick:list2
		}
	};
	function onAsyncSuccess(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		treeNode.halfCheck = false;
		zTree.updateNode(treeNode);
	}
	
	var zNodes = [];
			
	var code;
	//$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	$.ajax({
		url : $.ServiceHttp()+'platform/social/sys/socialArea/findGridMan',
		data : {
			"token": token,
			"timestamp": timestamp
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			//alert(JSON.stringify(data));
			if(data!=null && data!="" &&  data.success == true){
				//遍历所有权限
				for ( var i = 0; i < data.retObj.length; i++) {
					//zNodes[i].id=data.retObj.list[i].id;
					//zNodes[i].pId=data.retObj.list[i].parentId;
					//zNodes[i].name=""+data.retObj.list[i].name+"";
					var item = {id:data.retObj[i].treeId,pId:data.retObj[i].treePid,name:""+data.retObj[i].name+"",realId:data.retObj[i].id};
					zNodes.push(item);
					
				}
			}
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
			var node = treeObj.getNodeByParam("id", "1002"); 
			treeObj.selectNode(node,false);
			
		}
	});
}
function getTreeUrl(treeId, treeNode){
	//alert(treeNode.level);
	if(treeNode.level==2){
		return $.ServiceHttp()+'platform/social/data/socialGridInfo/findByArea';
	}
	else if(treeNode.level==3){
		return $.ServiceHttp()+'platform/social/sys/socialArea/list';
	}
}
function list2(event, treeId, treeNode){
	//alert(treeNode.level);
	if(treeNode.level==4){
		//alert(JSON.stringify(treeNode));
		//alert(treeNode.realId);
		$("#showgridmanid").val(treeNode.realId);
		$("#showgridman").val(treeNode.name);
		$("#showgridmanid2").val(treeNode.realId);
		$("#showgridman2").val(treeNode.name);
		$("#showgridmanid3").val(treeNode.realId);
		$("#showgridman3").val(treeNode.name);
		//alert(treeNode.id);
		$("#zwhc_paifaId").val(treeNode.realId);
		$("#zwhc_paifaName").val(treeNode.name);
		$("#zwhc2_paifaId").val(treeNode.realId);
		$("#zwhc2_paifaName").val(treeNode.name);
		$("#sjpf_paifaId").val(treeNode.realId);
		$("#sjpf_paifaName").val(treeNode.name);
		$("#sjpf2_paifaId").val(treeNode.realId);
		$("#sjpf2_paifaName").val(treeNode.name);
		$("#treePop").hide();
	}
	
}

function popTreeNet(){
	
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	var setting = {
		view: {
			showLine: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		
		callback:{
			onClick:listNet2
		}
	};
	function onAsyncSuccess(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		treeNode.halfCheck = false;
		zTree.updateNode(treeNode);
	}
	
	var zNodes = [];
			
	var code;
	//$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	var key = sessionStorage.getItem("key");
	var timestamp = new Date().getTime();
	var token =$.md5(timestamp+key.toUpperCase());
	$.ajax({
		url : $.ServiceHttp()+'platform/social/sys/socialArea/findGrid',
		data : {
			"pageNo": 1,
			"pageSize": 200,
			"token": token,
			"timestamp": timestamp
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		error : function(err) {
			console.log("error:"+ JSON.stringify(err));
		},
		success : function(data) {
			console.log("data:"+ JSON.stringify(data));
			//alert(JSON.stringify(data));
			if(data!=null && data!="" &&  data.success == true){
				//遍历所有权限
				for ( var i = 0; i < data.retObj.length; i++) {
					//zNodes[i].id=data.retObj.list[i].id;
					//zNodes[i].pId=data.retObj.list[i].parentId;
					//zNodes[i].name=""+data.retObj.list[i].name+"";
					var item = {id:data.retObj[i].treeId,pId:data.retObj[i].treePid,name:""+data.retObj[i].name+"",realId:data.retObj[i].id};
					zNodes.push(item);
					
				}
			}
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
			var node = treeObj.getNodeByParam("id", "1002"); 
			treeObj.selectNode(node,false);
			
		}
	});
}

function listNet2(event, treeId, treeNode){
	//alert(treeNode.level);
	if(treeNode.level==3){
		
		$(".pull_down_cont").slideUp();
		//$(".pull_down_search").val(word);
		$("#net3Id").val(treeNode.name);
		$("#netId").val(treeNode.realId);
		
	}
	
}
 