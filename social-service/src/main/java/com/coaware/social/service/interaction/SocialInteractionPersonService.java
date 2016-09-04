package com.coaware.social.service.interaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionPerson;
import com.coaware.social.dao.interaction.SocialInteractionPersonDao;

/**
 * 议员表Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionPersonService extends CrudService<SocialInteractionPersonDao, SocialInteractionPerson> {

	public SocialInteractionPerson get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionPerson> findList(SocialInteractionPerson socialInteractionPerson) {
		return super.findList(socialInteractionPerson);
	}
	
	public Page<SocialInteractionPerson> findPage(Page<SocialInteractionPerson> page, SocialInteractionPerson socialInteractionPerson) {
		return super.findPage(page, socialInteractionPerson);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionPerson socialInteractionPerson) {
		return super.save(socialInteractionPerson);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionPerson socialInteractionPerson) {
		super.delete(socialInteractionPerson);
	}
	
}