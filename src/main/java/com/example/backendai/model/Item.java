package com.example.backendai.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String INGNAME;
    private double INGAMOUNT;
    private String INGMEASUREMENT;
    @ManyToOne
    @JoinColumn(name = "shoppinglist", referencedColumnName = "id")
    private ShoppingList shoppingList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getINGNAME() {
        return INGNAME;
    }

    public void setINGNAME(String name) {
        this.INGNAME = name;
    }

    public double getINGAMOUNT() {
        return INGAMOUNT;
    }

    public void setINGAMOUNT(double amount) {
        this.INGAMOUNT = amount;
    }

    public String getINGMEASUREMENT() {
        return INGMEASUREMENT;
    }

    public void setINGMEASUREMENT(String measure) {
        this.INGMEASUREMENT = measure;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
