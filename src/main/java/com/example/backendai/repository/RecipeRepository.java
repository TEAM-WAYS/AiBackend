package com.example.backendai.repository;

import com.example.backendai.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
    Optional<Recipe> findById(int id);
}
