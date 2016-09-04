package com.coaware.social.dao.data;

import java.util.List;

import com.coaware.social.common.persistence.CrudDao;
import com.coaware.social.common.persistence.MyBatisDao;
import com.coaware.social.domain.data.SocialGridInfo;


/**
 * 网格信息DAO接口
 * @author Administrator
 * @version 2016-06-28
 */
@MyBatisDao
public interface SocialGridInfoDao extends CrudDao<SocialGridInfo> {
	
	
	/**
	 * 批量插入修改的字段
	 * @param map
	 * @return
	 */
	int insertBatch(List<SocialGridInfo> List);
	
	
	/**
	 * 批量删除
	 * @param map
	 * @return
	 */
	int delete(String [] ids);

	
	/*
	 * 根据行政区划id和网格名称查询同一社区下网格名称是否重复
	 */
	int selectCount(SocialGridInfo socialGridInfo);

	
}