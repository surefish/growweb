package com.cms.service;

import java.util.List;

import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TClass;

public interface TClassService{
	public List<TClass> dataGrid(TClass tClass, PageFilter ph);

	public Long count(TClass tClass, PageFilter ph);

	public void delete(String uuid);

	public void edit(TClass tClass, SessionInfo sessionInfo);

	public TClass get(String uuid);

	public void add(TClass tClass, SessionInfo sessionInfo);
}
