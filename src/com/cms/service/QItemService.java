package com.cms.service;

import java.util.List;

import com.cms.model.entity.QItem;
import com.cms.model.Tree;

public interface QItemService{
	public List<QItem> treeGrid();

	public void add(QItem qItem);

	public void delete(String uuid);

	public void edit(QItem qItem);

	public QItem get(String uuid);

	public List<Tree> tree();
}
