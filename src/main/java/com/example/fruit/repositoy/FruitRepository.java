package com.example.fruit.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fruit.entity.Fruit;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//parametreler:             1) hangi sınıfla eşleşecek?  2) primary key type nedir?
public interface FruitRepository extends JpaRepository<Fruit, Long > {
    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit AS f " + "ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getByPriceDesc ();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit AS f " + "ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getByPriceAsc ();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit AS f " + "WHERE f.name ILIKE %:name%", nativeQuery = true)
    List<Fruit> searchByName (String name);
}
