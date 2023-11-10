package com.example.backendai.model;

import jakarta.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String ingredients;
    @Column(columnDefinition = "TEXT")
    private String instructions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String NAME) {
        this.name = NAME;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String DESCRIPTION) {
        this.description = DESCRIPTION;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String INGREDIENTS) {
        this.ingredients = INGREDIENTS;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String INSTRUCTIONS) {
        this.instructions = INSTRUCTIONS;
    }
}