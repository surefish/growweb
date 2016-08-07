package com.cms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.constant.GlobalConstant;
import com.cms.model.Grid;
import com.cms.model.HomeWorkType;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.Tree;
import com.cms.model.entity.THomeWorkType;
import com.cms.model.entity.TNews;
import com.cms.model.entity.TNewsClass;
import com.cms.service.*;
@Controller
@RequestMapping("/homeworktype")
public class THomeWorkTypeController extends BaseController{
	@Autowired
	private THomeWorkTypeService thomeworktypeService;
	@RequestMapping("/manager")
	public String manager() {
		return "/homeworktype/homeworktype";
	}
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return thomeworktypeService.tree();
	}
	@RequestMapping("/treeGrid")
	@ResponseBody
	public Grid dataGrid(THomeWorkType homeworktype, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(thomeworktypeService.dataGrid(homeworktype, ph));
		grid.setTotal(thomeworktypeService.count(homeworktype, ph));
		return grid;
	}
	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		THomeWorkType t = thomeworktypeService.get(uuid);
		request.setAttribute("thomeworktype", t);
		return "/homeworktype/homeworktypeView";
	}
	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			THomeWorkType homeworktype = thomeworktypeService.get(uuid);			
			request.setAttribute("homeworktype", homeworktype);
			System.out.println(homeworktype);
		}
		return "/homeworktype/homeworktypeEdit";
	}

	@RequestMapping("/edit")
	public String edit(THomeWorkType homeworktype) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			thomeworktypeService.edit(homeworktype, sessionInfo);
		} catch (Exception e) {
		}
		return "/homeworktype/homeworktype";
	}
	@RequestMapping("/addPage")
	public String addPage() {
		return "/homeworktype/homeworktypeAdd";
	}	
	@RequestMapping("/add")
	public String add(THomeWorkType homeworktype) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			thomeworktypeService.add(homeworktype, sessionInfo);
		} catch (Exception e) {
		}
		return "/homeworktype/homeworktype";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		System.out.println("开始删除");
		Json j = new Json();
		try {			
			thomeworktypeService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
