package com.coaware.social.dao.interaction;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.interaction.SocialInteractionGood;

/**
 * 统计有用没用表DAO接口
 * @author Administrator
 * @version 2016-08-26
 */
@MyBatisDao
public interface SocialInteractionGoodDao extends CrudDao<SocialInteractionGood> {
	
}