package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.projectmanager.dao.UserDao;
import com.cognizant.projectmanager.pojo.User;


@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CounterService counter;
	
	public List<User> getAllUsers(){
		log.info("Inside UserService --> getAllUsers() Method");
		List<User> userList = new ArrayList<User>();		
		userDao.findAll().forEach(userList::add);
		return userList;	
	}
	public void createUser(User user) {
		log.info("Inside UserService --> createUser() Method");
		log.info("First Name : " + user.getEmpFirstName());
		log.info("Last Name : " + user.getEmpLastName());
		user.setUserID(String.valueOf(counter.getNextSequence("UserSequence")));
		log.info("Unique UserID : "+user.getUserID());
		userDao.insert(user);
	}
	public void updateUser(User user) {
		log.info("Inside UserService --> updateUser() Method");
		userDao.save(user);
	}

}
