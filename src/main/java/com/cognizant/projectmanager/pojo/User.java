package com.cognizant.projectmanager.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	@Id
	private String userID;
	private String empID;
	private String empFirstName;
	private String empLastName;
	private String status;
	private String projectID;
	private String taskID;
	
	public User() {
		
	}
	
	public User(String userID, String empID, String empFirstName, String empLastName, String status, String projectID, String taskID) {
		super();
		this.userID = userID;
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.status = status;
		this.projectID = projectID;
		this.taskID = taskID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	
	
}
