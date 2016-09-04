package com.coaware.social.service.interaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionParliament;
import com.coaware.social.domain.interaction.SocialInteractionPerson;
import com.coaware.social.domain.vo.interaction.SocialInteractionParliamentVo;
import com.coaware.social.dao.interaction.SocialInteractionParliamentDao;

/**
 * 居民议事会Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionParliamentService extends CrudService<SocialInteractionParliamentDao, SocialInteractionParliament> {
	@Autowired
	public SocialInteractionPersonService socialInteractionPersonService;
	 Map<Object, Object> map=new HashMap<Object, Object>();
	/**
	 * 查询议事会 与医院
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<Object, Object> listPerson(Integer id,int pageNo,int pageSize) {
		 SocialInteractionParliament sipl=super.get(id);
		 SocialInteractionPerson sip=new SocialInteractionPerson();
		 sip.setParliamentId(id);
		Page<SocialInteractionPerson> page=socialInteractionPersonService.findPage
				(new Page<SocialInteractionPerson>(pageNo, pageSize), sip);
		map.put("page", page);
		map.put("sipl", sipl);
		return map;
	}
	public Page<SocialInteractionParliamentVo> findSocialArea(Page<SocialInteractionParliamentVo> page, SocialInteractionParliamentVo socialInteractionParliamentVo) {
		socialInteractionParliamentVo.setPage(page);
		page.setList(super.dao.findSocialArea(socialInteractionParliamentVo));
		return page;
		}
	public SocialInteractionParliament get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionParliament> findList(SocialInteractionParliament socialInteractionParliament) {
		return super.findList(socialInteractionParliament);
	}
	
	public Page<SocialInteractionParliament> findPage(Page<SocialInteractionParliament> page, SocialInteractionParliament socialInteractionParliament) {
		return super.findPage(page, socialInteractionParliament);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialInteractionParliament socialInteractionParliament) {
		return super.save(socialInteractionParliament);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionParliament socialInteractionParliament) {
		super.delete(socialInteractionParliament);
	}
	
}