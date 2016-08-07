package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BaseDao;
import com.cms.model.MessagesClass;
import com.cms.model.Tree;
import com.cms.model.entity.TMessagesClass;
import com.cms.service.TMessagesClassService;

import com.cms.model.Organization;
import com.cms.model.base.Torganization;
@Service
public class TMessagesClassServiceImpl implements TMessagesClassService {

	@Autowired
	private BaseDao<TMessagesClass> tmessagesclassDao;
	
	@Override
	public List<MessagesClass> treeGrid() {
		
		List<MessagesClass> l = new ArrayList<MessagesClass>();
		List<TMessagesClass> list = tmessagesclassDao
				.find(" from TMessagesClass t");
		
		if ((list != null) && (list.size() > 0)) {
			for (TMessagesClass t : list) {
				MessagesClass r = new MessagesClass();
				r.setId(t.getFuID());
				r.setName(t.getfName());
				r.setMemo(t.getfMemo());
				//r.setUrl(t.getFurl());
				r.setIcon(t.getFicon());
				r.setPid(t.getFparentID());
				r.setIconCls(t.getFicon());
				l.add(r);
			}
		}		
		return l;		
	}

	@Override
	public void add(TMessagesClass tMessagesClass) {
		TMessagesClass t = new TMessagesClass();
		BeanUtils.copyProperties(tMessagesClass, t);
		t.setFuID(UUID.randomUUID().toString());
		tmessagesclassDao.save(t);

	}

	@Override
	public void delete(String uuid) {
		TMessagesClass t = tmessagesclassDao.get(TMessagesClass.class, uuid);
		tmessagesclassDao.delete(t);
	}

	@Override
	public void edit(TMessagesClass tMessagesClass) {
		TMessagesClass t = tmessagesclassDao.get(TMessagesClass.class, tMessagesClass.getFuID());
		t.setfName(tMessagesClass.getfName());
		t.setfMemo(tMessagesClass.getfMemo());
		t.setFicon(tMessagesClass.getFicon());
		t.setFparentID(tMessagesClass.getFparentID());
		tmessagesclassDao.update(t);	

	}

	@Override
	public TMessagesClass get(String uuid) {
		TMessagesClass t = tmessagesclassDao.get(TMessagesClass.class, uuid);
		return t;
	}

	@Override
	public List<Tree> tree() {
		List<TMessagesClass> l = null;
		List<Tree> lt = new ArrayList<Tree>();

		l = tmessagesclassDao.find("select distinct t from TMessagesClass t");

		if ((l != null) && (l.size() > 0)) {
			for (TMessagesClass r : l) {
				Tree tree = new Tree();
				tree.setId(r.getFuID().toString());
				if (r.getFparentID() != null) {
					tree.setPid(r.getFparentID());
				}
				tree.setText(r.getfName());
				
				tree.setIconCls(r.getFicon());
				//tree.setIconCls("icon-btn");
				lt.add(tree);
			}
			
		}
		return lt;
		
	}
	
}
