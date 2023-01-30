package com.axis.saral.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Project;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
