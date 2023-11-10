package com.example.backendai.service;

import com.example.backendai.model.Recipe;
import com.example.backendai.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getRecipe(){
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> postRecipe(Recipe recipe){
        return Optional.of(recipeRepository.save(recipe));
    }

    @Override
    public Optional<Recipe> putRecipe(Recipe recipe){
        Optional<Recipe> foundRecipe = recipeRepository.findById(recipe.getId());

        if (foundRecipe.isPresent()){
            return Optional.of(recipeRepository.save(recipe));
        } else return Optional.empty();
    }

    public boolean deleteRecipe(int id) {
        Optional<Recipe> foundRecipe = recipeRepository.findById(id);

        if (foundRecipe.isPresent()){
            recipeRepository.delete(foundRecipe.get());
            return true;
        }
        return false;
    }
}
