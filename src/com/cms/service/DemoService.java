package com.cms.service;

import java.util.List;

import com.cms.model.PageFilter;
import com.cms.model.Demo;

public interface DemoService {

	public List<Demo> dataGrid(Demo demo, PageFilter ph);

	public Long count(Demo demo, PageFilter ph);

	public void add(Demo demo);

	public void delete(Long id);

	public void edit(Demo demo);

	public Demo get(Long id);

}
