package com.axis.saral.service.service;

import java.util.List;

import com.axis.saral.service.entity.Project;



public interface ProjectService {
	Project getProjectByProjectIdProject(long ProjectId);
	List<Project> getAllProjects();
	void saveProject(Project project);
	void updateProject(long projectId, Project updatedProject);
	void deleteProjectById(long projectId);
}
