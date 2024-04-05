package com.example.fruit.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fruit.entity.Vegetable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit AS f " + "ORDER BY f.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc ();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit AS f " + "ORDER BY f.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc ();

    @Query(value = "SELECT f.id, f.name FROM fsweb.fruit AS f " + "WHERE f.name ILIKE %:name%", nativeQuery = true)
    List<Vegetable> searchByName (String name);
}
