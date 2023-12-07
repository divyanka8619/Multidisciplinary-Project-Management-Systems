package com.multidisplinary.project_management.EntityConverter;

import com.multidisplinary.project_management.DTO.AddTeamMembersDTO;
import com.multidisplinary.project_management.Entities.TeamMembers;

import org.springframework.stereotype.Service;

@Service
public class TeamMembersEntityConverter implements EntityConverter<TeamMembers, AddTeamMembersDTO> {

    @Override
    public AddTeamMembersDTO convertToDTO(TeamMembers teamMembersEntity) {
        AddTeamMembersDTO addTeamMembersDTO = new AddTeamMembersDTO();
        addTeamMembersDTO.teamMember_LastName = teamMembersEntity.getLastName();
        addTeamMembersDTO.teamMember_FirstName = teamMembersEntity.getFirstName();
        addTeamMembersDTO.teamMember_EmailAddress = teamMembersEntity.getEmailAddress();
        return addTeamMembersDTO;
    }

    @Override
    public TeamMembers convertToEntity(AddTeamMembersDTO addTeamMembersDTO) {
        TeamMembers teamMembersEntity = new TeamMembers();
        teamMembersEntity.setLastName(addTeamMembersDTO.teamMember_LastName);
        teamMembersEntity.setFirstName(addTeamMembersDTO.teamMember_FirstName);
        teamMembersEntity.setEmailAddress(addTeamMembersDTO.teamMember_EmailAddress);
        return teamMembersEntity;
    }
}
