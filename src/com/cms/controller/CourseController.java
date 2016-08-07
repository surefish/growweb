package com.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.constant.GlobalConstant;
import com.cms.model.Grid;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TCourse;
import com.cms.service.TCourseService;

@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {
	@Autowired
	private TCourseService tCourseService;

	@RequestMapping("/manager")
	public String manager() {
		return "/course/course";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TCourse tCourse, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tCourseService.dataGrid(tCourse, ph));
		grid.setTotal(tCourseService.count(tCourse, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TCourse t = tCourseService.get(uuid);
			request.setAttribute("tcourse", t);
		}
		return "/course/courseView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/course/courseAdd";
	}

	@RequestMapping("/add")
	public String add(TCourse tCourse) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tCourseService.add(tCourse, sessionInfo);
		} catch (Exception e) {
		}
		return "/course/course";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tCourseService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		} 
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TCourse get(String uuid) {
		return tCourseService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TCourse t = tCourseService.get(uuid);
			
			
			request.setAttribute("tcourse", t);
		}
		return "/course/courseEdit";
	}

	@RequestMapping("/edit")
	public String edit(TCourse tCourse) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tCourseService.edit(tCourse, sessionInfo);
		} catch (Exception e) {
		}
		return "/course/course";
	}
}
