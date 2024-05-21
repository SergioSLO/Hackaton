package com.example.demo.Etiquetas.Infraestructure;

import com.example.demo.Etiquetas.Domain.Etiquetas;

import java.util.Optional;

public interface EtiquetasRepository {
    Optional<Etiquetas> findByidEtiqueta(int idEtiqueta);
}
