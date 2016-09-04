package com.coaware.social.service.interaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionComment;
import com.coaware.social.domain.vo.interaction.SocialInteractionBefriendVo;
import com.coaware.social.domain.vo.interaction.SocialInteractionCommentVo;
import com.coaware.social.dao.interaction.SocialInteractionCommentDao;

/**
 * 帮助信息评论表Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionCommentService extends CrudService<SocialInteractionCommentDao, SocialInteractionComment> {

	
	@Transactional(readOnly = false)
	public int update(SocialInteractionComment socialInteractionComment) {
		return super.dao.update(socialInteractionComment);
	}
	
	public Page<SocialInteractionCommentVo> findVo(Page<SocialInteractionCommentVo> page, SocialInteractionCommentVo SocialInteractionCommentVo) {
		
		SocialInteractionCommentVo.setPage(page);
		page.setList(super.dao.findVo(SocialInteractionCommentVo));
		return page;
	}
	
	
	
	public SocialInteractionComment get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionComment> findList(SocialInteractionComment socialInteractionComment) {
		return super.findList(socialInteractionComment);
	}
	
	public Page<SocialInteractionComment> findPage(Page<SocialInteractionComment> page, SocialInteractionComment socialInteractionComment) {
		return super.findPage(page, socialInteractionComment);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionComment socialInteractionComment) {
		return super.save(socialInteractionComment);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionComment socialInteractionComment) {
		super.delete(socialInteractionComment);
	}
	
}