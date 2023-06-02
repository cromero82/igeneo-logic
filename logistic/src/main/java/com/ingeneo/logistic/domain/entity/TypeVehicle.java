package com.ingeneo.logistic.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_vehicle")
@Getter
@Setter
public class TypeVehicle {
    @Id
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String pattern;

}
