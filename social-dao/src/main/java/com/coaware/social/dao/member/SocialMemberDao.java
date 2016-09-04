package com.coaware.social.dao.member;

import java.util.Map;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.member.SocialMember;

/**
 * 社区管家注册用户DAO接口
 * @author Administrator
 * @version 2016-06-25
 */
@MyBatisDao
public interface SocialMemberDao extends CrudDao<SocialMember> {
	
	/**
	 * 启用和禁用用户
	 * @param map
	 * @return
	 */
	int updateStatusById(Map<String,Object> map);
	
	/**
	 * 验证用户
	 * @param map
	 * @return
	 */
	int updateVerifyById(Map<String,Object> map);
	
	/**
	 * 根据用户名、手机号和密码登录，用户必须是启用的
	 * @param map
	 * @return
	 */
	SocialMember login(Map<String,Object> map);
	
	/**
	 * 根据手机号查询用户，status=1
	 * @param map
	 * @return
	 */
	SocialMember findByMobile(String mobile);
	
	/**
	 * 查询手机号是否注册
	 * @param mobile
	 * @return
	 */
	int isRegist(String mobile);
}