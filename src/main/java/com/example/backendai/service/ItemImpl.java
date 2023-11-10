package com.example.backendai.service;

import com.example.backendai.model.Item;
import com.example.backendai.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ItemImpl implements ItemInterface{
    @Autowired
    ItemRepository itemRepository;
    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }


    public boolean addToShoppigList(ArrayList<Item> list) {
        for(Item item : list){
            Optional<Item> lookingFor = itemRepository.findAllByName(item.getINGNAME());
            if(lookingFor.isPresent()){
                lookingFor.get().setINGAMOUNT(lookingFor.get().getINGAMOUNT() + item.getINGAMOUNT());
            }else{
                itemRepository.save(item);
            }
        }
        return true;
    }





}
