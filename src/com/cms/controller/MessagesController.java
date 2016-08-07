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
import com.cms.model.entity.TMessages;
import com.cms.service.TMessagesService;

@Controller
@RequestMapping("/messages")
public class MessagesController extends BaseController {
	@Autowired
	private TMessagesService tMessagesService;

	@RequestMapping("/manager")
	public String manager() {
		return "/messages/messages";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(TMessages tMessages, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(tMessagesService.dataGrid(tMessages, ph));
		grid.setTotal(tMessagesService.count(tMessages, ph));
		return grid;
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TMessages t = tMessagesService.get(uuid);
			request.setAttribute("tmessages", t);
		}
		return "/messages/messagesView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/messages/messagesAdd";
	}

	@RequestMapping("/add")
	public String add(TMessages tMessages) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tMessagesService.add(tMessages, sessionInfo);
		} catch (Exception e) {
		}
		return "/messages/messages";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String uuid) {
		Json j = new Json();
		try {
			tMessagesService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TMessages get(String uuid) {
		return tMessagesService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		if (null != uuid && !"".equals(uuid)) {
			TMessages t = tMessagesService.get(uuid);
			request.setAttribute("tmessages", t);
		}
		return "/messages/messagesEdit";
	}

	@RequestMapping("/edit")
	public String edit(TMessages tMessages) {
		SessionInfo sessionInfo = (SessionInfo) session
				.getAttribute(GlobalConstant.SESSION_INFO);
		try {
			tMessagesService.edit(tMessages, sessionInfo);
		} catch (Exception e) {
		}
		return "/messages/messages";
	}
}
