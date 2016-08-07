package com.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.Session;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.PageFilter;
import com.cms.model.Resource;
import com.cms.model.SessionInfo;
import com.cms.model.base.Tdemo;
import com.cms.model.base.Tresource;
import com.cms.model.entity.TBookStore;
import com.cms.service.TBookStoreService;

@Service
public class TBookStoreServiceImpl implements TBookStoreService {

	@Autowired
	private BaseDao<TBookStore> ttbookstoreDao;

	@Override
	public List<TBookStore> dataGrid(TBookStore tBookStore, PageFilter ph) {
		List<TBookStore> ul = new ArrayList<TBookStore>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TBookStore t ";
		List<TBookStore> l = ttbookstoreDao.find(hql + whereHql(tBookStore, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TBookStore t : l) {
			TBookStore u = new TBookStore();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TBookStore tBookStore, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TBookStore t ";
		return ttbookstoreDao.count("select count(*) " + hql + whereHql(tBookStore, params), params);
	}

	@Override
	public void add(TBookStore tBookStore, SessionInfo sessionInfo) {
		TBookStore t = new TBookStore();
		t.setFuID(UUID.randomUUID().toString());
		
		t.setFname(tBookStore.getFname());
		//t.setFcatalog(tBookStore.getFcatalog());
		//t.setFcontent(StringEscapeUtils.unescapeHtml4(tBookStore.getFcontent()));
		t.setFremark(tBookStore.getFremark());
		
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());
		
		t.setFurl(tBookStore.getFurl());
		
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		
		//t.setFpublishtime(new Date());
		ttbookstoreDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		TBookStore t = ttbookstoreDao.get(TBookStore.class, uuid);
		ttbookstoreDao.delete(t);

	}

	@Override
	public void edit(TBookStore tBookStore, SessionInfo sessionInfo) {
		TBookStore t = ttbookstoreDao.get(TBookStore.class, tBookStore.getFuID());
		//t.setFcatalog(tBookStore.getFcatalog());
		//t.setFcontent(StringEscapeUtils.unescapeHtml4(tBookStore.getFcontent()));
		t.setFurl(tBookStore.getFurl());
		
		//t.setFotheruid(sessionInfo.getId().toString());
		t.setFremark(tBookStore.getFremark());
		t.setFname(tBookStore.getFname());
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		ttbookstoreDao.update(t);
	}

	@Override
	public TBookStore get(String uuid) {
		TBookStore t = ttbookstoreDao.get(TBookStore.class, uuid);
		System.out.println("BUG t="+t);
		TBookStore r = new TBookStore();
		BeanUtils.copyProperties(t, r);
		return r;
	}

	private String whereHql(TBookStore tBookStore, Map<String, Object> params) {
		String hql = "";
		if (tBookStore != null) {
			hql += " where 1=1 ";
			if (tBookStore.getFname() != null) {
				hql += " and t.ftitle like :title";
				params.put("title", "%%" + tBookStore.getFname() + "%%");
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
