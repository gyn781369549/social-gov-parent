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
import com.coaware.social.domain.interaction.SocialInteractionParliament;
import com.coaware.social.domain.vo.interaction.SocialInteractionParliamentVo;
import com.coaware.social.service.interaction.SocialInteractionParliamentService;

/**
 * 居民议事会Controller
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionParliament")
public class SocialInteractionParliamentController extends BaseController {

	@Autowired
	private SocialInteractionParliamentService socialInteractionParliamentService;
	
	@RequestMapping(value = "view")
	@ResponseBody
	public ReturnJson view(@RequestParam(required=false) Integer id) {
		SocialInteractionParliament entity = null;
		if (id != null){
			entity = socialInteractionParliamentService.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", 0, entity, true);
		return ret;
	}
	
	/**
	 * right连接  查询社区（社区为主） 与 议事会
	 * @param socialInteractionParliamentVo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = {"list", ""})
	@ResponseBody
	public ReturnJson list(SocialInteractionParliamentVo socialInteractionParliamentVo, @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		//Page<SocialInteractionParliament> page = socialInteractionParliamentService.findPage(new Page<SocialInteractionParliament>(pageNo, pageSize), socialInteractionParliament); 
		
		Page<SocialInteractionParliamentVo> page = socialInteractionParliamentService.findSocialArea(new Page<SocialInteractionParliamentVo>(pageNo, pageSize), socialInteractionParliamentVo); 
		
		ReturnJson ret = new ReturnJson("查询成功", 0, page, true);
		return ret;
	}
	/**
	 * 议事会 与 议员表
	 * @param socialInteractionParliamentVo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = {"listPerson", ""})
	@ResponseBody
	public ReturnJson listPerson(SocialInteractionParliament socialInteractionParliament, @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {	
		ReturnJson ret = new ReturnJson("查询成功", 0,
				socialInteractionParliamentService.listPerson(socialInteractionParliament.getId(),pageNo, pageSize), true);
		return ret;
	}

	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionParliament socialInteractionParliament) {
		socialInteractionParliamentService.save(socialInteractionParliament);
		return ReturnJson.Success;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionParliament socialInteractionParliament) {
		socialInteractionParliamentService.delete(socialInteractionParliament);
		return ReturnJson.Success;
	}
	
	@InitBinder("socialInteractionParliament")    
    public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionParliament.");    
    }

}