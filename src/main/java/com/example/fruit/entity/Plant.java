package com.example.fruit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass  // MAP 'lenmiş, değeri belirtilmiş bir superclass. Bunun entity sini - SQL 'de tablosunu oluşturmuyor.
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
}
