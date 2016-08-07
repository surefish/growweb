package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.constant.GlobalConstant;
import com.cms.model.Grid;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TSchool;
import com.cms.service.TSchoolService;

@Controller
@RequestMapping("/school")
public class SchoolController extends BaseController {

	@Autowired
	private TSchoolService tSchoolService;

	@RequestMapping("/manager")
	public String manager() {
		return "/school/school";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TSchool tSchool, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tSchoolService.dataGrid(tSchool, ph));
		grid.setTotal(tSchoolService.count(tSchool, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage(String uuid) {
		TSchool r = tSchoolService.get(uuid);
		request.setAttribute("tschool", r);
		return "/school/schoolView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/school/schoolAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(TSchool tSchool) {
		SessionInfo sessionInfo = (SessionInfo) request
				.getAttribute(GlobalConstant.SESSION_INFO);
		Json j = new Json();
		try {
			tSchoolService.add(tSchool, sessionInfo);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete() {
		String uuid = request.getParameter("uuid");
		Json j = new Json();
		try {
			tSchoolService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TSchool get(String uuid) {
		return tSchoolService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		TSchool r = tSchoolService.get(uuid);
		request.setAttribute("tschool", r);
		return "/school/schoolEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TSchool tSchool) {
		SessionInfo sessionInfo = (SessionInfo) request
				.getAttribute(GlobalConstant.SESSION_INFO);
		Json j = new Json();
		try {
			tSchoolService.edit(tSchool, sessionInfo);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

}
