package com.multidisplinary.project_management.EntityConverter;

import com.multidisplinary.project_management.DTO.ProjectManagerDTO;
import com.multidisplinary.project_management.Entities.Project;

import org.springframework.stereotype.Service;

@Service
public class ProjectEntityConverter implements EntityConverter<Project, ProjectManagerDTO> {

    @Override
    public ProjectManagerDTO convertToDTO(Project projectEntity) {
        ProjectManagerDTO projectManagerDTO = new ProjectManagerDTO();
        projectManagerDTO.projectName = projectEntity.getName();
        projectManagerDTO.projectId = projectEntity.getProjectId();

        if (projectEntity.getStatusOfProject() != null) {

            projectManagerDTO.statusName = projectEntity.getStatusOfProject().getStatusName();
        } else {

            projectManagerDTO.statusName = "Undefined Status";
        }
        return projectManagerDTO;
    }

    @Override
    public Project convertToEntity(ProjectManagerDTO projectManagerDTO) {

        Project projectEntity = new Project();

        projectEntity.setName(projectManagerDTO.projectName);
        projectEntity.setDescription(projectManagerDTO.description);
        return projectEntity;
    }
}
