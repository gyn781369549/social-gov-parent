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
import com.coaware.social.domain.interaction.SocialInteractionMsg;
import com.coaware.social.service.interaction.SocialInteractionMsgService;

/**
 * 消息Controller
 * @author Administrator
 * @version 2016-09-02
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionMsg")
public class SocialInteractionMsgController extends BaseController {

	@Autowired
	private SocialInteractionMsgService socialInteractionMsgService;
	
	@RequestMapping(value = "view")
	@ResponseBody
	public ReturnJson view(@RequestParam(required=false) Integer id) {
		SocialInteractionMsg entity = null;
		if (id != null){
			entity = socialInteractionMsgService.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", 0, entity, true);
		return ret;
	}
	

	@RequestMapping(value = {"list", ""})
	@ResponseBody
	public ReturnJson list(SocialInteractionMsg socialInteractionMsg, @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		Page<SocialInteractionMsg> page = socialInteractionMsgService.findPage(new Page<SocialInteractionMsg>(pageNo, pageSize), socialInteractionMsg); 
		ReturnJson ret = new ReturnJson("查询成功", 0, page, true);
		return ret;
	}


	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionMsg socialInteractionMsg) {
		socialInteractionMsgService.save(socialInteractionMsg);
		return ReturnJson.Success;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionMsg socialInteractionMsg) {
		socialInteractionMsgService.delete(socialInteractionMsg);
		return ReturnJson.Success;
	}
	
	@InitBinder("socialInteractionMsg")    
    public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionMsg.");    
    }

}