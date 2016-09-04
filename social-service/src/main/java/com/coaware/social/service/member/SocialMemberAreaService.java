package com.coaware.social.service.member;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.dao.member.SocialMemberAreaDao;
import com.coaware.social.domain.member.SocialMemberArea;
import com.coaware.social.domain.member.SocialMemberAreaNode;
import com.coaware.social.domain.vo.member.SocialMemberAreaVo;

/**
 * 系统用户社区表Service
 * @author Administrator
 * @version 2016-06-03
 */
@Service
@Transactional(readOnly = true)
public class SocialMemberAreaService extends CrudService<SocialMemberAreaDao, SocialMemberArea> {

	 
	 
	public SocialMemberArea get(Integer id) {
		return super.get(id);
	}
	
	public List<SocialMemberArea> findList(SocialMemberArea socialMemberArea) {
		return super.findList(socialMemberArea);
	}
	
	public Page<SocialMemberArea> findPage(Page<SocialMemberArea> page, SocialMemberArea socialMemberArea) {
		return super.findPage(page, socialMemberArea);
	}
	
	@Transactional(readOnly = false)
	public int save(SocialMemberArea socialMemberArea) {
		return super.save(socialMemberArea);
	}
	
	@Transactional(readOnly = false)
	public int saveByAreaIds(Integer memberId, String areaIds) {
		try{
			this.deleteByMemberIdAndAreaId(memberId, null);
			String[] areaIdArr = areaIds.split(",");
			SocialMemberArea socialMemberArea = null;
			for(int i=0;i<areaIdArr.length;i++){
				socialMemberArea = new SocialMemberArea();
				socialMemberArea.setMemberId(memberId);
				socialMemberArea.setAreaId(Integer.parseInt(areaIdArr[i]));
				socialMemberArea.setCreateDate(new Date());
				super.save(socialMemberArea);
			}
		}catch(Exception e){
			logger.info("保存用户关注的社区异常："+e.getMessage());
			return 0;
		}
		return 1;
	}
	
	@Transactional(readOnly = false)
	public void delete(SocialMemberArea socialMemberArea) {
		super.delete(socialMemberArea);
	}
	
	@Transactional(readOnly = false)
	public int deleteByMemberIdAndAreaId(Integer memberId, Integer areaId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("areaId", areaId);
		return this.dao.deleteByMemberIdAndAreaId(map);
	}
	
	/**
	 * 根据会员ID查询关注社区列表
	 * @param map
	 * @return
	 */
	public List<SocialMemberAreaVo> findByMemberId(Integer memberId){
		return this.dao.findByMemberId(memberId);
	}

	/**
	 * 查询所有社区（node）
	 * @return
	 */
	public SocialMemberAreaNode findAllAarea() {
		SocialMemberAreaNode area = new SocialMemberAreaNode();
		List<SocialMemberAreaNode> areaList = this.dao.findAllArea();
		for(SocialMemberAreaNode vo : areaList){
			if(vo != null && vo.getState()!=null && "0".equals(vo.getState())){//获取第一层级
				setNodes(areaList, vo);
				area=vo;
			}
		}
		return area;
	}
	public void setNodes(List<SocialMemberAreaNode> area, SocialMemberAreaNode childNode){
		for(SocialMemberAreaNode vo : area){
			if (vo != null && vo.getPid() != null
					&& vo.getPid().equals(childNode.getId())) {
				childNode.getChildNodes().add(vo);
				setNodes(area, vo);
			}
		}
	}
}