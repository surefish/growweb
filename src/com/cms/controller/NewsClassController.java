package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.model.Json;
import com.cms.model.NewsClass;
import com.cms.model.Tree;
import com.cms.model.entity.TNewsClass;
import com.cms.service.TNewsClassService;

@Controller
@RequestMapping("/newsclass")
public class NewsClassController extends BaseController {
	@Autowired
	private TNewsClassService tNewsClassService;

	@RequestMapping("/manager")
	public String manager() {
		return "/newsclass/newsclass";
	}

	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return tNewsClassService.tree();
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<NewsClass> treeGrid() {
		return tNewsClassService.treeGrid();
	}

	@RequestMapping("/viewPage")
	public String viewPage() {
		String uuid = request.getParameter("uuid");
		TNewsClass t = tNewsClassService.get(uuid);
		request.setAttribute("tnewsclass", t);
		return "/newsclass/newsclassView";
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return "/newsclass/newsclassAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(TNewsClass tNewsClass) {
		System.out.println(tNewsClass.getFname());
		Json j = new Json();
		try {
			tNewsClassService.add(tNewsClass);
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
			tNewsClassService.delete(uuid);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public TNewsClass get(String uuid) {
		return tNewsClassService.get(uuid);
	}

	@RequestMapping("/editPage")
	public String editPage() {
		String uuid = request.getParameter("uuid");
		System.out.println("NewsClass uuid = "+uuid);
		TNewsClass t = tNewsClassService.get(uuid);
		System.out.println(t.toString());
		request.setAttribute("tnewsclass", t);
		return "/newsclass/newsclassEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TNewsClass tNewsClass) {
		Json j = new Json();
		try {
			tNewsClassService.edit(tNewsClass);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
