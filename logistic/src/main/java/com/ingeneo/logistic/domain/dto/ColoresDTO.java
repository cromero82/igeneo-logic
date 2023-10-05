package com.ingeneo.logistic.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ColoresDTO {
    private Long id;
    private String nombre;
    private String rgb;
    private boolean favorito = false ;
}
