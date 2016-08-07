package com.cms.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cms.controller.BaseController;
import com.cms.constant.GlobalConstant;
import com.cms.model.Json;
import com.cms.model.SessionInfo;
import com.cms.model.User;
import com.cms.service.ResourceService;
import com.cms.service.UserService;
import com.cms.utils.MemcachedUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		//SessionInfo sessionInfo = (SessionInfo) MemcachedUtils.get(GlobalConstant.SESSION_INFO);
		if ((sessionInfo != null) && (sessionInfo.getId() != null)) {
			return "/index";
		}
		return "/login";
	}

	@ResponseBody
	@RequestMapping("/login")
	public Json login(User user, HttpSession session) {
		Json j = new Json();
		User sysuser = userService.login(user);
		if (sysuser != null) {
			j.setSuccess(true);
			j.setMsg("登陆成功！");

			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setId(sysuser.getId());
			sessionInfo.setLoginname(sysuser.getLoginname());
			sessionInfo.setName(sysuser.getName());
			// user.setIp(IpUtil.getIpAddr(getRequest()));
			sessionInfo.setResourceList(userService.listResource(sysuser
					.getId()));
			sessionInfo.setResourceAllList(resourceService.listAllResource());
			session.setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			//MemcachedUtils.set(GlobalConstant.SESSION_INFO, sessionInfo);
			
		} else {
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}

	@ResponseBody
	@RequestMapping("/logout")
	public Json logout(HttpSession session) {
		Json j = new Json();
		 if (session != null) {
		 session.invalidate();
		 }
		//if (MemcachedUtils.get(GlobalConstant.SESSION_INFO) != null) {
			//MemcachedUtils.delete(GlobalConstant.SESSION_INFO);
			//MemcachedUtils.flashAll();
		//}
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}

}
