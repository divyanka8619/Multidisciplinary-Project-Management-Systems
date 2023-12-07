package com.multidisplinary.project_management.Entities;

import javax.persistence.*;

import com.multidisplinary.project_management.DTO.AddTeamMembersDTO;

import java.util.List;

@Entity
@Table(name = "team_members")
public class TeamMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Integer memberId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email_address")
    String emailAddress;


    @OneToMany(mappedBy = "teamMemberOfProject")
    List<Project> projects;

    @OneToMany(mappedBy = "teamMemberOfItem")
    List<Item> items;

    public TeamMembers() {
    }

    public TeamMembers(Integer teamMemberId) {
    }

    public TeamMembers(AddTeamMembersDTO addTeamMembersDTO) {
        this.lastName = addTeamMembersDTO.teamMember_LastName;
        this.firstName = addTeamMembersDTO.teamMember_FirstName;
        this.emailAddress = addTeamMembersDTO.teamMember_EmailAddress;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Team_Members{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
