package com.cms.service;

import java.util.List;

import com.cms.model.PageFilter;
import com.cms.model.SessionInfo;
import com.cms.model.entity.TMessages;

public interface TMessagesService{

	public List<TMessages> dataGrid(TMessages tMessages, PageFilter ph);

	public Long count(TMessages tMessages, PageFilter ph);

	public void add(TMessages tMessages, SessionInfo sessionInfo);

	public void delete(String uuid);

	public void edit(TMessages tMessages, SessionInfo sessionInfo);

	public TMessages get(String uuid);
}
