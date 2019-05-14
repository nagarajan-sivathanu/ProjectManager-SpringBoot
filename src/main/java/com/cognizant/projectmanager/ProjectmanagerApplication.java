package com.cognizant.projectmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectmanagerApplication {
	private final static Logger log = LoggerFactory.getLogger(ProjectmanagerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectmanagerApplication.class, args);
		log.info("Sprint Boot Application UP & Running!");
	}

}

