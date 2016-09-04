package com.coaware.social.dao.interaction;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.interaction.SocialInteractionParliament;
import com.coaware.social.domain.vo.interaction.SocialInteractionParliamentVo;

/**
 * 居民议事会DAO接口
 * @author Administrator
 * @version 2016-08-26
 */
@MyBatisDao
public interface SocialInteractionParliamentDao extends CrudDao<SocialInteractionParliament> {
	List<SocialInteractionParliamentVo> findSocialArea(SocialInteractionParliamentVo socialInteractionParliamentVo);
}