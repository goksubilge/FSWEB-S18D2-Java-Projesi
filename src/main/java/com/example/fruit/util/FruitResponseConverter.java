package com.example.fruit.util;

import com.example.fruit.dto.FruitResponseList;
import com.example.fruit.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitResponseConverter {
    public static List<FruitResponseList> fruitToFruitResponse(List<Fruit> fruits){
        List<FruitResponseList> records = new ArrayList<>();
        for(Fruit fruit: fruits){
            records.add(new FruitResponseList("Success",fruit.getName(),fruit.getPrice(),fruit.getFruitType()));
        }
        return records;
    }
}
