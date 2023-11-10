package com.example.backendai.service;

import com.example.backendai.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getRecipe();

    Optional<Recipe> postRecipe(Recipe recipe);

    Optional<Recipe> putRecipe(Recipe recipe);

    boolean deleteRecipe(int id);
}
