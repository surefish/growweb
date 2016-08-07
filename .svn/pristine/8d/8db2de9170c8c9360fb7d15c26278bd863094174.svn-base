package com.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.model.Grid;
import com.cms.model.Json;
import com.cms.model.PageFilter;
import com.cms.model.entity.TTeacher;
import com.cms.service.TTeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{
	@Autowired
	private TTeacherService tTeacherService;

	@RequestMapping("/manager")
	public String manager() {
		return "/teacher/teacher";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TTeacher tTeacher, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tTeacherService.dataGrid(tTeacher, ph));
		grid.setTotal(tTeacherService.count(tTeacher, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage(HttpServletRequest request, String uuid) {
		TTeacher t = tTeacherService.get(uuid);
		request.setAttribute("tteacher", t);
		return "/teacher/teacherView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/teacher/teacherAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(TTeacher tTeacher) {
		Json j = new Json();
		try {
			tTeacherService.add(tTeacher);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tTeacherService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TTeacher get(String uuid) {
		return tTeacherService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String uuid) {
		TTeacher t = tTeacherService.get(uuid);
		request.setAttribute("tteacher", t);
		return "/teacher/teacherEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TTeacher tTeacher) {
		Json j = new Json();
		try {
			tTeacherService.edit(tTeacher);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
