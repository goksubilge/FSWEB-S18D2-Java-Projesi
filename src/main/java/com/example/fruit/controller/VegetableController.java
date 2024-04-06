package com.example.fruit.controller;

import com.example.fruit.entity.Vegetable;
import com.example.fruit.service.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> get(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable get(@Positive @PathVariable long id){
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getByDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping("/")
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> save(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Size(min= 2, max= 45) @PathVariable long id){
        return vegetableService.delete(id);
    }
}
