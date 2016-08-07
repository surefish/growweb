package com.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.HomeWorkType;
import com.cms.model.NewsClass;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.Tree;
import com.cms.model.entity.THomeWorkType;
import com.cms.model.entity.TNews;
import com.cms.model.entity.TNewsClass;
import com.cms.service.THomeWorkTypeService;
@Service
public class THomeWorkTypeServiceImpl implements THomeWorkTypeService{
	@Autowired
	private BaseDao<THomeWorkType> thomeworktypeDao;
	@Override
	public List<HomeWorkType> treeGrid() {
		List<HomeWorkType> l = new ArrayList<HomeWorkType>();
		List<THomeWorkType> list = thomeworktypeDao
				.find(" from THomeWorkType t");

		
		if ((list != null) && (list.size() > 0)) {
			for (THomeWorkType t : list) {
				HomeWorkType r = new HomeWorkType();
				r.setFuID(t.getFuID());
				r.setFname(t.getFname());
				r.setFcreateBy(t.getFcreateBy());
				r.setFcreateTime(t.getFupdateTime());
				r.setFupdateBy(t.getFupdateBy());
				r.setFupdateTime(t.getFupdateTime());
				r.setFdesc(t.getFdesc());
				r.setFstatusCode(t.getFstatusCode());
				r.setFstatusDesc(t.getFstatusDesc());
				l.add(r);
				
			}
//			System.out
//					.println("NewsClass="+l.toString());
			
		}
		return l;
	}

	@Override
	public void add(THomeWorkType THomeWorkType,SessionInfo sessionInfo) {
		THomeWorkType t = new THomeWorkType();
		t.setFuID(UUID.randomUUID().toString());		
		t.setFname(THomeWorkType.getFname());	
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());	
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		t.setFdesc("正常");
		thomeworktypeDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		THomeWorkType t = thomeworktypeDao.get(THomeWorkType.class, uuid);
		thomeworktypeDao.delete(t);
	}

	@Override
	public void edit(THomeWorkType tHomeWorkType, SessionInfo sessionInfo) {
		THomeWorkType t = thomeworktypeDao.get(THomeWorkType.class,tHomeWorkType.getFuID());			
		t.setFname(tHomeWorkType.getFname());	
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());	
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		t.setFdesc("正常");
		thomeworktypeDao.update(t);
		
	}

	@Override
	public THomeWorkType get(String uuid) {
		THomeWorkType t = thomeworktypeDao.get(THomeWorkType.class, uuid);
		System.out.println("BUG t="+t);
		THomeWorkType r = new THomeWorkType();
		BeanUtils.copyProperties(t, r);
		return r;
	}

	@Override
	public List<Tree> tree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<THomeWorkType> dataGrid(THomeWorkType tHomeWorkType,
			PageFilter ph) {
		List<THomeWorkType> ul = new ArrayList<THomeWorkType>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from THomeWorkType t ";
		List<THomeWorkType> l = thomeworktypeDao.find(hql + whereHql(tHomeWorkType, params)				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (THomeWorkType t : l) {
			THomeWorkType u = new THomeWorkType();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	private String whereHql(THomeWorkType tHomeWorkType, Map<String, Object> params) {
		String hql = "";
		if (tHomeWorkType != null) {
			hql += " where 1=1 ";
			if (tHomeWorkType.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("title", "%%" + tHomeWorkType.getFname() + "%%");
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

	@Override
	public Long count(THomeWorkType tHomeWorkType, PageFilter ph) {
		// TODO Auto-generated method stub
		return null;
	}

}
