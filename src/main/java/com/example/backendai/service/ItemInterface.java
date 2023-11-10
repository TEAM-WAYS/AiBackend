package com.example.backendai.service;

import com.example.backendai.model.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemInterface {
    List<Item> getItems();
    boolean addToShoppigList(ArrayList<Item> list);
}
