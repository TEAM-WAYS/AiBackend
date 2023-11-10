package com.example.backendai.repository;


import com.example.backendai.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, String> {
    Optional<Item> findAllByName(String name);


}
