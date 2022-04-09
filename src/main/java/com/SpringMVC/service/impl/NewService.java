package com.SpringMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMVC.dao.INewDAO;
import com.SpringMVC.model.NewModel;
import com.SpringMVC.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewDAO newDao;

	@Override
	public List<NewModel> findAll() {
		return newDao.findAll();
	}

}
