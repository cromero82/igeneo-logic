package com.ingeneo.logistic.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "type_vehicle")
@Getter
@Setter
public class TypeVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true,length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String pattern;

}
