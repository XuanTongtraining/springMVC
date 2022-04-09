package com.SpringMVC.service.impl;

import com.SpringMVC.dao.IUserDAO;
import com.SpringMVC.dao.impl.UserDAO;
import com.SpringMVC.model.UserModel;
import com.SpringMVC.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
