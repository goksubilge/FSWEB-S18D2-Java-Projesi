package com.example.fruit.dto;

import com.example.fruit.entity.FruitType;

public record FruitResponseList(String message, String name, double price, FruitType fruitType) {
}
