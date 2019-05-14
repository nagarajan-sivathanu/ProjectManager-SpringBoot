package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.projectmanager.dao.TaskDao;
import com.cognizant.projectmanager.pojo.Task;

@Service
public class TaskService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private CounterService counter;
	@Autowired
	private TaskDao taskDao;
	
	public List<Task> getAllTasks(){
		log.info("Inside TasService --> getAllTasks() Method");
		List<Task> taskList = new ArrayList<Task>();		
		taskDao.findAll().forEach(taskList::add);
		return taskList;	
	}
	public void createTask(Task task) {
		log.info("Inside TaskService --> createTask() Method");
		task.setTaskID(String.valueOf(counter.getNextSequence("TaskSequence")));
		log.info("Unique TaskID : "+task.getTaskID());
		taskDao.insert(task);
	}
	public void updateTask(Task task) {
		log.info("Inside TasService --> v() Method");
		taskDao.save(task);
	}
}
