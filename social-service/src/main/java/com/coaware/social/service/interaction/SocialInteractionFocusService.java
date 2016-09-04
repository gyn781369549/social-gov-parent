package com.coaware.social.service.interaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionFocus;
import com.coaware.social.dao.interaction.SocialInteractionFocusDao;

/**
 * 社区公示表Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionFocusService extends CrudService<SocialInteractionFocusDao, SocialInteractionFocus> {

	public SocialInteractionFocus get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionFocus> findList(SocialInteractionFocus socialInteractionFocus) {
		return super.findList(socialInteractionFocus);
	}
	
	public Page<SocialInteractionFocus> findPage(Page<SocialInteractionFocus> page, SocialInteractionFocus socialInteractionFocus) {
		return super.findPage(page, socialInteractionFocus);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionFocus socialInteractionFocus) {
		socialInteractionFocus.setIsNewRecord(true);
		return super.save(socialInteractionFocus);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionFocus socialInteractionFocus) {
		super.delete(socialInteractionFocus);
	}
	
}