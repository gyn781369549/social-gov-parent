package com.coaware.social.service.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.service.CrudService;
import com.coaware.social.common.utils.CompareUtils;
import com.coaware.social.common.utils.CompareUtils.CompareValue;
import com.coaware.social.constants.enums.EmModifiedRecordType;
import com.coaware.social.dao.data.SocialGridInfoDao;
import com.coaware.social.domain.data.SocialGridInfo;

import com.coaware.social.domain.sys.SocialArea;

import com.coaware.social.service.sys.SocialAreaService;


/**
 * 网格信息Service
 * @author Administrator
 * @version 2016-06-28
 */
@Service
@Transactional(readOnly = true)
public class SocialGridInfoService extends CrudService<SocialGridInfoDao, SocialGridInfo> {

	
	@Autowired
	private SocialGridInfoDao socialGridInfoDao;	
	@Autowired
	private SocialAreaService socialAreaService;
	
	public SocialGridInfo get(Integer id) {
		return super.get(id);
	}
	
	
	
	
	
	
	
	@Transactional(readOnly = false)
	public void delete(String [] ids) {
		socialGridInfoDao.delete(ids);
	}
	
	/**
	 * 查询网格信息
	 * @param id
	 * @return
	 */
	public ReturnJson view(Integer id){
		SocialGridInfo entity = null;
		if (id != null){
			entity = this.get(id);
		}
		if (entity == null){
			return ReturnJson.Faild;
		}
		ReturnJson ret = new ReturnJson("查询成功", entity);
		return ret;
	}
	/**
	 * 导入Excel表
	 * 查询指定目录中电子表格中所有的数据
	 * @param
	 */
	@Transactional(readOnly = false)
	public void getAllByGridInfoExcel(String file) {
		List<SocialGridInfo> list=new ArrayList<SocialGridInfo>();
        try {
        	FileInputStream fis = new FileInputStream(file);
        	jxl.Workbook rwb=Workbook.getWorkbook(fis);
            Sheet rs=rwb.getSheet(0);
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                	SocialGridInfo socialGridInfo = new SocialGridInfo();
                	
                	socialGridInfo.setGridNum(rs.getCell(j++, i).getContents());//默认最左边编号也算一列 所以这里得j++
                	socialGridInfo.setGridName(rs.getCell(j++, i).getContents());
                	socialGridInfo.setAreaId(Integer.parseInt(rs.getCell(j++, i).getContents()));//所属委员会Id
                	socialGridInfo.setGridType(Integer.parseInt(rs.getCell(j++, i).getContents()));
                	socialGridInfo.setGridArea(Double.parseDouble(rs.getCell(j++, i).getContents()));
                	socialGridInfo.setGridHouseholds(Integer.parseInt(rs.getCell(j++, i).getContents()));
                	socialGridInfo.setGridAddress(rs.getCell(j++, i).getContents());
                	socialGridInfo.setGridDescribe(rs.getCell(j++, i).getContents());
                    
                    list.add(socialGridInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        //分批保存，每次保存1000条数据
        int init = 1000;// 每隔1000条循环一次  
        int total = list.size();  
        int cycelTotal = total / init;  
        if (total % init != 0) {  
            cycelTotal += 1;  
            if (total < init) {  
                init = list.size();  
            }  
        }  
        logger.info("循环保存的次数->getAllByGridInfoExcel:"+cycelTotal);
        
        List<SocialGridInfo> gridInfoList = new ArrayList<SocialGridInfo>();
        for (int i = 0; i < cycelTotal; i++) {  
            for (int j = 0; j < init; j++) {  
                if (list.get(j) == null) {  
                    break;  
                }  
                gridInfoList.add(list.get(j));  
            }  
            //保存数据库方法  
            socialGridInfoDao.insertBatch(gridInfoList);
            list.removeAll(gridInfoList);//移出已经保存过的数据  
            gridInfoList.clear();//移出当前保存的数据  
        } 
        
	}
	

	

	/*
	 * 根据行政区划id和网格名称查询同一社区下网格名称是否重复
	 */
	public int findCount(SocialGridInfo socialGridInfo){
		return this.dao.selectCount(socialGridInfo);
	}


}