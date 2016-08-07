package com.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.constant.GlobalConstant;
import com.cms.model.Demo;
import com.cms.model.Grid;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TStudent;
import com.cms.service.DemoService;
import com.cms.service.TStudentIPService;
import com.cms.service.TStudentService;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{
	@Autowired
	private TStudentService tStudentService;

	@RequestMapping("/manager")
	public String manager() {
		return "/student/student";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TStudent tStudent, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tStudentService.dataGrid(tStudent, ph));
		grid.setTotal(tStudentService.count(tStudent, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid=request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TStudent t = tStudentService.get(uuid);
			request.setAttribute("tstudent", t);
		}
		return "/student/studentView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/student/studentAdd";
	}

	@RequestMapping("/add")
	public String add(TStudent tStudent) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tStudentService.add(tStudent,sessionInfo);
			return "student/student";
		} catch (Exception e) {
			return e.toString();
		}
		
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete() {
		String uuid = request.getParameter("uuid");
		Json j = new Json();
		if (null != uuid && !"".equals(uuid)) {
			try {
				tStudentService.delete(uuid);
				j.setMsg("删除成功！");
				j.setSuccess(true);
			} catch (Exception e) {
				j.setMsg(e.getMessage());
			}
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TStudent get(String uuid) {
		TStudent tStudent = tStudentService.get(uuid);
		return tStudent;
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TStudent t = tStudentService.get(uuid);
			request.setAttribute("tstudent", t);
		}
		return "/student/studentEdit";
	}

	@RequestMapping("/edit")
	public String edit(TStudent tStudent) {
		System.err.println(tStudent.toString());
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tStudentService.edit(tStudent,sessionInfo);
			return "student/student";
		} catch (Exception e) {
			return e.toString();
		}
		
	}
}
