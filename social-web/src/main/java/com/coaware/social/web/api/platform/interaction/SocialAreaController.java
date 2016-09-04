package com.coaware.social.web.api.platform.interaction;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coaware.social.common.config.Global;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.web.BaseController;
import com.coaware.social.domain.interaction.SocialInteractionBefriend;
import com.coaware.social.domain.member.SocialMember;
import com.coaware.social.domain.member.SocialMemberArea;
import com.coaware.social.domain.member.SocialMemberAreaNode;
import com.coaware.social.domain.sys.SocialArea;
import com.coaware.social.domain.vo.member.SocialMemberAreaVo;
import com.coaware.social.service.interaction.SocialInteractionBefriendService;
import com.coaware.social.service.interaction.util.OpeFunction;
import com.coaware.social.service.member.SocialMemberAreaService;
import com.coaware.social.service.member.SocialMemberService;
import com.coaware.social.service.sys.SocialAreaService;

/**
 * 社区Controller
 * 
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialAreaController")
public class SocialAreaController extends BaseController {
	@Autowired
	private SocialAreaService socialAreaService;
	@Autowired
	private HttpServletRequest request;
	ReturnJson ret;

	/**
	 * 
	 * 
	 * @param socialInteractionBefriend
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public ReturnJson list(SocialArea socialArea,
			@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		logger.info("list方法执行" + OpeFunction.getNowTime());
		logger.info("socialArea=" + socialArea);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			List<SocialArea> lsmav=socialAreaService.findList(socialArea);
			
		
			ret = new ReturnJson("查询成功", 0, lsmav, true);
			return ret;
		} catch (Exception e) {
			 e.printStackTrace();
			ret = new ReturnJson("查询失败", -1, null, false);
			
		}
		return ret;
	}
	
	@InitBinder("socialMember")
	public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialMember.");
	}

	public static void main(String[] s) {

	}

}