package com.SpringMVC.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.SpringMVC.dao.INewDAO;
import com.SpringMVC.mapper.NewMapper;
import com.SpringMVC.model.NewModel;


@Repository  //khai bao de lien ket autowired
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM new");
		return query(sql.toString(), new NewMapper());
	}
}
