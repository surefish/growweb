package com.cms.service;

import java.util.List;

import com.cms.model.Tree;
import com.cms.model.SessionInfo;
import com.cms.model.Resource;

public interface ResourceService {

	public List<Resource> treeGrid();

	public void add(Resource resource);

	public void delete(Long id);

	public void edit(Resource resource);

	public Resource get(Long id);

	public List<Tree> tree(SessionInfo sessionInfo);

	public List<Tree> listAllTree(boolean flag);

	public List<String> listAllResource();

}
