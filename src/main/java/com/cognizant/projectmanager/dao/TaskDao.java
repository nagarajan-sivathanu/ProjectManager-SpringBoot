package com.cognizant.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.projectmanager.pojo.Task;

@Repository
public interface TaskDao extends MongoRepository<Task, String> {
	@Autowired
	MongoTemplate mongoTemplate=null; 
	List<Task> findAll();
}
