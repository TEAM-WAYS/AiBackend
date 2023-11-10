package com.example.backendai.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class ShoppingList {
    private int id;
    private boolean isInventory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppinglist")
    @JsonBackReference
    private Set<Item> item = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInventory() {
        return isInventory;
    }

    public void setInventory(boolean inventory) {
        isInventory = inventory;
    }

    public Set<Item> getItem() {
        return item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }

}



