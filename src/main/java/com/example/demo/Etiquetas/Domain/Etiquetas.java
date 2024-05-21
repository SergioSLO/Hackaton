package com.example.demo.Etiquetas.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEtiqueta;

    @Column
    private String nombre;
}
