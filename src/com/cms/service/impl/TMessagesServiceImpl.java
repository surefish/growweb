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
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TMessages;
import com.cms.model.entity.TNews;
import com.cms.service.TMessagesService;


@Service
public class TMessagesServiceImpl implements TMessagesService{

	@Autowired
	private BaseDao<TMessages> ttmessagesDao;
	@Override
	public List<TMessages> dataGrid(TMessages tMessages, PageFilter ph) {
		List<TMessages> ul = new ArrayList<TMessages>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TMessages t ";
		List<TMessages> l = ttmessagesDao.find(hql + whereHql(tMessages,
				params) + orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TMessages t : l) {
			TMessages u = new TMessages();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TMessages tMessages, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TMessages t ";
		return ttmessagesDao.count("select count(*) " + hql + whereHql(tMessages, params), params);
	}

	@Override
	public void add(TMessages tMessages, SessionInfo sessionInfo) {
		TMessages t = new TMessages();
		t.setFuID(UUID.randomUUID().toString());
		t.setFtitle(tMessages.getFtitle());
		t.setFcatalog(tMessages.getFcatalog());
		t.setFcontent(StringEscapeUtils.unescapeHtml4(tMessages.getFcontent()));
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());
		//t.setFimagesurl(tMessages.getFimagesurl());
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		t.setFtag(tMessages.getFtag());
		t.setFpublishtime(new Date());
		ttmessagesDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		TMessages t = ttmessagesDao.get(TMessages.class, uuid);
		ttmessagesDao.delete(t);
	}

	@Override
	public void edit(TMessages tMessages, SessionInfo sessionInfo) {
		TMessages t = ttmessagesDao.get(TMessages.class, tMessages.getFuID());
		t.setFcatalog(tMessages.getFcatalog());
		t.setFcontent(StringEscapeUtils.unescapeHtml4(tMessages.getFcontent()));
		//t.setFimagesurl(tMessages.getFimagesurl());
		t.setFotheruid(sessionInfo.getId().toString());
		t.setFtag(tMessages.getFtag());
		t.setFtitle(tMessages.getFtitle());
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		ttmessagesDao.update(t);		
	}

	@Override
	public TMessages get(String uuid) {
		TMessages t = ttmessagesDao.get(TMessages.class,uuid);
		System.out.println("service get t="+t);
		TMessages r = new TMessages();
		BeanUtils.copyProperties(t, r);
		return r;
	}

	private String whereHql(TMessages tMessages, Map<String, Object> params) {
		String hql = "";
		if (tMessages != null) {
			hql += " where 1=1 ";
			if (tMessages.getFtitle() != null) {
				hql += " and t.ftitle like :title";
				params.put("title", "%%" + tMessages.getFtitle() + "%%");
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
