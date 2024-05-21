package com.example.demo.Etiquetas.Domain;

import com.example.demo.Etiquetas.Infraestructure.EtiquetasRepository;
import com.example.demo.Etiquetas.dto.EtiquetasAddedDto;
import com.example.demo.Etiquetas.dto.NewEtiquetasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void delete(Long id) {
        etiquetasRepository.deleteById(id);
    }

    public Optional<EtiquetasAddedDto> getEtiquetasById(Long etiquetasId) {
        Pageable pageable = Pageable.ofSize(10).withPage(0);

        return etiquetasRepository.findByidEtiqueta(etiquetasId)
                .map(item -> {
                    EtiquetasAddedDto itemAddedDto = new EtiquetasAddedDto();
                    itemAddedDto.setIdSalon(itemAddedDto.getIdSalon());
                    itemAddedDto.setIdEtiqueta(etiquetasId);
                    return itemAddedDto;
                });
    }

}
