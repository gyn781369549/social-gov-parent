package com.coaware.social.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.dao.sys.SocialSysUserDao;
import com.coaware.social.domain.sys.SocialSysUser;

/**
 * 用户Service
 * @author Administrator
 * @version 2016-06-03
 */
@Service
@Transactional(readOnly = true)
public class SocialSysUserService extends CrudService<SocialSysUserDao, SocialSysUser> {

	public SocialSysUser get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialSysUser> findList(SocialSysUser socialSysUser) {
		return super.findList(socialSysUser);
	}
	
	public Page<SocialSysUser> findPage(Page<SocialSysUser> page, SocialSysUser socialSysUser) {
		return super.findPage(page, socialSysUser);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialSysUser socialSysUser) {
		return super.save(socialSysUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialSysUser socialSysUser) {
		super.delete(socialSysUser);
	}

	public SocialSysUser findByAccountAndPassword(Map<String, Object> paramMap) {
		return this.dao.findByAccountAndPassword(paramMap);
	}
	@Transactional(readOnly = false)
	public void update(SocialSysUser sysUser) {
		this.dao.update(sysUser);
	}
	@Transactional(readOnly = false)
	public void enble(SocialSysUser socialSysUser) {
		dao.enble(socialSysUser);
	}

	public SocialSysUser autoLoginNameAndPassword() {
		return this.dao.autoLoginNameAndPassword();
	}
	
	/**
	 * 根据关键字查询网格员信息
	 * @param keyword
	 * @return
	 */
	public List<SocialSysUser> queryGridMemberByName(String keyword){
		return this.dao.queryGridMemberByName(keyword);
	}

	public List<SocialSysUser> findNetIds(List<Integer> list) {
		return this.dao.findNetIds(list);
	}	
}