package com.coaware.social.dao.interaction;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.interaction.SocialInteractionMsg;

/**
 * 消息DAO接口
 * @author Administrator
 * @version 2016-09-02
 */
@MyBatisDao
public interface SocialInteractionMsgDao extends CrudDao<SocialInteractionMsg> {
	
}