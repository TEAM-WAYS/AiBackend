package com.example.backendai.repository;

import com.example.backendai.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Item, String> {
}
