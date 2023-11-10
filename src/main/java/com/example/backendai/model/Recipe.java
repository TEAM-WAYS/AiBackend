package com.example.backendai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    @Id
    private int id;
    private String NAME;
    private String DESCRIPTION;
    private String INGREDIENTS;
    private String INSTRUCTIONS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getINGREDIENTS() {
        return INGREDIENTS;
    }

    public void setINGREDIENTS(String INGREDIENTS) {
        this.INGREDIENTS = INGREDIENTS;
    }

    public String getINSTRUCTIONS() {
        return INSTRUCTIONS;
    }

    public void setINSTRUCTIONS(String INSTRUCTIONS) {
        this.INSTRUCTIONS = INSTRUCTIONS;
    }
}