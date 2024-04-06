package com.example.fruit.service;

import com.example.fruit.entity.Vegetable;
import com.example.fruit.exceptions.PlantException;
import com.example.fruit.repositoy.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {
    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        // throws exception
        throw new PlantException("Plant with given id is not exist: " + id , HttpStatus.NOT_FOUND);
        //return null;
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = getById(id);

            vegetableRepository.delete(vegetable);

        // throws exception => Id yi bulamazsa getById 'den hata atacak zaten. Koşullu ifadeyi sildim burada.
        return vegetable;
    }
}
