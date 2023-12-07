package com.multidisplinary.project_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidisplinary.project_management.Entities.TeamMembers;

import java.util.Optional;

public interface AddTeamMembersRepository extends JpaRepository<TeamMembers, Integer> {

    Optional<TeamMembers> findByMemberId (Integer id);

    TeamMembers findByLastName(String lastName);

    TeamMembers findByFirstName(String firstName);

    TeamMembers findByEmailAddress(String emailAddress);
}
