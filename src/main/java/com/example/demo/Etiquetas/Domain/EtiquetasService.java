package com.example.demo.Etiquetas.Domain;

import com.example.demo.Etiquetas.Infraestructure.EtiquetasRepository;
import com.example.demo.Etiquetas.dto.NewEtiquetasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetasService {
    @Autowired
    private EtiquetasRepository etiquetasRepository;

    public String create(NewEtiquetasDto newEtiquetasDto) {
        Etiquetas etiquetas = new Etiquetas();
        etiquetas.setNombre(newEtiquetasDto.getNombre());
        etiquetasRepository.save(etiquetas);

        return "/api/etiqueta/" + etiquetas.getId();
    }
}
