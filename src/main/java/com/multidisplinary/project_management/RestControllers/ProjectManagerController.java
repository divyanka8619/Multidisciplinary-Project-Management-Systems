package com.multidisplinary.project_management.RestControllers;

import com.multidisplinary.project_management.DTO.ProjectManagerDTO;
import com.multidisplinary.project_management.Entities.Project;
import com.multidisplinary.project_management.Services.ProjectManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectManagerController {

    @Autowired
    ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<ProjectManagerDTO> getProjectById(@PathVariable Integer projectId) {

        Project projectById = projectManagerService.getProjectById(projectId);
        if (projectById != null) {
            Project projectEntity = projectById;
            ProjectManagerDTO projectManagerDTO = new ProjectManagerDTO(projectEntity);
            return new ResponseEntity<ProjectManagerDTO>(projectManagerDTO, HttpStatus.OK);

            //todo catch exception here.
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No project with the id " + projectId + " was found.");
        }
    }

    @GetMapping(value = "/projects", produces = "application/json")
    public ResponseEntity<List<ProjectManagerDTO>> getAllProjects() {

        List<ProjectManagerDTO> allProjects = projectManagerService.getAllProjects();
        return new ResponseEntity<List<ProjectManagerDTO>>(allProjects, HttpStatus.OK);
    }

    @PostMapping(value = "add-new-project", consumes = "application/json")
    public ResponseEntity<Project> createProject(@RequestBody ProjectManagerDTO projectManagerDTO) {

        Project project = projectManagerService.saveProject(projectManagerDTO);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @PutMapping(value = "/update-project/{projectId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Project> updateProjectById(@PathVariable(name = "projectId") Integer projectId, @RequestBody ProjectManagerDTO projectManagerDTO) {

        Project p = projectManagerService.getProjectById(projectId);
        if (p != null) {
            Project project = projectManagerService.updateProjectById(projectId, projectManagerDTO);//todo save
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find project with the id: " + projectId);
        }
    }

    @DeleteMapping("/project/{projectId}")
    public void deleteProjectById(@PathVariable Integer projectId) {

        if (projectManagerService.isProjectIdPresent(projectId)) {
            projectManagerService.deleteProjectById(projectId);

            //TODO DO NOT THROW EXCEPTION DIRECTLY. RETURN AN EXCEPTION DTO
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No project with the id " + projectId + " was found.");
        }
    }
}
