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
import com.cms.model.entity.TBookStore;
import com.cms.service.TBookStoreService;

@Controller
@RequestMapping("/bookstore")
public class BookStoreController extends BaseController {
	@Autowired
	private TBookStoreService tBookStoreService;


	@RequestMapping("/manager")
	public String manager() {
		return "/bookstore/bookstore";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TBookStore tBookStore, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tBookStoreService.dataGrid(tBookStore, ph));
		grid.setTotal(tBookStoreService.count(tBookStore, ph));







		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TBookStore t = tBookStoreService.get(uuid);

			request.setAttribute("tbookstore", t);
		}
		return "/bookstore/bookstoreView";

	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/bookstore/bookstoreAdd";

	}

	@RequestMapping("/add")
	public String add(TBookStore tBookStore) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);




		try {
			tBookStoreService.add(tBookStore, sessionInfo);



		} catch (Exception e) {

		}
		return "/bookstore/bookstore";

	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tBookStoreService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TBookStore get(String uuid) {
		return tBookStoreService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TBookStore t = tBookStoreService.get(uuid);



			request.setAttribute("tbookstore", t);
		}
		return "/bookstore/bookstoreEdit";

	}

	@RequestMapping("/edit")
	public String edit(TBookStore tBookStore) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);



		try {
			tBookStoreService.edit(tBookStore, sessionInfo);



		} catch (Exception e) {

		}
		return "/bookstore/bookstore";

	}
}
