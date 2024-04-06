package com.example.fruit.controller;

import com.example.fruit.dto.FruitResponseList;
import com.example.fruit.dto.FruitResponseObj;
import com.example.fruit.entity.Fruit;
import com.example.fruit.service.FruitService;
import com.example.fruit.util.FruitResponseConverter;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<FruitResponseList> get(){
        List<Fruit> fruits =fruitService.getByPriceAsc();
        return FruitResponseConverter.fruitToFruitResponse(fruits);
    }

    @GetMapping("/{id}")
    public FruitResponseObj get(@Positive @PathVariable long id){
         return new FruitResponseObj("Success", fruitService.getById(id));  // tek bir obje döndüğüm için convertion yapmadım
        // eski hali: return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<FruitResponseList> getByDesc(){
        List<Fruit> fruits = fruitService.getByPriceDesc();
        return FruitResponseConverter.fruitToFruitResponse(fruits);
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> save(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Size(min= 2, max= 45) @PathVariable long id){
       return fruitService.delete(id);
    }
}
// tek bir obje döndüğüm için convertion yapmadım
// List gibi collection döneceğim zaman gidip util(validation) package altında bir convertion işlemi yapıyorum. Böylece o convertion işlemin controller 'a taşımıyorum amacım o.