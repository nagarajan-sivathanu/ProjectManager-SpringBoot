package com.cognizant.projectmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.projectmanager.pojo.Project;
import com.cognizant.projectmanager.pojo.Task;
import com.cognizant.projectmanager.pojo.User;
import com.cognizant.projectmanager.service.ProjectService;
import com.cognizant.projectmanager.service.TaskService;
import com.cognizant.projectmanager.service.UserService;

@RestController
@CrossOrigin
public class ProjectManagerController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	ResponseEntity<?> resEntity;
	List<User> userList;
	List<Project> projectList;
	List<Task> taskList;
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	@Autowired
	TaskService taskService;

	
	
	
	@RequestMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		log.info("Inside ProjectManagerController --> getAllUsers() Method");
		userList = userService.getAllUsers();
		resEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/users/")
	public ResponseEntity<?>  createUser(@RequestBody User user) {
		log.info("Inside ProjectManagerController --> createUser() Method");
		userService.createUser(user);	
		resEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
		return resEntity;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/users/")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		log.info("Inside ProjectManagerController --> updateUser() Method");
		userService.updateUser(user);
		resEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/projects")
	public ResponseEntity<?> getAllProjects() {
		log.info("Inside ProjectManagerController --> getAllProjects() Method");
		projectList = projectService.getAllProjects();
		resEntity = new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/projects")
	public ResponseEntity<?>  createProject(@RequestBody Project project) {
		log.info("Inside ProjectManagerController --> createProject() Method");
		projectService.createProject(project);	
		resEntity = new ResponseEntity<Project>(project, HttpStatus.CREATED);
		return resEntity;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/projects")
	public ResponseEntity<?> updateProject(@RequestBody Project project) {
		log.info("Inside ProjectManagerController --> updateProject() Method");
		projectService.updateProject(project);
		resEntity = new ResponseEntity<Project>(project, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tasks")
	public ResponseEntity<?> getAllTasks(){
		log.info("Inside ProjectManagerController --> getAllTasks() Method");
		taskList = taskService.getAllTasks();
		resEntity = new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/tasks")
	public ResponseEntity<?> createTask(@RequestBody Task task){
		log.info("Inside ProjectManagerController --> CreateTask() Method");
		log.info("isItParentTask?? "+task.isParent());
		taskService.createTask(task);
		resEntity = new ResponseEntity<Task>(task, HttpStatus.CREATED);
		return resEntity;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/tasks")
	public ResponseEntity<?> updateTask(@RequestBody Task task){
		log.info("Inside ProjectManagerController --> updateTask() Method");
		taskService.updateTask(task);
		resEntity = new ResponseEntity<Task>(task, HttpStatus.OK);
		return resEntity;
	}
	
}

