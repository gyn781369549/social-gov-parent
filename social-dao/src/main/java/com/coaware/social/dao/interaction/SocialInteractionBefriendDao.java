package com.coaware.social.dao.interaction;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.domain.interaction.SocialInteractionBefriend;
import com.coaware.social.domain.vo.interaction.SocialInteractionBefriendVo;

/**
 * 邻邦帮助信息表DAO接口
 * @author Administrator
 * @version 2016-08-26
 */
@MyBatisDao
public interface SocialInteractionBefriendDao extends CrudDao<SocialInteractionBefriend> {
	List<SocialInteractionBefriendVo> findVo(SocialInteractionBefriendVo socialInteractionBefriendVo);
	int update(SocialInteractionBefriend socialInteractionBefriend);
}