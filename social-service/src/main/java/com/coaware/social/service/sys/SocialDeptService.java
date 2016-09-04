package com.coaware.social.service.sys;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.dao.sys.SocialDeptDao;
import com.coaware.social.domain.sys.SocialDept;

/**
 * 部门Service
 * @author Administrator
 * @version 2016-06-03
 */
@Service
@Transactional(readOnly = true)
public class SocialDeptService extends CrudService<SocialDeptDao, SocialDept> {

	public SocialDept get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialDept> findList(SocialDept socialDept) {
		return super.findList(socialDept);
	}
	
	public Page<SocialDept> findPage(Page<SocialDept> page, SocialDept socialDept) {
		return super.findPage(page, socialDept);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialDept socialDept) {
		return super.save(socialDept);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialDept socialDept) {
		super.delete(socialDept);
	}
	@Transactional(readOnly = false)
	public void enble(SocialDept socialDept) {
		dao.enble(socialDept);
	}
	@Transactional(readOnly = false)
	public void update(SocialDept socialDept) {
		socialDept.preUpdate();
		this.dao.update(socialDept);
	}
	
	/**
	 * 查询所有的部门
	 * @return
	 */
	public List<SocialDept> findAllList(){
		return this.dao.findAllList();
	}
	
	/**
	 * 根据事件ID查询对应的部门
	 * @param eventId
	 * @return
	 */
	public List<SocialDept> queryByEventId(Integer eventId){
		return this.dao.queryByEventId(eventId);
	}
}