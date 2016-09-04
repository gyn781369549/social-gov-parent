package com.coaware.social.web.api.platform.interaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coaware.social.common.config.Global;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.common.persistence.ReturnJson;
import com.coaware.social.common.web.BaseController;
import com.coaware.social.domain.interaction.SocialInteractionBefriend;
import com.coaware.social.domain.member.SocialMember;
import com.coaware.social.domain.vo.interaction.SocialInteractionBefriendVo;
import com.coaware.social.service.interaction.SocialInteractionBefriendService;
import com.coaware.social.service.interaction.util.OpeFunction;
import com.coaware.social.service.member.SocialMemberService;

/**
 * 邻邦帮助信息表Controller
 * 
 * @author Administrator
 * @version 2016-08-26
 */
@Controller
@RequestMapping(value = "${platformPath}/social/interaction/socialInteractionBefriend")
public class SocialInteractionBefriendController extends BaseController {

	@Autowired
	private SocialInteractionBefriendService socialInteractionBefriendService;

	@Autowired
	private SocialMemberService socialMemberService;
	@Autowired
	private HttpServletRequest request;
	ReturnJson ret;

	/**
	 * 包含ALL查询方法
	 * 
	 * @param socialInteractionBefriend
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public ReturnJson list(SocialInteractionBefriendVo socialInteractionBefriendVo,
			@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		logger.info("list方法执行" + OpeFunction.getNowTime());
		logger.info("SocialInteractionBefriendVo=" + socialInteractionBefriendVo);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {

			Page<SocialInteractionBefriendVo> page = socialInteractionBefriendService
					.findVo(new Page<SocialInteractionBefriendVo>(pageNo, pageSize), socialInteractionBefriendVo);
			ret = new ReturnJson("查询成功", 0, page, true);

		} catch (Exception e) {
			e.printStackTrace();
			ret = new ReturnJson("查询失败", -1, null, false);

		}
		return ret;
	}

	/**
	 * 新建帮助，寻求帮助信息
	 * 
	 * @param socialInteractionBefriend
	 * @param files
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public ReturnJson save(SocialInteractionBefriend socialInteractionBefriend) throws IOException {
		logger.info("save方法执行" + OpeFunction.getNowTime());
		logger.info("SocialInteractionBefriend=" + socialInteractionBefriend);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");

		try {

			socialInteractionBefriendService.save(socialInteractionBefriend);
			ret = new ReturnJson("添加成功", 1, null, true);
		} catch (Exception e) {

			ret = new ReturnJson("添加失败", -1, null, false);
		}

		return ret;

	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public ReturnJson upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		logger.info("upload方法执行" + OpeFunction.getNowTime());
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");

		try {

			String path = "/upload/img/SocialInteractionBefriend/" + OpeFunction.getNameDayTime();
			String filepath = path;
			path = request.getSession().getServletContext().getRealPath(path);// 上传的目录
			// for (MultipartFile multipartFile : files) {
			logger.info("開始...");
			String fileName = file.getOriginalFilename();// 上传的文件名字
			logger.info("fileName：" + fileName);
			fileName = java.util.UUID.randomUUID() + "." + file.getContentType().split("/")[1];

			logger.info("path：" + path);
			logger.info("newFileName：" + fileName);

			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			filepath = filepath + fileName;
			// 保存
			try {
				file.transferTo(targetFile);

			} catch (Exception e) {
				e.printStackTrace();
			}
			filepath = filepath + ",";

			logger.info("..................上传完毕!");
			// }
			logger.info("拼接后的地址..................-" + filepath);
			ret = new ReturnJson("上传成功", 1, filepath, true);

		} catch (Exception e) {
			ret = new ReturnJson("上传失败", -1, null, false);
			e.printStackTrace();

		}
		return ret;
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public ReturnJson delete(SocialInteractionBefriend socialInteractionBefriend) {
		logger.info("delete方法执行" + OpeFunction.getNowTime());
		logger.info("socialInteractionBefriend=" + socialInteractionBefriend);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			socialInteractionBefriendService.delete(socialInteractionBefriend);
			ret = new ReturnJson("刪除成功", 1, null, true);
		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("刪除失敗", -1, null, false);
			e.printStackTrace();
		}

		return ret;
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public ReturnJson update(SocialInteractionBefriend socialInteractionBefriend) {
		logger.info("update方法执行" + OpeFunction.getNowTime());
		logger.info("socialInteractionBefriend=" + socialInteractionBefriend);
		logger.info("访问ip: [" + request.getRemoteAddr().toString() + "]");
		try {
			socialInteractionBefriendService.update(socialInteractionBefriend);
			ret = new ReturnJson("更新成功", 1, null, true);
		} catch (Exception e) {
			// TODO: handle exception
			ret = new ReturnJson("更新失敗", -1, null, false);
			e.printStackTrace();
		}

		return ret;
	}

	@InitBinder("socialInteractionBefriend")
	public void initBinder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("socialInteractionBefriend.");
	}

	public static void main(String[] s) {

	}

}