package com.example.backendai.service;

import com.example.backendai.dto.ItemDTO;
import com.fasterxml.jackson.core.type.TypeReference;

import com.example.backendai.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;

public class ProcessString {
    public static ArrayList<Item> itemLisFromString(String jsonString){


        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<ItemDTO> dtoList;
        try {
            dtoList = objectMapper.readValue(jsonString, new TypeReference<ArrayList<ItemDTO>>() {});

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        ArrayList<Item> list = new ArrayList<>();
        for (ItemDTO dto : dtoList) {
            double amount = 0;
            String str =  dto.getINGAMOUNT();
            try {
                amount =  Double.parseDouble(str);
            }catch (Exception e){
                String[] parts = str.split(" ");
                for (String part : parts){
                    try {
                        amount = Double.parseDouble(part);
                    }catch (Exception ex){

                    }
                }
                if(amount==0){

                    for (String part : parts){
                        int i = 0;
                        for (int j= 0; j < part.length(); j++) {
                            if (Character.isDigit(part.charAt(i))) {
                                amount = amount * 10  + Character.getNumericValue(part.charAt(i));

                                i++;
                            }else if (amount!=0 ) {
                                if(part.charAt(i)=='/' && Character.isDigit(part.charAt(i+1))){
                                    amount /= Character.getNumericValue(part.charAt(i+1));
                                }else{
                                    break;
                                }
                            }

                        }
                    }
                }
            }
            Item item = new Item();
            item.setINGMEASUREMENT(dto.getINGMEASUREMENT());
            item.setINGNAME(dto.getINGNAME());
            item.setINGAMOUNT(amount);
            list.add(item);
        }

        return list;

    }
}
