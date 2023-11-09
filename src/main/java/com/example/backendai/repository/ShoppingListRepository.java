package com.example.backendai.repository;

import com.example.backendai.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;




public interface ShoppingListRepository extends JpaRepository<Item, String> {

        Optional<Item> findAllByName(String Name);


}
