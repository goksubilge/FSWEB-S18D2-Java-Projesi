package com.example.fruit.controller;

import com.example.fruit.entity.Fruit;
import com.example.fruit.service.FruitService;
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
    public List<Fruit> get(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit get(@Positive @PathVariable long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getByDesc(){
        return fruitService.getByPriceDesc();
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
