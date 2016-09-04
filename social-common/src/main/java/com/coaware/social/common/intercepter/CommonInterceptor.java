package com.coaware.social.common.intercepter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coaware.social.common.config.Global;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.utils.CookieUtils;
import com.coaware.social.common.utils.JedisUtils;
import com.coaware.social.common.utils.MD5Util;
import com.coaware.social.constants.web.CookieConsts;


public class CommonInterceptor implements HandlerInterceptor{
	private final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
 
	@Value("${platformPath}")
	private String platformPath ;
	@Value("${mobilePath}")
	private String mobilePath ;
	@Value("${padPath}")
	private String padPath ;
	@Value("${projectPath}")
	private String projectPath;
	
	@Value("${PLATFORM_KEY}")
	private String PLATFORM_KEY;	
	@Value("${PAD_KEY}")
	private String PAD_KEY;	
	@Value("${MOBILE_KEY}")
	private String MOBILE_KEY;	
	
    /** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
    	 
    	 
    	//logger.info("==============执行顺序: 1、preHandle================");  
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
      
		//logger.info("requestUri:"+requestUri);  
		//logger.info("contextPath:"+contextPath);  
        //logger.info("url:"+url);  
        
        String uri = request.getRequestURI();
       
        String token = "";
        Long timestamp = null;
    	token = request.getParameter("token");
    	if(request.getParameter("timestamp")!=null && !"".equals(request.getParameter("timestamp"))){
    		timestamp = Long.valueOf(request.getParameter("timestamp"));
    	}
        if(StringUtils.isBlank(token) || timestamp == null){
	        String jsonParams = getJSONString(request);
	        //logger.info("jsonParams:"+jsonParams);
	        JSONObject obj = null;
	        if(StringUtils.isNotBlank(jsonParams)){
	        	obj = JSON.parseObject(jsonParams);
	        	token = obj.getString("token");
				timestamp = obj.getLong("timestamp");
	        }
        }
        
        if(StringUtils.isBlank(token) || timestamp == null){
        	//logger.error("IP:"+request.getRemoteAddr());
        	response.getWriter().print(CookieConsts.TOKEN_ERROR_CODE);
        	return false;
        }else{
			String localToken = "";
			if(uri.startsWith(projectPath+platformPath)){
				
				//只针对管理平台，这个KEY是对应每个用户登录之后返回的KEY，在登录环节按照此方法处理
				String KEY = MD5Util.md5Hex(PLATFORM_KEY+CookieUtils.getCookie(request, CookieConsts.COOKIE_USER));
				localToken = MD5Util.md5Hex(timestamp + KEY );
				String userId = CookieUtils.getCookie(request, CookieConsts.COOKIE_USER_ID);
				/*String cacheUserId = JedisUtils.get(Global.PC_USER_ID+userId);
				if(StringUtils.isBlank(cacheUserId)){//用户不在线，返回失败的对象
					response.getWriter().print(JSON.toJSONString(new ReturnJson("登录超时，请重新登录",-1,null,false)));
					return false;
				}
				JedisUtils.setex(Global.PC_USER_ID+userId, 60*30, userId);
				Set<String> userIds = JedisUtils.getSet(Global.PC_LOGIN_USER_ID_ALL);
				if(userIds == null){
					userIds = new HashSet<String>();
				}
				userIds.add(userId);
				JedisUtils.setSet(Global.PC_LOGIN_USER_ID_ALL, userIds, 0);*/
				//Global.userMap.put(CookieUtils.getCookie(request, CookieConsts.COOKIE_USER_ID), new Date());
			}else if(uri.startsWith(projectPath+padPath)){
				localToken = MD5Util.md5Hex(timestamp+PAD_KEY);
			}else if(uri.startsWith(projectPath+mobilePath)){
				localToken = MD5Util.md5Hex(timestamp+MOBILE_KEY);
			}
			if(!localToken.equalsIgnoreCase(token)){
				logger.error("IP:"+request.getRemoteAddr()+"timestamp:"+timestamp+",token:"+token);
				response.getWriter().print(CookieConsts.TOKEN_ERROR_CODE);
				return false;
			}
        }
		return true;
    }  
  
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作   
     * 可在modelAndView中加入数据，比如当前时间
     */
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {   
    	//logger.info("==============执行顺序: 2、postHandle================");  
        if(modelAndView != null){  //加入当前时间  
            modelAndView.addObject("var", "测试postHandle");  
        }  
    }  
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
    	//logger.info("==============执行顺序: 3、afterCompletion================");  
    }  
    
    
	public static String getJSONString(HttpServletRequest request) {
		String json = "";
		try {
			ServletInputStream in = request.getInputStream();
			String content = IOUtils.toString(in, "UTF-8");
			json = URLDecoder.decode(content, "UTF-8");
			json = json.substring(json.indexOf("=") + 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}  