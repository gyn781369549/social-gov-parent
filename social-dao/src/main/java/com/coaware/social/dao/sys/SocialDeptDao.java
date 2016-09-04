package com.coaware.social.dao.sys;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.sys.SocialDept;

/**
 * 部门DAO接口
 * @author Administrator
 * @version 2016-06-03
 */
@MyBatisDao
public interface SocialDeptDao extends CrudDao<SocialDept> {

	void enble(SocialDept socialDept);
	
	/**
	 * 根据事件ID查询对应的部门
	 * @param eventId
	 * @return
	 */
	List<SocialDept> queryByEventId(Integer eventId);
	
}