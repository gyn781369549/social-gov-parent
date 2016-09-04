package com.coaware.social.service.interaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionMsg;
import com.coaware.social.dao.interaction.SocialInteractionMsgDao;

/**
 * 消息Service
 * @author Administrator
 * @version 2016-09-02
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionMsgService extends CrudService<SocialInteractionMsgDao, SocialInteractionMsg> {

	public SocialInteractionMsg get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionMsg> findList(SocialInteractionMsg socialInteractionMsg) {
		return super.findList(socialInteractionMsg);
	}
	
	public Page<SocialInteractionMsg> findPage(Page<SocialInteractionMsg> page, SocialInteractionMsg socialInteractionMsg) {
		return super.findPage(page, socialInteractionMsg);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionMsg socialInteractionMsg) {
		return super.save(socialInteractionMsg);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionMsg socialInteractionMsg) {
		super.delete(socialInteractionMsg);
	}
	
}