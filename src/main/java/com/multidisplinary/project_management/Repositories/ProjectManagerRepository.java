package com.multidisplinary.project_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multidisplinary.project_management.Entities.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectManagerRepository extends JpaRepository<Project, Integer> {

    List<Project> findByName(String name);

    Optional<Project> findProjectByProjectId(Integer projectId);

    @Query(value = "SELECT * FROM project WHERE project_id = :statusId", nativeQuery = true)
    List<Project> findAllProjectsByStatusId(@Param("statusId") Integer statusId);
}
