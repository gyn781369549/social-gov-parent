package com.coaware.social.service.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.dao.sys.SocialAreaDao;
import com.coaware.social.domain.sys.SocialArea;
import com.coaware.social.domain.sys.SocialSysUser;


/**
 * 系统用户表Service
 * @author Administrator
 * @version 2016-06-03
 */
@Service
@Transactional(readOnly = true)
public class SocialAreaService extends CrudService<SocialAreaDao, SocialArea> {

	@Autowired
	private SocialSysUserService socialSysUserService;
	
	public SocialArea get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialArea> findList(SocialArea socialArea) {
		return super.findList(socialArea);
	}
	
	public Page<SocialArea> findPage(Page<SocialArea> page, SocialArea socialArea) {
		return super.findPage(page, socialArea);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialArea socialArea) {
		return super.save(socialArea);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialArea socialArea) {
		super.delete(socialArea);
	}

	public SocialArea autoCode() {
		return this.dao.autoCode();
	}

	@Transactional(readOnly = false)
	public void update(SocialArea socialArea) {
		dao.update(socialArea);
	}
	
	/**
	 * 查询所有行政区划
	 * @return
	 */
	public List<SocialArea> findAllList(){
		return this.dao.findAllList();
	}

	
	
}