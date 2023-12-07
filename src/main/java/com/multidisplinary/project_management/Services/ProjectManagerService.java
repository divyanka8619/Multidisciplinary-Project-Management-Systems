package com.multidisplinary.project_management.Services;

import com.multidisplinary.project_management.DTO.ProjectManagerDTO;
import com.multidisplinary.project_management.Entities.Project;
import com.multidisplinary.project_management.Entities.Status;
import com.multidisplinary.project_management.Entities.TeamMembers;
import com.multidisplinary.project_management.EntityConverter.ProjectEntityConverter;
import com.multidisplinary.project_management.Repositories.ProjectManagerRepository;
import com.multidisplinary.project_management.Repositories.StatusOfEmployeeRepository;
import com.multidisplinary.project_management.Repositories.AddTeamMembersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectManagerService {

    @Autowired
    ProjectManagerRepository projectManagerRepository;

    @Autowired
    StatusOfEmployeeRepository statusOfEmployeeRepository;

    @Autowired
    AddTeamMembersRepository addTeamMembersRepository;

    @Autowired
    ProjectEntityConverter projectEntityConverter;

    @Transactional
    public Boolean isProjectIdPresent(Integer id) {

        return projectManagerRepository.findById(id).isPresent();
    }

    @Transactional
    public Project getProjectById(Integer id){

        Optional<Project> byId = projectManagerRepository.findProjectByProjectId(id);

        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a project with the id: " + id);
            // todo ELSE throw exception
        }
    }

    @Transactional
    public List<Project> findByName(String title) {

        return projectManagerRepository.findByName(title);
    }

    @Transactional
    public Project saveProject(ProjectManagerDTO projectManagerDTO) {

        Optional<Status> byStatusName = statusOfEmployeeRepository.findByStatusName(projectManagerDTO.statusName);
        Optional<TeamMembers> byMemberId = addTeamMembersRepository.findByMemberId(projectManagerDTO.teamMemberId);

        TeamMembers teamMembers = null;
        if (!byMemberId.isPresent()) {

            TeamMembers newMember = new TeamMembers(projectManagerDTO.teamMemberId);
            teamMembers = addTeamMembersRepository.save(newMember);
        } else {
            teamMembers = byMemberId.get();
        }

        Status status = null;
        if (!byStatusName.isPresent()) {

            Status newStatus = new Status(projectManagerDTO.statusName);
            status = statusOfEmployeeRepository.save(newStatus);
        } else {

            status = byStatusName.get();
        }

        Project projectToBeSaved = new Project(projectManagerDTO, teamMembers, status);
        Project savedProject = projectManagerRepository.save(projectToBeSaved);
        return savedProject;
    }

    @Transactional
    public List<ProjectManagerDTO> getAllProjects() {

        List<Project> all = projectManagerRepository.findAll();
        List<ProjectManagerDTO> dtos = new ArrayList<>();
        for (Project project : all) {
            ProjectManagerDTO temp = new ProjectManagerDTO();
            temp.projectId = project.getProjectId();
            temp.projectName = project.getName();
            temp.description = project.getDescription();
            temp.statusName = project.getStatusOfProject().getStatusName();
            temp.teamMemberId = project.getTeamMemberOfProject().getMemberId();
            temp.teamMemberOfProjectLastName = project.getTeamMemberOfProject().getLastName();
            temp.teamMemberOfProjectFirstName = project.getTeamMemberOfProject().getFirstName();
            temp.teamMemberOfProjectEmailAddress = project.getTeamMemberOfProject().getEmailAddress();
            dtos.add(temp);
        }
        return dtos;
    }

    @Transactional
    public Project updateProjectById(Integer id, ProjectManagerDTO projectToBeUpdated) {

        Project project;
        Status status;
        TeamMembers teamMembers;

        Optional<Status> statusOptional = statusOfEmployeeRepository.findByStatusName(projectToBeUpdated.statusName);

        Optional<TeamMembers> teamMembersOptional = addTeamMembersRepository.findByMemberId(projectToBeUpdated.teamMemberId);

        Optional<Project> projectOptional = projectManagerRepository.findById(id);
        if (!projectOptional.isPresent()) {

            throw new RuntimeException("Could not find project with the id: " + id);
        } else {

            project = projectOptional.get();

            status = statusOptional.get();
            status.setStatusName(projectToBeUpdated.statusName);

            teamMembers = teamMembersOptional.get();
            teamMembers.setMemberId(projectToBeUpdated.teamMemberId);

            project.setName(projectToBeUpdated.projectName);
            project.setDescription(projectToBeUpdated.description);
            project.setStatusOfProject(status);
            project.setTeamMemberOfProject(teamMembers);
        }
        return projectManagerRepository.save(project);
    }

    @Transactional
    public void deleteProjectById(Integer id) {

        projectManagerRepository.deleteById(id);
    }
}