package com.axis.saral.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.saral.service.entity.Project;
import com.axis.saral.service.service.ProjectService;

@RestController
@CrossOrigin(value ="http://localhost:3000")

public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping("/project/{projectId}")
	public Project getProjectByProjectId(@PathVariable long projectId) {
		return projectService.getProjectByProjectIdProject(projectId);
	}

	@PostMapping("/project")
	public ResponseEntity<String> saveProject(@RequestBody Project project) {
		projectService.saveProject(project);
		return new ResponseEntity<String>("Project Added Sucessfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/project/delete/{projectId}")
	public ResponseEntity<String> deleteProjectByProjectId(@PathVariable long projectId) {
		projectService.deleteProjectById(projectId);
		return new ResponseEntity<String>("Project deleted sucessfully"  + projectId, HttpStatus.OK);
	}
	
	@PutMapping("/project/update/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable long projectId,
			@RequestBody Project updatedProject){
		if(projectId != updatedProject.getProjectId()) {
			return new ResponseEntity<String>("User Not Found!!", HttpStatus.BAD_REQUEST);
		}else {
			projectService.updateProject(projectId, updatedProject);
			return new ResponseEntity<String>("User updated Successfully", HttpStatus.OK);
		}
	}
}
