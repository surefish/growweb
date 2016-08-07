package com.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TClass;
import com.cms.model.entity.TSchool;
import com.cms.service.TClassService;

@Service
public class TClassServiceImpl implements TClassService{

	@Autowired
	private BaseDao<TClass> tclassDao;
	
	@Override
	public List<TClass> dataGrid(TClass tClass, PageFilter ph) {
		List<TClass> ul = new ArrayList<TClass>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TClass t ";
		List<TClass> l = tclassDao.find(hql + whereHql(tClass, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TClass t : l) {
			TClass u = new TClass();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TClass tClass, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TClass t ";
		return tclassDao.count("select count(*) " + hql + whereHql(tClass, params), params);
	}

	@Override
	public void delete(String uuid) {
		TClass t = tclassDao.get(TClass.class, uuid);
		tclassDao.delete(t);
	}

	@Override
	public void edit(TClass tClass, SessionInfo sessionInfo) {
		TClass t = tclassDao.get(TClass.class, tClass.getFuID());

		tclassDao.update(t);
		
	}

	@Override
	public TClass get(String uuid) {
		return tclassDao.get(TClass.class, uuid);
	}

	@Override
	public void add(TClass tClass, SessionInfo sessionInfo) {
		TClass t = new TClass();
		
		tclassDao.save(t);
	}
	
	private String whereHql(TClass tClass, Map<String, Object> params) {
		String hql = "";
		if (tClass != null) {
			hql += " where 1=1 ";
			if (tClass.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("name", "%%" + tClass.getFname() + "%%");
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
