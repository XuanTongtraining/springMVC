package com.SpringMVC.service;

import java.util.List;

import com.SpringMVC.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
