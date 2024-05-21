package com.example.demo.Etiquetas.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEtiqueta;

    @Column
    private String nombre;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of();
    }
}
