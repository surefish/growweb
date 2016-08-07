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
import com.cms.model.entity.TBook;
import com.cms.model.entity.TBookType;
import com.cms.service.TBookService;

@Service
public class TBookServiceImpl implements TBookService {

	@Autowired
	private BaseDao<TBook> ttbookDao;

	@Override
	public List<TBook> dataGrid(TBook tBook, PageFilter ph) {
		List<TBook> ul = new ArrayList<TBook>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TBook t ";
		List<TBook> l = ttbookDao.find(hql + whereHql(tBook, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TBook t : l) {
			TBook u = new TBook();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TBook tBook, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TBook t ";
		
		return ttbookDao.count("select count(*) " + hql + whereHql(tBook, params), params);
	}

	@Override
	public void add(TBook tBook, SessionInfo sessionInfo) {
		
	
		TBook t = new TBook();
		t.setFuID(UUID.randomUUID().toString());
		
		t.setFname(tBook.getFname());
		t.setFprice(tBook.getFprice());
		t.setFwriter(tBook.getFwriter());
		t.setFintroduced(tBook.getFintroduced());
		t.setFurl(tBook.getFurl());
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());
	 TBookType r= new TBookType();
		t.setfBookTypefuid(tBook.getfBookTypefuid());
	
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		
		//t.setFpublishtime(new Date());
		ttbookDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		TBook t = ttbookDao.get(TBook.class, uuid);
		ttbookDao.delete(t);

	}

	@Override
	public void edit(TBook tBook, SessionInfo sessionInfo) {
		TBook t = ttbookDao.get(TBook.class, tBook.getFuID());
		
		t.setFwriter(tBook.getFwriter());
		t.setFintroduced(tBook.getFintroduced());
		t.setFurl(tBook.getFurl());
		
		t.setfBookTypefuid(tBook.getfBookTypefuid());
		
		//t.setFotheruid(sessionInfo.getId().toString());
		t.setFprice(tBook.getFprice());
		t.setFname(tBook.getFname());	
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		ttbookDao.update(t);
	}

	@Override
	public TBook get(String uuid) {
		TBook t = ttbookDao.get(TBook.class, uuid);
		
		TBook r = new TBook();
		
	
		
		BeanUtils.copyProperties(t, r);
		
		return r;
	}

	private String whereHql(TBook tBook, Map<String, Object> params) {
		String hql = "";
		if (tBook != null) {
			hql += " where 1=1 ";
			if (tBook.getFname() != null) {
				hql += " and t.fname like :name";
				params.put("name", "%%" + tBook.getFname() + "%%");
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
