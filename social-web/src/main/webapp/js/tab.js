//tab
var nn;
var curNumi=1;
var jj=0;
function showPagei(idi,nn,i){
	for(var j=1;j<=nn;j++){	
			if(j==idi)
		{
		$("#box"+i+j).removeClass ();	
		$("#box"+i+j).addClass ("tab1");	
			}
		else 
		{
		$("#box"+i+j).removeClass ();	
		$("#box"+i+j).addClass ("tab2");	
			}
	}
	
}