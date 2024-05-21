package com.example.demo.Salon.Domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSalon;

    private String nombre;

    private String ubicacion;

    private Integer capacidad;

    private String descripcion;
}
