package com.example.backendai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String INGNAME;
    private double INGAMOUNT;
    private String INGMEASUREMENT;


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
}
