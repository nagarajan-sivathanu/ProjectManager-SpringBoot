package com.cognizant.projectmanager.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tasks")
public class Task {
	@Id
	private String taskID;
	private String taskName;
	private boolean parent;
	//private boolean isItParentTask;
	//private String parentTaskID;
	@DBRef
	private Task parentTask;
	@DBRef
	private User user;
	@DBRef
	private Project project;
	private Date startDate;
	private Date endDate;
	private String status;
	private int priority;
	
	public Task() {
		
	}
	public Task(String taskID, String taskName, boolean parent, User user, Project project,
			Date startDate, Date endDate, String status, int priority, Task parentTask) {
		super();
		this.taskID = taskID;
		this.taskName = taskName;
		//this.isItParentTask = isItParentTask;
		//this.parentTaskID = parentTaskID;
		this.parent = parent;
		this.user = user;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.priority = priority;
		this.parentTask = parentTask;
	}
	public Task getParentTask() {
		return parentTask;
	}
	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/*
	public boolean isItParentTask() {
		return isItParentTask;
	}
	public void setItParentTask(boolean isItParentTask) {
		this.isItParentTask = isItParentTask;
	}
	
	public String getParentTaskID() {
		return parentTaskID;
	}
	public void setParentTaskID(String parentTaskID) {
		this.parentTaskID = parentTaskID;
	}
	*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isParent() {
		return parent;
	}
	public void setParent(boolean parent) {
		this.parent = parent;
	}
	
	

}
