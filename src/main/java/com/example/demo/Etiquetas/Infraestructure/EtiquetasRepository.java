package com.example.demo.Etiquetas.Infraestructure;

import com.example.demo.Etiquetas.Domain.Etiquetas;
import com.example.demo.Usuario.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtiquetasRepository extends JpaRepository<Etiquetas, Long> {

    Optional<Etiquetas> findByidEtiqueta(int idEtiqueta);
}
