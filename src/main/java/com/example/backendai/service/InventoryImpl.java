package com.example.backendai.service;

import com.example.backendai.model.Item;
import com.example.backendai.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InventoryImpl implements InventoryInterface{
    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public List<Item> getItems() {
        return inventoryRepository.findAll();
    }
}
