package com.example.fruit.controller;

import com.example.fruit.entity.Fruit;
import com.example.fruit.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Fruit get(@PathVariable long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getByDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping("/")
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> save(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id){
       return fruitService.delete(id);
    }
}
