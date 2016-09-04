package com.coaware.social.service.interaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.domain.interaction.SocialInteractionBefriend;
import com.coaware.social.domain.vo.interaction.SocialInteractionBefriendVo;
import com.coaware.social.service.interaction.util.OpeFunction;
import com.coaware.social.dao.interaction.SocialInteractionBefriendDao;

/**
 * 邻邦帮助信息表Service
 * @author Administrator
 * @version 2016-08-26
 */
@Service
@Transactional(readOnly = true)
public class SocialInteractionBefriendService extends CrudService<SocialInteractionBefriendDao, SocialInteractionBefriend> {

	
	public Page<SocialInteractionBefriendVo> findVo(Page<SocialInteractionBefriendVo> page, SocialInteractionBefriendVo SocialInteractionBefriendVo) {
		
		SocialInteractionBefriendVo.setPage(page);
		page.setList(super.dao.findVo( SocialInteractionBefriendVo));
		return page;
	}
	public SocialInteractionBefriend get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialInteractionBefriend> findList(SocialInteractionBefriend socialInteractionBefriend) {
		return super.findList(socialInteractionBefriend);
	}
	
	public Page<SocialInteractionBefriend> findPage(Page<SocialInteractionBefriend> page, SocialInteractionBefriend socialInteractionBefriend) {
		return super.findPage(page, socialInteractionBefriend);
	}
	/**
	 * 新建帮助，寻求帮助信息
	 * @param socialInteractionBefriend
	 * @param files
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@Transactional(readOnly = false)
	public int save(SocialInteractionBefriend socialInteractionBefriend){
//		socialInteractionBefriend=new SocialInteractionBefriend();
		//socialInteractionBefriend.setUserId(1);
		//socialInteractionBefriend.setAreaId(1);
		//设置为添加数据
		socialInteractionBefriend.setIsNewRecord(true);
//		socialInteractionBefriend.setAddress("");
		//socialInteractionBefriend.setId(2);
//		socialInteractionBefriend.setC_heck(0);		// 审核是否通过0待审核&amp;1审核通过 &amp;2被驳回 默认0
//		socialInteractionBefriend.setPhone("");;		// 联系电话
//		socialInteractionBefriend.setAddress("");;		// 联系地址
//		socialInteractionBefriend.setLinkTime("");;		// 联系时间范围
//		socialInteractionBefriend.setTime(new Date());;		// 申请时间（年月日）
//		socialInteractionBefriend.setContent("");;		// 帮助内容简介
//		socialInteractionBefriend.setIsCharged(0);;		// 是否收费 0免费&amp;1收费 默认0
//		socialInteractionBefriend.setPic("");		// 图片地址
//		socialInteractionBefriend.setFeature(0);		// 组织特性0公益&amp;1 默认0
//		socialInteractionBefriend.setCome(0);		// 状态 0求助&amp;1帮助 默认0
		
		
		
		return super.save(socialInteractionBefriend);
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialInteractionBefriend socialInteractionBefriend) {
		super.delete(socialInteractionBefriend);
	}
	@Transactional(readOnly = false)
	public int update(SocialInteractionBefriend socialInteractionBefriend) {
		super.dao.update(socialInteractionBefriend);
		return 1;
	}
	
}