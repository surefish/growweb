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
import com.cms.model.entity.TBook;
import com.cms.service.TBookService;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
	@Autowired

	private TBookService tBookService;

	@RequestMapping("/manager")
	public String manager() {
		return "/book/book";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TBook tBook, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tBookService.dataGrid(tBook, ph));
		grid.setTotal(tBookService.count(tBook, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {

			TBook t = tBookService.get(uuid);
			request.setAttribute("tbook", t);
		}

		return "/book/bookView";
	}

	@RequestMapping("/addPage")
	public String addPage() {

		return "/book/bookAdd";
	}

	@RequestMapping("/add")
	public String add(TBook tBook) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tBookService.add(tBook, sessionInfo);
		} catch (Exception e) {
		}
		return "/book/book";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tBookService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TBook get(String uuid) {
		return tBookService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {

			TBook t = tBookService.get(uuid);
			
			
			request.setAttribute("tbook", t);
		}

		return "/book/bookEdit";
	}

	@RequestMapping("/edit")
	public String edit(TBook tBook) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tBookService.edit(tBook, sessionInfo);
		} catch (Exception e) {
		}
		return "/book/book";
	}
}
