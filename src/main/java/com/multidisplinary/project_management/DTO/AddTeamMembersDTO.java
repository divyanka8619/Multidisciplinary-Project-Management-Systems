package com.multidisplinary.project_management.DTO;

import com.multidisplinary.project_management.Entities.TeamMembers;

public class AddTeamMembersDTO {

    public int teamMember_id;
    public String teamMember_LastName;
    public String teamMember_FirstName;
    public String teamMember_EmailAddress;

    public AddTeamMembersDTO() {
    }

    public AddTeamMembersDTO(int teamMemberid, String teamMemberLastName, String teamMemberFirstName, String teamMemberEmailAddress) {
        this.teamMember_id = teamMemberid;
        this.teamMember_LastName = teamMemberLastName;
        this.teamMember_FirstName = teamMemberFirstName;
        this.teamMember_EmailAddress = teamMemberEmailAddress;
    }

    public AddTeamMembersDTO(TeamMembers teamMembersEntity) {
        this.teamMember_id = teamMembersEntity.getMemberId();
        this.teamMember_FirstName = teamMembersEntity.getFirstName();
        this.teamMember_LastName = teamMembersEntity.getLastName();
        this.teamMember_EmailAddress = teamMembersEntity.getEmailAddress();
    }

    public int getTeamMemberid() {
        return teamMember_id;
    }

    public void setTeamMemberid(int teamMemberid) {
        this.teamMember_id = teamMemberid;
    }

    public String getTeamMemberLastName() {
        return teamMember_LastName;
    }

    public void setTeamMemberLastName(String teamMemberLastName) {
        this.teamMember_LastName = teamMemberLastName;
    }

    public String getTeamMemberFirstName() {
        return teamMember_FirstName;
    }

    public void setTeamMemberFirstName(String teamMemberFirstName) {
        this.teamMember_FirstName = teamMemberFirstName;
    }

    public String getTeamMemberEmailAddress() {
        return teamMember_EmailAddress;
    }

    public void setTeamMemberEmailAddress(String teamMemberEmailAddress) {
        this.teamMember_EmailAddress = teamMemberEmailAddress;
    }

    @Override
    public String toString() {
        return "TeamMembersDTO{" +
                "teamMemberid=" + teamMember_id +
                ", teamMemberLastName='" + teamMember_LastName + '\'' +
                ", teamMemberFirstName='" + teamMember_FirstName + '\'' +
                ", teamMemberEmailAddress='" + teamMember_EmailAddress + '\'' +
                '}';
    }
}
