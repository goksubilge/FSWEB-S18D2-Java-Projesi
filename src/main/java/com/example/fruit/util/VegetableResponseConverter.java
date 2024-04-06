package com.example.fruit.util;

import com.example.fruit.dto.VegetableResponseList;
import com.example.fruit.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class VegetableResponseConverter {
    public static List<VegetableResponseList> vegetableToVegetableResponse(List<Vegetable> vegetables) {
        List<VegetableResponseList> records = new ArrayList<>();
        for(Vegetable vegetable: vegetables){
            records.add(new VegetableResponseList("Success", vegetable.getName(),vegetable.getPrice(),vegetable.isGrownOnTree()));
        }
        return records;
    }
}
