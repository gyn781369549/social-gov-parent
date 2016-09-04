package com.coaware.social.web.api.platform.interaction;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.web.BaseController;
import com.coaware.social.domain.data.SocialGridInfo;
import com.coaware.social.domain.vo.data.SocialGridMemberVo;
import com.coaware.social.service.data.SocialGridInfoService;
import com.coaware.social.service.interaction.util.OpeFunction;
import com.coaware.social.service.sys.SocialSysUserService;

/**
 * 网格Controller
 * 
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialGridInfoController")
public class SocialGridInfoController extends BaseController {
	@Autowired
	private SocialGridInfoService service;
	@Autowired
	private SocialSysUserService socialSysUserService;
	
	@Autowired
	private HttpServletRequest request;
	ReturnJson ret;

	/**
	 * 网格员列表
	 * 
	 * @param socialInteractionBefriend
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public ReturnJson list(SocialGridInfo socialGridInfo,
			@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		logger.info("list方法执行" + OpeFunction.getNowTime()); 
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
//		try {
//			List<SocialGridMemberVo> sgmv = service.findAllGridMembers();
//		
//			ret = new ReturnJson("查询成功", 0, sgmv, true);
//			return ret;
//		} catch (Exception e) {
//			 e.printStackTrace();
//			ret = new ReturnJson("查询失败", -1, null, false);
//			
//		}
		return ret;
	}
	
	
	@InitBinder("socialMember")
	public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialMember.");
	}

	public static void main(String[] s) {

	}

}