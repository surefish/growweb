package com.cms.service;

import java.util.List;

import com.cms.model.MessagesClass;
import com.cms.model.Tree;
import com.cms.model.entity.TMessagesClass;


public interface TMessagesClassService {

	public List<MessagesClass> treeGrid();

	public void add(TMessagesClass tMessagesClass);

	public void delete(String uuid);

	public void edit(TMessagesClass tMessagesClass);

	public TMessagesClass get(String uuid);

	public List<Tree> tree();
	
}
