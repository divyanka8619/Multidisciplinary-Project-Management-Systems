package com.multidisplinary.project_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidisplinary.project_management.Entities.Type;

import java.util.Optional;

public interface TypeOfRatingsRepository extends JpaRepository<Type, Integer> {

    Optional<Type> findByName(String typeName);
}
