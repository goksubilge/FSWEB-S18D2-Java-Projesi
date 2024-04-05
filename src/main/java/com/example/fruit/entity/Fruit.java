package com.example.fruit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="fsweb", schema="fruit")
public class Fruit extends Plant {
    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
private FruitType fruitType;

}
