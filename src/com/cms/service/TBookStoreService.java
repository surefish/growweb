package com.cms.service;

import java.util.List;

import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TBookStore;

public interface TBookStoreService{
	public List<TBookStore> dataGrid(TBookStore tBookStore, PageFilter ph);

	public Long count(TBookStore tBookStore, PageFilter ph);

	public void delete(String uuid);

	public void edit(TBookStore tBookStore, SessionInfo sessionInfo);

	public TBookStore get(String uuid);

	public void add(TBookStore tBookStore, SessionInfo sessionInfo);

	
}
