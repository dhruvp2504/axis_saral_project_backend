package com.axis.saral.service.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private long projectId;
	private String projectTitle;
	private String projectOwner;
	private int teamMembersCount;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date startingDate;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date deadLineDate;
	private String projectStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private List<StakeHolder> stakeHolderList;
	
	public Project() {
	}

	public Project(long projectId, String projectTitle, String projectOwner, int teamMembersCount, Date startingDate,
			Date deadLineDate, String projectStatus) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.projectOwner = projectOwner;
		this.teamMembersCount = teamMembersCount;
		this.startingDate = startingDate;
		this.deadLineDate = deadLineDate;
		this.projectStatus = projectStatus;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	public int getTeamMembersCount() {
		return teamMembersCount;
	}

	public void setTeamMembersCount(int teamMembersCount) {
		this.teamMembersCount = teamMembersCount;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getDeadLineDate() {
		return deadLineDate;
	}

	public void setDeadLineDate(Date deadLineDate) {
		this.deadLineDate = deadLineDate;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}



	@Override
	public int hashCode() {
		return Objects.hash(projectId, projectTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return projectId == other.projectId && Objects.equals(projectTitle, other.projectTitle);
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectOwner=" + projectOwner
				+ ", teamMembersCount=" + teamMembersCount + ", startingDate=" + startingDate + ", deadLineDate="
				+ deadLineDate + ", projectStatus=" + projectStatus + ", employee=" +  "]";
	}

	

}
