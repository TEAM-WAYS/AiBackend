package com.example.backendai.controller;

import com.example.backendai.dto.ApiResponse;
import com.example.backendai.model.Recipe;
import com.example.backendai.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getRecipe() {
        List<Recipe> recipeList = recipeService.getRecipe();

        if (recipeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(recipeList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(recipeList);
        }
    }

    @PostMapping("/recipes")
    public ResponseEntity<?> postRecipe(@RequestBody Recipe recipe) {
        Optional<Recipe> savedRecipe = recipeService.postRecipe(recipe);

        if (savedRecipe.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("recipe didn't save"));
        }
    }

    @PutMapping("/recipes")
    public ResponseEntity<?> putRecipe(@RequestBody Recipe recipe) {
        Optional<Recipe> foundRecipe = recipeService.putRecipe(recipe);

        if (foundRecipe.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("recipe not found or couldn't be updated"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("recipe updated successfully"));
        }
    }

    @DeleteMapping("/recipes/delete/{id}")
    public ResponseEntity<ApiResponse> deleteRecipe(@PathVariable int id) {
        Boolean foundRecipe = recipeService.deleteRecipe(id);

        if (foundRecipe) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("recipe deleted"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("recipe not deleted"));
        }
    }
}
