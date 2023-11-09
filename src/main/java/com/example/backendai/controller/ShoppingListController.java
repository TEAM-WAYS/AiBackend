package com.example.backendai.controller;

import com.example.backendai.model.Item;
import com.example.backendai.service.ProcessString;
import com.example.backendai.service.ShoppingListRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    private ShoppingListRepositoryInterface shoppingListRepositoryInterface;
    @GetMapping("/shoppinglist")
    public ResponseEntity<List<Item>> getShoppingList(){
        List<Item> list = shoppingListRepositoryInterface.getItems();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }
    @PutMapping("/shoppinglist/addto")
    public boolean adToShoppingList(@RequestParam String s){
         ArrayList<Item> list = ProcessString.itemLisFromString(s);
         return shoppingListRepositoryInterface.addToShoppigList(list);
    }



}
