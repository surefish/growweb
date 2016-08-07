package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.constant.GlobalConstant;
import com.cms.model.CourseApply;
import com.cms.model.Grid;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TCourseApply;
import com.cms.service.TCourseApplyService;

@Controller
@RequestMapping("/courseapply")
public class CourseApplyController extends BaseController {
	@Autowired
	private TCourseApplyService tCourseApplyService;

	@RequestMapping("/manager")
	public String manager() {
		return "/courseapply/courseapply";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TCourseApply tCourseApply, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tCourseApplyService.dataGrid(tCourseApply, ph));
		grid.setTotal(tCourseApplyService.count(tCourseApply, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			CourseApply t = tCourseApplyService.get(uuid);
			request.setAttribute("tcourseapply", t);
		}
		return "/courseapply/courseapplyView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/courseapply/courseapplyAdd";
	}

	@RequestMapping("/add")
	public String add(TCourseApply tCourseApply) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tCourseApplyService.add(tCourseApply, sessionInfo);
		} catch (Exception e) {
		}
		return "/courseapply/courseapply";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tCourseApplyService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		} 
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public CourseApply get(String uuid) {
		return tCourseApplyService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			CourseApply t = tCourseApplyService.get(uuid);
			request.setAttribute("tcourseapply", t);
		}
		return "/courseapply/courseapplyEdit";
	}

	@RequestMapping("/edit")
	public String edit(TCourseApply tCourseApply) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tCourseApplyService.edit(tCourseApply, sessionInfo);
		} catch (Exception e) {
		}
		return "/courseapply/courseapply";
	}
}
