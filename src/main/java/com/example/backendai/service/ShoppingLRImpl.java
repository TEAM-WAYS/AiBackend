package com.example.backendai.service;

import com.example.backendai.model.Item;
import com.example.backendai.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ShoppingLRImpl implements ShoppingListRepositoryInterface {

    @Autowired
    ShoppingListRepository shoppingListRepository;
    @Override
    public List<Item> getItems() {
        List<Item> lst = shoppingListRepository.findAll();
        return lst;
    }

    @Override
    public boolean addToShoppigList(ArrayList<Item> list) {
        for(Item item : list){
            Optional<Item> lookingFor = shoppingListRepository.findAllByName(item.getINGNAME());
            if(lookingFor.isPresent()){
                lookingFor.get().setINGAMOUNT(lookingFor.get().getINGAMOUNT() + item.getINGAMOUNT());
            }else{
                shoppingListRepository.save(item);
            }
        }




        return true;
    }
}
