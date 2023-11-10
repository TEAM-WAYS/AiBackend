package com.example.backendai.controller;

import com.example.backendai.model.Item;
import com.example.backendai.service.ItemInterface;
import com.example.backendai.service.ProcessString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    private ItemInterface itemInterface;
    @GetMapping("/shoppinglist")
    public ResponseEntity<List<Item>> getShoppingList(){
        List<Item> list = itemInterface.getItems();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }
    @PostMapping("/shoppinglist")
    public boolean adToShoppingList(@RequestParam String s){
         ArrayList<Item> list = ProcessString.itemLisFromString(s);
         return itemInterface.addToShoppigList(list);
    }



}
