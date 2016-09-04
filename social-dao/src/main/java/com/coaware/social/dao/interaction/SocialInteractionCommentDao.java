package com.coaware.social.dao.interaction;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.domain.interaction.SocialInteractionBefriend;
import com.coaware.social.domain.interaction.SocialInteractionComment;
import com.coaware.social.domain.vo.interaction.SocialInteractionBefriendVo;
import com.coaware.social.domain.vo.interaction.SocialInteractionCommentVo;

/**
 * 帮助信息评论表DAO接口
 * @author Administrator
 * @version 2016-08-26
 */
@MyBatisDao
public interface SocialInteractionCommentDao extends CrudDao<SocialInteractionComment> {
	List<SocialInteractionCommentVo> findVo(SocialInteractionCommentVo SocialInteractionCommentVo);
	int update(SocialInteractionCommentVo SocialInteractionCommentVo);
}