package com.example.fruit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="vegetable", schema="fsweb")
public class Vegetable extends Plant {
    @Column(name="is_grown_on_tree")
    @NotNull
    private boolean isGrownOnTree;
}
