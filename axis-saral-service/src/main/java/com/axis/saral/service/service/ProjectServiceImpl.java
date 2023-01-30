package com.axis.saral.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.Project;
import com.axis.saral.service.exception.ProjectNotFoundException;
import com.axis.saral.service.repository.ProjectRepository;


@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProjectByProjectIdProject(long projectId) {
		Optional<Project> projectOptional = projectRepository.findById(projectId);
		if(!projectOptional.isPresent()) {
			throw new ProjectNotFoundException("Project not found with ID : " +projectId);
		}
		return projectOptional.get();
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public void saveProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.save(project);
		
	}

	@Transactional
	@Override
	public void updateProject(long projectId, Project updatedProject) {
		// TODO Auto-generated method stub
		projectRepository.save(updatedProject);
	}

	@Override
	public void deleteProjectById(long projectId) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(projectId);
		
	}

}
