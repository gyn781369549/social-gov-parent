package com.coaware.social.service.interaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionGood;
import com.coaware.social.dao.interaction.SocialInteractionGoodDao;

/**
 * 统计有用没用表Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionGoodService extends CrudService<SocialInteractionGoodDao, SocialInteractionGood> {

	public SocialInteractionGood get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionGood> findList(SocialInteractionGood socialInteractionGood) {
		return super.findList(socialInteractionGood);
	}
	
	public Page<SocialInteractionGood> findPage(Page<SocialInteractionGood> page, SocialInteractionGood socialInteractionGood) {
		return super.findPage(page, socialInteractionGood);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionGood socialInteractionGood) {
		return super.save(socialInteractionGood);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionGood socialInteractionGood) {
		super.delete(socialInteractionGood);
	}
	
}