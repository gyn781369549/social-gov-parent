package com.coaware.social.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.coaware.social.common.chart.XYPlot;

/**
 * 比较两个对象的属性是否相等
 * @author Jack
 * @date : 2016-7-4
 */
public class CompareUtils {

	/**
	 * 比较同一个类的两个对象的属性是否相等
	 * @param oldObj
	 * @param newObj
	 * @return key是属性名，value是对象，包含了是否相等，修改前后的值
	 * @throws Exception
	 */
	public static Map<String, CompareValue> compare(Object oldObj, Object newObj) throws Exception {  
	    Map<String, CompareValue> result = new HashMap<String, CompareValue>();  
	    Field[] fs = oldObj.getClass().getDeclaredFields();  
	    for (Field f : fs) {  
	        f.setAccessible(true);  
	        Object v1 = f.get(oldObj);  
	        Object v2 = f.get(newObj);  
	        result.put(f.getName(), new CompareValue(v1, v2, equals(v1, v2)));  
	    }  
	    return result;  
	}  
	  
	public static boolean equals(Object obj1, Object obj2) {  
		if (obj1 == obj2) {  
	        return true;  
	    }  
	    if (obj1 == null || obj2 == null) {  
	        return false;  
	    }  
	    return obj1.equals(obj2);  
	}
	
	public static class CompareValue{
		private Object oldValue; //修改之前的值
		private Object newValue; //修改之后的值
		private boolean flag;	//是否一样
		
		public CompareValue(){
			
		}
		
		public CompareValue(Object oldValue, Object newValue, boolean flag){
			this.oldValue = oldValue;
			this.newValue = newValue;
			this.flag = flag;
		}
		
		public Object getOldValue() {
			return oldValue;
		}
		public void setOldValue(Object oldValue) {
			this.oldValue = oldValue;
		}
		public Object getNewValue() {
			return newValue;
		}
		public void setNewValue(Object newValue) {
			this.newValue = newValue;
		}
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		
	}
	
	
	public static void main(String[] args){
		XYPlot r1 = new XYPlot();
		r1.setId(1);
		r1.setName("abc");
		XYPlot r2 = new XYPlot();
		r2.setId(2);
		r2.setName("abc");
		r2.setTotal(10);
		try {
			System.out.println(JSON.toJSONString(compare(r1,r2),SerializerFeature.WriteMapNullValue));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
