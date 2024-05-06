package org.example.backend.service;

import jakarta.persistence.TypedQuery;
import org.example.backend.model.Inventory;
import org.example.backend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    //可以根据table_id来返回所有满足table_id的event_id，且只返回event_id的integer数组
    public List<Integer> getEventIdsByTableId(Integer tableID) {
        return inventoryRepository.findEventIdByTableID(tableID);
    }
}
