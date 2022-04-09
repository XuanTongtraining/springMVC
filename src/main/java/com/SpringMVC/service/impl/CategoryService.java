package com.SpringMVC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringMVC.dao.ICategoryDAO;
import com.SpringMVC.model.CategoryModel;
import com.SpringMVC.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
