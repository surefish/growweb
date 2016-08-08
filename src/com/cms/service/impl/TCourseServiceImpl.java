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
import com.cms.model.Tree;
import com.cms.model.base.Tdemo;
import com.cms.model.base.Tresource;
import com.cms.model.entity.TCourse;
import com.cms.service.TCourseService;

@Service
public class TCourseServiceImpl implements TCourseService {

	@Autowired
	private BaseDao<TCourse> ttcourseDao;

	@Override
	public List<TCourse> dataGrid(TCourse tCourse, PageFilter ph) {
		List<TCourse> ul = new ArrayList<TCourse>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TCourse t ";
		List<TCourse> l = ttcourseDao.find(hql + whereHql(tCourse, params)
				
				+ orderHql(ph), params, ph.getPage(), ph.getRows());
		for (TCourse t : l) {
			TCourse u = new TCourse();
			BeanUtils.copyProperties(t, u);
			ul.add(u);
		}
		return ul;
	}

	@Override
	public Long count(TCourse tCourse, PageFilter ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TCourse t ";
		return ttcourseDao.count("select count(*) " + hql + whereHql(tCourse, params), params);
	}

	@Override
	public void add(TCourse tCourse, SessionInfo sessionInfo) {
		TCourse t = new TCourse();
		t.setFuID(UUID.randomUUID().toString());
		
		t.setFname(tCourse.getFname());
		t.setFtype(tCourse.getFtype());
		//t.setFcontent(StringEscapeUtils.unescapeHtml4(tCourse.getFcontent()));
		t.setFname(tCourse.getFtime());
		
		t.setFcreateBy(sessionInfo.getLoginname());
		t.setFcreateTime(new Date());
		
		t.setFimage(tCourse.getFimage());
		
		t.setFstatusCode("normal");
		t.setFstatusDesc("正常");
		
		t.setFcreateTime(new Date());
		ttcourseDao.save(t);
	}

	@Override
	public void delete(String uuid) {
		TCourse t = ttcourseDao.get(TCourse.class, uuid);
		ttcourseDao.delete(t);

	}

	@Override
	public void edit(TCourse tCourse, SessionInfo sessionInfo) {
		TCourse t = ttcourseDao.get(TCourse.class, tCourse.getFuID());
		t.setFname(tCourse.getFname());
		t.setFtype(tCourse.getFtype());
		//t.setFcontent(StringEscapeUtils.unescapeHtml4(tCourse.getFcontent()));
		t.setFimage(tCourse.getFimage());
		
		//t.setFotheruid(sessionInfo.getId().toString());
		t.setFname(tCourse.getFtime());
		
		t.setFupdateBy(sessionInfo.getLoginname());
		t.setFupdateTime(new Date());
		ttcourseDao.update(t);
	}

	@Override
	public TCourse get(String uuid) {
		TCourse t = ttcourseDao.get(TCourse.class, uuid);
		System.out.println("BUG t="+t);
		TCourse r = new TCourse();
		BeanUtils.copyProperties(t, r);
		return r;
	}

	private String whereHql(TCourse tCourse, Map<String, Object> params) {
		String hql = "";
		if (tCourse != null) {
			hql += " where 1=1 ";
			if (tCourse.getFname() != null) {
				hql += " and t.ftitle like :title";
				params.put("title", "%%" + tCourse.getFname() + "%%");
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
	public List<Tree> tree() {
		List<TCourse> l = null;
		List<Tree> lt = new ArrayList<Tree>();

		l = ttcourseDao.find("select distinct t from TCourse t");

		if ((l != null) && (l.size() > 0)) {
			for (TCourse r : l) {
				Tree tree = new Tree();
				tree.setId(r.getFuID().toString());
//				if (r.getFparentid() != null) {
//					tree.setPid(r.getFparentid());
//				}
				tree.setText(r.getFname());
//				tree.setIconCls(r.getFicon());
				lt.add(tree);
			}
		}
		return lt;
	}
}
