package com.cms.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cms.service.TNewsClassService;
import com.cms.utils.GsonUtil;

public class NewsClassTest extends BaseTest{
	
	@Autowired
	private TNewsClassService tNewsClassService;
	
	@Test
	public void testTreeGrid() {
		//List<TNewsClass> list = tNewsClassService.treeGrid();
		
		System.out.println(JSON.toJSON(tNewsClassService.treeGrid()));
	}
}
