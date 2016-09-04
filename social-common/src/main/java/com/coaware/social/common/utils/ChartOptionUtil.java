package com.coaware.social.common.utils;

import java.text.DecimalFormat;
import java.util.List;

import com.coaware.social.common.chart.EmChartType;
import com.coaware.social.common.chart.XYPlot;

public class ChartOptionUtil {

	/**
	 * 组装Bar and Pie Option
	 * @param title
	 * @param list
	 * @param chartType
	 * @return
	 */
	public static String getBarAndPieOption(String title, List<XYPlot> list,int chartType){
		StringBuffer option = new StringBuffer();
		if(EmChartType.BAR.getValue() == chartType){
			option.append("{");
				option.append("title : {");
					option.append("text: '").append(title).append("',");
					option.append("textStyle: {fontSize: 10 },");
					option.append("x:'center'");
				option.append("},");
				option.append("tooltip:{");
					option.append("show: true,");
					option.append("trigger: 'axis'");
				option.append("},");
				option.append("xAxis:[");
					option.append("{");
					option.append("type: 'category',");
					option.append("textStyle: {fontSize: 8 },");
					option.append("data:[");
					for(int i=0;i<list.size();i++){
						if(i>0){
							option.append(",'").append(list.get(i).getName()).append("'");
						}else{
							option.append("'").append(list.get(i).getName()).append("'");
						}
					}
					option.append("]");
				option.append("}],");
				option.append("yAxis:[{ type: 'value'}],");
				option.append("series:[{");
					option.append("name:'数量',");
					option.append("type:'bar',");
					option.append("itemStyle : { normal: {");
					option.append("color: function(params) {");                
						option.append("var colorList = [");
						option.append("'#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',");
						option.append("'#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',");
						option.append("'#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0',");
						option.append("'#FF3E96','#BA55D3','#008B00','#8B2323','#9A32CD'");
						option.append("];");
						option.append("return colorList[params.dataIndex%20]");
						option.append("},");
						option.append("label : {show: true, position: 'top'}}},");
					option.append("data:[");
						for(int i=0;i<list.size();i++){
							if(i>0){
								option.append(","+list.get(i).getTotal());
							}else{
								option.append(list.get(i).getTotal());
							}
						}
					option.append("]");
				option.append("}]");
			option.append("}");
		}else if(EmChartType.PIE.getValue() == chartType){
			int total = 0;
			for(int i=0;i<list.size();i++){
				total += list.get(i).getTotal();
			}
			option.append("{");
				option.append("title : {");
					option.append("text: '").append(title).append("',");
					option.append("textStyle: {fontSize: 10 },");
					option.append("x:'center'");
				option.append("},");
				option.append("tooltip : {");
					option.append("trigger: 'item',");
					option.append("formatter: '{a} <br/>{b} : {c} ({d}%)'");
				option.append("},");
				option.append("legend: {");
					option.append("orient : 'vertical',");
					option.append("textStyle: {fontSize: 8 },");
					option.append("x : 'left',");
					option.append("data:[");
					for(int i=0;i<list.size();i++){
						if(i==0){
							option.append("'").append(list.get(i).getName()).append("(").append(getPercent(list.get(i).getTotal(),total)).append(")").append("'");
						}else{
							option.append(",'").append(list.get(i).getName()).append("(").append(getPercent(list.get(i).getTotal(),total)).append(")").append("'");
						}
					}
				option.append("]},");
				option.append("toolbox: {");
					option.append("show : true,");
					option.append("feature : {");
						option.append("magicType : {");
							option.append("show: true,");
							option.append("type: ['pie', 'funnel'],");
							option.append("option: {");
								option.append("funnel: {");
									option.append("x: '25%',");
									option.append("width: '50%',");
									option.append("funnelAlign: 'left',");
									option.append("max: 5");
								option.append("}");
							option.append("}");
						option.append("},");
						option.append("restore : {");
							option.append("show : true,");
							option.append("title : '还原',");
							option.append("color : 'yellow'");
			            option.append("},");
						option.append("myTool : {");
							option.append("show : true,");
							option.append("title : '全屏显示',");
							option.append("icon : 'asset/fullscreen.png',");
							option.append("onclick : function (){");
									option.append("fullscreen(this);");
							option.append("}");
						option.append("}");
					option.append("}");
				option.append("},");
				option.append("calculable : true,");
				option.append("series : [");
				option.append("{");
					option.append("name:'数量',");
					option.append("type:'pie',");
					option.append("itemStyle : { normal: {");
						option.append("color: function(params) {");                
							option.append("var colorList = [");
							option.append("'#436EEE','#B5C334','#FCCE10','#E87C25','#27727B',");
							option.append("'#FE8463','#9BCA63','#C1232B','#F3A43B','#60C0DD',");
							option.append("'#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0',");
							option.append("'#FF3E96','#BA55D3','#008B00','#8B2323','#9A32CD'");
							option.append("];");
							option.append("return colorList[params.dataIndex%20]");
							option.append("}");
						option.append("}},");
					option.append("radius : '35%',");
					//option.append("roseType : 'radius',");
					option.append("center: ['60%', '60%'],");
					option.append("data:[");
					for(int i=0;i<list.size();i++){
						if(i == 0){
							option.append("{value:").append(list.get(i).getTotal()).append(",name:'").append(list.get(i).getName()).append("(").append(getPercent(list.get(i).getTotal(),total)).append(")").append("'}");
						}else{
							option.append(",{value:").append(list.get(i).getTotal()).append(",name:'").append(list.get(i).getName()).append("(").append(getPercent(list.get(i).getTotal(),total)).append(")").append("'}");
						}
					}
					option.append("]");
				option.append("}");
				option.append("]");
			option.append("}");
		}
		return option.toString();
	}
	
	/**
	 * 组装环比数据Option
	 * @param title
	 * @param list
	 * @return
	 */
	public static String getHBOption(String title, List<XYPlot> list){
		StringBuffer option = new StringBuffer();
		option.append("{");
			option.append("title:{");
				option.append("text:'").append(title).append("',");
				option.append("textStyle: {fontSize: 12 },");
				option.append("x:'center'");
			option.append("},");
			option.append("tooltip:{");
				option.append("show: true,");
				option.append("trigger: 'axis'");
			option.append("},");
			option.append("toolbox:{");
				option.append("show : true,");
				option.append("feature : {");
					option.append("magicType : {show: true, type: ['line', 'bar']},");
					option.append("}");
			option.append("},");				
			//option.append("legend: {data:['按照入会时间统计会员信息']},");
			option.append("xAxis:[");
			option.append("{");
				option.append("type: 'category',").append(" data:[");
				if(list==null||list.size()==0){
					option.append("''");
				}else{
					for(int i=0;i<list.size();i++){
						String m = list.get(i).getName().replace(" ", "");
						m = m.substring(0,4)+"/"+m.substring(4);
						if(i>0){
							option.append(",'").append(m).append("'");
						}else{
							option.append("'").append(m).append("'");
						}
					}
				}
				
			option.append("]}],");
			option.append("yAxis:[{ type: 'value'}],");
			option.append("series:[{");
				option.append("name:'数量',");
				option.append("type:'bar',");
				option.append("itemStyle : { ");
					option.append("normal: {");
						option.append(" color: function(params) {");                
							option.append("var colorList = [");
							option.append("'#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',");
							option.append("'#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',");
							option.append("'#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0',");
							option.append("'#FF3E96','#BA55D3','#008B00','#8B2323','#9A32CD'");
							option.append("];");
							option.append("return colorList[params.dataIndex%20]");
						option.append("},");
						option.append("label : {show: true, position: 'top'}");
					option.append("}");
				option.append("},");
				option.append("data:[");
				if(list==null||list.size()==0){
					option.append("''");
				}else{
					for(int i=0;i<list.size();i++){
						if(i>0){
							option.append(","+list.get(i).getTotal());
						}else{
							option.append(list.get(i).getTotal());
						}
					}
				}
				
				option.append("]");
			option.append("}]");
		option.append("}");
		return option.toString();
	}
	
	/**
	 * 组装同比数据Option
	 * @param title
	 * @param legends
	 * @param list1:第一年数据
	 * @param list2:第二年数据
	 * @return
	 */
	public static String getTBOption(String title, List<String> legends, List<XYPlot> list1, List<XYPlot> list2){
		StringBuffer option = new StringBuffer();
		option.append("{");
			option.append("title : {");
				option.append("text: '").append(title).append("',");
				option.append("textStyle: {fontSize: 12 },");
				option.append("x: 'center'");
			option.append("},");
			option.append("tooltip : {");
				option.append("trigger: 'axis'");
			option.append("},");
			option.append("legend: {");
				option.append("x:'left',");
				option.append("orient : 'vertical',");
				option.append("data:[");
				for(int i=0;i<legends.size();i++){
					if(i==0){
						option.append("'").append(legends.get(i)).append("'");
					}else{
						option.append(",'").append(legends.get(i)).append("'");
					}
				}
				option.append("]");
			option.append("},");
			option.append("toolbox: {");
				option.append("show : true,");
				option.append("feature : {");
					option.append("magicType : {show: true, type: ['line', 'bar']}");
				option.append("}");
			option.append("},");	
			option.append("calculable : true,");
			option.append("xAxis : [");
				option.append("{");
					option.append("type : 'category',");
					option.append("data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']");
				option.append("}");
			option.append("],");
			option.append("yAxis : [");
				option.append("{");
					option.append("type : 'value'");
				option.append("}");
			option.append("],");
			option.append("series : [");				
				for(int j=0;j<legends.size();j++){					
					if(j==0){
						option.append("{");
						option.append("name:'").append(legends.get(j)).append("',");
						option.append("type:'bar',");
						option.append("itemStyle : { normal: {");
							option.append("color:'#1E90FF',");                
							option.append("label : {show: true, position: 'top'}}},");
						option.append("data:[");
						if(list1==null||list1.size()==0){
							option.append("0,0,0,0,0,0,0,0,0,0,0,0");
						}else{
							for(int i=0;i<list1.size();i++){
								if(i>0){
									option.append(","+list1.get(i).getTotal());
								}else{
									option.append(list1.get(i).getTotal());
								}
							}
						}
						option.append("]}");
					}else{
						option.append(",");
						option.append("{");
						option.append("name:'").append(legends.get(j)).append("',");
						option.append("type:'bar',");
						option.append("itemStyle : { normal: {");
						option.append("color: '#FFD700',");
						option.append("label : {show: true, position: 'top'}}},");
						option.append("data:[");
						if(list2==null||list2.size()==0){
							option.append("0,0,0,0,0,0,0,0,0,0,0,0");
						}else{
							for(int i=0;i<list2.size();i++){
								if(i>0){
									option.append(","+list2.get(i).getTotal());
								}else{
									option.append(list2.get(i).getTotal());
								}
							}
						}						
						option.append("]}");
					}
				}		
		option.append("]}");
		System.out.println(option);
		return option.toString();
	}
	
	public static String getPercent(int item, int total){
		if(total==0||item==0){
			return "0.00%";
		}else{
			return new DecimalFormat("#.00").format(item*100/total)+"%";
		}
	}
}
