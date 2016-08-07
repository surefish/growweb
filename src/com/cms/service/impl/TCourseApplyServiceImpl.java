package com.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.CourseApply;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TClass;
import com.cms.model.entity.TCourse;
import com.cms.model.entity.TCourseApply;
import com.cms.service.TCourseApplyService;
import com.cms.service.TCourseService;
import com.cms.service.TStudentService;

@Service
public class TCourseApplyServiceImpl
		implements
		TCourseApplyService {
	
	@Autowired
	private BaseDao<TCourseApply> tcourseapplyDao;
	@Autowired
	private TCourseService tCourseService;
	@Autowired
	private TStudentService tStudentService;
	@Override
	public List<CourseApply> dataGrid(TCourseApply tCourseApply, PageFilter ph) {
		List<CourseApply> ul = new ArrayList<CourseApply>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TCourseApply t ";
		List<TCourseApply> l = tcourseapplyDao.find(hql + whereHql(tCourseApply, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TCourseApply t : l) {
			CourseApply u = new CourseApply();
			u.setFcourse(tCourseService.get(t.getFcoursefuid()));
			u.setFstudent(tStudentService.get(t.getFstudentfuid()));
			u.setFuID(t.getFuID());
			u.setFnote(t.getFnote());
			u.setFcreateBy(t.getFcreateBy());
			u.setFcreateTime(t.getFcreateTime());
			u.setFupdateBy(t.getFupdateBy());
			u.setFupdateTime(t.getFupdateTime());
			u.setFstatusCode(t.getFstatusCode());
			u.setFstatusDesc(t.getFstatusDesc());
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TCourseApply tCourseApply, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TCourseApply t ";
		return tcourseapplyDao.count("select count(*) " + hql + whereHql(tCourseApply, params), params);
	}

	@Override
	public void delete(String uuid) {
		TCourseApply t = tcourseapplyDao.get(TCourseApply.class, uuid);
		tcourseapplyDao.delete(t);
	}

	@Override
	public void edit(TCourseApply tCourseApply, SessionInfo sessionInfo) {
		TCourseApply t = tcourseapplyDao.get(TCourseApply.class, tCourseApply.getFuID());
		tcourseapplyDao.update(t);
	}

	@Override
	public CourseApply get(String uuid) {
		TCourseApply tCourseApply = tcourseapplyDao.get(TCourseApply.class, uuid);
		CourseApply courseApply = new CourseApply();
		courseApply.setFcourse(tCourseService.get(tCourseApply.getFcoursefuid()));
		courseApply.setFstudent(tStudentService.get(tCourseApply.getFstudentfuid()));
		courseApply.setFuID(tCourseApply.getFuID());
		courseApply.setFnote(tCourseApply.getFnote());
		courseApply.setFcreateBy(tCourseApply.getFcreateBy());
		courseApply.setFcreateTime(tCourseApply.getFcreateTime());
		courseApply.setFupdateBy(tCourseApply.getFupdateBy());
		courseApply.setFupdateTime(tCourseApply.getFupdateTime());
		courseApply.setFstatusCode(tCourseApply.getFstatusCode());
		courseApply.setFstatusDesc(tCourseApply.getFstatusDesc());
		return courseApply;
	}

	@Override
	public void add(TCourseApply tCourseApply, SessionInfo sessionInfo) {
		tcourseapplyDao.save(tCourseApply);
	}
	
	private String whereHql(TCourseApply tCourseApply, Map<String, Object> params) {
		String hql = "";
		if (tCourseApply != null) {
			hql += " where 1=1 ";
			if (tCourseApply.getFstudentfuid() != null) {
				hql += " and t.fstudentfuid like :studentfuid";
				params.put("name", "%%" + tCourseApply.getFstudentfuid() + "%%");
			}
		}
		return hql;
	}

	private String orderHql(PageFilter ph) {
		String orderString = "";
		if ((ph.getSort() != null) && (ph.getOrder() != null)) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

}
