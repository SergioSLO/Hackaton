package com.example.demo.Etiquetas.Domain;

import com.example.demo.Salon.Domain.Salon;
import com.example.demo.Usuario.Domain.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombre;

    @JsonBackReference
    @ManyToMany(mappedBy = "etiquetas")
    private List<Salon> salones;

}
