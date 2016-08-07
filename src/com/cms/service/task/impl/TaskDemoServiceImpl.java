package com.cms.service.task.impl;

import com.cms.dao.BaseDao;
import com.cms.model.base.Tuser;
import com.cms.service.task.TaskDemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDemoServiceImpl implements TaskDemoService {

	@Autowired
	private BaseDao<Tuser> userDao;

	@Override
	public void test() {
		System.out.println("定时任务执行...");
	}

}
