package com.cms.service;

import java.util.List;

import com.cms.model.BookType;
import com.cms.model.Tree;
import com.cms.model.entity.TBookType;

public interface TBookTypeService{
	public List<BookType> treeGrid();

	public void add(TBookType tBookType);

	public void delete(String uuid);

	public void edit(TBookType tBookType);

	public TBookType get(String uuid);

	public List<Tree> tree();
}
