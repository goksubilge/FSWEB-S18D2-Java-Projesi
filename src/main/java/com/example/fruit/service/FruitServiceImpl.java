package com.example.fruit.service;

import com.example.fruit.entity.Fruit;
import com.example.fruit.exceptions.PlantException;
import com.example.fruit.repositoy.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
private FruitRepository fruitRepository;
    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        // throws exception
        throw new PlantException("Plant with given id is not exist: " + id , HttpStatus.NOT_FOUND);
        //return null;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = getById(id);

            fruitRepository.delete(fruit);

        // throws exception => Id yi bulamazsa getById 'den hata atacak zaten. Koşullu ifadeyi sildim burada.
        return fruit;
    }
}
