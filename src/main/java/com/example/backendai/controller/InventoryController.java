package com.example.backendai.controller;

import com.example.backendai.model.Item;
import com.example.backendai.service.InventoryInterface;
import com.example.backendai.service.ShoppingListRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryInterface inventoryInterface;
    @GetMapping("/inventory")
    public ResponseEntity<List<Item>> getShoppingList(){
        List<Item> list = inventoryInterface.getItems();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }
}
