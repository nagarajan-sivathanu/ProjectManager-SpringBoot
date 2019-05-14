package com.cognizant.projectmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.projectmanager.pojo.Project;


@Repository
public interface ProjectDao extends MongoRepository<Project, String>  {
	@Autowired
	MongoTemplate mongoTemplate=null; 
	List<Project> findAll();
}
