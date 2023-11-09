package com.example.backendai.service;

import com.example.backendai.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ShoppingListRepositoryInterface {
    List<Item> getItems();

    boolean addToShoppigList(ArrayList<Item> list);
}
