package com.cms.service;

import java.util.List;

import com.cms.model.Tree;
import com.cms.model.Organization;

public interface OrganizationService {

	public List<Organization> treeGrid();

	public void add(Organization organization);

	public void delete(Long id);

	public void edit(Organization organization);

	public Organization get(Long id);

	public List<Tree> tree();

}
