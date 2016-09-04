var coverLayer = {
	divObj : null,
	_coverTime : null,
	_coverRe : function(){//刷新遮盖层
		if(document.body.offsetHeight < document.documentElement.clientHeight){
			this.divObj.style.width = document.body.clientWidth + "px";
			this.divObj.style.height = document.documentElement.clientHeight + "px";
		}else{
			this.divObj.style.width = document.body.clientWidth + "px";
			this.divObj.style.height = document.body.clientHeight + "px";
		}
	},
	isIE : navigator.appVersion.indexOf("MSIE")!=-1?true:false,
	on : function(noSave){ //打开遮盖层
		if(this.divObj == null){
			this.divObj = document.createElement("div");
			this.divObj.style.zIndex = 10000;
			this.divObj.className = "coverBg"
			this.divObj.style.left = '0px';;
			this.divObj.style.top = '0px';;
			this.divObj.style.position = "fixed";
			this.divObj.style.backgroundColor = "#000000";
			if(this.isIE){
				var tempFrame = document.createElement("iframe");
				tempFrame.style.filter = "Alpha(Opacity=0)";
				tempFrame.frameBorder=0;
				tempFrame.scrolling="no";
				tempFrame.style.width = "100%";
				tempFrame.style.height = "100%";
				this.divObj.appendChild(tempFrame);
				this.divObj.style.filter = "Alpha(Opacity=50)";
			}else{
				this.divObj.style.opacity = 0.5
			};
			document.body.appendChild(this.divObj);
		};
		if(document.body.offsetHeight < document.documentElement.clientHeight){
			this.divObj.style.width = document.body.clientWidth + "px";
			this.divObj.style.height = document.documentElement.clientHeight + "px";
		}else{
			this.divObj.style.width = document.body.clientWidth + "px";
			this.divObj.style.height = document.body.clientHeight + "px";
		};
		this.divObj.style.display = "block";
		clearInterval(this._coverTime);
		this._coverTime = setInterval("coverLayer._coverRe()",50);
		document.body.parentNode.style.overflow="hidden";
	},
	off : function(noSave){ //关闭遮盖层
		if(this.divObj){this.divObj.style.display = "none"};
		clearInterval(this._coverTime);
		document.body.parentNode.style.overflow="auto";
	}
}

//第二个参数：点击打开弹窗第几个标签为当前，第三个参数：目前事情进行到第几步。
function showPop(id,stepId,stepNum,callBack){
	if(document.getElementById(id)){
	    var obj = document.getElementById(id);
		var sClientWidth = getWinSize().width;
		var sClientHeight = parent ? getWinSize(parent).height - 0 : getWinSize().height ;
		var scrolltop = getPageScroll();
		var sScrollTop = scrolltop[1];
		coverLayer.on();
		obj.style.visibility = "visible";
		obj.style.position = "absolute";
		obj.style.left = (sClientWidth - obj.offsetWidth)/2 + "px";
		obj.style.top = (sClientHeight - obj.offsetHeight)/2 + sScrollTop + "px";
	}
//--20160630
	//解除绑定
	for (var i=1;i<=6;i++) {
		$('#step'+i).unbind('click');
	}
    $(".step").removeClass("stepTyDq");
	$(".stepCon").hide();
	$("#step"+stepId).addClass("stepTyDq");
	$("#step"+stepId+"Con").show();	
	for (var c=1;c<=stepNum;c++) {
	$('#step'+c).bind('click',{stepNum:c}, function(e) {
	var clickStep = ($(this).attr("id"));
	$(".step").removeClass("stepTyDq").addClass("stepTy");
	$(this).removeClass("stepTy").addClass("stepTyDq");
	changeTab(clickStep);
	callBack(e.data.stepNum,stepNum);
  
});
	}
	//--20160630	end
}

function closePop(o){
	while(o.parentNode && o.className != "popBox"){
		o = o.parentNode;
	}
	coverLayer.off();
	o.style.visibility = "hidden";
}

function getPageScroll(){

	var yScroll;

	if (self.pageYOffset) {
		yScroll = self.pageYOffset;
	} else if (document.documentElement && document.documentElement.scrollTop){	 // Explorer 6 Strict
		yScroll = document.documentElement.scrollTop;
		//yScroll = parent ? parent.document.documentElement.scrollTop : document.documentElement.scrollTop;
	} else if (document.body) {// all other Explorers
		yScroll = document.body.scrollTop;
	}

	arrayPageScroll = new Array('',yScroll) 
	return arrayPageScroll;
}
function getWinSize(_target) {
	var windowWidth, windowHeight;
	if(_target) target = _target.document;
	else	target = document;
	if (self.innerHeight) { // all except Explorer
		if(_target) target = _target.self;
		else	target = self;
		windowWidth = target.innerWidth;
		windowHeight = target.innerHeight;
	} else if (target.documentElement && target.documentElement.clientHeight) { // Explorer 6 Strict Mode
		windowWidth = target.documentElement.clientWidth;
		windowHeight = target.documentElement.clientHeight;
	} else if (target.body) { // other Explorers
		windowWidth = target.body.clientWidth;
		windowHeight = target.body.clientHeight;
	}
	return {width:parseInt(windowWidth),height:parseInt(windowHeight)};
}

//------20160630
function changeTab(clickStep) {
	$(".stepCon").hide();
	$(".stepSon").hide();
	$(".stepSonDefault").show();
	$("#"+clickStep+"Con").show();
	}

function showPop2(id){
	if(document.getElementById(id)){
	    var obj = document.getElementById(id);
		var sClientWidth = getWinSize().width;
		var sClientHeight = parent ? getWinSize(parent).height - 0 : getWinSize().height ;
		var scrolltop = getPageScroll();
		var sScrollTop = scrolltop[1];
		coverLayer.on();
		obj.style.visibility = "visible";
		obj.style.position = "absolute";
		obj.style.left = (sClientWidth - obj.offsetWidth)/2 + "px";
		obj.style.top = ((sClientHeight - obj.offsetHeight)/2 + sScrollTop +100) + "px";
	}
}