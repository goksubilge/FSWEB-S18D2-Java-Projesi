package com.example.fruit.service;

import com.example.fruit.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> getByPriceAsc();

    Vegetable getById(long id);

    List<Vegetable> getByPriceDesc();

    Vegetable save (Vegetable vegetable);

    List<Vegetable> searchByName(String name);

    Vegetable delete(long id);
}
