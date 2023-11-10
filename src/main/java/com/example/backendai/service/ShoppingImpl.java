package com.example.backendai.service;

import com.example.backendai.model.ShoppingList;
import com.example.backendai.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingImpl implements ShoppingListInterface {

    @Autowired
    ShoppingListRepository shoppingListRepository;
    @Override
    public List<ShoppingList> getShoppingLists() {
        List<ShoppingList> lst = shoppingListRepository.findAll();
        return lst;
    }


}
