package com.coaware.social.common.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

//import com.coaware.framework.common.config.Global;


//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;




public class SMSSender {
	//private static final String SpCode =Global.getConfig("SpCode");
	//private static final String MessageUrl =Global.getConfig("MessageUrl");
	//private static final String LoginName =Global.getConfig("LoginName");
	//private static final String Password =Global.getConfig("Password");
//	private static final String SpCode ="227616";
//	private static final String MessageUrl ="http://sms.api.ums86.com:8899/sms/Api/Send.do";
//	private static final String LoginName ="yz_xtwgzx";
//	private static final String Password ="xt4767556*";
//	private static String _info = "";
	private static String result = "";
//	public static boolean sendMsg(String mobileNumber, String content ){
//		boolean success=false;
//		String msg="";		
//		try{
//			HttpClient httpclient = new HttpClient();
//			PostMethod post = new PostMethod(MessageUrl);
//			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gbk");
//			post.addParameter("SpCode", SpCode);
//			post.addParameter("LoginName", LoginName);
//			post.addParameter("Password", Password);
//			post.addParameter("MessageContent", content);
//			post.addParameter("UserNumber", mobileNumber);
//			post.addParameter("SerialNumber", "");
//			post.addParameter("ScheduleTime", "");
//			post.addParameter("f", "1");
//			httpclient.executeMethod(post);
//			String info = new String(post.getResponseBody(),"gbk");
//			//_info = info;
//			String[] infos = info.split("&");
//			msg=infos[1].split("=")[1];
//			String[] results=infos[0].split("=");
//			if(results[1].equals("0")){
//				success=true;
//			}
//		}catch (Exception e) {
//			msg=e.getLocalizedMessage();
//			e.printStackTrace();
//		}
//		return success;
//	}
	
	 /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static boolean sendPost(String mobileNumber, String content) {
        PrintWriter out = null;
        BufferedReader in = null;
        //String result = "";
        boolean success=false;
    	String msg="";	
        try {
            URL realUrl = new URL("MessageUrl");
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数    
            out.print("ss"/*"SpCode="+SpCode+"&LoginName="+LoginName+"&Password="+Password+
            		  "&MessageContent="+content+"&UserNumber="+mobileNumber+
            		  "&SerialNumber="+""+"&ScheduleTime="+""+"&f=1"*/);                     
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"gbk"));            
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println("短信通道发送短信返回结果："+result);
            String[] infos = result.split("&");
			msg=infos[1].split("=")[1];
			String[] results=infos[0].split("=");
			if(results[1].equals("0")){
				success=true;
			}
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return success;
        //return result;
    }  
	
//	public static void main(String[] args){
//		sendPost("15754880563", "123456");
//		System.out.println(result);
//	}
}
