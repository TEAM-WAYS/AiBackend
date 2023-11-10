package com.example.backendai.repository;

import com.example.backendai.model.Item;
import com.example.backendai.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;




public interface ShoppingListRepository extends JpaRepository<ShoppingList, String> {
}
