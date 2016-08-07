package com.cms.service;

import java.util.List;

import com.cms.model.HomeWorkType;
import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.Tree;
import com.cms.model.entity.THomeWorkType;
import com.cms.model.entity.TNews;

public interface THomeWorkTypeService{

	public List<HomeWorkType> treeGrid();

	public void add(THomeWorkType THomeWorkType, SessionInfo sessionInfo);

	public void delete(String uuid);

	public void edit(THomeWorkType THomeWorkType, SessionInfo sessionInfo);

	public THomeWorkType get(String uuid);

	public List<Tree> tree();
	public List<THomeWorkType> dataGrid(THomeWorkType tHomeWorkType, PageFilter ph);

	public Long count(THomeWorkType tHomeWorkType, PageFilter ph);

}
