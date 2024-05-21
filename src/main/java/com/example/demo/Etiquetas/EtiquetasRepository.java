package com.example.demo.Etiquetas;

import java.util.Optional;


public interface EtiquetasRepository {
    Optional<Etiquetas> findByidEtiqueta(int idEtiqueta);
}
