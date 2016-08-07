package com.cms.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cms.service.TMessagesClassService;
import com.cms.utils.GsonUtil;

public class MessagesClassTest extends BaseTest {

	@Autowired
	private TMessagesClassService tMessagesClassService;
	
	@Test
	public void testTreeGrid(){
		
		
		System.out.println(JSON.toJSON(tMessagesClassService.treeGrid()));
		
	}
}
