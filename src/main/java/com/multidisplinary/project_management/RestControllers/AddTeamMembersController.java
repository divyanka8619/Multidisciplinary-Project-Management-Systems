package com.multidisplinary.project_management.RestControllers;

import com.multidisplinary.project_management.DTO.AddTeamMembersDTO;
import com.multidisplinary.project_management.Entities.TeamMembers;
import com.multidisplinary.project_management.Services.AddTeamMembersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AddTeamMembersController {

    @Autowired
    AddTeamMembersService addTeamMembersService;

    public AddTeamMembersController(AddTeamMembersService addTeamMembersService) {
        this.addTeamMembersService = addTeamMembersService;
    }

    @GetMapping(value = "/members", produces = "application/json")
    public ResponseEntity<List<AddTeamMembersDTO>> getAllMembers() {

        List<AddTeamMembersDTO> allMembersDTO = addTeamMembersService.getAllMembers();
        return new ResponseEntity<List<AddTeamMembersDTO>>(allMembersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/member/firstName/{firstName}", produces = "application/json")
    public ResponseEntity<AddTeamMembersDTO> getTeamMemberByFirstName(@PathVariable String firstName) {

        TeamMembers teamMemberDTO = addTeamMembersService.findByFirstName(firstName);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            AddTeamMembersDTO addTeamMembersDTO = new AddTeamMembersDTO(teamMember);
            return new ResponseEntity<AddTeamMembersDTO>(addTeamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with first name: " + firstName + " was found.");
        }
    }

    @GetMapping(value = "member/lastName/{lastName}", produces = "application/json")
    public ResponseEntity<AddTeamMembersDTO> getTeamMemberByLastName(@PathVariable String lastName) {

        TeamMembers teamMemberDTO = addTeamMembersService.findByLastName(lastName);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            AddTeamMembersDTO addTeamMembersDTO = new AddTeamMembersDTO(teamMember);
            return new ResponseEntity<AddTeamMembersDTO>(addTeamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with last name: " + lastName + " was found.");
        }
    }

    @GetMapping(value = "member/emailAddress/{emailAddress}", produces = "application/json")
    public ResponseEntity<AddTeamMembersDTO> getTeamMemberByEmailAddress(@PathVariable String emailAddress) {

        TeamMembers teamMemberDTO = addTeamMembersService.findByEmailAdddress(emailAddress);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            AddTeamMembersDTO addTeamMembersDTO = new AddTeamMembersDTO(teamMember);
            return new ResponseEntity<AddTeamMembersDTO>(addTeamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with the email address: " + emailAddress + " was found.");
        }
    }

    @PostMapping(value = "add-new-member", consumes = "application/json")
    public ResponseEntity<TeamMembers> createMember(@RequestBody AddTeamMembersDTO addTeamMembersDTO) {

        TeamMembers teamMembers = addTeamMembersService.saveTeamMember(addTeamMembersDTO);
        return new ResponseEntity<TeamMembers>(teamMembers, HttpStatus.OK);
    }

    @DeleteMapping("/member/{memberId}")
    public void deleteMemberById(@PathVariable Integer memberId) {

        addTeamMembersService.deleteTeamMemberById(memberId);
    }

    @PutMapping(value = "/update-member/{memberId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TeamMembers> updateMemberById(@PathVariable(name = "memberId") Integer memberId, @RequestBody AddTeamMembersDTO addTeamMembersDTO) {

        TeamMembers t = addTeamMembersService.getMemberById(memberId);
        if (t != null) {
            TeamMembers teamMembers = addTeamMembersService.updateMemberById(memberId, addTeamMembersDTO);//todo save
            return new ResponseEntity<TeamMembers>(teamMembers, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find project with the id: " + memberId);
        }
    }
}
