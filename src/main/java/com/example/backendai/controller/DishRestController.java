package com.example.backendai.controller;


import com.example.backendai.DTO.ApiResponse;
import com.example.backendai.model.Dish;
import com.example.backendai.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DishRestController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getDishes() {
        List<Dish> dishList = dishService.getDish();

        if (dishList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dishList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(dishList);
        }
    }

    @PostMapping("/dishes")
    public ResponseEntity<?> postDish(@RequestBody Dish dish){
        Optional<Dish> savedDish = dishService.postDish(dish);

        if (savedDish.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDish.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dish didn't save");
        }
    }


    @PutMapping("/Dishes")
    public ResponseEntity<ApiResponse> putDish(@RequestBody Dish dish){
        Optional<Dish> foundDish = dishService.putDish(dish);

        if (foundDish.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("dish not found or couldn't be updated"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("dish updated successfully"));
        }
    }


    @DeleteMapping("/dishes/delete/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable int id){
        Boolean foundDish = dishService.deleteDish(id);

        if (foundDish){
            return ResponseEntity.status(HttpStatus.OK).body("dish deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dish not deleted");
        }
    }
    @GetMapping("/dishes/{dishId}")
    public ResponseEntity<?> getDishById(@PathVariable int dishId) {
        Optional<Dish> foundDish = dishService.getDishById(dishId);

        if (foundDish.isPresent()) {
            return ResponseEntity.ok(foundDish.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dish not found");
        }
    }
}

