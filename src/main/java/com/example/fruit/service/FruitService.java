package com.example.fruit.service;

import com.example.fruit.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getByPriceAsc();

    Fruit getById(long id);

    List<Fruit> getByPriceDesc();

    Fruit save (Fruit fruit);

    List<Fruit> searchByName(String name);

    Fruit delete(long id);
}
