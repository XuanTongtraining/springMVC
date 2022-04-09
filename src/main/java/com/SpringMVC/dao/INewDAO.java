package com.SpringMVC.dao;

import java.util.List;

import com.SpringMVC.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
