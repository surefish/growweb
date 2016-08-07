package com.cms.service;

import java.util.List;

import com.cms.model.CourseApply;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TCourseApply;

public interface TCourseApplyService{
	public List<CourseApply> dataGrid(TCourseApply tCourseApply, PageFilter ph);

	public Long count(TCourseApply tCourseApply, PageFilter ph);

	public void delete(String uuid);

	public void edit(TCourseApply tCourseApply, SessionInfo sessionInfo);

	public CourseApply get(String uuid);

	public void add(TCourseApply tCourseApply, SessionInfo sessionInfo);
}
