package com.coaware.social.service.member;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.dao.member.SocialMemberDao;
import com.coaware.social.domain.member.SocialMember;

/**
 * 社区管家注册用户Service
 * @author Administrator
 * @version 2016-06-25
 */
@Service
@Transactional(readOnly = true)
public class SocialMemberService extends CrudService<SocialMemberDao, SocialMember> {

	public SocialMember get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialMember> findList(SocialMember socialMember) {
		return super.findList(socialMember);
	}
	
	public Page<SocialMember> findPage(Page<SocialMember> page, SocialMember socialMember) {
		return super.findPage(page, socialMember);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialMember socialMember) {
		return super.save(socialMember);
	}
	
	@Transactional(readOnly = false)
	public void update(SocialMember socialMember) {
		this.dao.update(socialMember);
	}
	
	/**
	 * 根据用户名、手机号和密码登录，用户必须是启用的
	 * @param map
	 * @return
	 */
	public SocialMember login(Map<String,Object> map){
		return this.dao.login(map);
	}
	
	
	/**
	 * 启用和禁用用户
	 * @param map
	 * @return
	 */
	@Transactional(readOnly = false)
	public int updateStatusById(Map<String,Object> map){
		return this.dao.updateStatusById(map);
	}

	/**
	 * 验证用户
	 * @param map
	 * @return
	 */
	@Transactional(readOnly = false)
	public int updateVerifyById(Map<String,Object> map){
		return this.dao.updateVerifyById(map);
	}
	
	public ReturnJson view(Integer id){
		SocialMember entity = null;
		if (id != null){
			entity = this.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", 0, entity, true);
		return ret;
	}
	
	
	/**
	 * 根据手机号查询用户，status=1
	 * @param map
	 * @return
	 */
	public SocialMember findByMobile(String mobile){
		return this.dao.findByMobile(mobile);
	}
	
	/**
	 * 查询手机号是否注册
	 * @param mobile
	 * @return
	 */
	public int isRegist(String mobile){
		return this.dao.isRegist(mobile);
	}
}