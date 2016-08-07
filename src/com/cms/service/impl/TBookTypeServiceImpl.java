package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.BookType;
import com.cms.model.Organization;
import com.cms.model.Tree;
import com.cms.model.base.Torganization;
import com.cms.model.entity.TBookType;
import com.cms.service.TBookTypeService;

@Service
public class TBookTypeServiceImpl implements TBookTypeService {

	@Autowired
	private BaseDao<TBookType> tbooktypeDao;
	
	@Override
	public List<BookType> treeGrid() {
		List<BookType> l = new ArrayList<BookType>();
		List<TBookType> list = tbooktypeDao
				.find(" from TBookType t");
//		System.out
//				.println("TBookType="+list.toString());
		
		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i));
		}
		
		if ((list != null) && (list.size() > 0)) {
			for (TBookType t : list) {
				BookType r = new BookType();
				r.setId(t.getFuID());
				r.setName(t.getFname());
				r.setMemo(t.getFremark());
				
				r.setIcon(t.getFicon());
				r.setPid(t.getFparentid());
				r.setIconCls(t.getFicon());
				l.add(r);
				
			}
//			System.out
//					.println("BookType="+l.toString());
			
			for (int i = 0; i < l.size(); i++) {
			    System.out.println(l.get(i));
			}
		}
		return l;
	}

	@Override
	public void add(TBookType tBookType) {
		TBookType t = new TBookType();
		BeanUtils.copyProperties(tBookType, t);
		t.setFuID(UUID.randomUUID().toString());
		tbooktypeDao.save(t);

	}

	@Override
	public void delete(String uuid) {
		TBookType t = tbooktypeDao.get(TBookType.class, uuid);
		tbooktypeDao.delete(t);
	}

	@Override
	public void edit(TBookType tBookType) {
		TBookType t = tbooktypeDao.get(TBookType.class, tBookType.getFuID());
		t.setFname(tBookType.getFname());
		t.setFremark(tBookType.getFremark());
		
		t.setFicon(tBookType.getFicon());
		t.setFparentid(tBookType.getFparentid());
		tbooktypeDao.update(t);	

	}

	@Override
	public TBookType get(String uuid) {
		TBookType t = tbooktypeDao.get(TBookType.class, uuid);
		return t;
	}

	@Override
	public List<Tree> tree() {
		List<TBookType> l = null;
		List<Tree> lt = new ArrayList<Tree>();

		l = tbooktypeDao.find("select distinct t from TBookType t");

		if ((l != null) && (l.size() > 0)) {
			for (TBookType r : l) {
				Tree tree = new Tree();
				tree.setId(r.getFuID().toString());
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
