package com.coaware.social.dao.interaction;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.interaction.SocialInteractionPerson;

/**
 * 议员表DAO接口
 * @author Administrator
 * @version 2016-08-26
 */
@MyBatisDao
public interface SocialInteractionPersonDao extends CrudDao<SocialInteractionPerson> {
	
}