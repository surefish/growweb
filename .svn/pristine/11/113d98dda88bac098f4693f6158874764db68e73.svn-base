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
import com.cms.model.entity.TSchool;
import com.cms.service.TSchoolService;

@Service
public class TSchoolServiceImpl implements TSchoolService{

	@Autowired
	private BaseDao<TSchool> tschoolDao;
	
	@Override
	public List<TSchool> dataGrid(TSchool tSchool, PageFilter ph) {
		List<TSchool> ul = new ArrayList<TSchool>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TSchool t ";
		List<TSchool> l = tschoolDao.find(hql + whereHql(tSchool, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TSchool t : l) {
			TSchool u = new TSchool();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TSchool tSchool, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TNews t ";
		return tschoolDao.count("select count(*) " + hql + whereHql(tSchool, params), params);
	}

	@Override
	public void delete(String uuid) {
		TSchool t = tschoolDao.get(TSchool.class, uuid);
		tschoolDao.delete(t);
	}

	@Override
	public void edit(TSchool tSchool, SessionInfo sessionInfo) {
		TSchool t = tschoolDao.get(TSchool.class, tSchool.getFuID());

		tschoolDao.update(t);
	}

	@Override
	public TSchool get(String uuid) {
		return tschoolDao.get(TSchool.class, uuid);
	}

	@Override
	public void add(TSchool tSchool, SessionInfo sessionInfo) {
		TSchool t = new TSchool();
		
		tschoolDao.save(t);
	}
	
	private String whereHql(TSchool tSchool, Map<String, Object> params) {
		String hql = "";
		if (tSchool != null) {
			hql += " where 1=1 ";
			if (tSchool.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("name", "%%" + tSchool.getFname() + "%%");
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
