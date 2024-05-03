package org.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.backend.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
}
