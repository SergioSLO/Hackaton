package com.example.demo.Salon.Domain;

import com.example.demo.Etiquetas.Domain.Etiquetas;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private String ubicacion;

    private Integer capacidad;

    private String descripcion;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "Salon_Etiqueta",
            joinColumns = @JoinColumn(name = "Salon_id"),
            inverseJoinColumns = @JoinColumn(name = "Etiqueta_id"))
    private List<Etiquetas> etiquetas;




}
