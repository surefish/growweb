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
import com.cms.model.entity.TTeacher;
import com.cms.service.TTeacherService;

@Service
public class TTeacherServiceImpl implements TTeacherService {
	
	@Autowired
	private BaseDao<TTeacher> tteacherDao;
	@Override
	public List<TTeacher> dataGrid(TTeacher tTeacher, PageFilter ph) {
		List<TTeacher> ul = new ArrayList<TTeacher>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TTeacher t ";
		List<TTeacher> l = tteacherDao.find(hql + whereHql(tTeacher, params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TTeacher t : l) {
			TTeacher u = new TTeacher();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TTeacher tTeacher, PageFilter ph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(TTeacher tTeacher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(TTeacher tTeacher) {
		// TODO Auto-generated method stub

	}

	@Override
	public TTeacher get(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String whereHql(TTeacher tTeacher, Map<String, Object> params) {
		String hql = "";
		if (tTeacher != null) {
			hql += " where 1=1 ";
			if (tTeacher.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("name", "%%" + tTeacher.getFname() + "%%");
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
