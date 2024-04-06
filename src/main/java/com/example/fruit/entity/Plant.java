package com.example.fruit.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(min=2,max=45, message = "name size must be between 2 to 45")
    private String name;
    @Column(name="price")
    @NotNull
    @DecimalMin("10")
    private double price;
}
