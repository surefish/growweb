package com.cms.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.constant.GlobalConstant;
import com.cms.model.SessionInfo;
import com.cms.model.User;
import com.cms.service.ResourceService;
import com.cms.service.UserService;
import com.cms.utils.MemcachedUtils;

	public class MemcachedTest extends BaseTest{	
		@Autowired
		private UserService userService;
		@Autowired
		private ResourceService resourceService;
		@Test
		public void testMemcached(){
			User sysuser = userService.get((long) 1);
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setId(sysuser.getId());
			sessionInfo.setLoginname(sysuser.getLoginname());
			sessionInfo.setName(sysuser.getName());
			// user.setIp(IpUtil.getIpAddr(getRequest()));
			sessionInfo.setResourceList(userService.listResource(sysuser
					.getId()));
			sessionInfo.setResourceAllList(resourceService.listAllResource());
			//session.setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
			boolean result = MemcachedUtils.set(GlobalConstant.SESSION_INFO, sessionInfo);
			
			System.out.println("memcached写入结果:"+result);
			
			SessionInfo sessionInfo2 = (SessionInfo) MemcachedUtils.get(GlobalConstant.SESSION_INFO);
			System.out.println(sessionInfo2.getId());
			System.out.println(sessionInfo2.getLoginname());
			System.out.println(sessionInfo2.getResourceList().toString());
			System.out.println(sessionInfo2.getResourceAllList().toString());
		}
}
