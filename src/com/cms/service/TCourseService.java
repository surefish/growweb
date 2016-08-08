package com.cms.service;

import java.util.List;

import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.Tree;
import com.cms.model.entity.TCourse;

public interface TCourseService{
	public List<TCourse> dataGrid(TCourse tCourse, PageFilter ph);

	public Long count(TCourse tCourse, PageFilter ph);

	public void delete(String uuid);

	public void edit(TCourse tCourse, SessionInfo sessionInfo);

	public TCourse get(String uuid);

	public void add(TCourse tCourse, SessionInfo sessionInfo);

	public List<Tree> tree();
	
}
