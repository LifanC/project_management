package com.project.entity;

import java.util.*;

public class ProjectListVO {
	private List<Project> projects;
	public ProjectListVO() {}
	public ProjectListVO(List<Project> projects) {
		this.projects = projects;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
