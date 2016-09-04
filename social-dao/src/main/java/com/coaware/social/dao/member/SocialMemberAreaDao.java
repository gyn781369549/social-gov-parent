package com.coaware.social.dao.member;

import java.util.List;
import java.util.Map;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.member.SocialMemberArea;
import com.coaware.social.domain.member.SocialMemberAreaNode;
import com.coaware.social.domain.vo.member.SocialMemberAreaVo;

/**
 * 系统用户社区表DAO接口
 * @author Administrator
 * @version 2016-06-03
 */
@MyBatisDao
public interface SocialMemberAreaDao extends CrudDao<SocialMemberArea> {

	/**
	 * 根据会员ID和社区ID进行删除
	 * @param map
	 * @return
	 */
	int deleteByMemberIdAndAreaId(Map<String,Object> map);
	/**
	 * 根据会员ID查询关注社区列表
	 * @param map
	 * @return
	 */
	List<SocialMemberAreaVo> findByMemberId(Integer memberId);
	/**
	 * 查询所有社区
	 * @return
	 */
	List<SocialMemberAreaNode> findAllArea();
}