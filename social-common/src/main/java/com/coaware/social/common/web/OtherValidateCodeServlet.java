package com.coaware.social.common.web;

import java.io.IOException;  
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

import com.coaware.social.common.config.Global;
import com.coaware.social.common.utils.CookieUtils;
import com.coaware.social.common.utils.JedisUtils;
import com.coaware.social.common.utils.ValidateCode;

  
public class OtherValidateCodeServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void doGet(HttpServletRequest reqeust,  
            HttpServletResponse response) throws ServletException, IOException {  
        // 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        //禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
          
        //HttpSession session = reqeust.getSession();  
        String  vv= reqeust.getParameter("vvcode");
       
        ValidateCode vCode = new ValidateCode(120,40,4,10); 
        if(vv!=null&&!"".equals(vv)){
        	//Global.map.put(vv,vCode.getCode());
        	JedisUtils.setex(vv, 5*60, vCode.getCode());//图片验证码5分钟失效
        }
        CookieUtils.setCookie(response, "code", vCode.getCode());
        //session.setAttribute("code", vCode.getCode());  
        //System.out.println(session.getAttribute("code"));
        OutputStream outps = response.getOutputStream();
        vCode.write(outps);  
        
        //PrintWriter out = response.getWriter();
        //outps.write(("<input value="+vCode.getCode()+" type='text'>").getBytes());
    }  
/** 
 * web.xml 添加servlet 
    <servlet> 
        <servlet-name>validateCodeServlet</servlet-name> 
        <servlet-class>cn.dsna.util.images.ValidateCodeServlet</servlet-class> 
    </servlet>     
    <servlet-mapping> 
        <servlet-name>validateCodeServlet</servlet-name> 
        <url-pattern>*.images</url-pattern> 
    </servlet-mapping> 
 
在地址栏输入XXX/dsna.images 测试 
 */  
  
} 
