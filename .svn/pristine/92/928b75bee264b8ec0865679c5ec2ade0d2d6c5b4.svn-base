package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.NewsClass;
import com.cms.model.Organization;
import com.cms.model.Tree;
import com.cms.model.base.Torganization;
import com.cms.model.entity.TNewsClass;
import com.cms.service.TNewsClassService;

@Service
public class TNewsClassServiceImpl implements TNewsClassService {

	@Autowired
	private BaseDao<TNewsClass> tnewsclassDao;
	
	@Override
	public List<NewsClass> treeGrid() {
		List<NewsClass> l = new ArrayList<NewsClass>();
		List<TNewsClass> list = tnewsclassDao
				.find(" from TNewsClass t");
//		System.out
//				.println("TNewsClass="+list.toString());
		
		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i));
		}
		
		if ((list != null) && (list.size() > 0)) {
			for (TNewsClass t : list) {
				NewsClass r = new NewsClass();
				r.setId(t.getFuid());
				r.setName(t.getFname());
				r.setMemo(t.getFmemo());
				r.setUrl(t.getFurl());
				r.setIcon(t.getFicon());
				r.setPid(t.getFparentid());
				r.setIconCls(t.getFicon());
				l.add(r);
				
			}
//			System.out
//					.println("NewsClass="+l.toString());
			
			for (int i = 0; i < l.size(); i++) {
			    System.out.println(l.get(i));
			}
		}
		return l;
	}

	@Override
	public void add(TNewsClass tNewsClass) {
		TNewsClass t = new TNewsClass();
		BeanUtils.copyProperties(tNewsClass, t);
		t.setFuid(UUID.randomUUID().toString());
		tnewsclassDao.save(t);

	}

	@Override
	public void delete(String uuid) {
		TNewsClass t = tnewsclassDao.get(TNewsClass.class, uuid);
		tnewsclassDao.delete(t);
	}

	@Override
	public void edit(TNewsClass tNewsClass) {
		TNewsClass t = tnewsclassDao.get(TNewsClass.class, tNewsClass.getFuid());
		t.setFname(tNewsClass.getFname());
		t.setFmemo(tNewsClass.getFmemo());
		t.setFurl(tNewsClass.getFurl());
		t.setFicon(tNewsClass.getFicon());
		t.setFparentid(tNewsClass.getFparentid());
		tnewsclassDao.update(t);	

	}

	@Override
	public TNewsClass get(String uuid) {
		TNewsClass t = tnewsclassDao.get(TNewsClass.class, uuid);
		return t;
	}

	@Override
	public List<Tree> tree() {
		List<TNewsClass> l = null;
		List<Tree> lt = new ArrayList<Tree>();

		l = tnewsclassDao.find("select distinct t from TNewsClass t");

		if ((l != null) && (l.size() > 0)) {
			for (TNewsClass r : l) {
				Tree tree = new Tree();
				tree.setId(r.getFuid().toString());
				if (r.getFparentid() != null) {
					tree.setPid(r.getFparentid());
				}
				tree.setText(r.getFname());
				tree.setIconCls(r.getFicon());
				lt.add(tree);
			}
		}
		return lt;
	}
}
