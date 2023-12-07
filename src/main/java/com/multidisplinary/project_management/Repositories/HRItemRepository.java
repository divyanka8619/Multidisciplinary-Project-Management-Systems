package com.multidisplinary.project_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidisplinary.project_management.Entities.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface HRItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByItemId(Integer itemId);

    List<Item> findByTitle(String title);
}
