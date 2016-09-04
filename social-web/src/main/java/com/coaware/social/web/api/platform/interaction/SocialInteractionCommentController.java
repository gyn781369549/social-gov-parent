package com.coaware.social.web.api.platform.interaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.coaware.social.domain.interaction.SocialInteractionComment;
import com.coaware.social.domain.member.SocialMember;
import com.coaware.social.domain.vo.interaction.SocialInteractionCommentVo;
import com.coaware.social.service.interaction.SocialInteractionBefriendService;
import com.coaware.social.service.interaction.SocialInteractionCommentService;
import com.coaware.social.service.interaction.util.OpeFunction;
import com.coaware.social.service.member.SocialMemberService;

/**
 * 帮助信息评论表Controller
 * 
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionComment")
public class SocialInteractionCommentController extends BaseController {
	@Autowired
	private SocialInteractionBefriendService socialInteractionBefriendService;

	@Autowired
	private SocialMemberService socialMemberService;

	@Autowired
	private SocialInteractionCommentService socialInteractionCommentService;
	@Autowired
	private HttpServletRequest request;
	
	private ReturnJson ret;

	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public ReturnJson list(SocialInteractionCommentVo SocialInteractionCommentVo,
			@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		logger.info("list方法执行" + OpeFunction.getNowTime());
		logger.info("SocialInteractionCommentVo=" + SocialInteractionCommentVo);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		
		try {

			Page<SocialInteractionCommentVo> page = socialInteractionCommentService
					.findVo(new Page<SocialInteractionCommentVo>(pageNo, pageSize), SocialInteractionCommentVo);
			logger.info("page=" + page.getLast());
			List<com.coaware.social.domain.vo.interaction.SocialInteractionCommentVo> list = page.getList();
			
			ret = new ReturnJson("查询成功", 0, page, true);

		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("查询失败", -1, null, false);
		}
		return ret;
	}
	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionComment socialInteractionComment) {
		logger.info("save方法执行" + OpeFunction.getNowTime());
		logger.info("socialInteractionComment=" + socialInteractionComment);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			socialInteractionCommentService.save(socialInteractionComment);
			ret = new ReturnJson("添加成功", 1, null, true);

		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("添加失败", -1, null, false);
		}
		return ret;
	}
		
	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionComment socialInteractionComment) {
		logger.info("delete方法执行" + OpeFunction.getNowTime());
		logger.info("socialInteractionComment=" + socialInteractionComment);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			socialInteractionCommentService.delete(socialInteractionComment);
			ret = new ReturnJson("删除成功", 1, null, true);

		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("删除失败", -1, null, false);
		}
		return ret;
	}
	@RequestMapping(value = "update")
	@ResponseBody
	public ReturnJson update(SocialInteractionComment socialInteractionComment) {
		logger.info("update方法执行" + OpeFunction.getNowTime());
		logger.info("socialInteractionComment=" + socialInteractionComment);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			socialInteractionCommentService.update(socialInteractionComment);
			ret = new ReturnJson("更新成功", 1, null, true);

		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("更新失败", -1, null, false);
			e.printStackTrace();
		}
		return ret;
	}

	@InitBinder("socialInteractionComment")
	public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionComment.");
	}

}