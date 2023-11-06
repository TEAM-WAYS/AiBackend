package com.example.backendai.service;

import com.example.backendai.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Optional<Dish> putDish(Dish dish);

    Boolean deleteDish(int id);

    Optional<Dish> getDishById(int dishId);

    List<Dish> getDish();

    Optional<Dish> postDish(Dish dish);
}
