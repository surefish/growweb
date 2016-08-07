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
import com.cms.model.entity.TNews;
import com.cms.service.TNewsService;

@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {
	@Autowired
	private TNewsService tNewsService;

	@RequestMapping("/manager")
	public String manager() {
		return "/news/news";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TNews tNews, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tNewsService.dataGrid(tNews, ph));
		grid.setTotal(tNewsService.count(tNews, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TNews t = tNewsService.get(uuid);
			request.setAttribute("tnews", t);
		}
		return "/news/newsView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/news/newsAdd";
	}

	@RequestMapping("/add")
	public String add(TNews tNews) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tNewsService.add(tNews, sessionInfo);
		} catch (Exception e) {
		}
		return "/news/news";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tNewsService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		} 
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TNews get(String uuid) {
		return tNewsService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TNews t = tNewsService.get(uuid);
			
			
			request.setAttribute("tnews", t);
		}
		return "/news/newsEdit";
	}

	@RequestMapping("/edit")
	public String edit(TNews tNews) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tNewsService.edit(tNews, sessionInfo);
		} catch (Exception e) {
		}
		return "/news/news";
	}
}
