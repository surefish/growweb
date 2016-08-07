package com.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TNews;
import com.cms.model.entity.TStudent;
import com.cms.service.TStudentService;

@Service
public class TStudentServiceImpl implements TStudentService {
	@Autowired
	private BaseDao<TStudent> tstudentDao;

	@Override
	public void add(TStudent tStudent,SessionInfo sessionInfo) {
		TStudent t = new TStudent();
		t.setFno(tStudent.getFno());
		t.setFpw(tStudent.getFpw());
		t.setFbirth(tStudent.getFbirth());
		t.setFgender(tStudent.getFgender());
		t.setfEmail(tStudent.getfEmail());
		t.setFclassNo(tStudent.getFclassNo());
		t.setFparentname(tStudent.getFparentname());
		t.setFparentphone(tStudent.getFparentphone());
		t.setFileNo(tStudent.getFileNo());
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());
		tstudentDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		TStudent t = tstudentDao.get(TStudent.class, uuid);
		tstudentDao.delete(t);
	}

	@Override
	public void edit(TStudent tStudent, SessionInfo sessionInfo) {
		TStudent t = tstudentDao.get(TStudent.class, tStudent.getFuID());
		t.setFno(tStudent.getFno());
		t.setFpw(tStudent.getFpw());
		t.setFbirth(tStudent.getFbirth());
		t.setFgender(tStudent.getFgender());
		t.setfEmail(tStudent.getfEmail());
		t.setFclassNo(tStudent.getFclassNo());
		t.setFparentname(tStudent.getFparentname());
		t.setFparentphone(tStudent.getFparentphone());
		t.setFileNo(tStudent.getFileNo());
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		tstudentDao.update(t);
	}

	@Override
	public TStudent get(String uuid) {
		TStudent t = tstudentDao.get(TStudent.class, uuid);
		TStudent r = new TStudent();
		BeanUtils.copyProperties(t, r);
		return r;
	}

	@Override
	public List<TStudent> dataGrid(TStudent tStudent, PageFilter ph) {
		List<TStudent> ul = new ArrayList<TStudent>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TStudent t ";
		List<TStudent> l = tstudentDao.find(hql + whereHql(tStudent, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TStudent t : l) {
			TStudent u = new TStudent();
			BeanUtils.copyProperties(t, u);
			
			
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TStudent tStudent, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TStudent t ";
		return tstudentDao.count("select count(*) " + hql + whereHql(tStudent, params), params);
	}
	
	private String whereHql(TStudent tStudent, Map<String, Object> params) {
		String hql = "";
		if (tStudent != null) {
			hql += " where 1=1 ";
			if (tStudent.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("name", "%%" + tStudent.getFname() + "%%");
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
