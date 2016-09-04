package com.coaware.social.web.api.platform.interaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.coaware.social.common.config.Global;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.web.BaseController;
import com.coaware.social.domain.interaction.SocialInteractionPerson;
import com.coaware.social.service.interaction.SocialInteractionPersonService;

/**
 * 议员表Controller
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionPerson")
public class SocialInteractionPersonController extends BaseController {

	@Autowired
	private SocialInteractionPersonService socialInteractionPersonService;
	
	@RequestMapping(value = "view")
	@ResponseBody
	public ReturnJson view(@RequestParam(required=false) Integer id) {
		SocialInteractionPerson entity = null;
		if (id != null){
			entity = socialInteractionPersonService.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", 0, entity, true);
		return ret;
	}
	

	@RequestMapping(value = {"list", ""})
	@ResponseBody
	public ReturnJson list(SocialInteractionPerson socialInteractionPerson, @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		Page<SocialInteractionPerson> page = socialInteractionPersonService.findPage(new Page<SocialInteractionPerson>(pageNo, pageSize), socialInteractionPerson); 
		ReturnJson ret = new ReturnJson("查询成功", 0, page, true);
		return ret;
	}


	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionPerson socialInteractionPerson) {
		socialInteractionPersonService.save(socialInteractionPerson);
		return ReturnJson.Success;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionPerson socialInteractionPerson) {
		socialInteractionPersonService.delete(socialInteractionPerson);
		return ReturnJson.Success;
	}
	
	@InitBinder("socialInteractionPerson")    
    public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionPerson.");    
    }

}