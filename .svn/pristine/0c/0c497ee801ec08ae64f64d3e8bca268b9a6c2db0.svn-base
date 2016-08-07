package com.cms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.model.Json;
import com.cms.model.MessagesClass;
import com.cms.model.Tree;
import com.cms.model.entity.TMessagesClass;
import com.cms.service.TMessagesClassService;

@Controller
@RequestMapping("/messagesclass")

public class MessagesClassController extends BaseController{

	@Autowired
	private TMessagesClassService tMessagesClassService;

	@RequestMapping("/manager")
	public String manager() {
		return "/messagesclass/messagesclass";
	}

	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return tMessagesClassService.tree();
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<MessagesClass> treeGrid() {
		return tMessagesClassService.treeGrid();
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		TMessagesClass t = tMessagesClassService.get(uuid);
		request.setAttribute("tmessagesclass", t);
		return "/messagesclass/messagesclassView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/messagesclass/messagesclassAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(TMessagesClass tMessagesClass) {
		System.out.println(tMessagesClass.getfName());
		Json j = new Json();
		try {
			tMessagesClassService.add(tMessagesClass);
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
			tMessagesClassService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TMessagesClass get(String uuid) {
		return tMessagesClassService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		System.out.println("BUG uuid="+uuid);
		TMessagesClass t = tMessagesClassService.get(uuid);
		System.out.println(t.toString());
		request.setAttribute("tmessagesclass", t);
		return "/messagesclass/messagesclassEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TMessagesClass tMessagesClass) {
		Json j = new Json();
		try {
			tMessagesClassService.edit(tMessagesClass);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
}
