package com.coaware.social.dao.sys;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.sys.SocialArea;

/**
 * 系统用户表DAO接口
 * @author Administrator
 * @version 2016-06-03
 */
@MyBatisDao
public interface SocialAreaDao extends CrudDao<SocialArea> {

	SocialArea autoCode();
	
	/**
	 * 移动端查询社区
	 * @return
	 */
	List<SocialArea> findCommunityByLevel();
}