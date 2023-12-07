package com.multidisplinary.project_management.Services;

import com.multidisplinary.project_management.DTO.AddTeamMembersDTO;
import com.multidisplinary.project_management.Entities.TeamMembers;
import com.multidisplinary.project_management.Repositories.AddTeamMembersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddTeamMembersService {

    @Autowired
    AddTeamMembersRepository addTeamMembersRepository;

    @Transactional
    public TeamMembers getMemberById(Integer id){

        Optional<TeamMembers> byId = addTeamMembersRepository.findByMemberId(id);

        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a member with the id: " + id);
            // todo ELSE throw exception
        }
    }

    @Transactional
    public TeamMembers findByLastName(String lastName) {

        return addTeamMembersRepository.findByLastName(lastName);
    }

    @Transactional
    public TeamMembers findByFirstName(String firstName) {

        return addTeamMembersRepository.findByFirstName(firstName);
    }

    @Transactional
    public TeamMembers findByEmailAdddress(String emailAddress) {

        return addTeamMembersRepository.findByEmailAddress(emailAddress);
    }

    @Transactional
    public TeamMembers saveTeamMember(AddTeamMembersDTO addTeamMembersDTO) {

        TeamMembers teamMemberToBeSaved = new TeamMembers(addTeamMembersDTO);
        TeamMembers teamMemberSaved = addTeamMembersRepository.save(teamMemberToBeSaved);
        return teamMemberSaved;
    }

    @Transactional
    public void deleteTeamMemberById(Integer id) {

        addTeamMembersRepository.deleteById(id);
    }

    @Transactional
    public List<AddTeamMembersDTO> getAllMembers() {

        List<TeamMembers> all = addTeamMembersRepository.findAll();
        List<AddTeamMembersDTO> dtos = new ArrayList<>();
        for (TeamMembers member : all) {
            AddTeamMembersDTO temp = new AddTeamMembersDTO();
            temp.teamMember_id = member.getMemberId();
            temp.teamMember_LastName = member.getLastName();
            temp.teamMember_FirstName = member.getFirstName();
            temp.teamMember_EmailAddress = member.getEmailAddress();
            dtos.add(temp);
        }
        return dtos;
    }

    @Transactional
    public TeamMembers updateMemberById(Integer id, AddTeamMembersDTO memberToBeUpdated) {

        TeamMembers teamMembers;

        Optional<TeamMembers> teamMembersOptional = addTeamMembersRepository.findById(id);
        if (!teamMembersOptional.isPresent()) {

            throw new RuntimeException("Could not find member with the id: " + id);
        } else {

            teamMembers = teamMembersOptional.get();
            teamMembers.setFirstName(memberToBeUpdated.teamMember_FirstName);
            teamMembers.setLastName(memberToBeUpdated.teamMember_LastName);
            teamMembers.setEmailAddress(memberToBeUpdated.teamMember_EmailAddress);
        }
        return addTeamMembersRepository.save(teamMembers);
    }
}
