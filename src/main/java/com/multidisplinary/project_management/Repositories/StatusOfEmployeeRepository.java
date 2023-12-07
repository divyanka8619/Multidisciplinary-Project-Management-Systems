package com.multidisplinary.project_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidisplinary.project_management.Entities.Status;

import java.util.Optional;

@Repository
public interface StatusOfEmployeeRepository extends JpaRepository<Status, Integer> {

    Optional<Status> findByStatusName(String statusName);
}
