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
import com.cms.model.entity.TClass;
import com.cms.service.TClassService;

@Controller
@RequestMapping("/class")
public class ClassController extends BaseController{
	@Autowired
	private TClassService tClassService;

	@RequestMapping("/manager")
	public String manager() {
		return "/class/class";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TClass tClass, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tClassService.dataGrid(tClass, ph));
		grid.setTotal(tClassService.count(tClass, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage(String uuid) {
		TClass r = tClassService.get(uuid);
		request.setAttribute("tclass", r);
		return "/class/classView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/class/classAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(TClass tClass) {
		SessionInfo sessionInfo = (SessionInfo)request.getAttribute(GlobalConstant.SESSION_INFO);
		Json j = new Json();
		try {
			tClassService.add(tClass,sessionInfo);
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
			tClassService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TClass get(String uuid) {
		return tClassService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		TClass r = tClassService.get(uuid);
		request.setAttribute("demo", r);
		return "/demo/demoEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TClass tClass) {
		SessionInfo sessionInfo = (SessionInfo) request.getAttribute(GlobalConstant.SESSION_INFO);
		Json j = new Json();
		try {
			tClassService.edit(tClass,sessionInfo);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
