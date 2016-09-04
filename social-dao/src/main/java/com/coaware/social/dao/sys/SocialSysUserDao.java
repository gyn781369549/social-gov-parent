package com.coaware.social.dao.sys;

import java.util.List;
import java.util.Map;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.sys.SocialSysUser;

/**
 * 用户DAO接口
 * @author Administrator
 * @version 2016-06-03
 */
@MyBatisDao
public interface SocialSysUserDao extends CrudDao<SocialSysUser> {

	SocialSysUser findByAccountAndPassword(Map<String, Object> map);

	void enble(SocialSysUser socialSysUser);

	SocialSysUser autoLoginNameAndPassword();
	
	/**
	 * 根据名字关键查询网格员信息
	 * @param keyword
	 * @return
	 */
	List<SocialSysUser> queryGridMemberByName(String keyword);

	List<SocialSysUser> findNetIds(List<Integer> list);
	
}