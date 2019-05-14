package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.projectmanager.dao.ProjectDao;
import com.cognizant.projectmanager.pojo.Project;

@Service
public class ProjectService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	ProjectDao projectDao;
	@Autowired
	private CounterService counter;
	
	public List<Project> getAllProjects(){
		log.info("Inside ProjectService --> getAllProjects() Method");
		List<Project> projectList = new ArrayList<Project>();		
		projectDao.findAll().forEach(projectList::add);
		return projectList;	
	}
	
	public void createProject(Project project) {
		log.info("Inside ProjectService --> createProject() Method");
		log.info("Project Name : " + project.getProjectName());
		log.info("Priority : " + project.getPriority());
		log.info("Start Date : " + project.getStartDate());
		log.info("End Date : " + project.getEndDate());
		project.setProjectID(String.valueOf(counter.getNextSequence("ProjectSequence")));
		log.info("Unique ProjectID : "+project.getProjectID());
		projectDao.insert(project);
	}
	public void updateProject(Project project) {
		log.info("Inside ProjectService --> udpateProject() Method");
		projectDao.save(project);
	}
}
