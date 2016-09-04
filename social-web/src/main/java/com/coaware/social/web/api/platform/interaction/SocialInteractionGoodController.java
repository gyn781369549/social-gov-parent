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
import com.coaware.social.domain.interaction.SocialInteractionGood;
import com.coaware.social.service.interaction.SocialInteractionGoodService;

/**
 * 统计有用没用表Controller
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionGood")
public class SocialInteractionGoodController extends BaseController {

	@Autowired
	private SocialInteractionGoodService socialInteractionGoodService;
	
	@RequestMapping(value = "view")
	@ResponseBody
	public ReturnJson view(@RequestParam(required=false) Integer id) {
		SocialInteractionGood entity = null;
		if (id != null){
			entity = socialInteractionGoodService.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", 0, entity, true);
		return ret;
	}
	

	@RequestMapping(value = {"list", ""})
	@ResponseBody
	public ReturnJson list(SocialInteractionGood socialInteractionGood, @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		Page<SocialInteractionGood> page = socialInteractionGoodService.findPage(new Page<SocialInteractionGood>(pageNo, pageSize), socialInteractionGood); 
		ReturnJson ret = new ReturnJson("查询成功", 0, page, true);
		return ret;
	}


	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionGood socialInteractionGood) {
		socialInteractionGoodService.save(socialInteractionGood);
		return ReturnJson.Success;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionGood socialInteractionGood) {
		socialInteractionGoodService.delete(socialInteractionGood);
		return ReturnJson.Success;
	}
	
	@InitBinder("socialInteractionGood")    
    public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionGood.");    
    }

}